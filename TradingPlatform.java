import java.util.Scanner;

public class TradingPlatform {
    private StockMarket market;
    private Portfolio portfolio;
    private Scanner scanner;

    public TradingPlatform(double initialBalance) {
        market = new StockMarket();
        portfolio = new Portfolio(initialBalance);
        scanner = new Scanner(System.in);
    }

    public void start() {
        boolean running = true;
        while (running) {
            System.out.println("\n1. View Market Data");
            System.out.println("2. Buy Stock");
            System.out.println("3. Sell Stock");
            System.out.println("4. View Portfolio");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    market.showMarket();
                    break;
                case 2:
                    buyStock();
                    break;
                case 3:
                    sellStock();
                    break;
                case 4:
                    portfolio.showPortfolio(market.getStocks());
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    private void buyStock() {
        System.out.print("Enter stock symbol: ");
        String symbol = scanner.next().toUpperCase();
        Stock stock = market.getStock(symbol);

        if (stock != null) {
            System.out.print("Enter quantity: ");
            int quantity = scanner.nextInt();

            double totalPrice = quantity * stock.getPrice();
            if (totalPrice <= portfolio.getBalance() && quantity <= stock.getAvailableShares()) {
                portfolio.addStock(symbol, quantity);
                portfolio.updateBalance(-totalPrice);
                stock.buyShares(quantity);
                System.out.println("Bought " + quantity + " shares of " + stock.getName());
            } else {
                System.out.println("Not enough balance or shares available!");
            }
        } else {
            System.out.println("Stock not found!");
        }
    }

    private void sellStock() {
        System.out.print("Enter stock symbol: ");
        String symbol = scanner.next().toUpperCase();
        Stock stock = market.getStock(symbol);

        if (stock != null) {
            System.out.print("Enter quantity: ");
            int quantity = scanner.nextInt();

            if (portfolio.getHoldings().getOrDefault(symbol, 0) >= quantity) {
                double totalPrice = quantity * stock.getPrice();
                portfolio.removeStock(symbol, quantity);
                portfolio.updateBalance(totalPrice);
                stock.sellShares(quantity);
                System.out.println("Sold " + quantity + " shares of " + stock.getName());
            } else {
                System.out.println("Not enough shares to sell!");
            }
        } else {
            System.out.println("Stock not found!");
        }
    }

    public static void main(String[] args) {
        TradingPlatform platform = new TradingPlatform(10000.00);
        platform.start();
    }
}
