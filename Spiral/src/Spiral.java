
/**
 * Class create a Spiral object that draws spiral shapes when instantiated with a desired number of loops.
 * 
 * @author Huan Cung
 * @version 1.0.0
 * 
 */
public class Spiral {
	private static char[][] canvas;
	
	/**
	 * Constructor
	 * 
	 * @param spiral an int number representing the shape size
	 */
	public Spiral(int spiral) {
		canvas = new char[spiral][spiral];
		int row = 0;
		int col = spiral;

		while (spiral > 0) {
			// top edge
			for (int i = 0; i < spiral - 1; i++) {
				col--;
				canvas[row][col] = '-';
			}

			col--;
			canvas[row][col] = '+';
			spiral--;
			if (spiral == 0) {
				break;
			}

			// left edge
			for (int i = 0; i < spiral - 1; i++) {
				row++;
				canvas[row][col] = '|';
			}

			row++;
			canvas[row][col] = '+';
			spiral--;
			if (spiral == 0) {
				break;
			}

			// bottom edge
			for (int i = 0; i < spiral - 1; i++) {
				col++;
				canvas[row][col] = '-';

			}
			
			col++;
			canvas[row][col] = '+';
			spiral--;
			if (spiral == 0) {
				break;
			}

			// right edge
			for (int i = 0; i < spiral - 1; i++) {
				row--;
				canvas[row][col] = '|';
			}

			row--;
			canvas[row][col] = '+';
			spiral--;
			if (spiral == 0) {
				break;
			}
		}
	}

	/**
	 * Method prints the shape to console.
	 */
	public void printShape() {
		for (int i = 0; i < canvas.length; i++) {
			for (int j = 0; j < canvas[i].length; j++) {
				char n = canvas[i][j];
				if (n != '\0') {
					System.out.print(String.valueOf(n));
				} else {
					System.out.print(" ");
				}

			}
			System.out.println("");
		}
	}

	/**
	 * Returns the array that contains the shape.
	 * 
	 * @return char[][] canvas is the 2d array that contains the spiral
	 */
	public char[][] getCanvasArray() {
		return canvas;
	}
}
