package com.github.shymega.apps.chat.mjolnir.adapters.discord.listeners;

import discord4j.core.event.domain.message.MessageCreateEvent;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class DiscordBotMessageCreateEventListener implements DiscordBotEventListener<MessageCreateEvent> {
    @Override
    public Class<MessageCreateEvent> getDiscordEventType() {
        return MessageCreateEvent.class;
    }

    @Override
    public Mono<Void> execute(MessageCreateEvent event) {
        // Pass details to abstract Event Handler, along with metadata.
        return Mono.empty();
    }
}
