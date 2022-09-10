package dev.pascan.commands.music;

import org.javacord.api.event.message.MessageCreateEvent;

public class Play {
    public Play(MessageCreateEvent event) {
        String[] args = event.getMessageContent().split(" ");
        if (args.length == 1) {
            event.getChannel().sendMessage("Usage: !play <url>");
            return;
        }
        String url = args[1];
        event.getChannel().sendMessage("Playing " + url);
    }
}
