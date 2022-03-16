package com.example.dongdong_web_app.auth.component;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Component
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        try {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.setContentType("application/json;charset=utf-8");
            JSONObject jsonObject = new JSONObject();
            String message = "잘못된 접근 입니다.";
            jsonObject.put("code", "9999");
            jsonObject.put("message", message);
            PrintWriter out = response.getWriter();
            out.print(jsonObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
