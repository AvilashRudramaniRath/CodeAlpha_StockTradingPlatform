import java.util.HashMap;
import java.util.Map;

public class Portfolio {
    private Map<String, Integer> holdings;
    private double balance;

    public Portfolio(double initialBalance) {
        this.holdings = new HashMap<>();
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void addStock(String symbol, int quantity) {
        holdings.put(symbol, holdings.getOrDefault(symbol, 0) + quantity);
    }

    public void removeStock(String symbol, int quantity) {
        if (holdings.containsKey(symbol)) {
            int newQuantity = holdings.get(symbol) - quantity;
            if (newQuantity <= 0) {
                holdings.remove(symbol);
            } else {
                holdings.put(symbol, newQuantity);
            }
        }
    }

    public void updateBalance(double amount) {
        this.balance += amount;
    }

    public Map<String, Integer> getHoldings() {
        return holdings;
    }

    public void showPortfolio(Map<String, Stock> stockMarket) {
        System.out.println("\nPortfolio:");
        for (Map.Entry<String, Integer> entry : holdings.entrySet()) {
            String symbol = entry.getKey();
            int quantity = entry.getValue();
            Stock stock = stockMarket.get(symbol);
            if (stock != null) {
                double value = stock.getPrice() * quantity;
                System.out.println(symbol + " (" + stock.getName() + "): " + quantity + " shares, Value: $" + value);
            }
        }
        System.out.println("Available Balance: $" + balance);
    }
}
