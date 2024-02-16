package com.github.shymega.apps.chat.mjolnir.adapters.discord.listeners;

import discord4j.core.event.domain.Event;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

public interface DiscordBotEventListener<T extends Event> {
    Logger LOG = LoggerFactory.getLogger(DiscordBotEventListener.class);

    Class<T> getDiscordEventType();
    Mono<Void> execute(T event);

    default Mono<Void> handleError(Throwable err) {
        LOG.error("Unable to process event.");
        LOG.error("Event: " + getDiscordEventType().getSimpleName() + ": " + err.getMessage());
        return Mono.empty();
    }
}
