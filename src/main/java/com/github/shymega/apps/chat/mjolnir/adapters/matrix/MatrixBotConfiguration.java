package com.github.shymega.apps.chat.mjolnir.adapters.matrix;

import com.cosium.matrix_communication_client.MatrixResources;
import org.springframework.context.annotation.Configuration;

@Configuration
public final class MatrixBotConfiguration
{
    public void startMatrixBot() {
        final MatrixResources matrix = MatrixResources.factory()
                .builder()
                .https()
                .hostname("one.ems.host")
                .defaultPort()
                .usernamePassword("joebloggs", "password")
                .build();
    }
}
