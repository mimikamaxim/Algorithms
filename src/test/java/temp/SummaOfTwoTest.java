package temp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SummaOfTwoTest {

    @Test
    void sumOfTwo() {
        /**
         * this shows how use non-static methods
         */
        assertEquals(new SummaOfTwo().sumOfTwo(1, 1), 2);
    }

    @Test
    void staticTest() {
        /**
         * this shows how use static methods
         */
        assertEquals(SummaOfTwo.provides1(), 1);
    }
}