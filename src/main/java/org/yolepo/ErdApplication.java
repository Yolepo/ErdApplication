package org.yolepo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;

@SpringBootApplication
public class ErdApplication {

    public static void main(String[] args) {
        SpringApplication.run(ErdApplication.class, args);
    }

    @Bean
    public EmbeddedServletContainerCustomizer servletContainerCustomizer() {
        return c -> c.addErrorPages(new ErrorPage(HttpStatus.BAD_REQUEST, "/error/400.html"));
    }
}
