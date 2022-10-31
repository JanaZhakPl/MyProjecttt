package TriangleTest;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

class TriangleTest {
    private static Logger logger = LoggerFactory.getLogger(TriangleTest.class);

    @Test
    void triangleSquare() throws Exception {
        //given
        Triangle triangle = new Triangle(6, 8, 6);
        //when
        double actual = triangle.getTriangleSquare();
        double expected = 17.8;
        //then
        Assertions.assertEquals(expected, actual, 0.1);
    }

    @Test
    void isTriangleExist() {
        Triangle tr = new Triangle(6, 8, 6);
        Assert.assertTrue(tr.isTriangleExist());
    }
}