package mss.tool.global;


import org.omg.CORBA.UserException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalDefaultExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e) {
        if (e instanceof UserException) {
            UserException userException = (UserException) e;
            return Result.ofFail(CommonErrorCode.EXCEPTION);
        } else {
            return Result.ofFail("-1", e.getMessage());
        }
    }
}