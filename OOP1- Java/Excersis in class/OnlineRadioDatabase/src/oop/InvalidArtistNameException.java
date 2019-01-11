package oop;

public class InvalidArtistNameException extends InvalidSongException {
    public InvalidArtistNameException(Song song) {
        super(song);
    }

    @Override
    public boolean isInvalid() {

        if (song.atristName.length() < 3 || song.atristName.length() > 20){
            System.out.println("Artist name should be between 3 and 20 symbols.");
            return true;
        }

        return false;
    }
}
