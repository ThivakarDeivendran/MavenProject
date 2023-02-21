package projectGreen;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.MavenProjectClass.BaseClass;


public class FileInputStreamClass {

	public static void main(String[] args) throws IOException {
		toCreateExcelFile();toReadExcelFileMethod();
		//toCreateNotepadTextFile();toReadNotepadTextFile();
		//toCreatePropertyFile();toReadPropertyFile();
		//toReadSystemProperties();
		//inputReadExcel();
	}
	public static void toCreateExcelFile() throws IOException {
		File file =new File("C:\\Users\\user\\Desktop\\Test_Data.xlsx");
		if(!file.exists()) {
			file.createNewFile();
		}
			FileOutputStream outputFile = new FileOutputStream(file);
			Workbook workbook = new XSSFWorkbook();
			Sheet worksheet =workbook.createSheet("Testing");
			worksheet.createRow(0).createCell(1).setCellValue("Thivakar_Test_Automation");
			workbook.write(outputFile);
			System.out.println("File Insert Successfully");
			workbook.close();	
	}
	public static void toReadExcelFileMethod() throws IOException {
		File file =new File("C:\\Users\\user\\Desktop\\Test_Data.xlsx");
		FileInputStream InputFile = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(InputFile);
		System.out.println(workbook.getSheet("Testing").getRow(0).getCell(1).getStringCellValue());
		
	}
	public static void toCreateNotepadTextFile() throws IOException{
		File file =new File("C:\\Users\\user\\Desktop\\Test_Data.txt");
		if(!file.exists()) {
			file.createNewFile();
		}
			FileOutputStream outputFile = new FileOutputStream(file);
			outputFile.write("I Miss my Amma very much MalarKodi".getBytes());
			outputFile.flush();
			outputFile.close();
			System.out.println("File successfully created");
	}
	
	public static void toReadNotepadTextFile() throws IOException {
		File file =new File("C:\\Users\\user\\Desktop\\Test_Data.txt");
		FileInputStream inputFile = new FileInputStream(file);
		int num =inputFile.read();
		while(!(num==-1)) {
			char wordText =(char)num;
			System.out.print(wordText);
			num=inputFile.read();
		}
	}
	
	public static void toCreatePropertyFile() throws IOException{
		File file =new File("C:\\Users\\user\\Desktop\\Test_Data.properties");
		if(!file.exists()) {
			file.createNewFile();
		}
		FileOutputStream outputFile = new FileOutputStream(file);
		Properties property = new Properties();
		property.setProperty("UserName", "OVTHIDEI");
		property.setProperty("PassWord", "Thivakar12!@");
		property.setProperty("URLName", "LMSTEST");
		property.setProperty("Values", "123654789");
		property.store(outputFile, "LMSTEST Credentials");
		System.out.println("Properties File Created Successfully");
	}
	
	public static void toReadPropertyFile() throws IOException {
		File file =new File("C:\\Users\\user\\Desktop\\Test_Data.properties");
		FileInputStream inputFile = new FileInputStream(file);
		Properties property = new Properties();
		property.load(inputFile);
		String passwordValue =property.getProperty("PassWord");
		String ipAddress = property.getProperty("Values");
		System.out.println("PassWord   = "  + passwordValue);
		System.out.println("Values    ="+ ipAddress );
	}
	
	public static void toReadSystemProperties() {
		Properties systemProperty = System.getProperties();
		Set<Entry<Object,Object>>entrySet =systemProperty.entrySet();
		Iterator<Entry<Object,Object>>entry =entrySet.iterator();
		while(entry.hasNext()) {
			Entry<Object, Object> next = entry.next();
		Object systemKey =next.getKey();
		Object systemValue = next.getValue();
		System.out.println(systemKey);
		System.out.println(systemValue);
		}
	}
	public static void toReadExcelFile() throws IOException {
		File f = new File("C:\\Users\\user\\Desktop\\TestFile.xlsx");
		FileInputStream fis = new FileInputStream(f);
		XSSFWorkbook wbook = new XSSFWorkbook(fis);
		Cell cellValueType = wbook.getSheetAt(0).getRow(1).getCell(0);
			System.out.println(cellValueType.getStringCellValue());
	}
	static void toReaduserIDExcelFile() throws IOException {
		File excel = new File("C:\\Users\\user\\Desktop\\TestFile.xlsx");
		FileInputStream fis = new FileInputStream(excel);
		XSSFWorkbook UserID = new XSSFWorkbook(fis);
			 XSSFSheet sheetAt = UserID.getSheetAt(0);
			System.out.println(sheetAt.getRow(1).getCell(0).getStringCellValue());
	}
	
	static void toWriteoutputExcelFile() throws IOException{
		File n = new File ("C:\\Users\\user\\Desktop\\test"+System.currentTimeMillis()+".xlsx");
		if(!n.exists()) {
			n.createNewFile();
		}
		FileOutputStream foss =new FileOutputStream(n);
		foss.write("I am testing engineer".getBytes());
		foss.flush();
		foss.close();
	}



}
