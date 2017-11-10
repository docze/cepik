package com.mwsi.cepik.security;

class SecurityConstants {

    static final String SECRET = SecretGenerator.getSecret();
    static final long EXPIRATION_TIME = 864_000_000; // 10 days
    static final String TOKEN_PREFIX = "Token ";
    static final String HEADER_STRING = "Authorization";
    static final String SIGN_UP_URL = "/api/register";
}
