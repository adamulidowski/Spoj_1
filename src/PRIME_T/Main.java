package PRIME_T;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int czyPierwsza(int p) {
		if(p==1){
			return 0;
		}
		for (int i = 2; i <= Math.sqrt(p); i++) {
			if (p % i == 0) {
				return 0;
			}
		}
		return 1;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		 int iloscTestow;
		 int liczba;
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 iloscTestow = Integer.parseInt(br.readLine());
		 String tab[] = new String[iloscTestow];
		 for(int i=0; i<tab.length; i++){
			 liczba = Integer.parseInt(br.readLine());
	  		if (czyPierwsza(liczba)==0) 
	  			tab[i]="NIE";
	  		else
	  			tab[i]="TAK";
		}
		 for(int i=0; i<tab.length; i++){
			 System.out.println(tab[i]);
		 }
	}
}
