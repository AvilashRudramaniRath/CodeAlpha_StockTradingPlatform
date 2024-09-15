import java.util.HashMap;
import java.util.Map;

public class StockMarket {
    private Map<String, Stock> stocks;

    public StockMarket() {
        stocks = new HashMap<>();
        addSampleStocks();
    }

    public void addStock(Stock stock) {
        stocks.put(stock.getSymbol(), stock);
    }

    public Stock getStock(String symbol) {
        return stocks.get(symbol);
    }

    public Map<String, Stock> getStocks() {
        return stocks;
    }

    public void showMarket() {
        System.out.println("\nMarket Data:");
        for (Stock stock : stocks.values()) {
            System.out.println(stock.getSymbol() + " (" + stock.getName() + "): $" + stock.getPrice() + ", Available shares: " + stock.getAvailableShares());
        }
    }

    private void addSampleStocks() {
        addStock(new Stock("AAPL", "Apple Inc.", 150.00, 1000));
        addStock(new Stock("GOOGL", "Alphabet Inc.", 2800.00, 500));
        addStock(new Stock("AMZN", "Amazon.com, Inc.", 3500.00, 300));
    }
}
