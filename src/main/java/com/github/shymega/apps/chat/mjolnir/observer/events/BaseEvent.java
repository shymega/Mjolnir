package com.github.shymega.apps.chat.mjolnir.observer.events;

import lombok.*;
import org.springframework.context.ApplicationEvent;

import java.time.OffsetDateTime;

public class BaseEvent extends ApplicationEvent {
    protected final OffsetDateTime CREATED_TIMESTAMP = OffsetDateTime.now();
    public BaseEvent(final Object source) {
        super(source);
    }
}
