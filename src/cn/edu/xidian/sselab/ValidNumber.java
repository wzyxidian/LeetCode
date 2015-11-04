package cn.edu.xidian.sselab;
/**
 * title:Valid Number
 * content:
 * Validate if a given string is numeric.
 * Some examples:
 * "0" => true
 * " 0.1 " => true
 * "abc" => false
 * "1 a" => false
 * "2e10" => true
 * Note: It is intended for the problem statement to be ambiguous
 * You should gather all requirements up front before implementing one. 
 */
public class ValidNumber {
	
	//����������Сʱ���뵽��һ����ʵ�����벻��ȥ�ˣ����ڷ���һ��ʼ���ǵ����̫���ˣ�Ӧ��һ��ʼ�����еĿ������ȫ�����ǳ���
	//������Ϊֹ��ȱ�ٵ�����Ͱ���e�����+-����ֵ�������
	@SuppressWarnings("unused")
	public static boolean isNumber(String s){
		int len = s.length();
		if(s == null){
			return false;
		}
	
		int p = 0;
		boolean flag = true;
		boolean flag2 = true;
		int count1 = 0;
		int count2 = 0;
		for(int i=0;i<len;i++){
			if(s.charAt(i) == '.'){
				count1++;
			}
			if(s.charAt(i) == 'e'){
				count2++;
			}
			if(count1 > 1 || count2 > 1){
				return false;
			}
		}
		while(p < len && Character.isWhitespace(s.charAt(p)))
			p++;
		if( p == len){
			return false;
		}
		if(s.charAt(p) == '-' || s.charAt(p) == '+'){
		    p++;
		}
			
		if( p == len){
			return false;
		}else{
			String temp = s.substring(p);
			if(temp.equals(".") || temp.equals("e")){
				return false;
			}
			if(temp.startsWith("e"))
				return false;
			if( temp.startsWith(".e") || temp.contains("e.")){
				return false;
			}
		}
			
		int count = 0;
		for(;p<len;p++){
			
			if(s.charAt(p) == '.' || s.charAt(p) == 'e' || (s.charAt(p) >= '0' && s.charAt(p) <= '9')){
			   
				if(flag2 == false){
					if(s.charAt(p) != '.'){
						flag2 = true;
					}
				}
				if(flag) {
					if(s.endsWith("e")){
						return false;
					}else if(s.charAt(p) == 'e'){
					    if(s.substring(p).contains(".")){
					        return false;
					    }
						flag2 = false;
					}
				}else{
					 return false;
				}
				
				count++;
			}else if(s.charAt(p) == ' ' && p == len-1 && s.charAt(p - 1) != 'e'){
			    
				if(s.contains(".") && count > 1){
					return true;
				}else if(!s.contains(".")){
					return true;
				}else {
					return false;
				}
				
			}else if(s.charAt(p) == ' ' && p != len-1){
				flag = false;
			}else{
				return false;
			}
		}
		if(count == 1 && s.endsWith(".")){
			return false;
		}
		return true;
	}
	
	//�ȽϺõĽ��������
	//���������֮ǰһ��Ҫ���������ۺ�ʲô������������֣���Ȼ��̫ģ��
	//��������������������ʽ����⣬�����������˱���ַ����������ʾ��,���ַ�����ֵ�ý��
	public static boolean isNumbers(String s){
		if(s == null)
			return false;
		boolean numberSeen = false;
		boolean numberAfterESeen = false;
		boolean pointSeen = false;
		boolean eSeen = false;
		
		s = s.trim();
		int len = s.length();
		for(int i=0;i<len;i++){
			char temp = s.charAt(i);
			if(temp>='0'&&temp<='9'){
				numberAfterESeen = true;
				numberSeen = true;
			}else if(temp == '.'){
				if(pointSeen || eSeen){
					return false;
				}
				pointSeen = true;
			}else if(temp == 'e'){
				if(!numberSeen || eSeen){
					return false;
				}
				eSeen = true;
				numberAfterESeen = false;
			}else if(temp == '-' || temp == '+'){
				if(i != 0 || s.charAt(i-1) != 'e'){
					return false;
				}
			}else {
				return false;
			}
		}
		return numberAfterESeen && numberSeen;
	}

}
