package com.feidian.demo.errorHandler;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 *异常处理类*/
// @ControllerAdvice
// public class GlobalExceptionHandler {
//     @ExceptionHandler(value = Exception.class)
//     @ResponseBody
//     private Map<String,Object> returnErrorData(HttpServletRequest request, Exception e){
//         Map<String,Object> modelMap=new HashMap<String, Object>();
//         modelMap.put("errno",-1);
//         modelMap.put("errMsg",e.getMessage());
//         return modelMap;
//     }
// }
