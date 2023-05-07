package knight.arkham.shipping.services;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import java.io.FileInputStream;
import java.io.IOException;

@Service
public class ExcelService {

//    Todo no me lee las celdas que utilizan formulas, esto podria ser un problema.
    public void readExcelFile(String filenamePath, String sheetName){
        try {

            var file = new FileInputStream(filenamePath);

            var workbook = new XSSFWorkbook(file);
            var firstSheet = workbook.getSheet(sheetName);

            for (Row nextRow : firstSheet) {

                for (Cell cell : nextRow) {

                    switch (cell.getCellType()) {
                        case STRING:
                            System.out.print(cell.getStringCellValue());
                            break;
                        case NUMERIC:
                            System.out.print(cell.getNumericCellValue());
                            break;
                    }
                    System.out.print(" - ");
                }
                System.out.println();
            }

            workbook.close();
            file.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
