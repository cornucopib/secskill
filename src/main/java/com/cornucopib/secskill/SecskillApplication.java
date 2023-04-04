package com.cornucopib.secskill;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.cornucopib.secskill"})
public class SecskillApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecskillApplication.class, args);
    }

}
