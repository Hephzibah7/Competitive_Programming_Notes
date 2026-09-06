import java.util.*;

public class LunaticNeverContent {
	// Method to solve each test case
	private static void solve(Scanner scanner) {
		int n = scanner.nextInt();
		int[] a = new int[n];
		// Read the elements of the array
		for (int i = 0; i < n; i++) {
			a[i] = scanner.nextInt();
		}

		int ans = 0;
		// Iterate over the array to calculate the gcd of differences
		for (int i = 0; i < n; i++) {
			// Calculate the gcd of the current answer and the absolute difference
			// between the i-th element and its corresponding element from the end
			ans = gcd(ans, a[i] - a[n - i - 1]);
		}
		// Output the result for the current test case
		System.out.println(ans);
	}

	// Helper method to calculate gcd of two numbers
	private static int gcd(int a, int b) {
		if (b == 0) return a;
		return gcd(b, a % b);
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		// Read the number of test cases
		while (t-- > 0) {
			// Solve each test case
			solve(scanner);
		}
		scanner.close();
	}
}

// Time Complexity (TC): O(n * log(1e9))
// Space Complexity (SC): O(n)