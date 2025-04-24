package review.service;

import review.model.Customer;
import review.model.Rental;

public class StatementGenerator {
    public String generateStatement(Customer customer) {
        StringBuilder result = new StringBuilder("Rental Record for " + customer.getName() + "\n");

        double totalAmount = 0;
        int frequentRenterPoints = 0;

        for (Rental rental : customer.getRentals()) {
            double amount = rental.calculateAmount();
            totalAmount += amount;
            frequentRenterPoints += rental.calculateAmount();

            result.append("\t")
                    .append(rental.getTape().getMovie().getName())
                    .append("\t")
                    .append(amount)
                    .append("\n");
        }

        result.append("Amount owed is ").append(totalAmount).append("\n");
        result.append("You earned ").append(frequentRenterPoints).append(" frequent renter points");

        return result.toString();
    }
}
