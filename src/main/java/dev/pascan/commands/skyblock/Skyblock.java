package dev.pascan.commands.skyblock;

import dev.pascan.Constants;
import dev.pascan.commands.skyblock.classes.bazaar.Bazaar;
import dev.pascan.commands.skyblock.classes.bazaar.Product;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

public class Skyblock implements MessageCreateListener {
    @Override
    public void onMessageCreate(MessageCreateEvent event) {
        if (event.getMessageContent().startsWith(Constants.prefix + "bazaar") || event.getMessageContent().startsWith(Constants.prefix + "bz")) {
            Bazaar tempBz = SkyblockAPI.getBazaar();
            Product tempProduct = tempBz.products.get(Integer.parseInt(event.getMessageContent().split(" ")[1]));
            String message =
                tempProduct.sell_summary.get(1).pricePerUnit + " each, with " +
                tempProduct.sell_summary.get(1).amount + " from " +
                tempProduct.sell_summary.get(1).orders + " orders";
            event.getMessage().reply(message);
            //event.getMessage().reply("Specify a command.");
        }
    }


}
