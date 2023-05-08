package com.cornucopib.secskill;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.cornucopib.secskill"})
@MapperScan("com.cornucopib.secskill.*.dao")
public class SecskillApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecskillApplication.class, args);
    }

}
