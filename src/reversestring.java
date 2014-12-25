import java.util.Scanner;

public class reversestring {
	public static void main (String args[]) {

		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);

		String s = in.nextLine();
		final char[] array = s.toCharArray();
		char tmp;
		for(int i=array.length/2; i >= 0; i--) {
			tmp = array[i];
			array[i] = array[array.length-1-i];
			array[array.length-1-i] = tmp;
		}

		// return new String(array);
		System.out.println(array);
	}
}
