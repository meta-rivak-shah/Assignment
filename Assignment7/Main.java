package get2019.assignment7;

public class Main {



	public static void main(String[] args) {

		int matrix[][] = new int[][] {{1,1,3,0,4},{1,0,0,0,0},{0,0,0,0,0},{0,2,6,0,0}};
		int matrix1[][] = new int[][] {{1,1,0,0,4},{0,0,0,7,0},{0,0,0,0,0},{0,2,6,0,0}};
		Sparse obj = new Sparse(matrix);
		
		Sparse obj1 = new Sparse(matrix1);

		int newMatrix[][]=obj.getTranspose(obj.getMatrix());

		

		for (int i = 0; i < newMatrix.length; i++) {

			for (int j = 0; j < newMatrix[0].length; j++) {

				System.out.print(newMatrix[i][j]);

			}

			System.out.println();

		}

		

		boolean isSymetric =obj.findSymetric(obj.getMatrix());

		System.out.println(isSymetric);
		
		int newMatrix1[][]=obj.findAddtion(obj.getMatrix() , obj1.getMatrix());
		

		for (int i = 0; i < newMatrix1.length; i++) {

			for (int j = 0; j < newMatrix1[0].length; j++) {

				System.out.print(newMatrix1[i][j]+" ");

			}

			System.out.println();

		}

	int newMatrix2[][]=obj.multiPication(obj.getMatrix() , obj1.getMatrix());
		

		for (int i = 0; i < newMatrix1.length; i++) {

			for (int j = 0; j < newMatrix1[0].length; j++) {

				System.out.print(newMatrix1[i][j]+" ");

			}

			System.out.println();

		}
	}

}