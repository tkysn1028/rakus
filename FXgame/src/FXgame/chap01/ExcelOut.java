package FXgame.chap01;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelOut {
	
	public void ExcelOutExe(String str,String textarea) { 
		try {
			
		XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream("C:/Users/user/Desktop/" + str + ".xlsx"));
		/**C以下の文字列で保存ファイル先*/
		
		XSSFSheet sheet = workbook.getSheetAt(0);
		
		XSSFRow row = sheet.createRow(sheet.getLastRowNum() + 1);
		
		XSSFCell cell = row.createCell(0);
		cell.setCellValue(textarea);
		workbook.write(new FileOutputStream("C:/Users/user/Desktop/" + str + ".xlsx"));
		workbook.close();
		
		System.out.print( "excelファイル" + str + "に書き込み完了しました。。。");
		
		}catch(FileNotFoundException e) {
		System.out.println("ファイルが使用中のため書き込み不可");
		}catch(IOException e) {
		
			XSSFWorkbook workbook = new XSSFWorkbook();
			XSSFSheet sheet = workbook.createSheet("Sheet1");
			XSSFRow row = sheet.createRow(0);
			XSSFCell cell = row.createCell(0);
			cell.setCellValue(textarea);
		
				try {
					workbook.write(new FileOutputStream("C:/Users/user/Desktop/" + str + ".xlsx"));
					workbook.close();
					System.out.print( "excelファイル" + str + "に書き込み完了しました。。。");
					
				}catch(FileNotFoundException exc) {
				System.out.println("ファイルが使用中のため書き込み不可");
				}catch(IOException exc) {
					exc.printStackTrace();			
				}
		}
		}
}	
	
		
		
		
		
		/*try{
			
		/**XSSFWorkbook workbook = new XSSFWorkbook();new FileInputStream("C:/Users/user/Desktop/batfile/" + "output.xlsx"));
		XSSFSheet sheet = workbook.createSheet("Sheet1");
		workbook.write(new FileOutputStream("C:/Users/user/Desktop/batfile/" + str + ".xlsx"));
		System.out.println(sheet.getLastRowNum());
		*/
		/**workbook.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	}

	/**public void ExcelOutExe(String str) {
		System.out.println(str);
	}
}
*/		

		
		
		
		
		
		
		