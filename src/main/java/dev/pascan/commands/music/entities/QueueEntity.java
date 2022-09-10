package dev.pascan.commands.music.entities;

import java.util.ArrayList;

public class QueueEntity {
    private static ArrayList<TrackEntity> queue;

    public QueueEntity() {
        queue = new ArrayList<TrackEntity>();
    }

    public static void addTrackToFront(TrackEntity track) {
        queue.add(0, track);
    }

    public static void addTrackToBack(TrackEntity track) {
        queue.add(track);
    }

    public static void removeTrack(TrackEntity track) {
        queue.remove(track);
    }

    public static void clearQueue() {
        queue.clear();
    }

    public static TrackEntity getTrack(int index) {
        return queue.get(index);
    }

    public static int getQueueSize() {
        return queue.size();
    }

    public static boolean isEmpty() {
        return queue.isEmpty();
    }

    public static ArrayList<String> getQueueTitles() {
        ArrayList<String> titles = new ArrayList<String>();
        for (TrackEntity track : queue) {
            titles.add(track.getTitle());
        }
        return null;
    }

    public static ArrayList<String> getQueueURLs() {
        ArrayList<String> urls = new ArrayList<String>();
        for (TrackEntity track : queue) {
            urls.add(track.getUrl());
        }
        return null;
    }
}
