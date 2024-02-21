package com.github.etinaa.assignment;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
@SuppressWarnings("PMD.UseUtilityClass")
public class Application {

    public static void main(final String[] args) {
        new SpringApplicationBuilder().sources(Application.class).bannerMode(Banner.Mode.OFF).run(args);
    }

}
