package com.trainticket.config.security;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.nio.charset.Charset;

/**
 * @Author user
 * @Date 2020/12/15 11:35 AM
 * @Version 1.0
 */
@Component
public class TtPasswordEncoder implements PasswordEncoder {
    public static final String KEY_SECRET = "qw2323dwewefcsdweds34534rwed3";
    @Override
    public String encode(CharSequence charSequence) {
        byte[] bytes = charSequence.toString().getBytes(Charset.defaultCharset());
        byte[] bytes1 = KEY_SECRET.getBytes(Charset.defaultCharset());
        byte[] resBytes = new byte[bytes.length];
        for (int i = 0; i < bytes.length; i++){
            resBytes[i] = (byte) (bytes[i] ^ bytes1[i % bytes1.length]);
        }
        return new String(resBytes, Charset.defaultCharset());
    }

    @Override
    public boolean matches(CharSequence original, String cipherText) {
        return encode(original).equals(cipherText);
    }
}
