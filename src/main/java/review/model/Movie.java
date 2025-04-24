package review.model;

import review.repository.MovieRepositoryImpl;
import review.repository.Repository;

public class Movie extends DomainObject {
    private final PriceCode priceCode;
    private static final MovieRepositoryImpl repository = new MovieRepositoryImpl();

    public Movie(String name, PriceCode priceCode) {
        super(name);
        this.priceCode = priceCode;
    }

    public PriceCode getPriceCode() {
        return priceCode;
    }

    public void save() {
        repository.addToDb("Movie", this);
    }

    public static Movie find(String name) {
        return repository.getFromDb("Movie", name);
    }
}
