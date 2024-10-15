package nogada;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
	//담당자에게 받은 엑셀 파일을 가공 이름/부서/직위/이름/이메일 순으로 들어가있음.
	final public static String sourceFile="D:/1차대상자.xlsx";
	
	//취약점 점검 유형 선택 '1' -> '시나리오_1', '3file' -> '시나리오_3file'
	final public static String malType="1file";
	
	//첨부파일로 만들 파일명
	final public static String atchName="hanacard_20240621.html";
	
	//출력할 폴더 경로
	final public static String optPath="D:/mailing1/";
	
	
	
	public static void main(String[] args) throws IOException {
		ReadExcel excel = new ReadExcel();
		
		// 엑셀파일 확인하여 아랫값들을 입력
		// 시작줄 입력 1이 처음
		int start = 1;
		
		// 마지막 줄 입력 
		int end = 70;
		
	
		mkdir(start,end);
		
		//첨부파일을 생성
		htmlFileWriter(excel.fileRead(sourceFile, start, end),optPath);
		
		//각 csv파일을 생성
		csvFileWriter(excel.fileRead(sourceFile, start, end),optPath);
		
		//txt파일로 전체명단출력--- 첨부파일 없이 본문만 보내는 경우 얘만 사용함
		txtFileWriter(excel.fileRead(sourceFile, start, end), optPath);

	}
	
	private static void csvFileWriter(ArrayList<DataDTO> list, String outputhtml) {
		for(int i = 0 ; i< list.size() ; i++) {
			String eachfolder = outputhtml + ( i + 1);
			File file = new File(eachfolder+"/"+(i+1)+".csv");
		
			// PrintWriter 객체 생성
			PrintWriter writer=null;
			try {
				writer = new PrintWriter(file);
				String receiver = list.get(i).getE();
				//String type ="3file";
				String name = list.get(i).getD();
				
				String contents ="\"receiver_address\",\"name\",\"receiver_address\"\r\n"
						+ receiver+","+name+","+receiver;
			
				writer.print(contents);
			
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} finally {
				if (writer != null) {
					writer.close();
				}
			}
		}
	}

	public static void mkdir(int start, int end) {

    // 1부터 70까지의 폴더 이름 확인 및 생성
    for (int i = start; i <= end; i++) {
        // 폴더 경로 설정
        String folderName = optPath + "\\" + i;
        File folder = new File(folderName);

        // 폴더가 존재하지 않으면 생성
        if (!folder.exists()) {
            if (!folder.mkdirs()) {
                System.out.println("폴더 생성 실패: " + folderName);
            }
        } else {
            System.out.println("폴더가 이미 존재합니다: " + folderName);
        }
    }
	}
	
	public static void htmlFileWriter(ArrayList<DataDTO> list,String outputhtml) {
		
		for(int i = 0 ; i< list.size() ; i++) {
			String eachfolder = outputhtml + ( i + 1);
			File file = new File(eachfolder+"/"+atchName);
		
			// PrintWriter 객체 생성
			PrintWriter writer=null;
			try {
				writer = new PrintWriter(file);
				String receiver = list.get(i).getE();
				//String type ="3file";
				String name = list.get(i).getD();
				// 단순 스크립트 실행으로 주소 유도라 딱히 바꿀 필요없음.
				String contents ="<!DOCTYPE html>\r\n"
						+ "<html lang=\"en\">\r\n"
						+ "<head>\r\n"
						+ "</head>\r\n"
						+ "<body>\r\n"
						+ "<script type=\"text/javascript\">\r\n"
						+ "        window.location.href = \"https://fiis.foodpolis.kr/cmm/survey/mailTraining.do?PAGE_MN_ID=PTL-000000"
						+ "&receiver_address="
						+ receiver
						+ "&type="
						+ malType
						+	"&name="
						+ name
						+ "\";\r\n"
						+ "    </script>\r\n"
						+ "</body>\r\n"
						+ "</html>\r\n"
						+ "";
			
				writer.print(contents);
			
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} finally {
				if (writer != null) {
					writer.close();
				}
			}
		}
		
		
	}
	
  
	
	
	public static void txtFileWriter(ArrayList<DataDTO> list, String output) {
		PrintWriter writer = null;
		try {
			// 파일 경로 지정
			File file = new File(output+"/" + malType + ".csv");

			// PrintWriter 객체 생성
			writer = new PrintWriter(file);
			
			// 파일에 데이터 쓰기
			
			for(int i = 0 ; i< list.size() ; i++) {
				String receiver = list.get(i).getE();
				String name = list.get(i).getD();
				if( i==0 ) {
					writer.print("\"receiver_address\",\"name\",\"receiver_address\"");
				}
				
				writer.print("\n"+receiver+","+name+","+receiver);
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
