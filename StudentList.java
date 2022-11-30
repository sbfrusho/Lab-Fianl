import java.io.*;
import java.text.*;
import java.util.*;
public class StudentList {
	public static String studentName;
	public static Constants constants = new Constants();

	public static void writeFile(String readName){
		try {
			BufferedWriter bufferedWriter = new BufferedWriter(
					new FileWriter(constants.fileName));
			bufferedWriter.flush();
			bufferedWriter.write(readName);
			bufferedWriter.close();
		} catch (Exception e) {}
	}

	public static void readFile(){
		try {
			BufferedReader bufferedReader = new BufferedReader
					(new InputStreamReader
							(new FileInputStream(constants.fileName)));
			studentName = bufferedReader.readLine();
		} catch(Exception e){}
	}
	public static void main(String[] args) {

//		Check arguments
		if(args[0].equals(constants.printList)) {
				System.out.println(constants.loadData);
				readFile();
				String names[] = studentName.split(constants.stringComma);
				for(String n : names) {
					System.out.println(n);
				}

			System.out.println(constants.dataLoad);
		}
		else if(args[0].equals(constants.randomName)) {
			System.out.println(constants.loadData);
			readFile();
			String names[] = studentName.split(constants.stringComma);
			System.out.println(names[new Random().nextInt(names.length)]);
			System.out.println(constants.dataLoad);
		}
		else if(args[0].contains(constants.addName)){
				System.out.println(constants.loadData);
				readFile();
				writeFile(studentName + constants.stringComma + args[0].substring(1) + constants.updateList + new SimpleDateFormat(constants.dateFormat).format(new Date()));
				System.out.println(constants.dataLoad);
			}
		else if(args[0].contains(constants.findName)) {
				System.out.println(constants.loadData);
				readFile();
				String names[] = studentName.split(constants.stringComma);
				String name = args[0].substring(1);
				int idx;
				for(idx = 0; idx<names.length; idx++) {
				if(names[idx].equals(name)) {
					System.out.println(constants.foundName);
					}
				}
				if(idx == names.length){
					System.out.println(name + constants.doesNotFound);
				}
			System.out.println(constants.dataLoad);
		}
		else if(args[0].contains(constants.countWord)) {
				System.out.println(constants.loadData);
				readFile();
				char names[] = studentName.toCharArray();
				int count=1;
				for(char name:names) {
				if(name ==constants.charComma) {
						count++;
				}
			}
			System.out.println(count + constants.wordFound);
			System.out.println(constants.dataLoad);
		}
		else{
			System.out.println(constants.wrongArgument);
		}
	}
}