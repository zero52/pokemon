package com.zhu.common.aop;/*
2019/11/27
41586
*/

import com.zhu.modules.sys.entity.User;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Aspect
@Component
public class AuthHandle {

    private static final String NEED_LOGIN = "请先登录";
    private static final String TEACHER_AND_ADMIN = "只有教师或管理员有权操作！";
    private static final String NEED_ADMIN = "只有管理员有权操作！";

    @Pointcut(value = "execution(public * com.zhu.modules.*.*(..))")
    public void start(){
    }

    @Around("start()")
    public void access(ProceedingJoinPoint joinPoint){
    System.out.println("start()");
    }

    @Before("start()")
    // @Before("execution(* cn.freemethod.business.HaveResultBusiness.*(..))")
    public void before() {
        System.out.println("TimingAspect before...");
    }

    @Around("start()")
    public Object doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.currentTimeMillis();
        Object retVal = pjp.proceed();
        long end = System.currentTimeMillis();
        System.out.println("time elapse:" + (end - start));
        return retVal;
    }

    @After("start()")
    public void after() {
        System.out.println("TimingAspect after...");
    }

    @AfterThrowing(pointcut = "start()", throwing = "ex")
    public void doRecoveryActions(Exception ex) {
        System.out.println("@AfterThrowing:" + ex.getMessage());
    }

    @AfterReturning(pointcut = "start()", returning = "retVal")
    public void doAccessCheck(Object retVal) {
        System.out.println("@AfterReturning:"+retVal);
    }

    /**
     * 从session中获取当前用户
     * @return
     */
    private User getUser(){
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) requestAttributes;
        HttpServletRequest request = servletRequestAttributes.getRequest();
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        return user;
    }

    /**
     * 判断某方法上是否含有某注解
     * @return
     */
    private boolean hasAnnotationOnMethod(){

        return true;
    }
}
