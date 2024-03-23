package com.github.shymega.apps.chat.mjolnir.adapters.discord;

import discord4j.core.DiscordClientBuilder;
import discord4j.core.GatewayDiscordClient;
import discord4j.core.event.domain.Event;
import com.github.shymega.apps.chat.mjolnir.adapters.discord.listeners.DiscordBotEventListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import java.util.Arrays;
import java.util.List;

@Configuration
public final class DiscordBotConfiguration {
    @Autowired
    private Environment environment;

    private void constructDiscordBot() throws IllegalAccessException {
        if (environment == null) throw new IllegalAccessException("Environment is null.");

        Arrays.stream(environment.getActiveProfiles())
                .forEach(profile -> {
                    if (profile.equals("discord")) {
                        // Start the Discord bot.
                        DiscordProfile discordProfile = processDiscordProfile();
                    }
                });
    }

    private DiscordProfile processDiscordProfile() {
        return new DiscordProfile();
    }

    @Value("${mjolnir.adapters.discord.token}")
    private String discordToken;

    @Bean
    public <T extends Event> GatewayDiscordClient buildDiscordBot(List<DiscordBotEventListener<T>> listeners) {
        GatewayDiscordClient client = DiscordClientBuilder.create(this.discordToken)
                .build()
                .login()
                .block();

        for (DiscordBotEventListener<T> listener : listeners) {
            client.on(listener.getDiscordEventType())
                    .flatMap(listener::execute)
                    .onErrorResume(listener::handleError)
                    .subscribe();
        }

        return client;
    }
}
