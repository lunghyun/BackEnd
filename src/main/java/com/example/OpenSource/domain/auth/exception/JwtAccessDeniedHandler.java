package com.example.OpenSource.domain.auth.exception;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class JwtAccessDeniedHandler implements AccessDeniedHandler {
    /*
    JwtExceptionFilter 를 통해 여기까지 오기 전에 미리 JWTException 를 일으켜서
    JwtExceptionFilter 가 그 Exception 을 잡아서 처리 한 뒤, 반환하기에 필요없는 클래스
     */
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        // 필요한 권한이 없이 접근하려 할때 - 403 error
        response.sendError(HttpServletResponse.SC_FORBIDDEN);
    }
}