package review.model;

public class Rental {
    private final Tape tape;
    private final int daysRented;

    public Rental(Tape tape, int daysRented) {
        if (tape == null) {
            throw new IllegalArgumentException("Tape cannot be null");
        }
        if (daysRented <= 0) {
            throw new IllegalArgumentException("Days rented must be positive");
        }
        this.tape = tape;
        this.daysRented = daysRented;
    }

    public Tape getTape() {
        return tape;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public double calculateAmount() {
        switch (tape.getMovie().getPriceCode()) {
            case REGULAR:
                double amount = 2;
                if (daysRented > 2) {
                    amount += (daysRented - 2) * 1.5;
                }
                return amount;
            case NEW_RELEASE:
                return daysRented * 3;
            case CHILDRENS:
                amount = 1.5;
                if (daysRented > 3) {
                    amount += (daysRented - 3) * 1.5;
                }
                return amount;
            default:
                throw new IllegalArgumentException("Unknown price code");
        }
    }
}
