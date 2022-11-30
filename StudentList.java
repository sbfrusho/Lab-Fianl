import java.io.*;
import java.text.*;
import java.util.*;
public class StudentList {
	public static String studentName;
	public static void main(String[] args) {

//		Check arguments
		if(args[0].equals("a")) {
			System.out.println("Loading data ...");			
			try {
				BufferedReader bufferedReader = new BufferedReader(
						new InputStreamReader(
								new FileInputStream("students.txt")));
				String studentName = bufferedReader.readLine();
				String names[] = studentName.split(", ");
				for(String n : names) {
					System.out.println(n);
				}
			} catch (Exception e){}
			System.out.println("Data Loaded.");
		}
		else if(args[0].equals("r")) {
			System.out.println("Loading data ...");			
			try {
				BufferedReader bufferedReader = new BufferedReader(
						new InputStreamReader(
								new FileInputStream("students.txt")));
				studentName = bufferedReader.readLine();
//				System.out.println(studentName);
				String names[] = studentName.split(", ");
				Random random = new Random();
				int index = random.nextInt();
				System.out.println(names[index]);
			} catch (Exception e){} 
			System.out.println("Data Loaded.");			
		}
		else if(args[0].contains("+")){
			System.out.println("Loading data ...");			
			try {
				BufferedWriter bufferedWriter = new BufferedWriter(
						new FileWriter("students.txt", true));
				studentName = args[0].substring(1);
				Date date = new Date();
	        	String formate = "dd/mm/yyyy-hh:mm:ss a";
	        	DateFormat dateFormat = new SimpleDateFormat(formate);
	        	String formattedDate= dateFormat.format(date);
				bufferedWriter.write(", "+date+"\nList last updated on "+formattedDate);
				bufferedWriter.close();
			} catch (Exception e){}
							
			System.out.println("Data Loaded.");	
		}
		else if(args[0].contains("?")) {
			System.out.println("Loading data ...");			
			try {
				BufferedReader bufferedReader = new BufferedReader(
						new InputStreamReader(
								new FileInputStream("students.txt")));
				studentName = bufferedReader.readLine();
				String names[] = studentName.split(", ");
				boolean done = false;
				String name = args[0].substring(1);
				for(int idx = 0; idx<names.length && !done; idx++) {
				if(names[idx].equals(name)) {
					System.out.println("We found it!");
					done=true;
					}
				}
			} catch (Exception e){} 
			System.out.println("Data Loaded.");				
		}
		else if(args[0].contains("c")) {
			System.out.println("Loading data ...");			
			try {
				BufferedReader bufferedReader = new BufferedReader(
						new InputStreamReader(
								new FileInputStream("students.txt")));
				studentName = bufferedReader.readLine();
				char names[] = studentName.toCharArray();
				int count=1;
				for(char name:names) {
				if(name ==',') {
						count++;
				}
			}
			System.out.println(count +" word(s) found ");
			} catch (Exception e){} 
			System.out.println("Data Loaded.");				
		}
		else{
			System.out.println("Wrong argument pass!.Please try a,r,c,+ or ?");
		}
	}
}