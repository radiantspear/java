import java.util.Scanner;

public class POSGuatno {
    private Scanner scanner;
    private ProductInformationAmor[] products;
    private double grandTotal;

    public POSGuatno() {
        scanner = new Scanner(System.in);
        products = new ProductInformationAmor[5];
        products[0] = new ProductInformationSecsion("A001", "Mouse", 100.00);
        products[1] = new ProductInformationSecsion("A002", "Monitor", 2500.00);
        products[2] = new ProductInformationSecsion("A003", "Keyboard", 200.00);
        products[3] = new ProductInformationSecsion("A004", "Flash disk", 300.00);
        products[4] = new ProductInformationSecsion("A005", "Hard disk", 1500.00);
    }

    public void purchaseItem() {
        char purchaseChoice;

        do {
            displayProductInformation();
            System.out.print("Purchase item (y/n): ");
            purchaseChoice = scanner.next().charAt(0);

            if (purchaseChoice == 'y') {
                System.out.print("Enter product code: ");
                String productCode = scanner.next().toUpperCase();
                System.out.print("Enter quantity: ");
                int quantity = scanner.nextInt();

                double amount = getAmount(productCode, quantity);
                System.out.println("Amount: " + amount);
                grandTotal += amount;

                System.out.print("Add item (y/n): ");
                char addItemChoice = scanner.next().charAt(0);
                if (addItemChoice == 'n') {
                    displayOrderInfo();
                }
            }
        } while (purchaseChoice == 'y');

        System.out.println("Thank you for shopping at RG Computer Shop!");
    }

    public void displayProductInformation() {
        System.out.println("ACV COMPUTER SHOP");
        System.out.println("Makati City");
        System.out.println("PRODUCT INFORMATION");
        System.out.println("Code     Description        Unit Price");
        for (ProductInformationAmor product : products) {
            System.out.println(product.getProductCode() + "\t " +
                    product.getDescription() + "\t\t " +
                    String.format("%.2f", product.getPrice()));
        }
        System.out.println("------------------------------------------");
    }

    public void displayOrderInfo() {
        System.out.println("ORDER INFORMATION");
        System.out.println("Code Description    Unit Price    Quantity    Amount");
        // Display order details here

        System.out.println("------------------------ nothing follows ----------------------");
        System.out.println("GRAND TOTAL: " + String.format("%.2f", grandTotal));
        System.out.println("-------------------------------------------------------------------");

        System.out.print("New customer (y/n): ");
        char newCustomer = scanner.next().charAt(0);
        if (newCustomer == 'y') {
            displayProductInformation();
        }
    }

    public double getAmount(String productCode, int quantity) {
        for (ProductInformationAmor product : products) {
            if (product.getProductCode().equals(productCode)) {
                return product.getPrice() * quantity;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        POSGuatno pos = new POSGuatno();
        pos.purchaseItem();
    }
}
