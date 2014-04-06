package projecteuler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Problem42 {
	public static Integer max;
	public static List<Integer> triangleNumbers = new ArrayList<>();
	public static final String path = "files/Problem42.txt";

	public static String[] processData(String path) {
		String line;
		String text ="";
		String[] array;
		
		try (BufferedReader br = new BufferedReader(new FileReader(new File(path)))) {
			while((line = br.readLine())!=null) {
				text += line;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
		
		text = text.replaceAll("\"", "");
		text = text.toLowerCase();
		array = text.split(",");
		
		return array;
	}
	
	public static int asciiSum(String s) {
		int sum = 0;
		
		for(int i=0; i<s.length(); i++) {
			sum += ((int)s.charAt(i) - 96);
		}
		
		return sum;
	}
	
	public static int getTriangle(int n) {
		return (n * (n + 1)) / 2;
	}
	
	public static void generateTriangleNumber() {
		for(int i=1; i<100; i++) {
			triangleNumbers.add(getTriangle(i));
		}
		
		max = triangleNumbers.get(triangleNumbers.size() - 1);
	}
	
	public static void main(String[] args) {
		int c = 0;
		int asciiSum;
		String[] array = processData(path);
		
		generateTriangleNumber();
		for(String word : array) {
			asciiSum = asciiSum(word);
			
			if(triangleNumbers.contains(asciiSum)) {
				c++;
			}
		}
		
		System.out.println(c);
	}

}
