package com.github.shymega.apps.chat.mjolnir.observer.events;

import com.github.shymega.apps.chat.mjolnir.adapters.IncomingMessage;

public class AdapterMessageReceivedEvent<T extends IncomingMessage> extends BaseEvent {
    protected T payload;
    public AdapterMessageReceivedEvent(final Object source) {
        super(source);
    }
}
