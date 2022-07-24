package stack;

public class Instruments {
	public static boolean validateDeterminator(Stack<Character> stack) {
		int closed = 0;
		
		while (stack.size() != 0) { 
			if (stack.pop() == ')') {
				++closed;
				continue;
			}
			
			if (closed == 0) return false;
			
			--closed;
		}
		
		if (closed > 0) return false;
		
		return true;
	}
	
	public static Integer calculateExpression(Stack<Character> stack) {
		
		Stack<Character> s2 = new Stack<Character>();
		
		while (stack.size() != 0) {
			
			Character symb = stack.pop();
			int ascii = symb;

			if (ascii >= 48 && ascii <= 57) {
				s2.push(symb);
				continue;
			}

			if (ascii == 42) { //*//
				
				String num1 = "";
				
				s2.pop();
				
				Character num = s2.pop();

				while (num != null && num != ' ') {
					num1 += new String (new char[] {num.charValue()});
					num = s2.pop();
				}
				
				String num2 = "";
				
				num = s2.pop();
				
				while (num != null && num != ' ') {	
					num2 += new String (new char[] {num.charValue()});
					num = s2.pop();
				}

				String result = Integer.parseInt(num1) * Integer.parseInt(num2) + "";
				
				for (int i = 0; i < result.length(); ++i) {
					s2.push(result.charAt(result.length() - 1 - i));
				}
				
				continue;
			}

			if (ascii == 43) { //+//

				String num1 = "";
				
				s2.pop();
				
				Character num = s2.pop();

				while (num != null && num != ' ') {
					num1 += new String (new char[] {num.charValue()});
					num = s2.pop();
				}
				
				String num2 = "";
				
				num = s2.pop();
				
				while (num != null && num != ' ') {	
					num2 += new String (new char[] {num.charValue()});
					num = s2.pop();
				}
				
				String result = Integer.parseInt(num1) + Integer.parseInt(num2) + "";
				
				for (int i = 0; i < result.length(); ++i) {
					s2.push(result.charAt(result.length() - 1 - i));
				}

				continue;
			}
			
			
			
			if (symb == ' ' ) { 
				s2.push(symb);
				continue;
			}
			
			
			if (symb == '=') {
				
				String ready = "";
				
				s2.pop();
				
				Character num = s2.pop();
				while (num != null && num != ' ') {
					ready += num;
					
					num = s2.pop();
					
				}

				return Integer.parseInt(ready);
				
			}
			
		}
		return null;
	}
}
