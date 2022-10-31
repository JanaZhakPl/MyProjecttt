package TriangleTest;

import TriangleTest.Exeptions.NegativeSideException;
import TriangleTest.Exeptions.TriangleNotExistsException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

import static TriangleTest.Triangle.getTriangleSquare;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

class TriangleTest {
    final static Logger logger = LoggerFactory.getLogger(TriangleTest.class);

    @Test
    @Tag("PositiveTestCase")
    @DisplayName("Getting triangle area")
    void triangleSquare() throws TriangleNotExistsException, NegativeSideException {
        //logger.debug("Verifying positive test scenario...");
        double result = getTriangleSquare(3, 4, 5);
        Assertions.assertEquals(6, result, 0.1);
    }

    @Test
    @Tag("NegativeTestCase")
    @DisplayName("Getting triangle area with wrong sides dimensions")
    void negativeSidesTest() {
        assertThatExceptionOfType(TriangleNotExistsException.class)
                .isThrownBy(() -> getTriangleSquare(103, 4, 5));
    }

    @Test
    @Tag("NegativeTestCase")
    @DisplayName("Getting triangle area with negative sides dimensions")
    void negativeSideTriangleTest() {
        assertThatExceptionOfType(NegativeSideException.class)
                .isThrownBy(() -> getTriangleSquare(-3, 4, 8));
    }
}