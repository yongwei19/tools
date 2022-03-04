package com.test.tools.exception;

import com.test.tools.vo.JsonResult;
import org.apache.catalina.connector.ClientAbortException;
//import org.hibernate.exception.JDBCConnectionException;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.transaction.CannotCreateTransactionException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.UnexpectedTypeException;
import java.sql.SQLTransientConnectionException;

@ControllerAdvice
public class GlobalExceptionHandler {
    // 声明要捕获的异常
    @ExceptionHandler(Error.class)
    @ResponseBody
    public JsonResult defaultError(HttpServletRequest request, Error e) {
        if (e instanceof NoClassDefFoundError) {
            return JsonResult.fail("找不到类错误" + e.getMessage());
        }
        // 未知错误
        e.printStackTrace();
        return JsonResult.fail("项目运行异常, 请联系技术人员...");
    }

    // 声明要捕获的异常
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public JsonResult defaultException(HttpServletRequest request, Exception e) {
        // 请求方式有误
        if (e instanceof HttpRequestMethodNotSupportedException) {
            return JsonResult.warn("请求方式POST/GET有误");
        }

        /**
         * @Validated 进行接口参数校验统一处理
         */
        if (e instanceof MethodArgumentNotValidException) {
            MethodArgumentNotValidException exception = (MethodArgumentNotValidException)e;
            return JsonResult.warn(exception.getBindingResult().getFieldErrors().get(0).getDefaultMessage());
        }

        /**
         * 缺少参数异常
         */
        if (e instanceof MissingServletRequestParameterException) {
            return JsonResult.warn("缺少请求参数");
        }

        /**
         * 接口请求不对
         */
        if (e instanceof InvalidDataAccessApiUsageException) {
            return JsonResult.warn("请检查接口请求是否缺少参数");
        }

        // 参数格式有误，比如int类型输入了abc
        if (e instanceof HttpMessageNotReadableException) {
            return JsonResult.warn("参数格式异常：" + e.getMessage());
        }

        if (e instanceof NumberFormatException) {
            return JsonResult.warn("参数格式异常" + e.getMessage());
        }

        /**
         * 没有匹配到的数据
         */
        if (e instanceof EmptyResultDataAccessException) {
            return JsonResult.warn("数据不存在, 请检查参数是否正确");
        }

        /**
         * 前面的都是警告，不输出错误信息
         */
        e.printStackTrace();

        // id用了@NotBlank
        if (e instanceof UnexpectedTypeException) {
            return JsonResult.fail("请求参数类型异常" + e.getMessage());
        }

//        // 数据库异常
//        if (e instanceof JDBCConnectionException) {
//            return JsonResult.fail("数据库连接异常");
//        }
        if (e instanceof DataAccessResourceFailureException) {
            return JsonResult.fail("数据库连接异常");
        }
        if (e instanceof SQLTransientConnectionException) {
            return JsonResult.fail("数据库连接异常");
        }
        if (e instanceof CannotCreateTransactionException) {
            return JsonResult.fail("数据库连接异常");
        }

        if (e instanceof ClientAbortException) {
            return JsonResult.fail("中止了一个已建立的连接");
        }

        // 空指针异常
        if (e instanceof NullPointerException) {
            e.printStackTrace();
            return JsonResult.fail("空指针异常");
        }

        // 未知错误
        return JsonResult.fail("服务器处理异常, 请联系技术人员...");
    }

}
