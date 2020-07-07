package com.virtusaproject.vsharesecurities.server;

import com.virtusaproject.vsharesecurities.VShareSecuritiesApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(VShareSecuritiesApplication.class);
    }

}
