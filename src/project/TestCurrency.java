package project;

public class TestCurrency {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String field = "新台幣                 10.0000元";
		String[] tokens = field.split(" ");
		System.out.println(tokens.length);
		System.out.println(tokens[0]);
		System.out.println(tokens[tokens.length-1]);
		for (int i = 0; i < tokens.length; i++) {
			//System.out.println(tokens[i]);
		}
	}

}
