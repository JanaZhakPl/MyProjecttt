package TriangleTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

class TriangleTest {
    private static Logger logger = LoggerFactory.getLogger(TriangleTest.class);

    @Test
    void triangleSquare() throws Exception {
        Triangle triangle = new Triangle(6, 8, 6);
        double actual = triangle.getTriangleSquare();
        double expected = 17.88854381999832;
        Assertions.assertEquals(expected, actual);

    }

    @Test
    void isTriangleExist() {
    }
}