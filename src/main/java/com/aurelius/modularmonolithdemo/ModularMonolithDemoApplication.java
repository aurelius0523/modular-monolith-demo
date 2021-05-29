package com.aurelius.modularmonolithdemo;

import com.aurelius.modularmonolithdemo.authors.configs.AuthorModuleConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(AuthorModuleConfig.class)
public class ModularMonolithDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ModularMonolithDemoApplication.class, args);
    }

}
