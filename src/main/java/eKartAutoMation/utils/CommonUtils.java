package eKartAutoMation.utils;

public class CommonUtils {

//	public static void main(String[] args) {
//		String str = getProperString("santanu");
//		System.out.println(str);
//	}

	public String getProperString(String input) {
		input = input.toLowerCase();
		String output = "";
		for (int i = 0; i <= input.length() - 1; i++) {
			if(i==0) {
				output = output+input.charAt(i);
				output=output.toUpperCase();
				i++;
			}
			output = output+input.charAt(i);
		}

		return output;
	}

}
