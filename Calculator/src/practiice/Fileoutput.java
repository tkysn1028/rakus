package practiice;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Fileoutput{
	
	public static void Fileout(List<String> list){
		list.add("----------------変更履歴：下が最新です-------------");
		list.add("-----------消したら履歴は消えます-------------");
		try {
			FileWriter fw = new FileWriter("file.txt");
			
			for(String str : list) {
			fw.write(str);
			fw.write("\n");
			}
			System.out.println("完了");
			
				list.removeAll(list);
				
			
			
			
			fw.close();
			
			
		} catch (IOException e1) {
			// TODO 自動生成された catch ブロック
			e1.printStackTrace();
		}
		
		
			Runtime runtime = Runtime.getRuntime();
			try {
				Process process = runtime.exec("C:\\Windows\\notepad.exe file.txt");
			} catch (IOException e) {
				e.printStackTrace();
			}
		
	}

}
