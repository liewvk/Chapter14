public class PolymorphismDemo {

    static class Employee {
        private String name;
        private double salary;

        public Employee(String name, double salary) {
            this.name = name;
            this.salary = salary;
        }

        public String getName() {
            return name;
        }

        public double getSalary() {
            return salary;
        }

        public double calculateMonthlyPay() {
            return salary;
        }

        public void displayDetails() {
            System.out.println("Name: " + name);
            System.out.printf("Monthly Pay: $ %.2f%n", calculateMonthlyPay());
        }
    }

    static class Manager extends Employee {
        private double allowance;

        public Manager(String name, double salary, double allowance) {
            super(name, salary);
            this.allowance = allowance;
        }

        @Override
        public double calculateMonthlyPay() {
            return getSalary() + allowance;
        }
    }

    static class Developer extends Employee {
        private double projectBonus;

        public Developer(String name, double salary, double projectBonus) {
            super(name, salary);
            this.projectBonus = projectBonus;
        }

        @Override
        public double calculateMonthlyPay() {
            return getSalary() + projectBonus;
        }
    }

    public static void main(String[] args) {
        Employee employee1 = new Employee("Mei Ling", 3500.00);
        Employee employee2 = new Manager("Alex Tan", 6000.00, 1500.00);
        Employee employee3 = new Developer("Ravi Kumar", 4500.00, 800.00);

        employee1.displayDetails();
        System.out.println();

        employee2.displayDetails();
        System.out.println();

        employee3.displayDetails();
    }
}
