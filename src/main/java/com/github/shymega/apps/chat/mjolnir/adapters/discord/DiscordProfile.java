package com.github.shymega.apps.chat.mjolnir.adapters.discord;

import lombok.*;

@Data
@Builder
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class DiscordProfile {
    protected String GUILD_ID = null;
    protected String[] PRESET_ADMIN_IDS = null;
    protected Boolean enabled = false;
}
