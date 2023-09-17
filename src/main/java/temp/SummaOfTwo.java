package temp;

import java.util.Scanner;

public class SummaOfTwo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer a = scanner.nextInt();
        Integer b = scanner.nextInt();
        SummaOfTwo kl = new SummaOfTwo();
        System.out.println(kl.sumOfTwo(a,b));
    }
    public Integer sumOfTwo(Integer a, Integer b) {
        return a + b;
    }

    public static Integer provides1() {
        return 1;
    }
}
