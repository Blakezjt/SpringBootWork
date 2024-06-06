package com.fdzc.javaeeserver.interceptors;

import com.fdzc.javaeeserver.utils.JwtUtil;
import com.fdzc.javaeeserver.utils.ThreadLocalUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

//生成拦截器
//@Component
public class LoginInterceptors implements HandlerInterceptor {
//    @Autowired
//    private StringRedisTemplate stringRedisTemplate;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("Authorization");
        //验证token
        try {
            //从redis中获取相同的token
//            ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
//            String redisToken = operations.get(token);
//            if (redisToken==null){
//                //token已经失效了
//                throw new RuntimeException();
//            }
            Map<String, Object> claims = JwtUtil.parseToken(token);
        //把业务数据存储到ThreadLocal中
            ThreadLocalUtil.set(claims);
            //放行
            return true;
        } catch (Exception e) {
            //http响应状态码为401
            response.setStatus(401);
            //不放行
            return false;
        }
    }
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //清空ThreadLocal中的数据
        ThreadLocalUtil.remove();
    }

}
