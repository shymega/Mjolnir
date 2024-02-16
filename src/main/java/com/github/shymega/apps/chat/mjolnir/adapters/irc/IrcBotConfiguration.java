package com.github.shymega.apps.chat.mjolnir.adapters.irc;

import com.github.shymega.apps.chat.mjolnir.adapters.irc.listeners.IrcBotEventListener;
import org.pircbotx.PircBotX;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.net.ssl.SSLSocketFactory;

@Configuration
public class IrcBotConfiguration {
    @Bean
    public PircBotX buildIrcBot() {
        org.pircbotx.Configuration config = new org.pircbotx.Configuration.Builder()
                .setName("Pine64_Mjolnir")
                .addServer("irc.libera.chat", 6697)
                .setSocketFactory(SSLSocketFactory.getDefault())
                .setAutoNickChange(false)
                .setAutoReconnect(false)
                .addListener(new IrcBotEventListener())
                .buildConfiguration();

        return new PircBotX(config);
    }
}
