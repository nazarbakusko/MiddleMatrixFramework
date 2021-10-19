package com.eleks.framework.utils;

import jxl.Sheet;
import jxl.Workbook;

import java.io.File;
import java.util.Hashtable;

public class ExcelUtil {

    static Sheet worksheet;
    static Workbook workbook = null;
    static Hashtable dict = new Hashtable();

    //Create a Constructor
    public ExcelUtil() {
        //Initialize
        // workbook = Workbook.getWorkbook(new File(ExcelSheetPath));
        //For Demo purpose the excel sheet path is hardcoded, but not recommended :)
        // worksheet = workbook.getSheet("Sheet1");
        //Call the Column dictionary to store column names
        //ColumnDictionary();
    }

    public static void initializeExcelFile(String ExcelSheetPath, String sheetName) {
        try {
            //Initialize
            workbook = Workbook.getWorkbook(new File(ExcelSheetPath));
        } catch (Exception e) {
            e.getStackTrace();
        }
        //For Demo purpose the excel sheet path is hardcoded, but not recommended :)
        worksheet = workbook.getSheet(sheetName);
        //Call the Column dictionary to store column names
        columnDictionary();
    }

    //Returns the Number of Rows
    public static int rowCount() {
        return worksheet.getRows();
    }

    //Returns the Cell value by taking row and Column values as argument
    private static String readCell(int column, int row) {
        return worksheet.getCell(column, row).getContents();
    }

    //Overloading
    public static String readCell(String columnName, int rowNumber) {
        return readCell(getCell(columnName), rowNumber);
    }

    //Create Column Dictionary to hold all the Column Names
    private static void columnDictionary() {
        //Iterate through all the columns in the Excel sheet and store the value in Hashtable
        for (int col = 0; col < worksheet.getColumns(); col++) {
            dict.put(readCell(col, 0), col);
        }
    }

    //Read Column Names
    private static int getCell(String colName) {
        try {
            int value;
            value = ((Integer) dict.get(colName)).intValue();
            return value;
        } catch (NullPointerException e) {
            return (0);
        }
    }

}
