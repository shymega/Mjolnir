package com.github.shymega.apps.chat.mjolnir.adapters.matrix.listeners;

import com.cosium.matrix_communication_client.ClientEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

public interface MatrixBotListener<T extends ClientEvent> {
    Logger log = LoggerFactory.getLogger(MatrixBotListener.class);
    Class<T> getMatrixEventType();
    Mono<Void> execute(T event);

    default Mono<Void> handleError(final Throwable err) {
        log.error("Unable to process event.");
        log.error("Event: " + getMatrixEventType().getSimpleName() + ": " + err.getMessage());
        return Mono.empty();
    }
}
