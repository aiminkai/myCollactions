package review.model;

public class Tape extends DomainObject{
    private final Movie movie;

    public Tape(String serialNumber, Movie movie) {
        super(serialNumber);
        if (movie == null) {
            throw new IllegalArgumentException("Movie cannot be null");
        }
        this.movie = movie;
    }

    public Movie getMovie() {
        return movie;
    }
}
