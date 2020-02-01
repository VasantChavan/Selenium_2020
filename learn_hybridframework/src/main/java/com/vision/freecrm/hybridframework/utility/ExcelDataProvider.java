package com.vision.freecrm.hybridframework.utility;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {

	public XSSFWorkbook workbook;

	// freecrm_login
	public ExcelDataProvider() {
		try {
			FileInputStream fins = new FileInputStream(new File
					(".//TestData//testdata.xlsx"));
			workbook = new XSSFWorkbook(fins);
		} catch (Exception e) {

		}

	}

	public String getStringCellData(int sheetindex, int row, int column) {

		return workbook.getSheetAt(sheetindex).getRow(row).getCell(column)
				.getStringCellValue();
	}

	public String getStringCellData(String sheetname, int row, int column) {

		return workbook.getSheet(sheetname).getRow(row).getCell(column)
				.getStringCellValue();
	}

	public int getNumericCellData(String sheetname, int row, int column) {

		return (int) workbook.getSheet(sheetname).getRow(row)
				.getCell(column).getNumericCellValue();
	}

	public int getNumericCellData(int sheetIndex, int row, int column) {

		return (int) workbook.getSheetAt(sheetIndex).getRow(row)
				.getCell(column).getNumericCellValue();
	}

	public  Object[][] getExcelData(String sheetname) {

		XSSFSheet sheet = workbook.getSheet(sheetname);

		int rows = sheet.getLastRowNum();

		int cols = sheet.getRow(0).getLastCellNum();

		Object[][] data = new Object[rows][cols];

		for (int i = 0; i < rows; i++) {

			for (int j = 0; j < cols; j++) {

				data[i][j] = sheet.getRow(i + 1).getCell(j).toString();
			}
		}

		return data;
	}

	public  Object[][] getExcelData(int sheetindex) {

		XSSFSheet sheet = workbook.getSheetAt(sheetindex);

		int rows = sheet.getLastRowNum();

		int cols = sheet.getRow(0).getLastCellNum();

		Object[][] data = new Object[rows][cols];

		for (int i = 0; i < rows; i++) {

			for (int j = 0; j < cols; j++) {

				data[i][j] = sheet.getRow(i + 1).getCell(j).toString();
			}
		}

		return data;
	}
}
