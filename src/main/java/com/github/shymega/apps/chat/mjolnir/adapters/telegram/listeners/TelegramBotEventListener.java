package com.github.shymega.apps.chat.mjolnir.adapters.telegram.listeners;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

@Service
public class TelegramBotEventListener extends TelegramLongPollingBot {
    @Override
    public void onUpdateReceived(Update update) {
        // Pass details to abstract Event Handler, along with metadata.
    }

    @Override
    public String getBotUsername() {
        // TODO.
        return null;
    }
}
