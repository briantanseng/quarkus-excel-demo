package com.a98labs.reports;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelService {

    XSSFWorkbook workbook = new XSSFWorkbook();

    Object[][] sampleContent = { { "LastName", "FirstName", "BusinessPhone", "City", "ZipPostal" },
            { "Bedecs", "Anna", "(123)555-0100", "Seattle", 98052 },
            { "Gratacos Solsona", "Antonio", "(123)555-0100", "Boston", 98112 },
            { "Axen", "Thomas", "(123)555-0100", "Los Angeles", 98052 },
            { "Lee", "Christina", "(123)555-0100", "New York", 98052 },
            { "O’Donnell", "Martin", "(123)555-0100", "Minneapolis", 98012 } };

    private void generateContent(String sheetName) {
        XSSFSheet sheet = workbook.createSheet(sheetName);
        int rowNum = 0;
        System.out.println("Generating Excel content");

        for (Object[] content : sampleContent) {
            Row row = sheet.createRow(rowNum++);
            int colNum = 0;
            for (Object field : content) {
                Cell cell = row.createCell(colNum++);
                if (field instanceof String) {
                    cell.setCellValue((String) field);
                } else if (field instanceof Integer) {
                    cell.setCellValue((Integer) field);
                }
            }
        }
    }

    public byte[] toByteArray() {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            generateContent("Sheet 1");
            workbook.write(bos);
            bos.close();
            System.out.println("Retrieving Excel as a Byte array");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bos.toByteArray();
    }
}
