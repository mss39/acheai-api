package com.api.acheai.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import java.io.IOException;
import java.util.ArrayList;

public class JWTValidarFilter extends BasicAuthenticationFilter {

    public static final String HEADER_ATRIBUTO = "Authorization";
    public static final String PREFIX_ATRIBUTO = "Bearer ";

    public JWTValidarFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {


        String atributo = request.getHeader(HEADER_ATRIBUTO);

        if(atributo == null){
            chain.doFilter(request, response);
            return;
        }

        if(!atributo.startsWith(PREFIX_ATRIBUTO)){
            chain.doFilter(request, response);
            return;
        }

        String token = atributo.replace(PREFIX_ATRIBUTO, "");
        UsernamePasswordAuthenticationToken authenticationToken = getAuthenticationToken(token);

        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        chain.doFilter(request, response);
    }

    private UsernamePasswordAuthenticationToken getAuthenticationToken(String token){
        String usuario = JWT.require(Algorithm.HMAC512(JWTAutenticarFilter.TOKEN_SENHA))
                .build()
                .verify(token)
                .getSubject();

        if(usuario == null){
            return null;
        }

        return new UsernamePasswordAuthenticationToken(usuario, null, new ArrayList<>());
    }
}
