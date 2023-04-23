package nogada;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws IOException {
		ReadExcel excel = new ReadExcel();
		
		//읽을 excel파일를 path에 입력
		String path ="D:/test.xlsx";
	
		// 엑셀파일 확인하여 아랫값들을 입력
		// 시작줄 입력 1이 처음
		int start = 1;
		
		// 마지막 줄 입력 
		int end = 1064;
		
		//출력할 txt파일 경로 입력
		String output ="D:/test.txt";
		//텍스트 파일 출력
		
		txtFileWriter(excel.fileRead(path, start, end), output);

	}

	public static void txtFileWriter(ArrayList<DataDTO> list, String output) {
		PrintWriter writer = null;
		try {
			// 파일 경로 지정
			File file = new File(output);

			// PrintWriter 객체 생성
			writer = new PrintWriter(file);

			// 파일에 데이터 쓰기
			for (DataDTO dataDTO : list) {
				
			
				writer.print(dataDTO.getA());
				writer.print(dataDTO.getB());
				writer.print(dataDTO.getC());
						
				/* 
				// ,나 | 등 구분자가 있는 경우 split 메소드를 활용
				// ex) |를 구분자로 사용중이라면 "\\|" (split메소드는 정규식 사용가능)
				String[] values = dataDTO.getD().split(",");
				for (int i = 0; i < values.length; i++) {
    			writer.println(values[i]);
				} 
				*/
				
				writer.print(dataDTO.getD());
				
				writer.print(dataDTO.getM());
				writer.print(dataDTO.getN());
				writer.print(dataDTO.getO());
				writer.print(dataDTO.getP());
				writer.print(dataDTO.getQ());
				writer.print(dataDTO.getR());
				writer.println(dataDTO.getS());				
			}

			System.out.println("파일 쓰기 완료");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			// PrintWriter 객체 닫기
			if (writer != null) {
				writer.close();
			}
		}
	}
}
