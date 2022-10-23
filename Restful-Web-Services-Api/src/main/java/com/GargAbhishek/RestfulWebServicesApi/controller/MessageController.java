package com.GargAbhishek.RestfulWebServicesApi.controller;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;


@RestController
public class MessageController {
    private MessageSource messageSource;

    public MessageController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @GetMapping(path = "/message-i18n")
    public String messageInternational() {
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage("good.morning.message", null, "Default Message", locale );
    }

    @GetMapping(path = "/hello-name/{name}")
    public String helloMessage(@PathVariable String name) {
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage("hello.message", new String[]{name}, "Default Message", locale );
    }

}
