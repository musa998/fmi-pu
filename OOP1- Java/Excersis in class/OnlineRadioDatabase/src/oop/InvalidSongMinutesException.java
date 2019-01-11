package oop;

public class InvalidSongMinutesException extends InvalidSongLengthException {
    public InvalidSongMinutesException(Song song) {
        super(song);
    }

    @Override
    public boolean isInvalid() {
        super.isInvalid();
        if (song.songMinutes < 0 || song.songMinutes > 14){
            System.out.println("Song minutes should be between 0 and 14.");
            return true;
        }
        return false;
    }
}
