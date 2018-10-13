package edu.just.sheyang.safety;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = "edu.just.sheyang.safety.dao")
public class SafetyApplication {

    public static void main(String[] args) {
        SpringApplication.run(SafetyApplication.class, args);
    }
}
