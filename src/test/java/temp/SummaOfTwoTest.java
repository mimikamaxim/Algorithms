package temp;

import kotlin.jvm.internal.Lambda;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

    //    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    static class stdTest {
        private final InputStream systemIn = System.in;
        private final PrintStream systemOut = System.out;
        private ByteArrayInputStream testIn;
        private ByteArrayOutputStream testOut;

        @BeforeEach
        public void setUpOutput() {
            testOut = new ByteArrayOutputStream();
            System.setOut(new PrintStream(testOut));
//            System.out.println("Before called^");
        }

        private void provideInput(String data) {
            testIn = new ByteArrayInputStream(data.getBytes());
            System.setIn(testIn);
        }

        private String getOutput() {
            return testOut.toString();
        }

        @AfterEach
        public void restoreSystemInputOutput() {
            System.setIn(systemIn);
            System.setOut(systemOut);
        }

//        public String emitAndCollectData(String data, Lambda run) {
//            provideInput(data);
//            run.notify();
//            return getOutput();
//        }


        @Test
        public void testCase1() {
            final String testString = "1 1";
            provideInput(testString);
            SummaOfTwo.main(new String[0]);
            Scanner scanner = new Scanner(getOutput());
            assertEquals(2, scanner.nextInt());
        }

        @Test
        public void testCase2() {
            final String testStr = "2 2";
            provideInput(testStr);
            SummaOfTwo.main(new String[0]);
            Scanner scanner = new Scanner(getOutput());
            assertEquals(scanner.nextInt(), 4);
        }

//        @Test
//        public void testCase3() {
//            emitAndCollectData("3 3",
//        }
    }
}