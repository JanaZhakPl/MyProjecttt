package TriangleTest;

import TriangleTest.Exeptions.NegativeSideException;
import TriangleTest.Exeptions.TriangleNotExistsException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Triangle {
    private static final Logger logger = LoggerFactory.getLogger(Triangle.class);
    public static double getTriangleSquare(int a, int b, int c) throws NegativeSideException, TriangleNotExistsException {
        isTriangleValid(a, b, c);
        double halfPerimeter = (a + b + c) / 2;
        return Math.sqrt(halfPerimeter * (halfPerimeter - a) * (halfPerimeter - b) * (halfPerimeter - c));
    }
    public static void isTriangleValid(int a, int b, int c) throws NegativeSideException, TriangleNotExistsException {
        if (a <= 0 || b <= 0 || c <= 0) throw new NegativeSideException();
        logger.error("Triangle has negative side length(s): {}, {}, {}.", a, b, c);
        if (a > b + c || b > a + c || c > a + b) throw new TriangleNotExistsException();
        logger.error("It is not a triangle in case of side length(s): {}, {}, {}.", a, b, c);
    }
}
