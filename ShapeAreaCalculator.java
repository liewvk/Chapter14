public class ShapeAreaCalculator {

    static abstract class Shape {
        private final String shapeName;

        public Shape(String shapeName) {
            this.shapeName = shapeName;
        }

        public String getShapeName() {
            return shapeName;
        }

        public abstract double calculateArea();

        public void displayArea() {
            System.out.println("Shape: " + shapeName);
            System.out.printf("Area : %.2f%n", calculateArea());
        }
    }

    static class Circle extends Shape {
        private final double radius;

        public Circle(double radius) {
            super("Circle");
            this.radius = radius;
        }

        @Override
        public double calculateArea() {
            return Math.PI * radius * radius;
        }
    }

    static class Rectangle extends Shape {
        private final double width;
        private final double height;

        public Rectangle(double width, double height) {
            super("Rectangle");
            this.width = width;
            this.height = height;
        }

        @Override
        public double calculateArea() {
            return width * height;
        }
    }

    static class Triangle extends Shape {
        private final double base;
        private final double height;

        public Triangle(double base, double height) {
            super("Triangle");
            this.base = base;
            this.height = height;
        }

        @Override
        public double calculateArea() {
            return 0.5 * base * height;
        }
    }

    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];

        shapes[0] = new Circle(7);
        shapes[1] = new Rectangle(10, 5);
        shapes[2] = new Triangle(8, 6);

        for (Shape shape : shapes) {
            shape.displayArea();
            System.out.println();
        }
    }
}
