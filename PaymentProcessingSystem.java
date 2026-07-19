public class PaymentProcessingSystem {

    interface Payable {
        double calculatePayment();
        void displayPaymentDetails();
    }

    static class Invoice implements Payable {
        private String invoiceNumber;
        private double amount;

        public Invoice(String invoiceNumber, double amount) {
            this.invoiceNumber = invoiceNumber;
            this.amount = amount;
        }

        @Override
        public double calculatePayment() {
            return amount;
        }

        @Override
        public void displayPaymentDetails() {
            System.out.println("Invoice Number: " + invoiceNumber);
            System.out.printf("Payment Amount: $ %.2f%n", calculatePayment());
        }
    }

    static class Freelancer implements Payable {
        private String name;
        private double hourlyRate;
        private int hoursWorked;

        public Freelancer(String name, double hourlyRate, int hoursWorked) {
            this.name = name;
            this.hourlyRate = hourlyRate;
            this.hoursWorked = hoursWorked;
        }

        @Override
        public double calculatePayment() {
            return hourlyRate * hoursWorked;
        }

        @Override
        public void displayPaymentDetails() {
            System.out.println("Freelancer Name: " + name);
            System.out.printf("Hourly Rate    : $ %.2f%n", hourlyRate);
            System.out.println("Hours Worked   : " + hoursWorked);
            System.out.printf("Payment Amount : $ %.2f%n", calculatePayment());
        }
    }

    static class Supplier implements Payable {
        private String supplierName;
        private double orderAmount;
        private double deliveryFee;

        public Supplier(String supplierName, double orderAmount, double deliveryFee) {
            this.supplierName = supplierName;
            this.orderAmount = orderAmount;
            this.deliveryFee = deliveryFee;
        }

        @Override
        public double calculatePayment() {
            return orderAmount + deliveryFee;
        }

        @Override
        public void displayPaymentDetails() {
            System.out.println("Supplier Name  : " + supplierName);
            System.out.printf("Order Amount   : $ %.2f%n", orderAmount);
            System.out.printf("Delivery Fee   : $ %.2f%n", deliveryFee);
            System.out.printf("Payment Amount : $ %.2f%n", calculatePayment());
        }
    }

    public static void main(String[] args) {
        Payable[] payments = new Payable[3];

        payments[0] = new Invoice("INV1001", 1200.00);
        payments[1] = new Freelancer("Ravi Kumar", 80.00, 20);
        payments[2] = new Supplier("ABC Stationery", 950.00, 50.00);

        double totalPayment = 0;

        System.out.println("Payment Processing Report");
        System.out.println("-------------------------");

        for (Payable payment : payments) {
            payment.displayPaymentDetails();
            totalPayment += payment.calculatePayment();
            System.out.println();
        }

        System.out.printf("Total Payment: $ %.2f%n", totalPayment);
    }
}
