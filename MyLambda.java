

import java.util.Arrays;

public class MyLambda {
	public static void main(String[] args) {
		String[] words = {"yyy","ccc","a","ab"};
		Arrays.sort(words, (first,second)->first.length()-second.length());
		for (String s : words) {
			System.out.println(s);
		}
	}
}
