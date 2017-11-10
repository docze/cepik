package com.mwsi.cepik.security;

import java.security.SecureRandom;

public class SecretGenerator {

    static String getSecret(){
        SecureRandom rand = new SecureRandom();
        byte[] values = new byte[256];

        rand.nextBytes(values);

        return new String(values);
    }
}
