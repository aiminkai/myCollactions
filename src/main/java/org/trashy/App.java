package org.trashy;


import java.util.*;

public class App {

    private final TreeMap<Integer, Integer> banknotes; // Номинал -> Количество
    private final Set<Integer> allowedBanknotes = Set.of(50, 100, 500, 1000, 5000);

    public App(Map<Integer, Integer> banknotes) {
        for (Integer denomination : banknotes.keySet()) {
            if (!allowedBanknotes.contains(denomination)) {
                throw new IllegalArgumentException("Недопустимый номинал: " + denomination);
            }
        }
        this.banknotes = new TreeMap<>(Comparator.reverseOrder());
        this.banknotes.putAll(banknotes);
    }

    public Map<Integer, Integer> withdraw(int amount) {
        // Создаем копию для временных изменений
        TreeMap<Integer, Integer> tempBanknotes = new TreeMap<>(banknotes);
        Map<Integer, Integer> result = new HashMap<>();

        for (Map.Entry<Integer, Integer> entry : tempBanknotes.entrySet()) {
            int denomination = entry.getKey();
            int available = entry.getValue();

            if (amount >= denomination && available > 0) {
                int needed = amount / denomination;
                int used = Math.min(needed, available);

                result.put(denomination, used);
                amount -= denomination * used;
                entry.setValue(available - used);
            }

            if (amount == 0) {
                // Обновляем основной баланс банкомата
                banknotes.clear();
                banknotes.putAll(tempBanknotes);
                return result;
            }
        }
//
//        if (amount == 0) {
//            // Обновляем основной баланс банкомата
//            banknotes.clear();
//            banknotes.putAll(tempBanknotes);
//            return result;
//        } else {
//            return null; // Невозможно выдать запрошенную сумму
//        }
        return null;
    }

    public Map<Integer, Integer> getBalance() {
        return new TreeMap<>(banknotes);
    }

    public int getTotalAmount() {
        return banknotes.entrySet().stream()
                .mapToInt(entry -> entry.getKey() * entry.getValue())
                .sum();
    }

    public static void main(String[] args) {
        Map<Integer, Integer> initial = new HashMap<>();
        initial.put(50, 10);
        initial.put(100, 5);
        initial.put(500, 2);
        initial.put(1000, 10);
        initial.put(5000, 1);

        App atm = new App(initial);

        System.out.println("Начальный баланс: " + atm.getBalance());
        System.out.println("Общая сумма: " + atm.getTotalAmount() + "₽");

        int[] testAmounts = {155};

        for (int amount : testAmounts) {
            System.out.println("\nПытаемся выдать " + amount + "₽");
            Map<Integer, Integer> withdrawal = atm.withdraw(amount);
            System.out.println("Остаток в банкомате: " + atm.getBalance());
            System.out.println("Общая сумма остатка: " + atm.getTotalAmount() + "₽");

            if (withdrawal != null) {
                System.out.println("Выдано: " + withdrawal);
                System.out.println("Остаток в банкомате: " + atm.getBalance());
                System.out.println("Общая сумма остатка: " + atm.getTotalAmount() + "₽");
            } else {
                System.out.println("Невозможно выдать " + amount + "₽");
            }
        }
    }
}
