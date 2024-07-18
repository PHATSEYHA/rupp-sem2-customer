import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class CustomerViewer extends JFrame implements ActionListener {
    private List<Customer> customers;
    private int currentIndex = 0;

    private JTextField idField;
    private JTextField lastNameField;
    private JTextField firstNameField;
    private JTextField phoneNumberField;
    private JButton previousButton;
    private JButton nextButton;

    public CustomerViewer() {
        try {
            customers = Database.getCustomers();
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        setTitle("Customer");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2));

        JLabel idLabel = new JLabel("ID:");
        idField = new JTextField();
        idField.setEditable(false);
        JLabel lastNameLabel = new JLabel("Last Name:");
        lastNameField = new JTextField();
        lastNameField.setEditable(false);
        JLabel firstNameLabel = new JLabel("First Name:");
        firstNameField = new JTextField();
        firstNameField.setEditable(false);
        JLabel phoneNumberLabel = new JLabel("Phone Number:");
        phoneNumberField = new JTextField();
        phoneNumberField.setEditable(false);

        previousButton = new JButton("Previous");
        nextButton = new JButton("Next");

        previousButton.addActionListener(this);
        nextButton.addActionListener(this);

        add(idLabel);
        add(idField);
        add(lastNameLabel);
        add(lastNameField);
        add(firstNameLabel);
        add(firstNameField);
        add(phoneNumberLabel);
        add(phoneNumberField);
        add(previousButton);
        add(nextButton);

        if (!customers.isEmpty()) {
            displayCustomer(customers.get(currentIndex));
            updateButtonState();
        } else {
            previousButton.setEnabled(false);
            nextButton.setEnabled(false);
        }

        setVisible(true);
    }

    private void displayCustomer(Customer customer) {
        idField.setText(String.valueOf(customer.getId()));
        lastNameField.setText(customer.getLastName());
        firstNameField.setText(customer.getFirstName());
        phoneNumberField.setText(customer.getPhoneNumber());
    }

    private void updateButtonState() {
        previousButton.setEnabled(currentIndex > 0);
        nextButton.setEnabled(currentIndex < customers.size() - 1);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == previousButton) {
            if (currentIndex > 0) {
                currentIndex--;
                displayCustomer(customers.get(currentIndex));
                updateButtonState();
            }
        } else if (e.getSource() == nextButton) {
            if (currentIndex < customers.size() - 1) {
                currentIndex++;
                displayCustomer(customers.get(currentIndex));
                updateButtonState();
            }
        }
    }

    public static void main(String[] args) {
        new CustomerViewer();
    }
}
