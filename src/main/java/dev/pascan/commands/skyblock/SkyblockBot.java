package dev.pascan.commands.skyblock;

import java.awt.*;
import java.awt.event.InputEvent;
import java.security.cert.X509Certificate;

public class SkyblockBot extends Robot {
    public SkyblockBot() throws AWTException {
    }

    public void delayRandom() {
        this.delay((int) (Math.random() * 1000) + 100);
    }

    public void delayRandom200x() {
        delay((int) (Math.random() * 200));
    }

    public void openBz() {
        keyPress(47);
        delayRandom200x();
        keyPress(66);
        delayRandom200x();
        keyPress(90);
        delayRandom200x();
        keyPress(10);
    }

    public void mouseInvCoords6Tall(int x, int y) {
        mouseMove(720 + (54 * x), 251 + (54 * y));
    }

    public void mouseInvCoords5Tall(int x, int y) {
        mouseMove(720 + (54 * x), 278 + (54 * y));
    }

    public void mouseInvCoords4Tall(int x, int y) {
        mouseMove(720 + (54 * x), 305 + (54 * y));
    }

    public void maxBuyEqualPrice() {
        mouseInvCoords4Tall(6, 1);
        delayRandom();
        mousePress(1);
        delayRandom();
        mouseInvCoords4Tall(7, 1);
        delayRandom();
        mousePress(1);
        delay(200);
        keyPress(55);
        delay(50);
        keyPress(49);
        delay(50);
        keyPress(54);
        delay(50);
        keyPress(56);
        delay(50);
        keyPress(48);
        delay(200);
        mouseInvCoords5Tall(4, 7);
        delay(100);
        mousePress(1);
        delayRandom();
        mouseInvCoords4Tall(1, 1);
        delayRandom200x();
        mousePress(1);
        delayRandom200x();
        mouseInvCoords4Tall(4, 1);
        delayRandom200x();
        mousePress(1);

    }

    public void maxBuyPlusOne() {
        mouseInvCoords4Tall(6, 1);
        delayRandom();
        mousePress(1);
        delayRandom();
        mouseInvCoords4Tall(7, 1);
        delayRandom();
        mousePress(1);
        delay(200);
        keyPress(55);
        delay(50);
        keyPress(49);
        delay(50);
        keyPress(54);
        delay(50);
        keyPress(56);
        delay(50);
        keyPress(48);
        delay(200);
        mouseInvCoords5Tall(4, 7);
        delay(100);
        mousePress(1);
        delayRandom();
        mouseInvCoords4Tall(3, 1);
        delayRandom200x();
        mousePress(1);
        delayRandom200x();
        mouseInvCoords4Tall(4, 1);
        delayRandom200x();
        mousePress(1);

    }

    @Override
    public synchronized void mousePress(int buttons) {
        super.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        delay(10);
        super.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    }

    @Override
    public synchronized void keyPress(int keycode) {
        super.keyPress(keycode);
        delay(10);
        super.keyRelease(keycode);
    }

    public void categoryMining() {
        mouseInvCoords6Tall(0, 1);
        delay(80);
        mousePress(1);
    }

    public void itemMithril() {
        mouseInvCoords6Tall(3, 4);
        delay(80);
        mousePress(1);
    }

    public void itemMithrilOre() {
        mouseInvCoords5Tall(2, 1);
        delay(80);
        mousePress(1);
    }

    public void itemGold() {
        mouseInvCoords6Tall(5, 1);
        mousePress(1);
    }

    public void itemGoldIngot() {
        mouseInvCoords6Tall(2, 2);
        mousePress(1);
    }




}
