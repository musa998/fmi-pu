package oop;

public class InvalidSongLengthException extends InvalidSongNameException {
    public InvalidSongLengthException(Song song) {
        super(song);
    }

    @Override
    public boolean isInvalid() {
        super.isInvalid();
        if (song.realSongLen < 0 || song.realSongLen >= 15){
            System.out.println("Invalid song length.");
            return true;
        }
        return false;
    }
}
