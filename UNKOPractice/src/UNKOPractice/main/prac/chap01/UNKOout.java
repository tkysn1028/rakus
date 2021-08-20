package UNKOPractice.main.prac.chap01;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class UNKOout {

	public static void main(String[] args) {
		
		Unko un = new Unko();
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		list = un.UnkoExe();
		
		
		XSSFWorkbook workbook =new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("sheet1");
	
		
		for(int i = 0;i<list.size();i++) {
		XSSFRow row = sheet.createRow(i);
		XSSFCell cell = row.createCell(0);
		cell.setCellValue(list.get(i));
		}
		
try {
	
	workbook.write(new FileOutputStream("C:\\Users\\user\\Desktop\\batfile\\output.xlsx"));
	workbook.close();
	
}catch(IOException e) {
	e.printStackTrace();
	
}
	
	
	}

}
