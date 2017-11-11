package com.mwsi.cepik.security;

import java.util.Arrays;
import java.util.List;

class SecurityConstants {
    static final String FRONT_URL = "http://localhost:4200";
    static final List<String> ALLOWED_ORIGIN_METHODS = Arrays.asList("GET", "POST", "PUT");
    static final String SECRET = SecretGenerator.getSecret();
    static final long EXPIRATION_TIME = 864_000_000; // 10 days
    static final String TOKEN_PREFIX = "Token ";
    static final String HEADER_STRING = "Authorization";
    static final String SIGN_UP_URL = "/api/register";
}
