package projecteuler;

public class Problem21 {	
    public static long d(long n)
    {
    	long sum = 0;
    	for(int i=1; i<n; i++) {
    		if(n % i == 0) {
    			sum += i;
    		}
    	}
    	
    	return sum;
    }
	
	public static void main(String... args) {
		long b;
		long sum = 0;
		
		for(int a=1; a<10000; a++) {
			b = d(a);
			if(d(b) == a && a !=b) {
				sum += a;
			}
		}
		
		System.out.println(sum);
	}
}
