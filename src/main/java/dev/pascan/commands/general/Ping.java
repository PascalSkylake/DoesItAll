package dev.pascan.commands.general;

import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

public class Ping implements MessageCreateListener {
    @Override
    public void onMessageCreate(MessageCreateEvent event) {
        if (event.getMessageContent().equalsIgnoreCase("!ping")) {
            event.getChannel().sendMessage("" + (System.currentTimeMillis() - event.getMessage().getCreationTimestamp().toEpochMilli()) + "ms");
        }
    }
}
