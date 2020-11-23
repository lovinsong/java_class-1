package quiz;

import java.util.Arrays;

public class B14_Array2Quiz {

	public static void main(String[] args) {
		
		int[][] numArr = {
				{10, 10, 10, 10},
				{90, 50, 30, 70},
				{800, 500},
				{300, 300, 300}
		};
		
		// 1. numArr의 총합과 평균(소수점 둘째자리)을 구해서 출력해보세요 
		int sum = 0;
		int item_count = 0;		
		
		for (int i = 0; i < numArr.length; ++i) {			
			item_count += numArr[i].length;
			
			for (int j = 0; j < numArr[i].length; ++j) {
				sum += numArr[i][j];				
			}			
		}
		
		System.out.printf("총 합 : %d\n평 균 : %.2f\n", 
				sum, sum / (double) item_count);
		
		// 2. numArr의 각 행의 합과 열의 합을 모두 구해서 출력해보세요 
		//		0행의 합 : 10 + 10 + 10 + 10
		//		0열의 합 : 10 + 90 + 800 + 300
		
		int[] rowSum = new int[numArr.length];
		int[] colSum = new int[4];
		
		for (int i = 0; i < numArr.length; ++i) {			
			for (int j = 0; j < numArr[i].length; ++j) {				
				rowSum[i] += numArr[i][j];
				colSum[j] += numArr[i][j];				
			}			
		}
		System.out.println("행의 합 : " + Arrays.toString(rowSum));
		System.out.println("열의 합 : " + Arrays.toString(colSum));
	}
	
}
















