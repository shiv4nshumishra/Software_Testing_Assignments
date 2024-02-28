package utilities;

import java.io.*;
import java.lang.reflect.Method;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class ExcelUtility {
	
	@DataProvider(name = "xlxsDataProvider")
	public String[][] getData(Method m) throws IOException {
		String excelSheetName = m.getName();
		FileInputStream fis = new FileInputStream("D:\\GIT\\A.MLA.T\\SeleniumS2\\S2\\src\\test\\resources\\TestData.xlsx");
        Workbook wb = WorkbookFactory.create(fis);
        Sheet sheetName = wb.getSheet(excelSheetName);
        
        int totalRows = sheetName.getLastRowNum();
        System.out.println(totalRows);
        Row rowCells = sheetName.getRow(0);
        int totalCols = rowCells.getLastCellNum();
        System.out.println(totalCols);
        
        DataFormatter format = new DataFormatter();
        
        String testData[][] = new String[totalRows][totalCols];
        for(int i=1; i<=totalRows; i++) {
        	for(int j=0; j<totalCols; j++) {
        		testData[i-1][j] = format.formatCellValue(sheetName.getRow(i).getCell(j));
        		System.out.println(testData[i-1][j]);
        	}
        }
        return testData;
	}
}