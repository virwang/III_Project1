package testing;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import org.apache.*;
import org.apache.poi.hssf.ServerletOutputStream;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ApacheReadExcel {

	public static void main(String[] args) {
		//建立輸入流
		FileInputStream fis = new FileInputStream(new File("E:\\root\\sheet\\11.xls"));
		//通過建構函式傳參
		HSSFWorkbook workbook = new HSSFWorkbook(fis);
		//獲取工作表
		HSSFSheet sheet = workbook.getSheetAt(0);
		//獲取行,行號作為引數傳遞給getRow方法,第一行從0開始計算
		HSSFRow row = sheet.getRow(0);
		//獲取單元格,row已經確定了行號,列號作為引數傳遞給getCell,第一列從0開始計算
		HSSFCell cell = row.getCell(2);
		//設定單元格的值,即C1的值(第一行,第三列)
		String cellValue = cell.getStringCellValue();
		System.out.println("第一行第三列的值是" cellValue);
		workbook.close();
		fis.close();

	}

}
