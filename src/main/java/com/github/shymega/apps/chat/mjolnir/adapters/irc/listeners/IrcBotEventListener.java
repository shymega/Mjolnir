package com.github.shymega.apps.chat.mjolnir.adapters.irc.listeners;

import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.SetChannelBanEvent;
import org.pircbotx.hooks.types.GenericMessageEvent;

public class IrcBotEventListener extends ListenerAdapter {
    @Override
    public void onGenericMessage(final GenericMessageEvent event) {
        // Pass details to abstract Event Handler, along with metadata.
    }

    public void onBan(final SetChannelBanEvent event) {
        // Pass details to abstract Event Handler, along with metadata.
    }
}
