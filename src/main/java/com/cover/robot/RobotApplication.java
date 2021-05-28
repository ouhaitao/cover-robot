package com.cover.robot;

import com.cover.robot.controller.ProcessController;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class RobotApplication {

    public static void main(String[] args) throws Exception{
        SpringApplicationBuilder builder = new SpringApplicationBuilder(RobotApplication.class);
        ConfigurableApplicationContext context = builder.headless(false).run(args);
        ProcessController bean = context.getBean(ProcessController.class);
        bean.processStart("all");
    }

}
