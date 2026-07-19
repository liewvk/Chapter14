public class PrintableReportDemo {

    interface Printable {
        void print();
    }

    static class StudentReport implements Printable {
        private String studentName;
        private double mark;

        public StudentReport(String studentName, double mark) {
            this.studentName = studentName;
            this.mark = mark;
        }

        @Override
        public void print() {
            System.out.println("Student Report");
            System.out.println("--------------");
            System.out.println("Name: " + studentName);
            System.out.printf("Mark: %.2f%n", mark);
        }
    }

    static class SalesReport implements Printable {
        private String month;
        private double salesAmount;

        public SalesReport(String month, double salesAmount) {
            this.month = month;
            this.salesAmount = salesAmount;
        }

        @Override
        public void print() {
            System.out.println("Sales Report");
            System.out.println("------------");
            System.out.println("Month: " + month);
            System.out.printf("Sales: $ %.2f%n", salesAmount);
        }
    }

    public static void main(String[] args) {
        Printable[] reports = new Printable[2];

        reports[0] = new StudentReport("Mei Ling", 88.5);
        reports[1] = new SalesReport("January", 25000.00);

        for (Printable report : reports) {
            report.print();
            System.out.println();
        }
    }
}
