package dev.pascan.commands.orbits;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class RigCTLClient {
    private static final String HOST = "localhost";
    private static final int PORT = 4532;

    public static void setFrequency(int frequency) {
        sendCommand("F " + frequency);
    }

    public static void setBandwidth(int bandwidth) {
        sendCommand("W " + bandwidth);
    }

    private static void sendCommand(String command) {
        try (Socket socket = new Socket(HOST, PORT);
             PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            writer.println(command);

            // Read the response from the rigctl server
            String response;
            while ((response = reader.readLine()) != null) {
                System.out.println(response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
