package dev.pascan.commands.music.entities;

import java.net.URL;

public class TrackEntity {
    private String title;
    private String url;
    private int queuePos;

    public TrackEntity(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }    public String getUrl() {
        return url;
    }
    public int getQueuePos() { return queuePos; }
    public void setQueuePos(int queuePos) { this.queuePos = queuePos; }

}
