package com.github.shymega.apps.chat.mjolnir.adapters.telegram;

import com.github.shymega.apps.chat.mjolnir.adapters.telegram.listeners.TelegramBotEventListener;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@Configuration
public final class TelegramBotConfiguration {
    public void startTelegramBot() throws TelegramApiException {
        try {
            final TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(new TelegramBotEventListener());
        } catch (final TelegramApiException e) {
            // Handle gracefully.
            e.printStackTrace();
        }
    }
}
