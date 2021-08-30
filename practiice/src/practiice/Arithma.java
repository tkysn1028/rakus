package practiice;


public class Arithma {

	private Double fstoprnd;
	private Double scdoprnd;
	private String operator = "";
	private Double result;
		
	public Double getFstoprnd() {
		return fstoprnd;
	}
	public void setFstoprnd(Double fstoprnd) {
		this.fstoprnd = fstoprnd;
	}


	public Double getScdoprnd() {
		return scdoprnd;
	}
	public void setScdoprnd(Double scdoprnd) {
		this.scdoprnd = scdoprnd;
	}


	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}


	public Double getResult() {
		return result;
	}
	public void setResult(Double result) {
		this.result = result;
	}


	public double calculate(Double fstoprnd, Double scdoprnd,String operator) {
				
		switch(operator){
		
		case "+":
		result = fstoprnd + scdoprnd;
			break;
		
		case "-":
			result = fstoprnd - scdoprnd;
				break;
			
		case "×":
			result = fstoprnd * scdoprnd;
				break;
			
		case "÷":
			result = fstoprnd / scdoprnd;
			
				break;
	
		}
		
		return result;
		
	}
	
	public void deleteOp() {
		
		this.setFstoprnd(null);
		this.setOperator("");
		this.setScdoprnd(null);
		this.setResult(null);
		
		
	}
	
}
