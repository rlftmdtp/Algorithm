package leetcode.basic;

import java.util.Stack;

public class ValidParentheses {
	public static String list[] = {"(", ")", "[" , "]", "{" , "}"};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		isValid("()");
	}
	
    public static boolean isValid(String s) {
        Stack<String> st = new Stack<>();
        
        for(int i=0; i<s.length(); i++){
            String str = s.charAt(i) + "";
            
            if(st.isEmpty()) st.push(str);
            else {
            	if(str.equals("(") || str.equals("[") || str.equals("{")) st.push(str);
            	else { // ´Ý´Â °ýÈ£ Áß¿¡¼­ 
                	// Â¦ÀÌ ¸Â´Â °ýÈ£°¡ ³ª¿Ã °æ¿ì
                	if(st.peek().equals(getBracket(str))) {
                		st.pop();
                	}else return false;
            	}
            }
        }
        
        if(st.isEmpty()) return true;
        else return false;
    }
    
    public static String getBracket(String str) {
    	String result = "";
    	for(int i=0; i<list.length; i++) {
    		if(list[i].equals(str)) {
    			result = list[i-1];
    			break;
    		}
    	}
    	return result;
    }
    


}
