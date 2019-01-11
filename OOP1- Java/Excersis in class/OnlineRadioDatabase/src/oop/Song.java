package oop;

public class Song {
    String atristName;
    String songName;
    String songLenght;
    private float songMinutes;
   private float songSeconds;
    float realSongLen;
    float songRealSeconds;

    public float getSongRealSeconds() {
        return songRealSeconds;
    }

    public void setSongRealSeconds() {
        String[] arr = songLenght.split(":");
        this.songRealSeconds = Float.parseFloat(arr[1]);
    }

    public float getRealSongLen() {
        return realSongLen;
    }

    public void setRealSongLen() {
        this.realSongLen = songMinutes+songSeconds;
    }

    public Song(String atristName, String songName, String songLenght, float songMinutes, int songSeconds) {
        this.atristName = atristName;
        this.songName = songName;
        this.songLenght = songLenght;
        setSongMinutes();
        setSongSeconds();
        setRealSongLen();
    }

    public float getSongMinutes() {
        return songMinutes;
    }

    public void setSongMinutes() {
        String[] arr = songLenght.split(":");
        this.songMinutes = Float.parseFloat(arr[0]);
    }

    public float getSongSeconds() {
        return songSeconds;
    }

    public void setSongSeconds() {
        String[] arr = songLenght.split(":");
        if (Float.parseFloat(arr[1]) <= 100) {
            this.songSeconds = Float.parseFloat(arr[1]) / 100;
        }
        else {
            this.songSeconds = Float.parseFloat(arr[1]) / 1000;
        }
    }

    public Song(String atristName, String songName, String songLenght) {
        this.atristName = atristName;
        this.songName = songName;
        this.songLenght = songLenght;
        setSongMinutes();
        setSongSeconds();
        setRealSongLen();
        setSongRealSeconds();
    }

}
