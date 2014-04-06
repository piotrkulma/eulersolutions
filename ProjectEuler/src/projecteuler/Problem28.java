package projecteuler;

public class Problem28 {
	public static int FINAL = 1001;

	public static int getDiagonalSum(int size) {	
		int sum = 1;
		int localSize = 1;
		int actualNumber = 1;
		
		while(localSize < size) {
			localSize += 2;

			for(int i=0; i<4; i++) {
				actualNumber += (localSize - 1);
				sum += actualNumber;
			}
			
		}
		
		return sum;
	}
	
	public static void main(String[] args) {
		System.out.println(getDiagonalSum(FINAL));		
	}

}
