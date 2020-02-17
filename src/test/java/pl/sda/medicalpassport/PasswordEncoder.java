package pl.sda.medicalpassport;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoder {

    @Test
    public void encodePassword(){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encryptedPass = bCryptPasswordEncoder.encode("user");
        System.out.println(encryptedPass);
    }
}
