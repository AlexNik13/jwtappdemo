package net.proselyte.jwtappdemo.security.jwt;


import org.springframework.security.core.AuthenticationException;

//исключения

public class JwtAuthenticationException extends AuthenticationException {


    public JwtAuthenticationException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public JwtAuthenticationException(String msg) {
        super(msg);
    }
}
