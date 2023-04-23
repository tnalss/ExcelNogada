package nogada;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public ArrayList<DataDTO> fileRead(String path, int start, int end) throws IOException {
		// 파일 스트림 생성
		FileInputStream fis = new FileInputStream(new File(path));

		// Workbook 생성
		Workbook workbook = new XSSFWorkbook(fis);

		// 첫번째 시트 얻기
		Sheet sheet = workbook.getSheetAt(0);

		ArrayList<DataDTO> list = new ArrayList<DataDTO>();

		for (int rowIndex = start-1 ; rowIndex < end ; rowIndex++ ) {
			Row row = sheet.getRow(rowIndex);
			if (row == null) {
				break;
			}

			// Cell Type에 따른 데이터 얻기
			list.add(new DataDTO(row));

		}

		// 파일 스트림 닫기
		workbook.close();
		fis.close();

		return list;
	}
}
