package com.ironhack.userservice.utils.classes;

import org.springframework.security.crypto.bcrypt.*;
import org.springframework.security.crypto.password.*;

public class PasswordUtil {
    public static void main(String[] args) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        System.out.println(passwordEncoder.encode("12345678"));
        //$2a$10$8xxZdiGoq.O7GavRdhiDCeO.fa5EGRstd7eYQjPTfon9Ysff8r1K6
    }
}
