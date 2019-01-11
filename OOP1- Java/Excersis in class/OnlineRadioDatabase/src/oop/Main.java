package oop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader( new InputStreamReader(System.in));
        InvalidSongSecondsException exception;
        Playlist playlist = new Playlist();

        int n = Integer.parseInt(reader.readLine());

            for (int i = 0; i < n; i++) {
                String[] info = reader.readLine().split(";");
                Song song = new Song(info[0], info[1], info[2]);
                exception = new InvalidSongSecondsException(song);
                if (exception.isInvalid() == false){
                    System.out.println("Song added.");
                    playlist.addSong(song);

                }

            }
        System.out.println("Songs added "+ playlist.numberOfSongs());
        System.out.println("Playlist lenght " + playlist.LenghtOfPlaylist());




    }
}
