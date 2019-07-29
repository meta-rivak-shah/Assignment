package get2019.assignment7;

/**
 * @class Sparse have following opertion like
 * @func geneateSparseMatrix
 * @func getTranspose
 * @func findTranspose
 * @func genrateMainMatrix
 * @func findSymetric
 * @func findAddtion
 * @func multiPication
 * @author Rivak shah
 *this are function which we used in the class to perform basic operation
 */
public final class Sparse {

	private final int Matrix[][];

	public int[][] getMatrix() {

		return Matrix;

	}
	
	/**
	 * 
	 * @param matrix is used to initilize the value
	 */
	public Sparse(int[][] matrix) {

		super();

		Matrix = matrix;

	}
	/**
	 * 
	 * @param Matrix is the argument passed by used to genrate a sparse matrix
	 * @return 2 dimensional  sparse matrix
	 */
	private int[][] geneateSparseMatrix(int Matrix[][]) {

		int size = 0;

		for (int i = 0; i < Matrix.length; i++) {

			for (int j = 0; j < Matrix[0].length; j++) {

				if (Matrix[i][j] != 0) {

					size++;

				}

			}

		}

		int sparseMatix[][] = new int[3][size];

		int k = 0;

		for (int i = 0; i < Matrix.length; i++) {

			for (int j = 0; j < Matrix[0].length; j++) {

				if (Matrix[i][j] != 0) {

					sparseMatix[0][k] = i;

					sparseMatix[1][k] = j;

					sparseMatix[2][k] = Matrix[i][j];

					k = k + 1;

				}

			}

		}

		return sparseMatix;

	}
	
	/**
	 * 
	 * @param matrix2 is the arugment passed by user
	 * is used to find the transpose of matrix 
	 * @return the transpose matrix to user
	 */
	public int[][] getTranspose(int[][] matrix2) {

		int sparseMatrix[][] = this.geneateSparseMatrix(matrix2); //call the function to create a sparse matrix

		int transMatrix[][] = findTranspose(sparseMatrix); // call to get trnspose

		int main[][] = this.genrateMainMatrix(transMatrix); //ccall to genrate main matrix

		return main; //return the main matrix

	}

	/**
	 * 
	 * @param sparseMatrix this contain the sparse matrix array
	 * @return transpose of sparseMatrix array
	 */
	private int[][] findTranspose(int[][] sparseMatrix) {

		int k = 0;

		int transMatrix[][] = new int[sparseMatrix.length][sparseMatrix[0].length]; //initalize with col and row of main matrix

		for (int j = 0; j < sparseMatrix[0].length; j++) {

			transMatrix[0][k] = sparseMatrix[1][j];

			transMatrix[1][k] = sparseMatrix[0][j];

			transMatrix[2][k] = sparseMatrix[2][j];

			k = k + 1;

		}

		return transMatrix;

	}
	/**
	 * this function is used to convert the sparse matrix into noraml matrix based on requirement
	 * this is private helper mehtod
	 * @param transMatrix contain the matrix which we want to transpose
	 * @return the noraml matrix which we generated
	 */
	private int[][] genrateMainMatrix(int[][] transMatrix) {

		int newMain[][] = new int[this.getMatrix()[0].length][this.getMatrix().length];

		for (int i = 0; i < transMatrix[0].length; i++) {

			int row1 = transMatrix[0][i];

			int col1 = transMatrix[1][i];

			int value = transMatrix[2][i];

			newMain[row1][col1] = value;

		}

		return newMain;

	}
	/**
	 * this function is used to convert the sparse matrix into noraml matrix based on requirement
	 * this is private helper mehtod
	 * @param transMatrix contain the matrix which we want to transpose
	 * @return the noraml matrix which we generated
	 */
	private int[][] genrateMainMatrix1(int[][] SparseMatrix) {

		int newMain[][] = new int[this.getMatrix().length][this.getMatrix()[0].length];

		for (int i = 0; i < SparseMatrix[0].length; i++) {

			int row1 = SparseMatrix[0][i];

			int col1 = SparseMatrix[1][i];

			int value = SparseMatrix[2][i];

			if (value != 0) {

				newMain[row1][col1] = value;
			}

		}

		return newMain;

	}

	/**
	 * findSymetric is used to check matrix are equal to both side
	 * @param matrix2 contain the sparse matix which check that it is symetric or not
	 * @return true is symmetric else false
	 */
	public boolean findSymetric(int[][] matrix2) {

		int sparseMatrix1[][] = this.geneateSparseMatrix(matrix2);

		int transMatrix[][] = findTranspose(sparseMatrix1);

		int mainMatrix[][] = this.genrateMainMatrix(transMatrix);

		int sparseMatrix2[][] = this.geneateSparseMatrix(mainMatrix);

		for (int i = 0; i < sparseMatrix1[0].length; i++) {

			if (sparseMatrix1[0][i] != sparseMatrix2[0][i]) {

				return false;

			}

			if (sparseMatrix1[1][i] != sparseMatrix2[1][i]) {

				return false;

			}

			if (sparseMatrix1[2][i] != sparseMatrix2[2][i]) {

				return false;

			}

		}

		return true;

	}
	
	/**
	 * 
	 * @param matrix1 this contain first normal matrix
	 * @param matrix2 this contain second noraml matrix 
	 * @return the addtion of both matrix and convert into sparse and return to normal
	 */
	public int[][] findAddtion(int[][] matrix1, int[][] matrix2) {
		int sparseMatrix1[][] = this.geneateSparseMatrix(matrix1);
		int sparseMatrix2[][] = this.geneateSparseMatrix(matrix2);
		int max = sparseMatrix1[0].length + sparseMatrix2[0].length;
		int[][] addition = new int[3][max];
		int k = 0;
		int l = 0;
		for (int i = 0; i < sparseMatrix1[0].length; i++) {
			l = k;
			for (int j = 0; j < sparseMatrix2[0].length; j++) {
				//check that martix of same row and col of both matrix are equal or not
				if (sparseMatrix1[0][i] == sparseMatrix2[0][j] && sparseMatrix1[1][i] == sparseMatrix2[1][j]) {
					addition[0][k] = sparseMatrix1[0][i];
					addition[1][k] = sparseMatrix1[1][i];
					// System.out.println( sparseMatrix1[2][i] +
					// sparseMatrix2[2][j]+" sparseMatrix1[2][i] + sparseMatrix2[2][j]");
					addition[2][k] = sparseMatrix1[2][i] + sparseMatrix2[2][j];
					k++;
					break;
				}
			}
			if (l == k) {
				System.out.println(sparseMatrix1[2][i] + "v" + k);
				addition[0][k] = sparseMatrix1[0][i];
				addition[1][k] = sparseMatrix1[1][i];
				addition[2][k] = sparseMatrix1[2][i];
				k++;
				l++;
			}

		}
		for (int i = 0; i < sparseMatrix2[0].length; i++) {
			l = k;
			for (int j = 0; j < sparseMatrix1[0].length; j++) {
				//check that martix of same row and col of both matrix are equal or not
				if (sparseMatrix1[0][j] == sparseMatrix2[0][i] && sparseMatrix1[1][j] == sparseMatrix2[1][i]) {
					k++;
					break;
				}
			}
			if (l == k) {
				System.out.println(sparseMatrix2[2][i] + "v" + k);
				addition[0][k] = sparseMatrix2[0][i];
				addition[1][k] = sparseMatrix2[1][i];
				addition[2][k] = sparseMatrix2[2][i];
				k++;
				l++;
			}

		}

		return genrateMainMatrix1(addition);
	}

	/**
	 * this funciton is used to multipy number with both matrix one with second
	 * @param matrix1  is contain the normal matrix
	 * @param matrix0 is contain the second normal matrix
	 * @return the multiply of both matrix and return into single
	 */
	public int[][] multiPication(int[][] matrix1, int[][] matrix0) {
		
        
        if(matrix1[0].length != matrix2.length) {
            throw new AssertionError();
        }
        
        int mulMatrix[][] = new int[matrix1.length][matrix2[0].length];
        
        int sparse1[][]  = this.geneateSparseMatrix(this.getMatrix());
        
        int sparse2[][]  = this.geneateSparseMatrix(matrix2);
        
        int sparse2T[][] = this.getTranspose(matrix2);
        
        for (int i = 0; i < sparse1[0].length; i++) {
            
            int row1 = sparse1[1][i]; //column
            int sum=0;
            int col1 = sparse1[0][i];
            for (int j = 0; j < sparse2T[0].length; j++) {
                
                int row2 = sparse2T[0][j];
                int col2 = sparse2T[1][j];
                
                int temp1=i;
                int temp2=j;
                while(temp1<sparse1[0].length&&temp2<sparse2T[0].length&&row2 == row1 && col1 == col2) {
                    System.out.println("dd");
                    sum =sum+sparse1[2][i]*sparse2T[2][j];
                    temp1++;
                    temp2++;
                }
                mulMatrix[col1][col2] = sum;
            }
        }
        return mulMatrix;
        
	}

}
