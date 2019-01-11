package oop;

public class InvalidSongException {


    Song song;
    public InvalidSongException(Song song){
        this.song = song;
    }
    public InvalidSongException(){}

    public boolean isInvalid(){

        return false;

    }
}
