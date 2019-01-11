package oop;

public class InvalidSongSecondsException extends InvalidSongMinutesException {
    public InvalidSongSecondsException(Song song) {
        super(song);
    }

    @Override
    public boolean isInvalid() {
        super.isInvalid();
        if (song.songRealSeconds < 0 || song.songRealSeconds > 59){
            System.out.println("Song seconds should be between 0 and 59.");
            return true;
        }
        return false;
    }
}
