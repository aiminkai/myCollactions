package org.trashy;

import java.util.*;

public class ATM {
    private Map<Integer, Integer> banknotes;
    private final Set<Integer> availableBanknotes = Set.of(50, 100, 200, 500, 1000, 5000);

    public ATM(Map<Integer, Integer> inputBanknotes) {

        this.banknotes = new TreeMap<>(Comparator.reverseOrder());
        this.banknotes.putAll(inputBanknotes);
    }


    public String getMoney(int value) {
        int startValue = value;
        if (value <= 0) {
            return "Сумма должна быть положительной" ;
        }
        Map<Integer, Integer> tempMap = new HashMap<>(banknotes);
        Map<Integer, Integer> toUser = new HashMap<>();
        for(Map.Entry<Integer, Integer> entry : tempMap.entrySet()) {
            if(value > entry.getKey() && entry.getValue() > 0){
                int needed = value / entry.getKey();
                int available = Math.min(needed, entry.getValue());
                value = value - entry.getKey() * available;
                toUser.put(entry.getKey(), available);
                entry.setValue(entry.getValue() - available);
            }

            if (value == 0) {
                banknotes.clear();
                banknotes.putAll(tempMap);
                return "Выдали: " + toUser.toString();
            }
        }


        return "Не могу выдать " + startValue;
    }

    public int getSum() {
        return banknotes.entrySet().stream().mapToInt(v -> v.getValue() * v.getKey()).sum();
    }

    public String getBanknotes() {
        return banknotes.toString();
    }

    public static void main(String[] args) {
        Map<Integer, Integer> initial = new HashMap<>();
        initial.put(50, 10);
        initial.put(100, 5);
        initial.put(500, 2);
        initial.put(1000, 10);
        initial.put(5000, 1);


        ATM atm = new ATM(initial);

        System.out.println(atm.getSum());
        System.out.println(atm.getBanknotes());
        System.out.println("==============");

        System.out.println(atm.getMoney(745));
        System.out.println(atm.getSum());
        System.out.println(atm.getBanknotes());
    }
}
