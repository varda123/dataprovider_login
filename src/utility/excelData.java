package utility;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
public class excelData {

	private static XSSFSheet ExcelWSheet;

	private static XSSFWorkbook ExcelWBook;

	private static XSSFCell Cell;

	

public static Object[][] getTableArray(String FilePath, String SheetName) throws Exception {   

   String[][] tabArray = null;

   try {

	   FileInputStream ExcelFile = new FileInputStream(FilePath);

	   // Access the required test data sheet

	   ExcelWBook = new XSSFWorkbook(ExcelFile);

	   ExcelWSheet = ExcelWBook.getSheet(SheetName);

	   int startRow = 1;

	   int startCol = 0;

	   int ci,cj;

	   int totalRows = ExcelWSheet.getLastRowNum();
	   System.out.println("total rows are"+totalRows);
	
	   // you can write a function as well to get Column count
	   int totalCols = ExcelWSheet.getRow(0).getLastCellNum();
	System.out.println(totalCols);
	   tabArray=new String[totalRows][totalCols];

	   ci=0;

	   for (int i=startRow;i<=totalRows;i++, ci++) {           	   

		  cj=0;

		   for (int j=startCol;j<totalCols;j++, cj++){

			   tabArray[ci][cj]=getCellData(i,j);

			   //System.out.println("cell data "+tabArray[ci][cj]);  

				}

			}

		}

	catch (FileNotFoundException e){

		System.out.println("Could not read the Excel sheet");

		e.printStackTrace();

		}

	catch (IOException e){

		System.out.println("Could not read the Excel sheet");

		e.printStackTrace();

		}

	return(tabArray);

	}

public static String getCellData(int RowNum, int ColNum) throws Exception {

	try{

	
	/*	int dataType=Cell.getCellType();

		if  (dataType == 3) {

			return "";

		}*///else{
		 DataFormatter formatter = new DataFormatter(); //creating formatter using the default locale
			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);

		 String data = formatter.formatCellValue(Cell);
		//	String CellData = Cell.getStringCellValue();
//System.out.println(data);
			return data;

		//}
	}catch (Exception e){

		System.out.println(e.getMessage());

		throw (e);

		}

	}

}

