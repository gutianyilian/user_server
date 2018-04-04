package com.ehome.user_server.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 全局异常捕获处理工具类
 * author：SunTianJie
 * create time：2018/3/30 14:44
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public Map<String, Object> exceptionHandler(HttpServletRequest request,  Exception exception) throws Exception{
        exception.printStackTrace();
        Map<String, Object> map = new HashMap<String, Object>();
        String mes = StatusCode.getMessage(StatusCode.CODE_SERVER_ERROR.CODE_VALUE);
        map.put("statusCode", StatusCode.CODE_SERVER_ERROR.CODE_VALUE);
        map.put("codeMessage", mes);
        return map;
    }
}
