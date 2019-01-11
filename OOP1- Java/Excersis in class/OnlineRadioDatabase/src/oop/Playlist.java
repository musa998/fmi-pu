package oop;

import java.util.ArrayList;

public class Playlist {

    ArrayList<Song> allSongs = new ArrayList<>();

    public double LenghtOfPlaylist(){
        double result = 0;
        for (int i = 0; i < allSongs.size(); i++) {
             result += allSongs.get(i).realSongLen;
        }
        return result;
    }

    public void addSong(Song song){
        allSongs.add(song);
    }
    public int numberOfSongs(){
        return allSongs.size();
    }
}
