package mattresssalesapplications;

import java.util.Scanner;

public class PrintProduct {

    public void printReport() {
        Scanner input = new Scanner(System.in);
        int[][] sales = new int[3][3];
        
        String[] products = {
            "Cozy Nights Monarch mattress",
            "Restonic Barbados mattress",
            "Sealy Phuket mattress"
        };
        
        // Ask user to enter sales for each product and month
        for (int i = 0; i < products.length; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("Enter number of sales for month " + (j + 1) + " for " + products[i] + ": ");
                sales[i][j] = input.nextInt();
            }
        }
        
        // Create Product object to calculate totals and averages
        Product calc = new Product(sales);
        
        // Print the final report matching the sample output format
        System.out.println("\nPRODUCT SALES REPORT - 2026");
        System.out.println("*************************************************************");
        System.out.println("TOTAL PRODUCT SALES: " + calc.GetTotalProductSold());
        System.out.println("AVERAGE PRODUCT SALES: " + (int) calc.GetAverageProductSold());
        System.out.println("MOST POPULAR PRODUCT: " + calc.GetMostPopularProduct());
    }
}
