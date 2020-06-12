package com.zhu.common.config;/*
2019/11/27
41586
*/

import com.zhu.modules.sys.entity.User;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@ServletComponentScan
@WebFilter(urlPatterns = "/a/*", filterName = "customerFilter")
public class CustomerFilter implements Filter {

    //private static final Logger logger = LoggerFactory.getLogger(CustomerFilter.class);
    private String name;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        name = filterConfig.getInitParameter("name");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httprequest = (HttpServletRequest) request;
        System.out.println(httprequest.getRequestURL());
        if (httprequest.getHeader("x-forwarded-for") == null)
        {
            System.out.println("ip:"+httprequest.getRemoteAddr());
        }else {
            System.out.println("ip:"+httprequest.getHeader("x-forwarded-for"));
        }
        User user = (User) httprequest.getSession().getAttribute("user");
        if(user==null){
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/login");

            requestDispatcher.forward(request, response);

            return;
        }
        chain.doFilter(request, response);


        //设置假response 里面有缓冲区，假的writer
//        ResponseWrapper wrapper = new ResponseWrapper((HttpServletResponse) response);
//        chain.doFilter(request, wrapper);
//        //分界线，request拦截执行从这往前的代码，resposne拦截执行该行之后的代码
//        //后台已经把数据封装到缓冲区中，这里是取出来
//        String result = wrapper.getResult();
//        //后台数据编辑后，通过真正的response写到前台页面去
//        response.getOutputStream().write(result.getBytes());
    }

    @Override
    public void destroy() {

    }
}