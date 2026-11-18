package iproductcalculation;

import javax.swing.*;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class ProductGUI extends JFrame {
    private JTextField txtCustomerName, txtPrice;
    private JComboBox<String> cmbProducts;
    private JButton btnProcess;

    public ProductGUI() {
        setTitle("Product App");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        // Labels and Inputs
        JLabel lblName = new JLabel("Customer Name:");
        lblName.setBounds(30, 30, 120, 25);
        add(lblName);

        txtCustomerName = new JTextField();
        txtCustomerName.setBounds(160, 30, 180, 25);
        add(txtCustomerName);

        JLabel lblProduct = new JLabel("Select Product:");
        lblProduct.setBounds(30, 75, 120, 25);
        add(lblProduct);

        String[] products = { "Cozy Nights Monarch", "Restonic Barbados", "Sealy Phuket" };
        cmbProducts = new JComboBox<>(products);
        cmbProducts.setBounds(160, 75, 180, 25);
        add(cmbProducts);

        JLabel lblPrice = new JLabel("Enter Price:");
        lblPrice.setBounds(30, 120, 120, 25);
        add(lblPrice);

        txtPrice = new JTextField();
        txtPrice.setBounds(160, 120, 180, 25);
        add(txtPrice);

        btnProcess = new JButton("PROCESS");
        btnProcess.setBounds(140, 180, 100, 30);
        add(btnProcess);

        // Menu Bar (File -> Exit, Tools -> Process, Tools -> Clear)
        JMenuBar menuBar = new JMenuBar();
        JMenu menuFile = new JMenu("File");
        JMenuItem itemExit = new JMenuItem("Exit");
        itemExit.addActionListener(e -> System.exit(0));
        menuFile.add(itemExit);
        menuBar.add(menuFile);

        JMenu menuTools = new JMenu("Tools");
        JMenuItem itemProcess = new JMenuItem("Process");
        itemProcess.addActionListener(e -> processSales());
        JMenuItem itemClear = new JMenuItem("Clear");
        itemClear.addActionListener(e -> clearForm());
        menuTools.add(itemProcess);
        menuTools.add(itemClear);
        menuBar.add(menuTools);

        setJMenuBar(menuBar);

        // Process button action
        btnProcess.addActionListener(e -> processSales());
    }

    private void processSales() {
        try {
            String customerName = txtCustomerName.getText().trim();
            String productName = cmbProducts.getSelectedItem().toString();
            double price = Double.parseDouble(txtPrice.getText().trim());

            ProductCalculations calc = new ProductCalculations(price);
            double vat = calc.GetVat();
            double commission = calc.GetCommission();
            double total = calc.GetTotal();

            // Display message dialog matching the assignment screenshot
            String message = "Customer Name: " + customerName + "\n"
                           + "Product: " + productName + "\n"
                           + "VAT: R " + vat + "\n"
                           + "COMMISSION: R " + commission + "\n"
                           + "TOTAL: R " + total;

            JOptionPane.showMessageDialog(this, message, "Message", JOptionPane.INFORMATION_MESSAGE);

            // Save information to data.txt file
            PrintWriter writer = new PrintWriter(new FileWriter("data.txt", true));
            writer.println("DATA LOG");
            writer.println("*************************************************************");
            writer.println("Customer Name: " + customerName);
            writer.println("Product: " + productName);
            writer.println("VAT: R " + vat);
            writer.println("COMMISSION: R " + commission);
            writer.println("TOTAL: R " + total);
            writer.println("*************************************************************");
            writer.close();

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid numeric price.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error saving to file.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearForm() {
        txtCustomerName.setText("");
        txtPrice.setText("");
        cmbProducts.setSelectedIndex(0);
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> new ProductGUI().setVisible(true));
    }
}