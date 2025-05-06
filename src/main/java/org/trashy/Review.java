//package org.trashy;
//
//import java.util.ArrayList;
//
//public class Review {
//    static class DB {
//        public static void add(String collection, Object obj) {
//        }
//        public static <T> T get(String collection, String name) {
//            return null;
//        }
//    }
//    class DomainObject {
//        protected String name = "no name";
//        public DomainObject() {
//        }
//        public DomainObject(String name) {
//            this.name = name;
//        }
//        public String name() {
//            return name;
//        }
//        public String toString() {
//            return name;
//        }
//    }
//    class Movie extends DomainObject {
//        public static final int CHILDRENS = 2;
//        public static final int REGULAR = 0;
//        public static final int NEW_RELEASE = 1;
//        private int priceCode;
//        public Movie(String name, int priceCode) {
//            this.name = name;
//            this.priceCode = priceCode;
//        }
//        public int priceCode() {
//            return priceCode;
//        }
//        public void persist() {
//            DB.add("Movies", this);
//        }
//        public Movie get(String name) {
//            return (Movie) DB.get("Movies", name);
//        }
//    }
//    class Tape extends DomainObject {
//        private Movie movie;
//        private String serialNumber;
//        public Tape(String serialNumber, Movie movie) {
//            this.serialNumber = serialNumber;
//            this.movie = movie;
//        }
//        public Movie movie() {
//            return movie;
//        }
//    }
//    class Rental extends DomainObject {
//        private int daysRented;
//        private Tape tape;
//        public int daysRented() {
//            return daysRented;
//        }
//        public Tape tape() {
//            return tape;
//        }
//        public Rental(Tape tape, int daysRented) {
//            this.tape = tape;
//            this.daysRented = daysRented;
//        }
//    }
//    static class Customer extends DomainObject {
//        private ArrayList<Rental> rentals = new ArrayList<>();
//        public Customer(String name) {
//            this.name = name;
//        }
//        public void addRental(Rental arg) {
//            rentals.add(arg);
//        }
//        public static Customer get(String name) {
//            return (Customer) DB.get("Customers", name);
//        }
//        public String statement() {
//            double totalAmount = 0;
//            int frequentRenterPoints = 0;
//            String result = "Rental Record for " + name() + "\n";
//            for (Rental rental : rentals) {
//                double amount = 0;
//                //determine amounts for each line
//                switch (rental.tape().movie().priceCode()) {
//                    case Movie.REGULAR:
//                        amount += 2;
//                        if (rental.daysRented() > 2) {
//                            amount += (rental.daysRented() - 2) * 1.5;
//                        }
//                        break;
//                    case Movie.NEW_RELEASE:
//                        amount += rental.daysRented() * 3;
//                        break;
//                    case Movie.CHILDRENS:
//                        amount += 1.5;
//                        if (rental.daysRented() > 3) {
//                            amount += (rental.daysRented() - 3) * 1.5;
//                        }
//                        break;
//                }
//                totalAmount += amount;
//                // add frequent renter points
//                frequentRenterPoints++;
//                // add bonus for a two day new release rental
//                if ((rental.tape().movie().priceCode() == Movie.NEW_RELEASE) &&  rental.daysRented() > 1) {
//                    frequentRenterPoints++;
//                }
//                //show figures for this rental
//                result += "\t" + rental.tape().movie().name() + "\t" + amount + "\n";
//            }
//            //add footer lines
//            result += "Amount owed is " + totalAmount + "\n";
//            result += "You earned " + frequentRenterPoints + " frequent renter points";
//            return result;
//        }
//        public void persist() {
//            DB.add("Customers", this);
//        }
//    }
//
//    public enum PriceCode {
//
//        CHILDRENS(2),
//        REGULAR(0),
//        NEW_RELEASE(1);
//
//        private final int code;
//
//        PriceCode(int code) {
//            this.code = code;
//        }
//
//        public int getCode() {
//            return code;
//        }
//    }
//}
