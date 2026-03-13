package marathon;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadValuesFromExcel_SalesForce {

	public static String[][] getValue(String filename) throws IOException {

		// Step1: Settingup the excel file / workBook
		XSSFWorkbook wb = new XSSFWorkbook("./ReadExcel/" + filename + ".xlsx");

		// Step2: to get the sheet from the wb
		XSSFSheet sheet = wb.getSheetAt(0);

		// Step3: to get the row value
		XSSFRow row = sheet.getRow(0);

		// System.out.println(row);

		// getLastRowNum(); - excludes the Header
		int lastRowNum = sheet.getLastRowNum();
		System.out.println(lastRowNum);

		// getPhysicalNumberOfRows(); - includes the header
		int physicalNumberOfRows = sheet.getPhysicalNumberOfRows();
		System.out.println(physicalNumberOfRows);

		// get the cell/column value
		XSSFCell getCell = sheet.getRow(2).getCell(1);
		System.out.println(getCell);

		// to get the cell value along with the header
		int physicalNumberOfCells = sheet.getRow(1).getPhysicalNumberOfCells();
		System.out.println(physicalNumberOfCells);

		// getLastCellNum();
		short lastCellNum = sheet.getRow(2).getLastCellNum();
		System.out.println(lastCellNum);

		// Common integrations
		// count of the cell value/column
		String[][] data = new String[lastRowNum][lastCellNum];

		// Formatter to handle all cell types
		DataFormatter formatter = new DataFormatter();

		for (int i = 1; i <= lastRowNum; i++) {

			for (int j = 0; j < lastCellNum; j++) {

				XSSFCell cell = sheet.getRow(i).getCell(j);

				String value = formatter.formatCellValue(cell);

				System.out.println(value);

				data[i - 1][j] = value;
			}
			wb.close();
		}
		return data;
	}
}
