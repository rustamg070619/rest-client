package com.example.restclient.config.handler;

import com.example.restclient.model.Role;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Component
public class LoginSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest,
                                        HttpServletResponse httpServletResponse,

                                        Authentication authentication) throws IOException, ServletException {
        List<SimpleGrantedAuthority> list = (List) authentication.getAuthorities();
        String role = list.get(0).toString();
        if (role.equals("ROLE_ADMIN")) {

            httpServletResponse.sendRedirect("/admin");
        } else if (role.equals("ROLE_USER")) {
            String name = httpServletRequest.getParameter("j_username");
            httpServletResponse.sendRedirect("/user/" + name);
        }

    }
}