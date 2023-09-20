//  704 IRP POS GUI
//  Beck Busch
//  This is a GUI for the purchase ordering system
//  

// == Imports ==
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// == GUI Class ==
public class posGUI {
    Integer xGrid = 24;
    Integer yGrid = 32 + 8;
    Integer dimUnit = 20;
    ArrayList<String> Order;
    String[] LiquidList = { "Milk", "Honey", "Water", "Juice", "Beer", "Wine" };
    HashMap<String, Integer> PriceList = new HashMap<String, Integer>();
    HashMap<String, Integer> UserOrder = new HashMap<String, Integer>();
    HashMap<String, String> AccountList = new HashMap<String, String>();

    JFrame guiFrame;
    JTextField usernameField;
    JPasswordField passwordField;
    JComboBox<String> liquidSelectionCombo;
    JTextField quantitySelectionField;
    JPanel scrollItemsHolder;
    JPanel orderPanel;
    JPanel authPanel;
    JPanel submitPanel;
    JLabel priceLabel;

    // == Main Method ==
    public static void main(String[] args) {
        posGUI POSGUI = new posGUI();
    }

    // == GUI Class Constructor ==
    public posGUI() {
        PriceList.put("Honey", 25);
        PriceList.put("Water", 7);
        PriceList.put("Juice", 18);
        PriceList.put("Milk", 15);
        PriceList.put("Beer", 25);
        PriceList.put("Wine", 32);

        AccountList.put("admin", "admin");
        AccountList.put("UOA", "ecse");
        AccountList.put("bottles", "plant");
        AccountList.put("system", "j");
        AccountList.put("group", "7");

        generateGUI();
    }

    // == GUI Generator ==
    public void generateGUI() {
        // ---- GUI JFrame ----
        guiFrame = new JFrame();
        guiFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
        guiFrame.setLayout(null);
        guiFrame.setSize((int) (dimUnit * (xGrid + 0.7)), yGrid * (dimUnit + 1));

        // ---- Title Panel ----
        JPanel titlePanel = new JPanel();
        titlePanel.setBounds(0, 0, dimUnit * xGrid, dimUnit * 3);
        titlePanel.setBackground(Color.pink);
        JLabel titleLabel = new JLabel("Bottle Ordering System");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setBounds(0, 0, dimUnit * xGrid, dimUnit * 3);
        titleLabel.setFont(new Font("Verdana", Font.PLAIN, 34));
        titlePanel.add(titleLabel);

        // ---- Auth Panel ----
        authPanel = new JPanel();
        authPanel.setLayout(null);
        authPanel.setBounds(dimUnit * 2, dimUnit * 4, dimUnit * (xGrid - 4), dimUnit * 6);
        authPanel.setBackground(Color.cyan);
        // -- Auth Label --
        JLabel authLabel = new JLabel("User Authentication");
        authLabel.setHorizontalAlignment(JLabel.CENTER);
        authLabel.setFont(new Font("Verdana", Font.PLAIN, 32));
        authLabel.setBounds(0, 0, dimUnit * 16, dimUnit * 2);
        authPanel.add(authLabel);
        // -- Username Label --
        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setFont(new Font("Verdana", Font.PLAIN, 21));
        usernameLabel.setBounds(0, dimUnit * 2, dimUnit * 6, dimUnit * 2);
        authPanel.add(usernameLabel);
        // -- Password Label --
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(new Font("Verdana", Font.PLAIN, 21));
        passwordLabel.setBounds(0, dimUnit * 4, dimUnit * 6, dimUnit * 2);
        authPanel.add(passwordLabel);
        // -- Username Input --
        usernameField = new JTextField();
        usernameField.setBounds(dimUnit * 6, dimUnit * 2, dimUnit * 10, dimUnit * 2);
        authPanel.add(usernameField);
        // -- Password Input --
        passwordField = new JPasswordField();
        passwordField.setBounds(dimUnit * 6, dimUnit * 4, dimUnit * 10, dimUnit * 2);
        authPanel.add(passwordField);
        // -- Submit Button --
        JButton loginButton = new JButton("Login", null);
        loginButton.setFont(new Font("Verdana", Font.PLAIN, 17));
        loginButton.setBounds(dimUnit * 16, 0, dimUnit * 4, dimUnit * 6);
        loginButton.setActionCommand("login");
        loginButton.addActionListener(new ButtonClickListener());
        authPanel.add(loginButton);

        // ---- Ordering Panel ----
        orderPanel = new JPanel();
        orderPanel.setVisible(false);
        orderPanel.setLayout(null);
        orderPanel.setBounds(dimUnit * 1, dimUnit * 11, dimUnit * (xGrid - 2), dimUnit * 16);
        orderPanel.setBackground(Color.yellow);
        // -- Order Title
        JLabel orderTitle = new JLabel("Purchase Order");
        orderTitle.setHorizontalAlignment(JLabel.CENTER);
        orderTitle.setBounds(0, 0, dimUnit * (xGrid - 4), dimUnit * 2);
        orderTitle.setFont(new Font("Verdana", Font.PLAIN, 28));
        orderPanel.add(orderTitle);
        // -- New Label --
        JLabel newLabel = new JLabel("New Item:");
        newLabel.setHorizontalAlignment(JLabel.CENTER);
        newLabel.setBounds(dimUnit, dimUnit * 3, dimUnit * 4, dimUnit * 2);
        newLabel.setFont(new Font("Verdana", Font.PLAIN, 14));
        orderPanel.add(newLabel);
        // -- Liquid Selector Combo --
        liquidSelectionCombo = new JComboBox<String>(LiquidList);
        liquidSelectionCombo.setBounds(dimUnit * 6, dimUnit * 3, dimUnit * 5, dimUnit * 2);
        orderPanel.add(liquidSelectionCombo);
        // -- Quantity Selector Field --
        quantitySelectionField = new JTextField();
        quantitySelectionField.setBounds(dimUnit * 12, dimUnit * 3, dimUnit * 5, dimUnit * 2);
        orderPanel.add(quantitySelectionField);
        // -- Add item button --
        JButton addItemButton = new JButton("Add", null);
        addItemButton.setFont(new Font("Verdana", Font.PLAIN, 12));
        addItemButton.setBounds(dimUnit * 18, dimUnit * 3, dimUnit * 3, dimUnit * 2);
        addItemButton.setActionCommand("add");
        addItemButton.addActionListener(new ButtonClickListener());
        orderPanel.add(addItemButton);

        // -- Items Scroll Panel
        scrollItemsHolder = new JPanel();
        scrollItemsHolder.setBackground(Color.green);
        scrollItemsHolder.setLayout(null);
        scrollItemsHolder.setPreferredSize(new Dimension(dimUnit * (xGrid - 5), dimUnit * 2 * 1));
        JScrollPane itemsScroll = new JScrollPane(scrollItemsHolder);
        itemsScroll.setBounds(dimUnit, dimUnit * 6, dimUnit * 20, dimUnit * 9);
        orderPanel.add(itemsScroll);
        // orderPanel.add(scrollItemsHolder);

        // ---- Submit Order Panel ----
        submitPanel = new JPanel();
        submitPanel.setLayout(null);
        submitPanel.setBounds(dimUnit * 2, dimUnit * 28, dimUnit * (xGrid - 4), dimUnit * 3);
        submitPanel.setBackground(Color.green);
        JLabel totalLabel = new JLabel("Total:");
        totalLabel.setHorizontalAlignment(JLabel.CENTER);
        totalLabel.setFont(new Font("Verdana", Font.PLAIN, 24));
        totalLabel.setBounds(0, 0, dimUnit * 4, dimUnit * 3);
        submitPanel.add(totalLabel);
        priceLabel = new JLabel("$XXXX");
        priceLabel.setHorizontalAlignment(JLabel.CENTER);
        priceLabel.setFont(new Font("Verdana", Font.PLAIN, 24));
        priceLabel.setBounds(dimUnit * 4, 0, dimUnit * 5, dimUnit * 3);
        submitPanel.add(priceLabel);
        JButton submitButton = new JButton("Submit", null);
        submitButton.setFont(new Font("Verdana", Font.PLAIN, 18));
        submitButton.setBounds(dimUnit * 10, 0, dimUnit * 5, dimUnit * 3);
        submitButton.setActionCommand("submit");
        submitButton.addActionListener(new ButtonClickListener());
        submitPanel.add(submitButton);
        JButton resetButton = new JButton("Reset", null);
        resetButton.setFont(new Font("Verdana", Font.PLAIN, 16));
        resetButton.setBounds(dimUnit * 16, 0, dimUnit * 4, dimUnit * 3);
        resetButton.setActionCommand("reset");
        resetButton.addActionListener(new ButtonClickListener());
        submitPanel.add(resetButton);

        // ---- Response Panel ----
        JPanel responsePanel = new JPanel();
        responsePanel.setLayout(null);
        responsePanel.setBounds(dimUnit * 1, dimUnit * (yGrid-8), dimUnit * (xGrid - 2), dimUnit * 8);
        responsePanel.setBackground(Color.gray);
        // -- Response Header --
        JLabel responseLabel = new JLabel("System Response:");
        //responseLabel.setHorizontalAlignment(JLabel.CENTER);
        responseLabel.setFont(new Font("Verdana", Font.PLAIN, 24));
        responseLabel.setBounds(0, 0, dimUnit * (xGrid-2), dimUnit * 2);
        responsePanel.add(responseLabel);
        // -- Response Content --
        JTextArea responseArea = new JTextArea("no responce received");
        //responseArea.setBounds(dimUnit, dimUnit*3, dimUnit*(xGrid-4), dimUnit*4);
        responseArea.setBounds((int)(dimUnit*0.5), (int)(dimUnit*2), dimUnit*(xGrid-3), (int)(dimUnit*5.5));
        responseArea.setBackground(Color.gray);
        responsePanel.add(responseArea);

        // ---- Final Steps ----
        guiFrame.add(titlePanel);
        guiFrame.add(authPanel);
        guiFrame.add(orderPanel);
        guiFrame.add(submitPanel);
        guiFrame.add(responsePanel);
        guiFrame.setVisible(true);
    }

    // ---- Add Item Method ----
    private void updateOrderPanel() {

        // Clear Items Panel
        scrollItemsHolder.removeAll();
        scrollItemsHolder.setPreferredSize(new Dimension(dimUnit * (xGrid - 5), dimUnit * 2 * UserOrder.size()));

        // -- Temp Panel --
        JPanel tempPanel = new JPanel();
        tempPanel.setBounds(0, 0, dimUnit * (xGrid - 5), dimUnit * 2 * UserOrder.size());
        tempPanel.setLayout(null);

        Integer i = 0;
        Integer totalPrice = 0;

        for (Map.Entry<String, Integer> itemPair : UserOrder.entrySet()) {

            // -- Temp Name Label --
            JLabel tempName = new JLabel("Item " + Integer.toString(i+1) + ": " + itemPair.getKey());
            tempName.setHorizontalAlignment(JLabel.CENTER);
            tempName.setFont(new Font("Verdana", Font.PLAIN, 12));
            tempName.setBounds(0, dimUnit * 2 * i, dimUnit * 5, dimUnit * 2);
            tempPanel.add(tempName);
            // -- Temp Quantity Label --
            JLabel tempQuantity = new JLabel("Quantity: " + Integer.toString(itemPair.getValue()));
            tempQuantity.setHorizontalAlignment(JLabel.CENTER);
            tempQuantity.setFont(new Font("Verdana", Font.PLAIN, 12));
            tempQuantity.setBounds(dimUnit * 6, dimUnit * 2 * i, dimUnit * 5, dimUnit * 2);
            tempPanel.add(tempQuantity);
            // -- Temp Price Label --
            JLabel tempPrice = new JLabel(
                    "Price: $" + Integer.toString(PriceList.get(itemPair.getKey()) * itemPair.getValue()));
            tempPrice.setHorizontalAlignment(JLabel.CENTER);
            tempPrice.setFont(new Font("Verdana", Font.PLAIN, 12));
            tempPrice.setBounds(dimUnit * 12, dimUnit * 2 * i, dimUnit * 5, dimUnit * 2);
            tempPanel.add(tempPrice);

            totalPrice += PriceList.get(itemPair.getKey()) * itemPair.getValue();

            i += 1;
        }

        // Add temp panel to items holder
        scrollItemsHolder.add(tempPanel);

        priceLabel.setText("$" + Integer.toString(totalPrice));

        SwingUtilities.updateComponentTreeUI(guiFrame);
    }

    private void authUser(String name, char[] pass) {
        String password = String.valueOf(pass);

        if (AccountList.get(name).equals(password)) {
            orderPanel.setVisible(true);

            System.out.println("Login Correct"); // PRINTER

            for (Component i : authPanel.getComponents()) {
                i.setEnabled(false);
            }

            SwingUtilities.updateComponentTreeUI(guiFrame);
        }
    }

    private void submitOrder() {
        String[] items = new String[] { "Honey", "Water", "Juice", "Milk", "Beer", "Wine" };
        Integer[] outputArray = new Integer[items.length];
        int i = 0;

        for (String string : items) {
            if (UserOrder.get(string) != null) {
                outputArray[i] = UserOrder.get(string);
            } else {
                outputArray[i] = 0;
            }

            i += 1;
        }

        for (Component componentI : orderPanel.getComponents()) {
            componentI.setEnabled(false);
        }
        for (Component componentI : submitPanel.getComponents()) {
            componentI.setEnabled(false);
        }

        SwingUtilities.updateComponentTreeUI(guiFrame);

        System.out.println(Arrays.toString(outputArray));

        // for (Map.Entry<String, Integer> pair : UserOrder.entrySet()) {
        // System.out.println(pair.getKey() + Integer.toString(pair.getValue()));
        // }
    }

    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            if (command.equals("login")) {
                System.out.println(usernameField.getText()); // PRINTER
                System.out.println(passwordField.getPassword()); // PRINTER

                authUser(usernameField.getText(), passwordField.getPassword());

            } else if (command.equals("add")) {
                String additionalItem = liquidSelectionCombo.getSelectedItem().toString();
                Integer additionalQuantity;

                try {
                    additionalQuantity = Integer.parseInt(quantitySelectionField.getText());
                } catch (NumberFormatException exc) {
                    System.out.println("Please use numbers only");
                    return;
                }

                System.out.println(additionalItem); // PRINTER
                System.out.println(Integer.toString(additionalQuantity)); // PRINTER

                UserOrder.put(additionalItem, additionalQuantity);

                updateOrderPanel();

            } else if (command.equals("submit")) {
                System.out.println("SUBMIT pressed"); // PRINTER

                submitOrder();

            } else if (command.equals("reset")) {
                System.out.println("RESET pressed"); // PRINTER

                UserOrder.clear();

                updateOrderPanel();
            }
        }
    }

}

// JButton orderButton = new JButton("Order", null);
// orderButton.setBounds(dimUnit * 1, dimUnit * 1, dimUnit * 4, dimUnit * 1);
// orderButton.setActionCommand("order");
// orderButton.addActionListener(new ButtonClickListener());
// titlePanel.add(orderButton);