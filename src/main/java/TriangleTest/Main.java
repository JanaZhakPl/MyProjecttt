package TriangleTest;

public class Main {
    public static void main(String[] args) {
        Triangle triangle = new Triangle(1, 2, -2);

        try {
            System.out.println("Triangle's square is: " + triangle.getTriangleSquare());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
