package cinema;

import java.util.HashMap;
import java.util.Map;

public class PaymentService {
    private final Map<String, Integer> balances = new HashMap<>(Map.of(
            "U1", 3000, "U2", 500));

    public void charge(String userId, int amount) {
        Integer balance = balances.get(userId);
        if (amount <= 0 || balance == null || balance < amount) {
            throw new IllegalStateException("Payment rejected for user: " + userId);
        }
        balances.put(userId, balance - amount);
    }

    public void refund(String userId, int amount) {
        balances.put(userId, balances.get(userId) + amount);
    }

    public int balanceOf(String userId) {
        return balances.getOrDefault(userId, 0);
    }
}
