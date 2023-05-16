package com.etiya.library.system.core.internationalization;

public interface MessageService {
    String getMessage(String keyword);
    String getMessageWithParams(String keyword, Object... params);
}
