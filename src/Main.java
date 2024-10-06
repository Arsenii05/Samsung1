import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HashMap<String, Integer> prices = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] s = scanner.nextLine().split("\t");
            prices.put(s[0], Integer.parseInt(s[1]));
        }

        scanner.nextLine(); // empty input
        String buy = scanner.nextLine();
        int finalSum = 0;
        int orderSum = 0;
        int count = 1;
        boolean orderWas = false;

        while (!buy.equals(".")) {
            if (buy.length() == 0) {
                if (orderWas) {
                    System.out.printf("%d) %d%n", count, orderSum);
                    count++;
                    finalSum += orderSum;
                    orderSum = 0;
                    orderWas = false;
                }
            } else {
                orderWas = true;
                String[] order = buy.split("\t");
                orderSum += prices.get(order[0]) * Integer.parseInt(order[1]);
            }
            buy = scanner.nextLine();
        }

        if (orderSum != 0) {
            System.out.printf("%d) %d%n", count, orderSum);
            finalSum += orderSum;
        }

        System.out.printf("Итого: %d%n", finalSum);
        scanner.close();
    }
}

