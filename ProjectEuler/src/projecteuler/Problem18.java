package projecteuler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Problem18 {
	public static final int size = 100;
	public static final String path = "files/Problem18.txt";
	
	public static void processData(String path) {
		try {
			try (BufferedReader br = new BufferedReader(new FileReader(new File(path)))) {	
				
				int temp, max;
				int[] last = new int[size];
				int[] actual = new int[size];
				
				String line;
				String[] array;
	
				for(int i=0; i<actual.length; i++) actual[i] = -1;
				
				int c = 0;
				while((line = br.readLine()) != null) {
					array = line.split(" ");
					
					if(c != 0) {
						for(int i=0; i<c; i++) {
							temp = last[i] + Integer.parseInt(array[i]);
							
							if(temp > actual[i]) {
								actual[i] = temp;
							}
							
							temp = last[i] + Integer.parseInt(array[i + 1]);
							if(temp > actual[i + 1]) {
								actual[i + 1] = temp;
							}
						}
						
						for(int i=0; i<actual.length; i++) {
							last[i] = actual[i];
						}
					} else {
						last[0] = Integer.parseInt(array[0]);
					}					
					c++;
				}
				
				max = -1;
				for(int i=0; i<actual.length; i++) {
					if(actual[i] > max) {
						max = actual[i];
					}
				}
				
				System.out.println(max);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		processData(path);
	}
}
