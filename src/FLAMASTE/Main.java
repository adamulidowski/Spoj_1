package FLAMASTE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 int iloscZestawow = Integer.parseInt(br.readLine());
		 int ilosc=0;
		 boolean jedenWyraz=true;
		 for(int i=0; i<iloscZestawow; i++){
			 String wyraz = br.readLine();
			 char tabChar[] = wyraz.toCharArray();
			 if(tabChar.length==1){
				 System.out.println(tabChar[0]);
			 }
			 else if(tabChar.length==2) {
				 System.out.println(tabChar[0]+""+tabChar[1]);
			 }
			 else{ 
				 for(int j=1; j<tabChar.length; j++){
			
				 if(tabChar[j] != tabChar[j-1]){
					 jedenWyraz=false;
					 break;
				 }
			 }
			 if(jedenWyraz==false){
				 for(int j=1; j<tabChar.length; j++){
					 jedenWyraz=true;
				 if(tabChar[j] == tabChar[j-1]){
					 ilosc++;
				 } else {
					 if(ilosc >= 2 ){
						 System.out.print((tabChar[j-1])+""+(ilosc+1)); 
					 } else if(ilosc == 1){
						 System.out.print(tabChar[j-1]+""+tabChar[j-1] );
					 }
					 else if(ilosc == 0 ){
						 System.out.print((tabChar[j-1]));
					 }
					 ilosc=0;
				 }
			 }
			 ilosc=0;
			 for(int j=tabChar.length-1; j>0; j--){
				 if(tabChar[j] == tabChar[j-1]){
					 ilosc++;
			 } else{
				 if(ilosc >= 2 ){
					 System.out.print(  (tabChar[j])+""+(ilosc+1)); 
				 } else if(ilosc == 1){
					 System.out.print(tabChar[j]+""+tabChar[j]);
				 } else{
					 System.out.print(tabChar[j]);
				 }
				 ilosc=0;
				 break;
			 }
		 }
			 System.out.println();
		 } else {
			 System.out.println(tabChar[0]+""+(tabChar.length));
		 }
		 }
		 }
	}
}
