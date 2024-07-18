public class Customer {
    private final int id;
    private final String lastName;
    private final String firstName;
    private final String phoneNumber;

    public Customer(int id, String lastName, String firstName, String phoneNumber) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
