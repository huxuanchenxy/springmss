package mss.tool.global;


import com.alibaba.fastjson.JSON;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@ControllerAdvice
public class GlobalResponseHandler implements ResponseBodyAdvice<Object> {

    private GlobalDefaultProperties globalDefaultProperties;

    public GlobalResponseHandler(GlobalDefaultProperties globalDefaultProperties) {
        this.globalDefaultProperties = globalDefaultProperties;
    }

//    @Override
//    @SuppressWarnings("all")
//    public boolean supports(MethodParameter methodParameter,
//                            Class<? extends HttpMessageConverter<?>> aClass) {
//        return filter(methodParameter);
//    }

    //判断支持的类型
    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        // 检查注解是否存在，存在则忽略拦截
        if (methodParameter.getDeclaringClass().isAnnotationPresent(IgnoreResponseAdvice.class)) {
            return false;
        }
        if (methodParameter.getMethod().isAnnotationPresent(IgnoreResponseAdvice.class)) {
            return false;
        }
        return true;
    }

//    @Nullable
//    @Override
//    @SuppressWarnings("all")
//    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType,
//                                  Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest,
//                                  ServerHttpResponse serverHttpResponse) {
//
//        // 返回值为 Object 类型  并且返回为空是  AbstractMessageConverterMethodProcessor#writeWithMessageConverters 方法
//        // 无法触发调用本类的 beforeBodyWrite 处理，开发在 Controller 尽量避免直接使用 Object 类型返回。
//
//        // o is null -> return response
//        if (o == null) {
//            // 当 o 返回类型为 string 并且为null会出现 java.lang.ClassCastException: Result cannot be cast to java.lang.String
//            if (methodParameter.getParameterType().getName().equals("java.lang.String")) {
//                return JSON.toJSON(Result.ofSuccess()).toString();
//            }
//            return Result.ofSuccess();
//        }
//        // o is instanceof ConmmonResponse -> return o
//        if (o instanceof Result) {
//            return (Result<Object>) o;
//        }
//        // string 特殊处理 java.lang.ClassCastException: Result cannot be cast to java.lang.String
//        if (o instanceof String) {
//            return JSON.toJSON(Result.ofSuccess(o)).toString();
//        }
//        return Result.ofSuccess(o);
//    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        // 判断为null构建ResponseData对象进行返回
        if (o == null) {
            return Result.ofSuccess();
        }
        // 判断是ResponseData子类或其本身就返回Object o本身，因为有可能是接口返回时创建了ResponseData,这里避免再次封装
        if (o instanceof Result) {
            return (Result<Object>) o;
        }
        // String特殊处理，否则会抛异常
        if (o instanceof String) {
            return JSON.toJSON(Result.ofSuccess(0)).toString();
        }
        return Result.ofSuccess(0);
    }

    private Boolean filter(MethodParameter methodParameter) {
        Class<?> declaringClass = methodParameter.getDeclaringClass();
        // 检查过滤包路径
        long count = globalDefaultProperties.getAdviceFilterPackage().stream()
                .filter(l -> declaringClass.getName().contains(l)).count();
        if (count > 0) {
            return false;
        }
        // 检查<类>过滤列表
        if (globalDefaultProperties.getAdviceFilterClass().contains(declaringClass.getName())) {
            return false;
        }
        // 检查注解是否存在
        if (methodParameter.getDeclaringClass().isAnnotationPresent(IgnoreResponseAdvice.class)) {
            return false;
        }
        if (methodParameter.getMethod().isAnnotationPresent(IgnoreResponseAdvice.class)) {
            return false;
        }
        return true;
    }

}
