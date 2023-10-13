
// basically  builder pattern reduce the complexity of creating complex object
// some cases we have to use multiple constructer for create a instance of a class

// problem statement

// Happy Shopping Store is an online shopping system.
//  There when a registered customer buys an item from the store it
//  needs to provide five attributes as first name, last name, age, phone, and address 
//  as the delivery details in order to deliver the item to the particular customer. 
//  And here we want only the first name and the last name of the registered customer and the rest 
//  other fields are optional. Because system already have the delivery details of all 
//  the registered customers. So let’s solve this real world problem

class Customer {
    private final String firstName;
    private final String lastName;
    private final String address;
    private final String feedback;
    private final String phoneNumber;

    public Customer(Builder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.address = builder.address;
        this.feedback = builder.feedback;
        this.phoneNumber = builder.phoneNumber;
    }

    static class Builder {
        private String firstName;
        private String lastName;
        private String address;
        private String feedback;
        private String phoneNumber;

        public Builder firstName(String firstname) {
            this.firstName = firstname;
            return this;
        }

        public Builder lastName(String lastname) {
            this.lastName = lastname;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public Builder feedback(String feedback) {
            this.feedback = feedback;
            return this;
        }

        public Builder phoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Customer build() {
            return new Customer(this);
        }
    }

    @Override
    public String toString() {
        return "Customer [address=" + address + ", feedback=" + feedback + ", firstName=" + firstName + ", lastName="
                + lastName + ", phoneNumber=" + phoneNumber + "]";
    }

}

class ShoppingUser {
    public static void main(String[] args) {

        Customer.Builder builder = new Customer.Builder();

        Customer c1 = builder.firstName("Raj").lastName("Kumar").build();
        Customer c2 = builder.firstName("pabitra").lastName("dakua").feedback("very good").address("balasore").build();

        System.out.println(c1);
        System.out.println(c2);
    }
}