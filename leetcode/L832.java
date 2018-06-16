import javax.sound.midi.Soundbank;

public class L832 {
	public static int[][] flipAndInvertImage(int[][] A) {
		int arr_num = A.length;
		int elem_num = A[0].length;
		for(int i=0;i<arr_num;i++) {
			for(int j=1;j<=elem_num/2;j++) {
				int tmp = A[i][j-1];
				A[i][j-1] = A[i][elem_num-1-(j-1)];
				A[i][elem_num-1-(j-1)] = tmp;
			}
		}
		
		for(int i=0;i<arr_num;i++) {
			for(int j=0;j<elem_num;j++) {
				if(A[i][j] == 0)
					A[i][j] = 1;
				else
					A[i][j] = 0;
			}
		}
		for(int i = 0;i<arr_num;i++) {
			for(int j = 0;j<elem_num;j++) {
				System.out.print(A[i][j]);
			}
			System.out.println();
		}
		return A;
    }
//	public static void main(String[] args) {
//		int[][] x = {{1,1,0,0},{1,0,0,1},{0,1,1,1},{1,0,1,0}};
//		int[][] y = flipAndInvertImage(x);
//	}
}
