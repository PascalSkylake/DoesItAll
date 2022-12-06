package dev.pascan.commands.skyblock.robotcommands;

import dev.pascan.Constants;

public class BuyMithrilPlusOne implements Runnable {
    @Override
    public void run() {
        Constants.bot.mouseMove(810, 1060);
        Constants.bot.delay(1000);
        Constants.bot.mousePress(1);
        Constants.bot.delayRandom200x();
        Constants.bot.mouseMove(100, 100);
        Constants.bot.delayRandom200x();
        Constants.bot.openBz();
        Constants.bot.delayRandom();
        Constants.bot.categoryMining();
        Constants.bot.delayRandom();
        Constants.bot.itemMithril();
        Constants.bot.delayRandom();
        Constants.bot.itemMithrilOre();
        Constants.bot.delayRandom();
        Constants.bot.maxBuyPlusOne();
        Constants.bot.delay(500);
        Constants.bot.keyPress(84);
        Constants.bot.mouseMove(560, 1060);
        Constants.bot.delay(500);
        Constants.bot.keyPress(1);
    }
}
