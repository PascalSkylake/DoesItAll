package dev.pascan.commands.music;

import org.javacord.api.audio.AudioConnection;

public class AudioManager {
    private AudioConnection connection;
    public AudioManager(AudioConnection audioConnection) {
        this.connection = audioConnection;
    }


}
