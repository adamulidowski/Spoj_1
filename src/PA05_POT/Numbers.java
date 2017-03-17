package PA05_POT;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Numbers {

	private int numberOfCases;
	private long values[][];
	private long results[];

	private void insertNumberOfCases() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			numberOfCases = (Integer.parseInt(br.readLine()));
		} catch (NumberFormatException | IOException e) {
			System.out.println("B³¹d wprowadzania danych, podaj liczbê! " + e);
			System.exit(0);
		}
		checkNumberOfCases();
	}

	private void checkNumberOfCases() {
		if (numberOfCases < 1) {
			System.out.println("Liczba jest za ma³a");
			System.exit(0);
		} else if (numberOfCases > 10) {
			System.out.println("Liczba jest za du¿a");
			System.exit(0);
		}
	}

	private void insertValues() {
		values = new long[2][numberOfCases];
		Scanner scanner = new Scanner(System.in);
		for (int i = 0; i < numberOfCases; i++) {
			for (int j = 0; j < 2; j++) {
				try {
					values[j][i] = scanner.nextLong();
				} catch (InputMismatchException e) {
					System.out.println("Z³y format, podaj liczbê! " + e);
					System.exit(0);
				}
			}
		}
		checkValues();
	}

	private void checkValues() {
		for (int i = 0; i < numberOfCases; i++) {
			for (int j = 0; j < 2; j++) {
				if (values[j][i] < 1) {
					System.out.println("Wprowadzi³eœ za ma³¹ liczbê.");
					System.exit(0);
				} else if (values[j][i] > 1000000000) {
					System.out.println("Wprowadzi³eœ za du¿¹ liczbê.");
					System.exit(0);
				}
			}
		}
	}

	public void insertResults() {
		results = new long[numberOfCases];
		for (int i = 0; i < numberOfCases; i++) {
			results[i] = calculateNumbers(getLastNumbers(values[0][i]), values[1][i]);
		}
	}

	public long getLastNumbers(long number) {
		return number % 10;

	}

	public void insertAll() {
		insertNumberOfCases();
		insertValues();
	}

	private long calculateNumbers(long lastNumber, long power) {
		if (lastNumber == 0 || lastNumber == 1 || lastNumber == 5 || lastNumber == 6) {
			return lastNumber;
		} else if (lastNumber == 4) {
			if (power % 2 == 0) {
				return 6;
			} else {
				return 4;
			}
		} else if (lastNumber == 9) {
			if (power % 2 == 0) {
				return 1;
			} else {
				return 9;
			}
		} else {
			long remainder = getRest(power);
			return(checkTable(remainder, lastNumber));
		}
	}

	public long checkTable(long remainder, long lastNumber) {
		if ((remainder == 1 && lastNumber == 2) || (remainder == 3 && lastNumber == 8)) {
			return 2;
		} else if ((remainder == 1 && lastNumber == 3) || (remainder == 3 && lastNumber == 7)) {
			return 3;
		} else if ((remainder == 1 && lastNumber == 7) || (remainder == 3 && lastNumber == 3)) {
			return 7;
		} else if ((remainder == 1 && lastNumber == 8) || (remainder == 3 && lastNumber == 2)) {
			return 8;
		} else if ((remainder == 2 && lastNumber == 2) || (remainder == 2 && lastNumber == 8)) {
			return 4;
		} else if ((remainder == 2 && lastNumber == 3) || (remainder == 2 && lastNumber == 7)) {
			return 9;
		} else if ((remainder == 0 && lastNumber == 2) || (remainder == 0 && lastNumber == 8)) {
			return 6;
		} else if ((remainder == 0 && lastNumber == 3) || (remainder == 0 && lastNumber == 7)) {
			return 1;
		} else
			return 00;
	}

	public long getRest(long power) {
		return power % 4;

	}

	public void printResults() {
		for (int i = 0; i < numberOfCases; i++) {
			System.out.println(results[i]);
		}
	}

}