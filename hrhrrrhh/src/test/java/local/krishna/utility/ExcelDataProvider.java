package local.krishna.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.swing.plaf.basic.BasicArrowButton;

//import javax.swing.plaf.basic.BasicArrowButton;

//import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	
	XSSFWorkbook wb;
	public ExcelDataProvider() {
		
		
		File file=new File("./TestData/hk_TestData.xlsx");
		try {
			FileInputStream fis=new FileInputStream(file);
			wb=new XSSFWorkbook(fis);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Unable to ready excel file");
		}
	}
	
	public String getStringData(String sheetName, int row, int column) {
              return wb.getSheet(sheetName).getRow(row).getCell(column).getStringCellValue();
	}
	
	public String getStringData(int sheetIndex, int row, int column) {
        return wb.getSheetAt(sheetIndex).getRow(row).getCell(column).getStringCellValue();
}
	
	public double getNumericData(String sheetName, int row, int column) {
		return wb.getSheet(sheetName).getRow(row).getCell(column).getNumericCellValue();
	}
	
	public double getNumericData(int sheetIndex, int row, int column) {
		return wb.getSheetAt(sheetIndex).getRow(row).getCell(column).getNumericCellValue();
	}
	

}
