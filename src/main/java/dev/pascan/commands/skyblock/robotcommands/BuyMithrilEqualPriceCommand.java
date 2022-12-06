package dev.pascan.commands.skyblock.robotcommands;

import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

public class BuyMithrilEqualPriceCommand implements MessageCreateListener {
    @Override
    public void onMessageCreate(MessageCreateEvent event) {
        if (event.getMessageContent().contains("!buymithril")) {
            if (event.getMessageContent().contains("+1")) {
                new Thread(new BuyMithrilPlusOne()).start();
            } else {
                new Thread(new BuyMithrilEqualPrice()).start();
            }
        }
    }
}
