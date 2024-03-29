package br.edu.utfpr.pb.tcc.security.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.context.support.WebApplicationContextUtils;

import br.edu.utfpr.pb.tcc.AppConstant;
import br.edu.utfpr.pb.tcc.security.TokenUtils;
import br.edu.utfpr.pb.tcc.service.impl.UsuarioServiceImpl;

public class AuthenticationTokenFilter extends UsernamePasswordAuthenticationFilter {

    @Autowired
    private TokenUtils tokenUtils;

    @Autowired
    private UsuarioServiceImpl userDetailsService;

    @Override
    public void doFilter(ServletRequest request, 
    		ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
    	
        tokenUtils = WebApplicationContextUtils
                .getRequiredWebApplicationContext(
                		this.getServletContext())
                .getBean(TokenUtils.class);
        userDetailsService = WebApplicationContextUtils
                .getRequiredWebApplicationContext(
                		this.getServletContext())
                .getBean(UsuarioServiceImpl.class);

        HttpServletResponse resp = (HttpServletResponse) response;
        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE, PATCH");
        resp.setHeader("Access-Control-Max-Age", "3600");
        resp.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, " + AppConstant.TOKEN_HEADER);


        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String authToken = httpRequest.getHeader(AppConstant.TOKEN_HEADER);
        String username = this.tokenUtils.getUsernameFromToken(authToken);

        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
            if (this.tokenUtils.validateToken(authToken, userDetails)) {
                UsernamePasswordAuthenticationToken authentication =
                        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpRequest));
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }
		
        chain.doFilter(request, response);
    }
}

