package oop;

public class InvalidSongNameException extends InvalidArtistNameException {

    public InvalidSongNameException(Song song) {
        super(song);
    }

    @Override
    public boolean isInvalid() {
        super.isInvalid();
        if (song.songName.length() < 3 || song.songName.length() > 30){
            System.out.println("Song name should be between 3 and 30 symbols.");
            return true;
        }

        return false;
    }
}

