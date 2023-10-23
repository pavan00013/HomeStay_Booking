package Project;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

      public static void main(String[] args) {
        // Create a JFrame for the user interface
        JFrame frame = new JFrame("Hotel Room Billing System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Create labels, text fields, and a button
        JLabel nameLabel = new JLabel("Customer Name:");
        JTextField nameTextField = new JTextField(20);

        JLabel roomTypeLabel = new JLabel("Room Type:");
        JTextField roomTypeTextField = new JTextField(10);

        JLabel extraPersonsLabel = new JLabel("No. of Extra Persons:");
        JTextField extraPersonsTextField = new JTextField(2);

        JLabel daysOfStayLabel = new JLabel("No. of Days of Stay:");
        JTextField daysOfStayTextField = new JTextField(2);

        JButton calculateButton = new JButton("Calculate");

        // Create a panel for organizing components
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2));

        // Add components to the panel
        panel.add(nameLabel);
        panel.add(nameTextField);
        panel.add(roomTypeLabel);
        panel.add(roomTypeTextField);
        panel.add(extraPersonsLabel);
        panel.add(extraPersonsTextField);
        panel.add(daysOfStayLabel);
        panel.add(daysOfStayTextField);
        panel.add(new JLabel()); // Empty label for spacing
        panel.add(calculateButton);

        // Add an action listener to the Calculate button
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Retrieve user input from text fields
                String customerName = nameTextField.getText();
                String roomType = roomTypeTextField.getText();
                int extraPersons = Integer.parseInt(extraPersonsTextField.getText());
                int daysOfStay = Integer.parseInt(daysOfStayTextField.getText());

                // Create an instance of RoomDetails
                RoomDetails room = new RoomDetails(customerName, roomType, extraPersons, daysOfStay);
                float totalBill = room.calculateBill();

                if (totalBill != -1) {
                    // Display the bill in a JOptionPane
                    String billMessage = "BillId: " + room.getBillId() + "\n"
                            + "Customer Name: " + room.getCustomerName() + "\n"
                            + "No. of days of Stay: " + room.getNoOfDaysOfStay() + "\n"
                            + "Total Bill: " + totalBill;
                    JOptionPane.showMessageDialog(frame, billMessage, "Bill Details", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(frame, "Invalid input. Please check your entries.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Add the panel to the JFrame
        frame.add(panel);

        // Set the frame to be visible
        frame.setVisible(true);
    }
}

