package com.kdn.ecsi.epengine;

// import de.codecentric.boot.admin.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
// @EnableAutoConfiguration(exclude = SecurityAutoConfiguration.class)
// @EnableAdminServer
public class Application {
    public static void main(String[] args) {

        // List<Class<?>> classes = ClassFinder.find("com.package");

        SpringApplication.run(Application.class, args);
        // AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
    }
}
