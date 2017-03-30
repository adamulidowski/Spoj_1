package FCTRL3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		int iloscTestow;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		iloscTestow = Integer.parseInt(br.readLine());
		long silnia = 1;
		String silniaString = null;
		long liczba = 0;
		for (int i = 0; i < iloscTestow; i++) {
			liczba = Long.parseLong(br.readLine());
			for (int j = 1; j <= liczba; j++) {
				silnia *= j;
			}
			if (silnia < 10) {
				System.out.println("0 " + silnia);
			} else {
				silniaString = Long.toString(liczba);
				String s = String.valueOf(silnia);
				System.out.println(silniaString);
				System.out.println(silnia);
				long wynik = (long) ((long) Math.pow((liczba/Math.E), liczba)*Math.sqrt(2*Math.PI*liczba));
				System.out.println(wynik);
				//System.out.println(silniaString.substring(0, silniaString.length() - 1) + " "
				//		+ silniaString.substring(silniaString.length() - 1), silniaString.length());
			}
			silnia = 1;
			silniaString = null;
			liczba = 0;
		}
	}
}
