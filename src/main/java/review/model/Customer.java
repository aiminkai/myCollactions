package review.model;

import review.repository.CustomerRepositoryImpl;
import review.repository.Repository;
import review.service.StatementGenerator;

import java.util.ArrayList;
import java.util.List;

public class Customer extends DomainObject{
    private final List<Rental> rentals = new ArrayList<>();
    private static final CustomerRepositoryImpl repository = new CustomerRepositoryImpl();

    public Customer(String name) {
        super(name);
    }

    public void addRental(Rental rental) {
        if (rental == null) {
            throw new IllegalArgumentException("Rental cannot be null");
        }
        rentals.add(rental);
    }

    public boolean removeRental(Rental rental) {
        return rentals.remove(rental);
    }

    public List<Rental> getRentals() {
        return new ArrayList<>(rentals);
    }

    public String getStatement() {
        return new StatementGenerator().generateStatement(this);
    }

    public void save() {
        repository.addToDb("customer", this);
    }

    public static Customer find(String name) {
        return repository.getFromDb("customer", name);
    }
}
