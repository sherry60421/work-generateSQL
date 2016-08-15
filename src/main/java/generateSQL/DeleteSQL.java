package generateSQL;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class DeleteSQL {

	private static String TABLENAME = "SM.TBSMB0";
	private static List<String> FIELDSNAME = Arrays.asList("DEPT_SMB0", "CUST_NO_SMB0", "INT_FEQ_SMB0", "MODIFY_DATE_SMB0",
			"MODIFY_ID_SMB0", "SALES_SMB0");
	
	// 各欄位必須為文字!!
	public static void main(String[] args) throws IOException {

		FileReader f = new FileReader("input.txt");
		FileWriter f1 = new FileWriter("output.txt");
		BufferedReader b = new BufferedReader(f);
		BufferedWriter b1 = new BufferedWriter(f1);

		String line;
		while ((line = b.readLine()) != null) {
			String[] values = line.split(",");
			b1.write(processLine(values));
			b1.newLine();
		}
		b.close();
		b1.close();
		System.out.println("完成!");
	}
	
	public static String processLine(String[] values){
		StringBuilder b = new StringBuilder();
		b.append("DELETE FROM ");
		b.append(TABLENAME);
		b.append(" WHERE ");
		for(int i=0; i<FIELDSNAME.size(); i++){
			b.append(FIELDSNAME.get(i));
			b.append("='");
			b.append(values[i]);
			b.append("' AND ");
		}
		b.delete(b.length() - 5, b.length());
		b.append(";");
		return b.toString();
	}
}
