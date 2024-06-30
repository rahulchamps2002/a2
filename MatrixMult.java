package a2;

import static org.junit.Assert.*;

/**
 * Name:
 * Student ID:
 * Description of solution:
 * @author name
 *
 */
public class MatrixMult {

    /** Function to multiply matrices 
     *  Assumes A and B are square and have the same size!
     *  @param A - matrix A to multiply (first operand)
     *  @param B - matrix B to multiply (second operand)
     ***/
    public static int[][] multiply(int[][] A, int[][] B)
    {        
        int n = A.length;
        int[][] R = new int[n][n];
        /** base case **/
        if (n == 1)
            R[0][0] = A[0][0] * B[0][0];
        else
        {
        	int[][] A11 = new int[n/2][n/2];
            int[][] A12 = new int[n/2][n/2];
            int[][] A21 = new int[n/2][n/2];
            int[][] A22 = new int[n/2][n/2];

            int[][] B11 = new int[n/2][n/2];
            int[][] B12 = new int[n/2][n/2];
            int[][] B21 = new int[n/2][n/2];
            int[][] B22 = new int[n/2][n/2];
        }
        /** return result **/    
        return R;
    }
    
    /** 
     * Function to subtract two matrices A and B
     ***/
    public static int[][] sub(int[][] A, int[][] B)
    {
        int n = A.length;
        int[][] C = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                C[i][j] = A[i][j] - B[i][j];
        return C;
    }
    
    /** 
     * Function to add two matrices A and B
     ***/
    public static int[][] add(int[][] A, int[][] B)
    {
        int n = A.length;
        int[][] C = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                C[i][j] = A[i][j] + B[i][j];
        return C;
    }
    
    /** 
     * Function to split parent matrix into child matrices.
     * Assumes C is initialized.
     * @param P - parent matrix
     * @param C - A child matrix that will get the corresponding indices of the parent
     * @param iB - start row in parent
     * @param jB - start column in parent
     ***/
    public static void split(int[][] P, int[][] C, int iB, int jB) 
    {
        for(int i1 = 0, i2 = iB; i1 < C.length; i1++, i2++)
            for(int j1 = 0, j2 = jB; j1 < C.length; j1++, j2++)
                C[i1][j1] = P[i2][j2];
    }
    
    /** 
     * Function to join child matrices into a parent matrix 
     * Assumes C is initialized.
     * @param P - parent matrix
     * @param C - A child matrix that will provide the corresponding indices of the parent
     * @param iB - start row in parent
     * @param jB - start column in parent
     ***/
    public static void join(int[][] C, int[][] P, int iB, int jB) 
    {
        for(int i1 = 0, i2 = iB; i1 < C.length; i1++, i2++)
            for(int j1 = 0, j2 = jB; j1 < C.length; j1++, j2++)
                P[i2][j2] = C[i1][j1];
    }    
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Ensure that multiplying the two matrices gives the correct result!
		int[][] A = {{1, 2}, {3, 4}};
		int[][] B = {{5, 6}, {7, 8}};

		int[][] C = multiply(A, B);
		System.out.println(C.toString());
		System.out.println("Testing...");
		assertEquals(C[0][0], 19);
		assertEquals(C[0][1], 22);
		assertEquals(C[1][0], 43);
		assertEquals(C[1][1], 50);
		System.out.println("Success!");
	}

}
