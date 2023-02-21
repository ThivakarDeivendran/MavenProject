package projectGreen;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.Format;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class SeleniumTSSTest {

	public static void main(String[] args) throws InterruptedException, IOException {
//		//WebDriverManager.firefoxdriver().setup();
//		//WebDriver driver =new FirefoxDriver();
//		
//		WebDriverManager.chromedriver().browserVersion("99").setup();
//		WebDriver driver =new ChromeDriver();
//		
//		//WebDriverManager.edgedriver().setup();
//		//WebDriver driver =new EdgeDriver();
//		driver.get("http://lmstest.pilship.com/opuscntr/SignOn.do?serviceId=LMS");
//		
//		driver.manage().window().maximize();
//		Thread.sleep(5000);
//		driver.close();

		excelpad();
		// notpad();
		// readnotepad();
		// readexcelpad();
		// characterAt();
		// repeatedWords();
		// repeatedWordsWithoutMap();
		// characterrepeatedWords();
		// addArrayValue();
		 //createPropertyFile();
		// readPropertyFile();
		// createXMLFile();
		//readXMLFile();
		//systemProperties();
	}
	
	
	public static void testFile() throws FileNotFoundException {
		File f  = new File("C:\\Users\\thidei\\Desktop\\QaTest.xlsx");
		if(!f.exists()) {
			try {
				f.createNewFile();
			} catch (IOException e) {
			}
		}
		FileOutputStream ffooss = new FileOutputStream(f);
		Workbook frfr = new XSSFWorkbook();
		
	}

	public static void excelpad() throws IOException {
		File file = new File("C:\\Users\\USER\\Desktop\\QATESTING.xlsx");
		if (!file.exists()) {
			file.createNewFile();
		}

		FileOutputStream fos = new FileOutputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Sheet1");
		sheet.createRow(0).createCell(2, CellType.STRING).setCellValue("THIVAKAR");
		workbook.write(fos);
		workbook.close();
		System.out.println("jbfhjdsjkfnkjadjfn");
	}

	public static void notpad() throws IOException {
		File file = new File("C:\\Users\\thidei\\Desktop\\QATESTING.txt");
		if (!file.exists()) {
			file.createNewFile();
		}
		FileOutputStream fos = new FileOutputStream(file);
		fos.write("Im testing engineer".getBytes());
		fos.flush();
		fos.close();
		System.out.println("kmk");
	}

	public static void readnotepad() throws IOException {
		File file = new File("C:\\Users\\thidei\\Desktop\\QATESTING.txt");
		FileInputStream fis = new FileInputStream(file);
		int value = fis.read();
		while (!(value == -1)) {
			char sent = (char) value;
			System.out.println("sent   " + sent);
			value = fis.read();
		}
	}
	
	public static void readexcelpad() throws IOException {
		File file = new File("C:\\Users\\thidei\\Desktop\\QATESTING.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
		String vvvvv = sheet.getRow(0).getCell(0).getStringCellValue();
		 /* XSSFCell cell = sheet.getRow(0).getCell(0);
		DataFormatter d = new DataFormatter();
		 String formatCellValue = d.formatCellValue(cell);
		 */
		fis.close();
		System.out.println(vvvvv);
	}

	public static void createPropertyFile() throws IOException {
		File file = new File("C:\\Users\\user\\Desktop\\QATESTING.properties");
		if (!file.exists()) {
			file.createNewFile();
		}
		FileOutputStream fos = new FileOutputStream(file);
		Properties prop = new Properties();
		prop.setProperty("UserName", "OVTHIDEI");
		prop.setProperty("PassWord", "Thivakar12!@");
		prop.setProperty("LMSTESTURL", "http://lmstest.pilship.com/opuscntr/SignOn.do?serviceId=LMS");
		prop.store(fos, "File upload successfully");
		System.out.println("Properites File");
	}
	
	public static void readPropertyFile() throws IOException {
		File file = new File("C:\\Users\\thidei\\Desktop\\QATESTING.properties");
		FileInputStream fis = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(fis);
		String username = prop.getProperty("UserName");
		String uti = prop.getProperty("LMSTESTURL");
		System.out.println(username);
		System.out.println(uti);
	}

	public static void createXMLFile() throws IOException {
		File file = new File("C:\\Users\\thidei\\Desktop\\QATESTING.xml");
		if (!file.exists()) {
			file.createNewFile();
		}
		FileOutputStream fos = new FileOutputStream(file);
		Properties prop = new Properties();
		prop.setProperty("UserName", "OVTHIDEI");
		prop.setProperty("PassWord", "Thivakar12!@");
		prop.setProperty("LMSTESTURL", "http://lmstest.pilship.com/opuscntr/SignOn.do?serviceId=LMS");
		prop.storeToXML(fos, "file XML FILE");
		System.out.println("XML FILE Successfully");
	}

	public static void readXMLFile() throws IOException {
		File file = new File("C:\\Users\\thidei\\Desktop\\QATESTING.xml");
		FileInputStream fis = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(fis);
		String password = prop.getProperty("PassWord");
		System.out.println(password);
	}

	public static void pdfToConsole() {

		File file = new File("D://Sample.pdf");
		// PDDocument document = PDDocument.load(file);
		// PDFTextStripper pdfStripper = new PDFTextStripper();
		// String text = pdfStripper.getText(document);
		// System.out.println(text);
		// document.close();

	}

	public static void systemProperties() {
		Properties prop = System.getProperties();
		Set<Entry<Object, Object>> entrySet = prop.entrySet();
		Iterator<Entry<Object, Object>> iteratorSet = entrySet.iterator();
		while (iteratorSet.hasNext()) {
			Entry<Object, Object> objectItems = iteratorSet.next();
			Object keyNames = objectItems.getKey();
			Object valuesNames = objectItems.getValue();
			System.out.println(keyNames + "   =   " + valuesNames);
		}
	}
	
	
	
	static void characterAt() {
		String s = "thivakar";
		System.out.println(s.indexOf('Z'));
	}

	static void repeatedWords() {

		String[] words = { "Testing", "Thivakar", "Basketball", "Testing", "Thivakar" };
		Map<String, Integer> wordsMap = new HashMap<String, Integer>();
		for (String stringWords : words) {
			if (wordsMap.containsKey(stringWords)) {
				wordsMap.put(stringWords, wordsMap.get(stringWords) + 1);
			} else {
				wordsMap.put(stringWords, 1);
			}
		}
		System.out.println(wordsMap);
		System.out.println("================Duplicate words================");
		Set<Entry<String, Integer>> entry = wordsMap.entrySet();
		for (Entry<String, Integer> entry2 : entry) {
			if (entry2.getValue() > 1) {
				System.out.print(entry2.getKey());
				System.out.println(entry2.getValue());
			}
		}
	}

	static void repeatedWordsWithoutMap() {
		String[] words = { "Testing", "Thivakar", "Basketball", "Testing", "Thivakar" };
		for (int i = 0; i < words.length; i++) {
			int count = 0;
			int countdup = 0;
			for (int j = 0; j < words.length; j++) {
				if (words[i] == words[j]) {
					count++;
				}
			}
			for (int j = i - 1; j >= 0; j--) {
				if (words[i] == words[j]) {
					countdup++;
				}
			}
			if (countdup == 0) {
				System.out.println(words[i] + "   " + count);
			}
		}
	}

	static void characterrepeatedWords() {

		String sen = "Where there is a will there is a way";
		char[] senchar = sen.toCharArray();
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (char ccc : senchar) {
			if (ccc == ' ') {

			} else if (!map.containsKey(ccc)) {
				map.put(ccc, 1);
			} else {
				map.put(ccc, map.get(ccc) + 1);
			}
		}
		System.out.println(map);

	}

	static void addArrayValue() {
		String sen = "Where there is a will there is a way";
		char[] senchar = sen.toCharArray();
		for (int i = 0; i < senchar.length; i++) {
			if (senchar[i] != ' ') {
				System.out.print(senchar[i]);

			}
		}
	}
}
