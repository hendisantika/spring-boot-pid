package com.hendisantika.springbootpid;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.ApplicationPidFileWriter;

@SpringBootApplication
public class SpringBootPidApplication {

    public static void main(String[] args) {
//        SpringApplication.run(SpringBootPidApplication.class, args);
        SpringApplication springApplication = new SpringApplication(SpringBootPidApplication.class);
        springApplication.addListeners(new ApplicationPidFileWriter());
        springApplication.run(args);

    }

}

