package projecteuler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Comparator;

public class Problem22 {
	public static final String path = "files/Problem22.txt";
	
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
				
		Arrays.sort(array, new Comparator<String>(){
			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}	
		});
		
		return array;
	}
	
	public static long score(String[] array, int index) {
		long score = 0;
		
		score = asciiSum(array[index++]) * index;
		
		return score;
	}
	
	public static int asciiSum(String s) {
		int sum = 0;
		
		for(int i=0; i<s.length(); i++) {
			sum += ((int)s.charAt(i) - 96);
		}
		
		return sum;
	}
	
	public static void main(String[] args) {
		String[] array = processData(path);
		
		long sum = 0;
		for(int i=0; i<array.length; i++) {
			sum += score(array, i);
		}
		
		System.out.println(sum);
	}

}
