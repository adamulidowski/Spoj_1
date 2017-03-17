package FANGEN;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static class Windmills {

		protected char[][] Windmillfield;
		List<Windmill> Windmills = new ArrayList<Windmill>();
		Windmill windmill;

		public void insertWindmills() {
			int windmillsSize=0;
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			try {
				windmillsSize = Integer.parseInt(br.readLine());
			} catch (NumberFormatException | IOException e) {
				System.out.println("B³¹d wejœcia! Koniec programu "+ e);
				System.exit(0);
			}
			while (windmillsSize != 0) {
				if (checkSize(windmillsSize) == true) {
					windmill = new Windmill();
					if (windmillsSize > 0) {
						windmill.setSize(windmillsSize * 2);
						windmill.setDirectionRight(true);
						windmill.setField(createWindmillField(windmillsSize * 2));
					} else {
						windmill.setSize(windmillsSize * 2 * (-1));
						windmill.setDirectionRight(false);
						windmill.setField(createWindmillField(windmillsSize * 2 * (-1)));
					}
					Windmills.add(windmill);
				} else {
					System.out.println("Podaj liczbê od -20 do 20!");
				}
				try {
					windmillsSize = Integer.parseInt(br.readLine());
				} catch (NumberFormatException | IOException e) {
					System.out.println("B³¹d wejœcia! Koniec programu "+ e);
					System.exit(0);
				}
			}
		}

		public boolean checkSize(int size) {
			if (size > 20 || size < -20) {
				return false;
			} else
				return true;
		}

		public char[][] createWindmillField(int size) {
			Windmillfield = new char[size * 2][size * 2];
			for (int k = 0; k < size * 2; k++) {
				for (int j = 0; j < size * 2; j++) {
					Windmillfield[k][j] = '*';
				}
			}
			return Windmillfield;
		}

		public void createWindmills() {
			for (int i = 0; i < Windmills.size(); i++) {
				Windmills.get(i).createWindmill();
			}
		}



		public void printWindmils() {
			for (int i = 0; i < Windmills.size(); i++) {
				Windmills.get(i).printField();
				System.out.println();
			}
		}
	}
	
	
	
	public static class Windmill {

		private int size;
		private boolean directionRight;
		private char[][] field;

		public int getSize() {
			return size;
		}

		public void setSize(int size) {
			this.size = size;
		}

		public boolean isDirectionRight() {
			return directionRight;
		}

		public void setDirectionRight(boolean direction) {
			this.directionRight = direction;
		}

		public char[][] getField() {
			return field;
		}

		public void setField(char[][] field) {
			this.field = field;
		}

		public void printField() {
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					System.out.print(field[i][j]);
				}
				System.out.println();
			}
		}

		public void createWindmill() {
			if (isDirectionRight()) {
				createRightWindmill(size / 2, 0, 1);
			} else {
				createLeftWindmill(size / 2, 0, 1);
			}
		}

		public void createLeftWindmill(int level, int pom, int pom2) {
			while (level > 1) {
				for (int i = (pom + 1); i < (level * 2) - pom2; i++) {
					if (i > ((level * 2) - 2) / 2 + pom) {
						field[(pom + 1) - 1][i] = '.';
					}
				}
				for (int i = (pom + 1); i < (level * 2) - pom2; i++) {
					if (i <= ((level * 2) - 2) / 2 + pom) {
						field[i][(pom + 1) - 1] = '.';
					}
				}
				for (int i = (size) - (pom + 2); i > pom; i--) {
					if (i > ((size) - 2) / 2) {
						field[i][(size) - (pom + 1)] = '.';
					}
				}
				for (int i = (size) - (pom + 2); i > pom; i--) {
					if (i <= ((size) - 2) / 2) {
						field[(size) - (pom + 1)][i] = '.';
					}
				}
				level--;
				pom++;
				pom2--;
			}
		}

		public void createRightWindmill(int level, int pom, int pom2) {
			while (level > 1) {
				for (int i = (pom + 1); i < (level * 2) - pom2; i++) {
					if (i <= ((level * 2) - 2) / 2 + pom) {
						field[(pom + 1) - 1][i] = '.';
					}
				}
				for (int i = (pom + 1); i < (level * 2) - pom2; i++) {
					if (i > ((level * 2) - 2) / 2 + pom) {
						field[i][(pom + 1) - 1] = '.';
					}
				}
				for (int i = (size) - (pom + 2); i > pom; i--) {
					if (i <= ((size) - 2) / 2) {
						field[i][(size) - (pom + 1)] = '.';
					}
				}
				for (int i = (size) - (pom + 2); i > pom; i--) {
					if (i > ((size) - 2) / 2) {
						field[(size) - (pom + 1)][i] = '.';
					}
				}
				level--;
				pom++;
				pom2--;
			}
		}

	}

	public static void main(String[] args) {
		Main.Windmills w = new Main.Windmills();
		w.insertWindmills();
		w.createWindmills();
		w.printWindmils();
	}
}

