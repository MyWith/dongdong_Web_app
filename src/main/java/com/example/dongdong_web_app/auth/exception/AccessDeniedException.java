package com.example.dongdong_web_app.auth.controller;

import com.example.dongdong_web_app.auth.component.CustomAuthenticationEntryPoint;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/exception")
public class ExceptionController {
    @GetMapping("/entrypoint")
    public CommonResult{
        throw new CustomAuthenticationEntryPoint();
    }
}
