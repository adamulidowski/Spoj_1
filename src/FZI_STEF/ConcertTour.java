package FZI_STEF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConcertTour {
	private long temporaryProfit;
	private long maximumProfit;
	private int numberOfCities;
	private int[] profitFromEveryCity;
	private BufferedReader br;

	public BufferedReader getBr() {
		return br;
	}

	public void setBr() {
		br = new BufferedReader(new InputStreamReader(System.in));
	}

	public void insertNumberOfCities() {
		try {
			numberOfCities = (Integer.parseInt(br.readLine()));
			while (checkNumbers(numberOfCities, 1, 100000) == false)
				numberOfCities = Integer.parseInt(br.readLine());
		} catch (NumberFormatException | IOException e) {
			System.out.println("Bl¹d wprowadzania danych! " + e);
			System.exit(0);
		}
	}

	public void insertProfitsFromCities() {
		profitFromEveryCity = new int[numberOfCities];
		for (int i = 0; i < profitFromEveryCity.length; i++) {
			try {
				profitFromEveryCity[i] = Integer.parseInt(br.readLine());
			} catch (NumberFormatException | IOException e) {
				System.out.println("Bl¹d wprowadzania danych! " + e);
				System.exit(0);
			}
			if (!checkNumbers(profitFromEveryCity[i], -100000, 100000)) {
				i--;
			}
		}
	}

	public boolean checkNumbers(int number, int firstNumber, int lastNumber) {
		if (number < firstNumber || number > lastNumber) {
			System.out.println("Podaj liczbê z zakresu od " + firstNumber + " do " + lastNumber + "!");
			return false;
		} else
			return true;
	}

	public long calculateMaximumProfit() {
		temporaryProfit = maximumProfit = 0;
		for (int i = 0; i < profitFromEveryCity.length; i++) {
			temporaryProfit = Math.max(profitFromEveryCity[i], temporaryProfit + profitFromEveryCity[i]);
			maximumProfit = Math.max(maximumProfit, temporaryProfit);
		}
		if (maximumProfit < 0) {
			maximumProfit = 0;
		}
		return maximumProfit; 
	}

	public void run() {
		setBr();
		insertNumberOfCities();
		insertProfitsFromCities();
		System.out.println(calculateMaximumProfit());
	}

}
