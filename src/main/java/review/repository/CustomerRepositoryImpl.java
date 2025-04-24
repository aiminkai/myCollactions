package review.repository;

import review.model.Customer;
import review.model.Movie;
import review.model.PriceCode;

public class CustomerRepositoryImpl  implements Repository<Customer> {

    @Override
    public void addToDb(String collection, Object obj) {
        System.out.println("add movie to DB");
    }

    @Override
    public Customer getFromDb(String collection, String name) {
        return new Customer("customer");
    }
}
