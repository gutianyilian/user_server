package com.ehome.user_server.aop;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * 全局日志管理AOP
 * author：SunTianJie
 * create time：2018/3/29 13:22
 */
@Aspect
@Component
public class WebLogAspect {
	private Logger logger = LoggerFactory.getLogger(getClass());
	@Pointcut("execution(public * com.ehome.user_server.controller..*.*(..))")
	public void webLog() {
	}
	@Before("webLog()")
	public void doBefore(JoinPoint joinPoint) throws Throwable {
		// 接收到请求，记录请求内容
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
		// 记录下请求内容
		logger.info("#################################服务端接收到接口请求#######################################");
		logger.info("请求 URL : " + request.getRequestURL().toString());
		logger.info("请求类型 : " + request.getMethod());
		logger.info("客户端IP : " + request.getRemoteAddr());
		Enumeration<String> enu = request.getParameterNames();
		String param = "";
		while (enu.hasMoreElements()) {
			String key = (String) enu.nextElement();
			String value = request.getParameter(key);
			param += key+"="+value+",";
//			logger.info("name:{},value:{}", key, value);
		}
		if(param!=null&&param.length()>0){
			param = param.substring(0,param.length()-1);
		}
		logger.info("请求参数 : "+param);
	}
	@AfterReturning(returning = "ret", pointcut = "webLog()")
	public void doAfterReturning(Object ret) throws Throwable {
		// 处理完请求，返回内容
		ObjectMapper objectMapper = new ObjectMapper();
		String resJson = objectMapper.writeValueAsString(ret);
        logger.info("接口响应 : " + resJson);
        logger.info("##################################服务端处理接口请求成功#####################################");
	}
}