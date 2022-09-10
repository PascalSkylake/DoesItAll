package dev.pascan.commands.music;

import org.javacord.api.event.message.MessageCreateEvent;

public class Stop {
    public Stop(MessageCreateEvent event) {
        event.getMessage().reply("Stopping music...");
        //AudioManagerCommand.closeConnection(event.getServer());
    }
}
