package com.fdzc.javaeeserver.exception;


import com.fdzc.javaeeserver.common.R;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//当某个控制器中抛出异常时，@RestControllerAdvice 注解所标注的类将会被自动调用，
// 并根据异常类型和处理程序的注解来决定如何处理该异常。类似地，当控制器返回数据时，
// @RestControllerAdvice 注解所标注的类也将会被调用，根据返回数据的类型和处理程序的注解来决定如何处理该数据

//用于统一处理控制器异常和返回结果的注解，它可以被用来定义全局异常处理程序和全局响应结果处理程序。
@RestControllerAdvice
public class GlobalExceptionHandler {

//    @ExceptionHandler注解我们一般是用来自定义异常的。
//    可以认为它是一个异常拦截器（处理器）。
//    此时注解的参数是Exception.class，表示只有方法抛出Exception时，才会调用该方法。
    @ExceptionHandler(Exception.class)
    public R handleException(Exception e){
        e.printStackTrace();
        //StringUtils.hasLength()如果字符序列不为 null 值,并且字符序列的长度大于 0 ,则返回 true
        return R.error(StringUtils.hasLength(e.getMessage())? e.getMessage() :"操作失败");
    }
}
