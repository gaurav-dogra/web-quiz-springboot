import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        String[] numbers = scanner.nextLine().split("\\s");
        String searchNo = scanner.next();
        List<String> list = List.of(numbers);
        System.out.println(list.contains(searchNo));
    }
}