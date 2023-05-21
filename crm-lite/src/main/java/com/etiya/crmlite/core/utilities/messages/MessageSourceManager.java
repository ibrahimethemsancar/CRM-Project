package com.etiya.crmlite.core.utilities.messages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

@Service
public class MessageSourceManager implements IMessageSourceService {
    private MessageSource messageSource;

    @Autowired
    public MessageSourceManager(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @Override
    public String getMessage(String code) {
        return messageSource.getMessage(code,null, LocaleContextHolder.getLocale());
    }
}
