package com.github.shymega.apps.chat.mjolnir.adapters;

import lombok.*;

import java.time.OffsetDateTime;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class IncomingMessage {
    protected String author;
    protected Boolean isBot;
    protected boolean isSelf;
    protected String message;
    protected OffsetDateTime timestamp;
    protected String[] mentions;
    protected String channel;
    protected String guild;
}
