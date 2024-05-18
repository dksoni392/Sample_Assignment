import java.util.Scanner;

public class CulturalFestSeatingPlan {
    public static String canArrangeSeatsEvenly(int n, int[] seats) {
        int totalSeats = 0;
        for (int seat : seats) {
            totalSeats += seat;
        }

        if (totalSeats % 2 != 0) {
            return "not possible";
        }

        int targetSeats = totalSeats / 2;
        boolean[] dp = new boolean[targetSeats + 1];
        dp[0] = true;

        for (int seat : seats) {
            for (int j = targetSeats; j >= seat; j--) {
                dp[j] = dp[j] || dp[j - seat];
            }
        }

        return dp[targetSeats] ? "balanced" : "not possible";
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
