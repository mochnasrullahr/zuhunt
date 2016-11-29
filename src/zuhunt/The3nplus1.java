package zuhunt;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class The3nplus1 {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new FileInputStream("The3nplus1.txt"));
//		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int lowBound = in.nextInt();
			int upBound = in.nextInt();
			int cycle = getMaxCycle(lowBound, upBound);
			System.out.format("%d %d %d\n", lowBound, upBound, cycle);
		}
	}

	private static int getMaxCycle(int lowBound, int upBound) {
		if (lowBound>upBound) {
			int temp = lowBound;
			lowBound = upBound;
			upBound = temp;
		}

		int maxCycle = 0;
		for (int i = lowBound; i <= upBound; i++) {
			int cycle = getCycle(i);
			if (cycle > maxCycle)
				maxCycle = cycle;
		}
		return maxCycle;
	}

	private static int getCycle(int n) {
		// System.out.println(n);
		if (n == 1)
			return 1;
		if (n % 2 == 1) {
			return 1 + getCycle(n * 3 + 1);
		} else {
			return 1 + getCycle(n / 2);
		}
	}
}
