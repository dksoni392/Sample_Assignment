import java.util.Scanner;

public class CulturalFestSeatingBruteForce {
    public static String canArrangeSeatsEvenly(int n, int[] seats) {
        int totalSeats = 0;
        for (int seat : seats) {
            totalSeats += seat;
        }

        if (totalSeats % 2 != 0) {
            return "not possible";
        }

        int targetSeats = totalSeats / 2;
        boolean result = backtrack(seats, 0, 0, targetSeats);

        return result ? "balanced" : "not possible";
    }

    private static boolean backtrack(int[] seats, int index, int sumLeftSide, int targetSeats) {
        if (sumLeftSide == targetSeats) {
            return true;
        }

        if (index >= seats.length) {
            return false;
        }

        if (backtrack(seats, index + 1, sumLeftSide + seats[index], targetSeats)) {
            return true;
        }

        if (backtrack(seats, index + 1, sumLeftSide, targetSeats)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of sections: ");
        int n = scanner.nextInt();
        int[] seats = new int[n];
        System.out.println("Enter the number of seats in each section: ");
        for (int i = 0; i < n; i++) {
            seats[i] = scanner.nextInt();
        }
        System.out.println(canArrangeSeatsEvenly(n, seats));
        scanner.close();
    }
}

 
