package printingspiraldigits.com.br;

import java.io.*;

public class PRINTSPIRAL {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcases = Integer.parseInt(br.readLine());
		int i = 1;

		while (i <= testcases) {

			int[] numbers = pointsToArray(br);
			int rows = numbers[0];
			int columns = numbers[1];
			int[][] A = spiralMatrix(rows, columns);

			System.out.println("Case " + i + ":");

			for (int g = 0; g < rows; g++) {
				for (int j = 0; j < columns; j++) {
					if (rows * columns > 9 && rows * columns <= 99) {
						System.out.printf("%02d", A[g][j]);
						if ( j == columns - 1) { 
							break; 
						} else { 
							System.out.printf(" ");
						}
					} if (rows * columns <= 9) {					
						System.out.printf("%1d", A[g][j]);
						if ( j == columns - 1) { 
							break; 
						} else { 
							System.out.printf(" ");
						}
					}
				}
				System.out.println();
			}
			i++;
		}
	}

	private static int[][] spiralMatrix(int rows, int columns) {

		int[][] spiral = new int[rows][columns];

		if (spiral == null || spiral.length == 0)
			return spiral;

		int x = 0;
		int y = 0;
		int value = 1;

		while (rows > 0 && columns > 0) {

			if (rows == 1) {
				for (int i = 0; i < columns; i++) {
					spiral[x][y++] = value++;
				}
				break;
			} else if (columns == 1) {
				for (int i = 0; i < rows; i++) {
					spiral[x++][y] = value++;
				}
				break;
			}
			// below, process a circle
			// top - move right
			for (int i = 0; i < columns - 1; i++) {
				spiral[x][y++] = value++;
			}

			// right - move down
			for (int i = 0; i < rows - 1; i++) {
				spiral[x++][y] = value++;
			}

			// bottom - move left
			for (int i = 0; i < columns - 1; i++) {
				spiral[x][y--] = value++;
			}

			// left - move up
			for (int i = 0; i < rows - 1; i++) {
				spiral[x--][y] = value++;
			}
			x++;
			y++;
			rows = rows - 2;
			columns = columns - 2;
		}
		return spiral;
	}

	private static int[] pointsToArray(BufferedReader in) throws IOException {

		String[] arr = in.readLine().split(" ");
		int[] array = new int[arr.length];

		for (int i = 0; i < arr.length; i++) {
			array[i] = Integer.parseInt(arr[i]);
		}
		return array;
	}
}