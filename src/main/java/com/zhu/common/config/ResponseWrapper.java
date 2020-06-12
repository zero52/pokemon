package com.zhu.common.config;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class ResponseWrapper extends HttpServletResponseWrapper {
    private PrintWriter cachedWriter;//定义打印流，servlet里拿到后，数据通过它存到缓冲区
    private CharArrayWriter bufferedWriter;//缓冲区，用来存放后台数据
    public ResponseWrapper(HttpServletResponse response) {
        super(response);
        bufferedWriter = new CharArrayWriter();
        cachedWriter = new PrintWriter(bufferedWriter);
    }
    @Override
    public PrintWriter getWriter() throws IOException {
        return cachedWriter;
    }
    public String getResult() {
        byte[] bytes = bufferedWriter.toString().getBytes();
        try {
            return new String(bytes, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }
}