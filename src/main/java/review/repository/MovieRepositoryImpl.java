package review.repository;

import review.model.Movie;
import review.model.PriceCode;

public class MovieRepositoryImpl implements Repository<Movie> {

    @Override
    public void addToDb(String collection, Object obj) {
        System.out.println("add movie to DB");
    }

    @Override
    public Movie getFromDb(String collection, String name) {
        return new Movie("film", PriceCode.NEW_RELEASE);
    }
}
