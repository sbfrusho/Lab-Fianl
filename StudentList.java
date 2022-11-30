import java.io.*;
import java.text.*;
import java.util.*;
public class StudentList {
	public static String studentName;

	public static void writeFile(String readName){
		try {
			BufferedWriter bufferedWriter = new BufferedWriter(
					new FileWriter("students.txt"));
			bufferedWriter.flush();
			bufferedWriter.write(readName);
			bufferedWriter.close();
		} catch (Exception e) {}
	}

	public static void readFile(){
		try {
			BufferedReader bufferedReader = new BufferedReader
					(new InputStreamReader
							(new FileInputStream("students.txt")));
			studentName = bufferedReader.readLine();
		} catch(Exception e){}
	}
	public static void main(String[] args) {

//		Check arguments
		if(args[0].equals("a")) {
				System.out.println("Loading data ...");
				readFile();
				String names[] = studentName.split(", ");
				for(String n : names) {
					System.out.println(n);
				}

			System.out.println("Data Loaded.");
		}
		else if(args[0].equals("r")) {
			System.out.println("Loading data ...");
			readFile();
			String names[] = studentName.split(", ");
			System.out.println(names[new Random().nextInt(names.length)]);
			System.out.println("Data Loaded.");
		}
		else if(args[0].contains("+")){
				System.out.println("Loading data ...");
				readFile();
				writeFile(studentName + ", " + args[0].substring(1) + "\nlist updated on " + new SimpleDateFormat("dd/mm/yyyy-hh:mm:ss a").format(new Date()));
				System.out.println("Data Loaded.");
			}
		else if(args[0].contains("?")) {
				System.out.println("Loading data ...");
				readFile();
				String names[] = studentName.split(", ");
				boolean done = false;
				String name = args[0].substring(1);
				for(int idx = 0; idx<names.length && !done; idx++) {
				if(names[idx].equals(name)) {
					System.out.println("We found it!");
					done=true;
					}
				}
			System.out.println("Data Loaded.");				
		}
		else if(args[0].contains("c")) {
				System.out.println("Loading data ...");
				readFile();
				char names[] = studentName.toCharArray();
				int count=1;
				for(char name:names) {
				if(name ==',') {
						count++;
				}
			}
			System.out.println(count +" word(s) found ");
			System.out.println("Data Loaded.");				
		}
		else{
			System.out.println("Wrong argument pass!.Please try a,r,c,+ or ?");
		}
	}
}