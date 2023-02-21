package projectGreen;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class JavaJDBCConnectionClass {
	static Statement createStatement;
	static Connection conDatabase;
	static ResultSet queryResults;

	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
//		// loading of JDBC driver
//		Class.forName("oracle.jdbc.driver.OracleDriver");
//		// create instance for connection
//		conDatabase = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "admin");
//		createStatement = conDatabase.createStatement();
//		// selectQueryStatement();
//		insertQueryStatement();
//		createStatement.close();
//		conDatabase.close();
		testing2();
	
		
		//tempMethod(0,"First_Name",0) ;
		//tempMethod(0,"Second_Name",1) ;
		//tempMethod(1,"Thivakar",0) ;
		//tempMethod(1,"Deivendran",1) ;
	}

	public static void selectQueryStatement() throws SQLException {
		String query = "Select  * from Regions";
		queryResults = createStatement.executeQuery(query);
		while (queryResults.next()) {
			System.out.println(queryResults.getInt("REGION_ID") + "      " + queryResults.getString("REGION_NAME"));
		}
	}

	public static void insertQueryStatement() throws SQLException {
		String query = "Insert into Regions values(5, 'India')";
		queryResults = createStatement.executeQuery(query);
		System.out.println("Insert Query successfully");

	}
	
	public static void mySqlDriverDatabase(String userName, String passWord) throws SQLException {
		Connection conDatabase=DriverManager.getConnection("jdbc:mysql://localhost:3306/databaseName",userName,passWord);
		Statement createStatement =conDatabase.createStatement();
	}
	
	
	public static void tempMethod(int row,String value,int cell) throws IOException {
		File f = new File("C:\\Users\\user\\Desktop\\prop.xlsx");
		if (!f.exists()) {
			f.createNewFile();
		}
		FileOutputStream fos = new FileOutputStream(f);
		Workbook book = new XSSFWorkbook();
		Sheet sheetName = book.createSheet("Testing");
		//if(sheetName{
			book.getSheet("Testing");
			sheetName.createRow(row).createCell(cell,CellType.STRING).setCellValue(value);
			book.write(fos);
		//}else {
			Sheet sheetName2 = book.createSheet("Testing");
			sheetName2.createRow(row).createCell(cell,CellType.STRING).setCellValue(value);
			book.write(fos);
		//}
		
		
		System.out.println("tested.....!");
	}
	public static void tempMethod2() throws IOException {
		File f = new File("C:\\Users\\user\\Desktop\\prop.properities");
		FileInputStream fis = new FileInputStream(f);
		Properties property = new Properties();
		property.load(fis);
		String name =property.getProperty("Name");
		String name2 =property.getProperty("Name");
		System.out.println(name +"     "+ name2);
	}	
	
	
	public static void testing() throws SQLException {
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(ClassNotFoundException e) {
			
		}
		Connection conection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","admin");
		Statement statement =conection.createStatement();
		String q = "SELECT * FROM REGIONS";
		ResultSet result=statement.executeQuery(q);
		while(result.next()) {
			System.out.println( result.getInt("REGION_ID"));
			System.out.println(result.getString("REGION_NAME"));
		}
	}

	public static void testing2() throws SQLException {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
		}
		Statement s = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "admin")
				.createStatement();
		ResultSet ss = s.executeQuery("SELECT REGION_NAME FROM REGIONS WHERE REGION_ID =3");
		while (ss.next()) {
			String gg = ss.getString("REGION_NAME");
			System.out.println(gg);
		}
		//s.executeQuery("INSERT INTO REGIONS VALUES(9,'INDIA')");
		System.out.println("Query execure");

	}
}





