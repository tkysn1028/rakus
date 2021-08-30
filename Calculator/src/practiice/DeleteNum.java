package practiice;

public class DeleteNum {

	
	public StringBuilder deletenum(StringBuilder sb) {	
		
		
		if(sb.toString().length() == 1) {
			sb.delete(0, 1);
			sb.append("0");
			
		}else {
		
		sb.delete(sb.toString().length() - 1, sb.toString().length());
		}
		return sb;
	
	}
	
	public static void main(String[] args) {
		
		DeleteNum num = new DeleteNum();
		StringBuilder sb = new StringBuilder("4");
		num.deletenum(sb);
		
		System.out.println(sb.toString());
	}
	
	
	
}
