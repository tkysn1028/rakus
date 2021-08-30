package practiice;


/**0だった時は中身を削除するクラス*/
public class DeleteZero{
	
	public StringBuilder MakeNum(StringBuilder sb) {
		
		if(sb.toString().equals("0")) {
			
			sb.replace(0, 1,"");
		}	
		

	return sb;
	
	}
	
	
	
}