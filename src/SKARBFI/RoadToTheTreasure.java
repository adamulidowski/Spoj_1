package SKARBFI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Scanner;

public class RoadToTheTreasure {

	private int numberOfSets;
	private int numberOfTips;
	private int stepsUp;
	private int stepsDown;
	private int stepsLeft;
	private int stepsRight;
	private int direction;
	private int numberOfSteps;
	private BufferedReader br;
	private int verticalLength;
	private int levelLength;

	public BufferedReader getBr() {
		return br;
	}

	public void setBr() {
		br = new BufferedReader(new InputStreamReader(System.in));
	}

	public void insertNumberOfSets() {
		try {
			numberOfSets = (Integer.parseInt(br.readLine()));
			while (checkNumbers(numberOfSets, 1, 50) == false)
				numberOfSets = (Integer.parseInt(br.readLine()));
		} catch (NumberFormatException | IOException e) {
			System.out.println("B³¹d przy wprowadzaniu danych! Koniec programu. " + e);
			System.exit(0);
		}
	}


	public void insertNumberOfTips() {
		try {
			numberOfTips = (Integer.parseInt(br.readLine()));
			while (checkNumbers(numberOfTips, 1, 100000) == false)
				numberOfTips = (Integer.parseInt(br.readLine()));
		} catch (NumberFormatException | IOException e) {
			System.out.println("B³¹d przy wprowadzaniu danych! Koniec programu. " + e);
			System.exit(0);
		}
	}

	public boolean checkNumbers(int number, int firstNumber, int lastNumber) {
		if (number < firstNumber || number > lastNumber) {
			System.out.println("Podaj liczbê z zakresu od " + firstNumber + " do " + lastNumber + "!");
			return false;
		} else
			return true;
	}
	
	public void insertPair() {
		Scanner scanner = new Scanner(System.in);
		for (int j = 0; j < numberOfTips; j++) {
			try {
				direction = scanner.nextInt();
				numberOfSteps = scanner.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Nie poda³eœ liczby! Koniec programu! " + e);
				System.exit(0);
			}
			if(checkDirection().equals("failure") || checkSteps()==true){
				takeSteps();
			}
		}
	}

	public boolean checkSteps() {
		if (numberOfSteps > 10000 || numberOfSteps < 1) {
			System.out.println("Liczba kroków musi byæ w przedziale od 1 do 10000!");
			System.out.println("Kroki nie s¹ brane po uwagê!");
			numberOfTips++;
			return false;
		} else
			return true;
	}

	public String checkDirection() {
		if (direction == 0) {
			return "goUp";
		} else if (direction == 1) {
			return "goDown";
		} else if (direction == 2) {
			return "goLeft";
		} else if (direction == 3) {
			return "goRight";
		} else {
			return "failure";
		}
	}

	public void takeSteps() {
		if (checkDirection().equals("goUp")) {
			stepsUp += numberOfSteps;
		} else if (checkDirection().equals("goDown")) {
			stepsDown += numberOfSteps;
		} else if (checkDirection().equals("goLeft")) {
			stepsLeft += numberOfSteps;
		} else if (checkDirection().equals("goRight")) {
			stepsRight += numberOfSteps;
		} else if (checkDirection().equals("failure")) {
			System.out.println("Nie ma takiego kierunku!");
			System.out.println("Kroki nie s¹ brane po uwagê!");
			numberOfTips++;
		}
	}

	public void calculateDistanceToTheTreasure() {
		verticalLength = stepsDown - stepsUp;
		levelLength = stepsRight - stepsLeft;
	}

	public void printDistanceToTheTreasure() {
		calculateDistanceToTheTreasure();
		if (verticalLength == 0 && levelLength == 0) {
			System.out.println("studnia");
		}
		if (verticalLength < 0) {
			System.out.println("0 " + verticalLength * (-1));
		} else if (verticalLength > 0) {
			System.out.println("1 " + verticalLength);
		}
		if (levelLength > 0) {
			System.out.println("3 " + levelLength);
		} else if (levelLength < 0) {
			System.out.println("2 " + levelLength * (-1));
		}
	}

	public void resetSteps() {
		stepsUp = stepsDown = stepsRight = stepsLeft = 0;
	}

	public void start() {
		setBr();
		insertNumberOfSets();
		for (int i = 0; i < numberOfSets; i++) {
			insertNumberOfTips();
			insertPair();
			printDistanceToTheTreasure();
			resetSteps();
		}
	}
}
