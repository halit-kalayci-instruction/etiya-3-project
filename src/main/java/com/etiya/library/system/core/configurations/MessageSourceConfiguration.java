package com.etiya.library.system.core.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import java.util.Locale;

@Configuration
public class MessageSourceConfiguration {
    @Bean
    public ResourceBundleMessageSource bundleMessageSource(){
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        // DB bağlantısı
        messageSource.setBasename("messages");
        return messageSource;
    }

    @Bean
    public LocaleResolver localeResolver(){
        // Accept-Language
        AcceptHeaderLocaleResolver acceptHeaderLocaleResolver = new AcceptHeaderLocaleResolver();
        acceptHeaderLocaleResolver.setDefaultLocale(new Locale("tr"));
        return acceptHeaderLocaleResolver;
    }
}
