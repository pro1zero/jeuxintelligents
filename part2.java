/**
 * The part2 class is the main class which contains a number of different methods including the main  method.
 * All the variables are static as they are more versatile and used all over the program using just 1 copy of the variable.
 * Just the file input/output and the util package have been used for i/o and data storing purposes.
 * 
 * @author Jenish Soni (40132415)
 * @version 1.0
 * @since 24th October, 2020
 */

import java.io.*;
import java.util.*;
public class part2 {
	static Scanner scan = null;
	static String filename = "";
	static int successful = 0;
	static int pivot = 0;

	
	// here, efficiency is taken into consideration. If the file, is invalid, it won't be accessed again.
	/**
	 * 
	 * @param args - the necessary string type array to be passes as a parameter for the command line arguments.
	 * @return - returns nothing as the return type is void. 
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		System.out.println("Welcome to BibCreator!\n");
		boolean noFilesMissing = checkForFiles();
		if(!noFilesMissing) {
			System.out.println("\nCould not open input file Latex" + (pivot+1) + ".bib for reading.\nPlease check if file exists! Program will terminate after closing any opened files.");
			
			for(int i = pivot; i > 0; i--) {
				try {
					File file = new File("C:\\Users\\jenis\\Desktop\\Files\\IEEE" + i + ".json");
					file.delete();
					file = new File("C:\\Users\\jenis\\Desktop\\Files\\ACN" + i + ".json");
					file.delete();
					file = new File("C:\\Users\\jenis\\Desktop\\Files\\NJ" + i + ".json");
					file.delete();
				}catch(Exception e) {System.out.println(e);}
			}
			System.out.println("Program terminating now.");
			return;
		}
		for(int i = 1; i <= 10; i++) {
			String file = "C:\\Users\\jenis\\eclipse-workspace\\assign2\\src\\assign2\\Files\\Latex" + i +".bib";
			if(processFilesForValidation(file, i)) {
				createACN(file, i);
				createIEEE(file, i);
				continue;
			}
			File fileToDelete = new File("C:\\Users\\jenis\\Desktop\\Files\\IEEE" + i + ".json");
			fileToDelete.delete();
			fileToDelete = new File("C:\\Users\\jenis\\Desktop\\Files\\ACN" + i + ".json");
			fileToDelete.delete();
			fileToDelete = new File("C:\\Users\\jenis\\Desktop\\Files\\NJ" + i + ".json");
			fileToDelete.delete();
		}         
		System.out.println("A total of " + (10 - successful) + " files were invalid, and could not be processed. All other 'VALID'" + successful + " files have been created.\n");
		System.out.print("Please enter the name of one of the files that you need to review: ");
		openFile(false);
		System.out.println("Hope you give me good marks! :)");
	}
	
	//returns true if there are no files missing in the given folder else returns false.`
	public static boolean checkForFiles() {
		Scanner scan = null;
		for(int i = 1; i <= 10; i++) {
			pivot = i-1;
			String filename = "C:\\Users\\jenis\\eclipse-workspace\\assign2\\src\\assign2\\Files\\Latex" + i +".bib";
			try{
				scan = new Scanner(new FileReader(filename));
				String location = "C:\\Users\\jenis\\Desktop\\Files\\" + "IEEE" + i + ".json";
				createFiles(location);
				location = "C:\\Users\\jenis\\Desktop\\Files\\" + "ACN" + i + ".json";
				createFiles(location);
				location = "C:\\Users\\jenis\\Desktop\\Files\\" + "NJ" + i + ".json";
				createFiles(location);
			}catch(Exception e) {
				return false;
			}
		}
		scan.close();
		return true;
	}
	
	public static void createFiles(String file) {
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(new FileOutputStream(file));
		}catch(Exception e) {
			System.out.println(e);
		}
		pw.close();
	}
	
	/**
	 * 
	 * @param flag - states if the user has entered invalid file name. 
	 */
	public static void openFile(boolean flag) {
		Scanner temp = new Scanner(System.in);
		String fileToOpen = temp.nextLine();
		try {
			File file = new File("C:\\Users\\jenis\\Desktop\\Files\\" + fileToOpen);
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line;
			while((line = br.readLine()) != null) {
				System.out.println(line);
			}
			br.close();
		}catch(Exception e) {
			if(!flag) {
				flag = true;
				System.out.print("Last Chance! Enter a filename to show its contents: ");
				openFile(true);
				temp.close();
				return;
			}
			if(flag) {
				System.out.println("Sorry, I was unable to find the file you mentioned. Program will terminate now.");
			}
		}
		temp.close();
	}
	
	/**
	 * 
	 * @param file - file is the file name and the exact location of the input file to be accessed. 
	 * @param i - i is the # Latex file number. 
	 * @return - returns a boolean value indicating if the file is valid and good for the other functions to gather information. 
	 */
	public static boolean processFilesForValidation(String file, int i) {
		try {
			scan = new Scanner(new FileInputStream(file));
		}catch(Exception e) {
			System.out.println("Could not open input file Latex" + i + ".bib for reading.\n\n Please check if file exists! \n\nProgram will terminate after closing any opened files.");
		}
		List<List<String>> articles = new ArrayList<>();
		List<String> article = new ArrayList<>();
		while(scan.hasNextLine()){
			String s = scan.nextLine().strip();
			if(s.isEmpty()) continue; 
			article.add(s.strip());
			if(s.strip().equals("@ARTICLE{")) {
				article.remove(article.size() - 1);
				if(article.size() > 0) article.remove(article.size() - 1);
				articles.add(article);
				article = new ArrayList<>();
			}
		}
		articles.remove(0);
		articles.add(article);
		List<String> resultNJ = new ArrayList<>();
		for(List<String> arctic: articles) {
			String firstBadField = "";
			Map<String, String> map = new HashMap<>();
			boolean[] flags = new boolean[11];
			for(String s: arctic) {
				try {
					if(s.isEmpty()) continue;
					boolean match = false;
					if(s.length() > 6 && s.substring(0, 6).equals("author")) {
						flags[0] = true;
						match = true;
						String key = "";
						boolean start = false;
						for(char c: s.toCharArray()) {
							if(c == '=') {
								start = true;
								continue;
							}
							if(start) {
								if(c == ',' || c == '{' || c == '}') continue;
								key += c;
							}
						}
						if(key.replace("and", "&").strip().isEmpty()) {
							flags[0] = false;
							firstBadField = "author";
							break;
						}
						map.put("author", key.replace("and", "&").strip());
						if(match) {
							match = false;
							continue;
						}
					}
					if(s.length() > 5 && s.substring(0, 5).equals("title")) {
						flags[1] = true;
						match = true;
						String key = "";
						boolean start = false;
						for(char c: s.toCharArray()) {
							if(c == '=') {
								start = true;
								continue;
							}
							if(start) {
								if(c == ',' || c == '{' || c == '}') continue;
								key += c;
							}
						}
						if(key.strip().isEmpty()) {
							flags[1] = false;
							firstBadField = "title";
							break;
						}
						map.put("title", key.strip());
						if(match) {
							match = false;
							continue;
						}
					}
					if(s.length() > 7 && s.substring(0, 7).equals("journal")) {
						flags[2] = true;
						match = true;
						String key = "";
						boolean start = false;
						for(char c: s.toCharArray()) {
							if(c == '=') {
								start = true;
								continue;
							}
							if(start) {
								if(c == ',' || c == '{' || c == '}') continue;
								key += c;
							}
						}
						if(key.strip().isEmpty()) {
							flags[2] = false;
							firstBadField = "journal";
							break;
						}
						map.put("journal", key.strip());
						if(match) {
							match = false;
							continue;
						}
					}
					if(s.length() > 6 && s.substring(0, 6).equals("volume")) {
						flags[3] = true;
						match = true;
						String key = "";
						boolean start = false;
						for(char c: s.toCharArray()) {
							if(c == '=') {
								start = true;
								continue;
							}
							if(start) {
								if(c == ',' || c == '{' || c == '}') continue;
								key += c;
							}
						}
						if(key.strip().isEmpty()) {
							flags[3] = false;
							firstBadField = "volume";
							break;
						}
						map.put("volume", key.strip());
						if(match) {
							match = false;
							continue;
						}
					}
					
					if(s.length() > 5 && s.substring(0, 5).equals("pages")) {
						flags[4] = true;
						match = true;
						String key = "";
						boolean start = false;
						for(char c: s.toCharArray()) {
							if(c == '=') {
								start = true;
								continue;
							}
							if(start) {
								if(c == ',' || c == '{' || c == '}') continue;
								key += c;
							}
						}
						if(key.strip().isEmpty()) {
							flags[4] = false;
							firstBadField = "pages";
							break;
						}
						map.put("pages", key.strip());
						if(match) {
							match = false;
							continue;
						}
					}
					if(s.length() > 4 && s.substring(0, 4).equals("year")) {
						flags[5] = true;
						String key = "";
						boolean start = false;
						for(char c: s.toCharArray()) {
							if(c == '=') {
								start = true;
								continue;
							}
							if(start) {
								if(c == ',' || c == '{' || c == '}') continue;
								key += c;
							}
						}
						if(key.strip().isEmpty()) {
							flags[5] = false;
							firstBadField = "year";
							break;
						}
						map.put("year", key.strip());
						if(match) {
							match = false;
						}
					}
					if(s.length() > 5 && s.substring(0, 5).equals("month")) {
						match = true;
						flags[6] = true;
						String key = "";
						boolean start = false;
						for(char c: s.toCharArray()) {
							if(c == '=') {
								start = true;
								continue;
							}
							if(start) {
								if(c == ',' || c == '{' || c == '}') continue;
								key += c;
							}
						}
						if(key.strip().isEmpty()) {
							flags[6] = false;
							firstBadField = "month";
							break;
						}
						map.put("month", key.strip());
						if(match) {
							match = false;
							continue;
						}
					}
					if(s.length() > 4 && s.substring(0, 4).equals("year")) {
						String key = "";
						flags[7] = true;
						boolean start = false;
						for(char c: s.toCharArray()) {
							if(c == '=') {
								start = true;
								continue;
							}
							if(start) {
								if(c == ',' || c == '{' || c == '}') continue;
								key += c;
							}
						}
						if(key.strip().isEmpty()) {
							flags[7] = false;
							firstBadField = "year";
							break;
						}
						map.put("year", key.strip());
						if(match) {
							match = false;
						}
					}
					if(s.length() > 8 && s.substring(0, 8).equals("keywords")) {
						String key = "";
						flags[8] = true;
						boolean start = false;
						for(char c: s.toCharArray()) {
							if(c == '=') {
								start = true;
								continue;
							}
							if(start) {
								if(c == ',' || c == '{' || c == '}') continue;
								key += c;
							}
						}
						if(key.strip().isEmpty()) {
							flags[8] = false;
							firstBadField = "keywords";
							break;
						}
					}
					if(s.length() > 3 && s.substring(0, 3).equals("doi")) {
						String key = "";
						flags[9] = true;
						boolean start = false;
						for(char c: s.toCharArray()) {
							if(c == '=') {
								start = true;
								continue;
							}
							if(start) {
								if(c == ',' || c == '{' || c == '}') continue;
								key += c;
							}
						}
						if(key.strip().isEmpty()) {
							flags[9] = false;
							firstBadField = "doi";
							break;
						}
					}
					if(s.length() > 4 && s.substring(0, 4).equals("ISSN")) {
						String key = "";
						flags[10] = true;
						boolean start = false;
						for(char c: s.toCharArray()) {
							if(c == '=') {
								start = true;
								continue;
							}
							if(start) {
								if(c == ',' || c == '{' || c == '}') continue;
								key += c;
							}
						}
						if(key.strip().isEmpty()) {
							flags[10] = false;
							firstBadField = "ISSN";
							break;
						}
					}
				}catch(Exception e) {
					System.out.println(e);
				}
			}
			
			// This is infact the meat of the logic where, if any value of the flags array is false, it indicates that the file is missing some information. 
			if(!(flags[0] && flags[1] && flags[2] && flags[3] && flags[4] && flags[5] && flags[6] && flags[7] && flags[8] && flags[9] && flags[10])) {
				System.out.println("Error: Detected Empty Field!");
				System.out.println("============================\n");
				System.out.println("Problem detected with input file Latex" + i + ".bib");
				System.out.println("File is Invalid: Field '" + firstBadField + "' is Empty. Processing stopped a this point. Other empty fields may be present as well.\n");
				try {
					@SuppressWarnings("unused")
					FileInvalidException fie = new FileInvalidException("NJ", i);
				}catch(Exception e) {}
				return false;
			}
			String a = map.get("author");
			
			String temp = a + ". " + (map.get("title")) + ". " + (map.get("journal")) + ". "  + (map.get("volume")) + ", "+ (map.get("pages")) + "(" + (map.get("year")) + ").";
						resultNJ.add(temp);
		}
		String location = "C:\\Users\\jenis\\Desktop\\Files\\" + "NJ" + i + ".json";
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(new FileOutputStream(location));
			for(String s: resultNJ) {
				pw.println(s + "\n");
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		pw.close();
		scan.close();
		return true;
	}
	
	/**
	 * 
	 * @param file - file is the name of the file which is to be scanned and information is to be stored.
	 * @param i - i is the #Latex file number. 
	 */
	public static void createACN(String file, int i) {
		successful += 1;
		try {
			scan = new Scanner(new FileInputStream(file));
		}catch(Exception e) {
			System.out.println("Could not open input file Latex" + i + ".bib for reading. Please check if file exists! Program will terminate after closing any opened files");
		}
		List<List<String>> articles = new ArrayList<>();
		List<String> article = new ArrayList<>();
		while(scan.hasNextLine()){
			String s = scan.nextLine().strip();
			if(s.isEmpty()) continue; 
			article.add(s.strip());
			if(s.strip().equals("@ARTICLE{")) {
				article.remove(article.size() - 1);
				if(article.size() > 0) article.remove(article.size() - 1);
				articles.add(article);
				article = new ArrayList<>();
			}
		}
		articles.remove(0);
		articles.add(article);
		List<String> resultACN = new ArrayList<>();
		int j = 1;
		for(List<String> artic: articles) {
			Map<String, String> map = new HashMap<>();
			boolean[] flags = new boolean[11];
			for(String s: artic) {
				try {
					if(s.isEmpty()) continue;
					boolean match = false;
					if(s.length() > 6 && s.substring(0, 6).equals("author")) {
						flags[0] = true;
						match = true;
						String key = "";
						boolean start = false;
						for(char c: s.toCharArray()) {
							if(c == '=') {
								start = true;
								continue;
							}
							if(start) {
								if(c == ',' || c == '{' || c == '}') continue;
								key += c;
							}
						}
						if(key.replace(" and", ",").strip().isEmpty()) {
							flags[0] = false;
							break;
						}
						map.put("author", key.replace(" and", ",").strip());
						if(match) {
							match = false;
							continue;
						}
					}
					if(s.length() > 5 && s.substring(0, 5).equals("title")) {
						flags[1] = true;
						match = true;
						String key = "";
						boolean start = false;
						for(char c: s.toCharArray()) {
							if(c == '=') {
								start = true;
								continue;
							}
							if(start) {
								if(c == ',' || c == '{' || c == '}') continue;
								key += c;
							}
						}
						if(key.strip().isEmpty()) {
							flags[1] = false;
							break;
						}
						map.put("title", key.strip());
						if(match) {
							match = false;
							continue;
						}
					}
					if(s.length() > 7 && s.substring(0, 7).equals("journal")) {
						flags[2] = true;
						match = true;
						String key = "";
						boolean start = false;
						for(char c: s.toCharArray()) {
							if(c == '=') {
								start = true;
								continue;
							}
							if(start) {
								if(c == ',' || c == '{' || c == '}') continue;
								key += c;
							}
						}
						if(key.strip().isEmpty()) {
							flags[2] = false;
							break;
						}
						map.put("journal", key.strip());
						if(match) {
							match = false;
							continue;
						}
					}
					if(s.length() > 6 && s.substring(0, 6).equals("volume")) {
						flags[3] = true;
						match = true;
						String key = "";
						boolean start = false;
						for(char c: s.toCharArray()) {
							if(c == '=') {
								start = true;
								continue;
							}
							if(start) {
								if(c == ',' || c == '{' || c == '}') continue;
								key += c;
							}
						}
						if(key.strip().isEmpty()) {
							flags[3] = false;
							break;
						}
						map.put("volume", key.strip());
						if(match) {
							match = false;
							continue;
						}
					}
					if(s.length() > 6 && s.substring(0, 6).equals("number")) {
						flags[4] = true;
						match = true;
						String key = "";
						boolean start = false;
						for(char c: s.toCharArray()) {
							if(c == '=') {
								start = true;
								continue;
							}
							if(start) {
								if(c == ',' || c == '{' || c == '}') continue;
								key += c;
							}
						}
						if(key.strip().isEmpty()) {
							flags[4] = false;
							break;
						}
						map.put("number", key.strip());
						if(match) {
							match = false;
							continue;
						}
					}
					if(s.length() > 5 && s.substring(0, 5).equals("pages")) {
						flags[5] = true;
						match = true;
						String key = "";
						boolean start = false;
						for(char c: s.toCharArray()) {
							if(c == '=') {
								start = true;
								continue;
							}
							if(start) {
								if(c == ',' || c == '{' || c == '}') continue;
								key += c;
							}
						}
						if(key.strip().isEmpty()) {
							flags[5] = false;
							break;
						}
						map.put("pages", key.strip());
						if(match) {
							match = false;
							continue;
						}
					}
					if(s.length() > 5 && s.substring(0, 5).equals("month")) {
						flags[6] = true;
						match = true;
						String key = "";
						boolean start = false;
						for(char c: s.toCharArray()) {
							if(c == '=') {
								start = true;
								continue;
							}
							if(start) {
								if(c == ',' || c == '{' || c == '}') continue;
								key += c;
							}
						}
						if(key.strip().isEmpty()) {
							flags[6] = false;
							break;
						}
						map.put("month", key.strip());
						if(match) {
							match = false;
							continue;
						}
					}
					if(s.length() > 4 && s.substring(0, 4).equals("year")) {
						flags[7] = true;
						String key = "";
						boolean start = false;
						for(char c: s.toCharArray()) {
							if(c == '=') {
								start = true;
								continue;
							}
							if(start) {
								if(c == ',' || c == '{' || c == '}') continue;
								key += c;
							}
						}
						if(key.strip().isEmpty()) {
							flags[7] = false;
							break;
						}
						map.put("year", key.strip());
						if(match) {
							match = false;
						}
					}
					if(s.length() > 3 && s.substring(0, 3).equals("doi")) {
						flags[8] = true;
						String key = "";
						boolean start = false;
						for(char c: s.toCharArray()) {
							if(c == '=') {
								start = true;
								continue;
							}
							if(start) {
								if(c == ',' || c == '{' || c == '}') continue;
								key += c;
							}
						}
						if(key.strip().isEmpty()) {
							flags[8] = false;
							break;
						}
						map.put("doi", key.strip());
						if(match) {
							match = false;
						}
					}
					if(s.length() > 8 && s.substring(0, 8).equals("keywords")) {
						String key = "";
						flags[9] = true;
						boolean start = false;
						for(char c: s.toCharArray()) {
							if(c == '=') {
								start = true;
								continue;
							}
							if(start) {
								if(c == ',' || c == '{' || c == '}') continue;
								key += c;
							}
						}
						if(key.strip().isEmpty()) {
							flags[9] = false;
							break;
						}
					}
					if(s.length() > 4 && s.substring(0, 4).equals("ISSN")) {
						String key = "";
						flags[10] = true;
						boolean start = false;
						for(char c: s.toCharArray()) {
							if(c == '=') {
								start = true;
								continue;
							}
							if(start) {
								if(c == ',' || c == '{' || c == '}') continue;
								key += c;
							}
						}
						if(key.strip().isEmpty()) {
							flags[10] = false;
							break;
						}
					}
				}catch(Exception e) {
					System.out.println(e);
				}
			}
			if(!(flags[0] && flags[1] && flags[2] && flags[3] && flags[4] && flags[5] && flags[6] && flags[7] && flags[8] && flags[9] && flags[10])) {
				try {
					@SuppressWarnings("unused")
					FileInvalidException fie = new FileInvalidException("ACN", i);
				}catch(Exception e) {System.out.println(e);}
				
				return;
			}
			String a = map.get("author");
			boolean moreThanOne = false;
			String newA = "";
			if(a.contains(",")) {
				moreThanOne = true;
				int index = 0;
				while(index < a.length() && a.charAt(index) != ',') {
					newA += a.charAt(index++);
				}
			}
			if(!moreThanOne) newA = a; 
			String suffix = moreThanOne ? "et al." : "";
			String temp = "[" + j + "]\t" + newA + " " + suffix + " " + (map.get("year")) + ". " + (map.get("title")) + '.' + " " + (map.get("journal")) + ". " + (map.get("volume")) + ", " + (map.get("number")) + " (" + (map.get("year")) + "), " + (map.get("pages")) + ". DOI:https://doi.org/" + (map.get("doi")) + ".\n";
						resultACN.add(temp);
			j += 1;
		}
		String location = "C:\\Users\\jenis\\Desktop\\Files\\" + "ACN" + i + ".json";
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(new FileOutputStream(location));
			for(String s: resultACN) {
				pw.println(s);
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		pw.close();
		scan.close();
	}
	
	/**
	 * 
	 * @param file - file is the name of the file which is to be scanned and information is to be stored.
	 * @param i - i is the #Latex file number. 
	 */
	public static void createIEEE(String file, int i) throws Exception { 
		try {
			scan = new Scanner(new FileInputStream(file));
		}catch(Exception e) {
			System.out.println("Could not open input file Latex" + i + ".bib for reading. Please check if file exists! Program will terminate after closing any opened files");
		}
		List<List<String>> articles = new ArrayList<>();
		List<String> article = new ArrayList<>();
		while(scan.hasNextLine()){
			String s = scan.nextLine().strip();
			if(s.isEmpty()) continue; 
			article.add(s.strip());
			if(s.strip().equals("@ARTICLE{")) {
				article.remove(article.size() - 1);
				if(article.size() > 0) article.remove(article.size() - 1);
				articles.add(article);
				article = new ArrayList<>();
			}
		}
		articles.remove(0);
		articles.add(article);
		List<String> resultIEEE = new ArrayList<>();
		for(List<String> artic: articles) {
			Map<String, String> map = new HashMap<>();
			boolean[] flags = new boolean[11];
			for(String s: artic) {
				try {
					if(s.isEmpty()) continue;
					boolean match = false;
					if(s.length() > 6 && s.substring(0, 6).equals("author")) {	
						match = true;
						flags[0] = true;
						String key = "";
						boolean start = false;
						for(char c: s.toCharArray()) {
							if(c == '=') {
								start = true;
								continue;
							}
							if(start) {
								if(c == ',' || c == '{' || c == '}') continue;
								key += c;
							}
						}
						if(key.replace("and", ",").strip().isEmpty()) {
							flags[0] = false;
							break;
						}
						map.put("author", key.replace("and", ",").strip());
						if(match) {
							match = false;
							continue;
						}
					}
					if(s.length() > 5 && s.substring(0, 5).equals("title")) {
						match = true;
						flags[1] = true;
						String key = "";
						boolean start = false;
						for(char c: s.toCharArray()) {
							if(c == '=') {
								start = true;
								continue;
							}
							if(start) {
								if(c == ',' || c == '{' || c == '}') continue;
								key += c;
							}
						}
						
						if(key.strip().isEmpty()) {
							flags[1] = false;
							break;
						}
						map.put("title", key.strip());
						if(match) {
							match = false;
							continue;
						}
					}
					if(s.length() > 7 && s.substring(0, 7).equals("journal")) {
						match = true;
						flags[2] = true;
						String key = "";
						boolean start = false;
						for(char c: s.toCharArray()) {
							if(c == '=') {
								start = true;
								continue;
							}
							if(start) {
								if(c == ',' || c == '{' || c == '}') continue;
								key += c;
							}
						}
						if(key.strip().isEmpty()) {
							flags[2] = false;
							break;
						}
						map.put("journal", key.strip());
						if(match) {
							match = false;
							continue;
						}
					}
					if(s.length() > 6 && s.substring(0, 6).equals("volume")) {
						match = true;
						flags[3] = true;
						String key = "";
						boolean start = false;
						for(char c: s.toCharArray()) {
							if(c == '=') {
								start = true;
								continue;
							}
							if(start) {
								if(c == ',' || c == '{' || c == '}') continue;
								key += c;
							}
						}
						if(key.strip().isEmpty()) {
							flags[3] = false;
							break;
						}
						map.put("volume", key.strip());
						if(match) {
							match = false;
							continue;
						}
					}
					if(s.length() > 6 && s.substring(0, 6).equals("number")) {
						match = true;
						flags[4] = true;
						String key = "";
						boolean start = false;
						for(char c: s.toCharArray()) {
							if(c == '=') {
								start = true;
								continue;
							}
							if(start) {
								if(c == ',' || c == '{' || c == '}') continue;
								key += c;
							}
						}
						if(key.strip().isEmpty()) {
							flags[4] = false;
							break;
						}
						map.put("number", key.strip());
						if(match) {
							match = false;
							continue;
						}
					}
					if(s.length() > 5 && s.substring(0, 5).equals("pages")) {
						match = true;
						flags[5] = true;
						String key = "";
						boolean start = false;
						for(char c: s.toCharArray()) {
							if(c == '=') {
								start = true;
								continue;
							}
							if(start) {
								if(c == ',' || c == '{' || c == '}') continue;
								key += c;
							}
						}
						if(key.strip().isEmpty()) {
							flags[5] = false;
							break;
						}
						map.put("pages", key.strip());
						if(match) {
							match = false;
							continue;
						}
					}
					if(s.length() > 5 && s.substring(0, 5).equals("month")) {
						match = true;
						flags[6] = true;
						String key = "";
						boolean start = false;
						for(char c: s.toCharArray()) {
							if(c == '=') {
								start = true;
								continue;
							}
							if(start) {
								if(c == ',' || c == '{' || c == '}') continue;
								key += c;
							}
						}
						if(key.strip().isEmpty()) {
							flags[6] = false;
							break;
						}
						map.put("month", key.strip());
						if(match) {
							match = false;
							continue;
						}
					}
					if(s.length() > 4 && s.substring(0, 4).equals("year")) {
						String key = "";
						flags[7] = true;
						boolean start = false;
						for(char c: s.toCharArray()) {
							if(c == '=') {
								start = true;
								continue;
							}
							if(start) {
								if(c == ',' || c == '{' || c == '}') continue;
								key += c;
							}
						}
						if(key.strip().isEmpty()) {
							flags[7] = false;
							break;
						}
						map.put("year", key.strip());
						if(match) {
							match = false;
						}
					}
					if(s.length() > 8 && s.substring(0, 8).equals("keywords")) {
						String key = "";
						flags[8] = true;
						boolean start = false;
						for(char c: s.toCharArray()) {
							if(c == '=') {
								start = true;
								continue;
							}
							if(start) {
								if(c == ',' || c == '{' || c == '}') continue;
								key += c;
							}
						}
						if(key.strip().isEmpty()) {
							flags[8] = false;
							break;
						}
					}
					if(s.length() > 3 && s.substring(0, 3).equals("doi")) {
						String key = "";
						flags[9] = true;
						boolean start = false;
						for(char c: s.toCharArray()) {
							if(c == '=') {
								start = true;
								continue;
							}
							if(start) {
								if(c == ',' || c == '{' || c == '}') continue;
								key += c;
							}
						}
						if(key.strip().isEmpty()) {
							flags[9] = false;
							break;
						}
					}
					if(s.length() > 4 && s.substring(0, 4).equals("ISSN")) {
						String key = "";
						flags[10] = true;
						boolean start = false;
						for(char c: s.toCharArray()) {
							if(c == '=') {
								start = true;
								continue;
							}
							if(start) {
								if(c == ',' || c == '{' || c == '}') continue;
								key += c;
							}
						}
						if(key.strip().isEmpty()) {
							flags[10] = false;
							break;
						}
					}
				}catch(Exception e) {
					System.out.println(e);
				}
			}
			if(!(flags[0] && flags[1] && flags[2] && flags[3] && flags[4] && flags[5] && flags[6] && flags[7] && flags[8] && flags[9] && flags[10])) {
				try {
					@SuppressWarnings("unused")
					FileInvalidException fie = new FileInvalidException("IEEE", i);
				}catch(Exception e) {System.out.println(e);}
				
				return;
			}
			String a = (map.get("author")).charAt(map.get("author").length() - 1) == ',' ? map.get("author").substring(0, map.get("author").length() - 1) + "." : map.get("author") + ".";
			String temp = a + " " + '"' + (map.get("title")) + '"' + " " + (map.get("journal")) + ", " + 
					" vol. " + (map.get("volume")) + ", no. " + (map.get("number")) + ", p. " + (map.get("pages")) + ", " + (map.get("month")) + " " + (map.get("year")) + ".";
						resultIEEE.add(temp);
		}
		String location = "C:\\Users\\jenis\\Desktop\\Files\\" + "IEEE" + i + ".json";
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(new FileOutputStream(location));
			for(String s: resultIEEE) {
				pw.println(s + "\n");
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		pw.close();
		scan.close();
	}	
}
/**
 * 
 * @author Jenish Soni (40132415)
 * @version 1.0
 * @since 24th October, 2020
 *
 *
 *This is the custom exception which is invoked by creating instances of this class and the default or parameterized constructors are called. 
 */
class FileInvalidException{
	public FileInvalidException() throws Exception {
		throw new Exception(" Input file cannot be parsed due to missing information");
	}
	
	public FileInvalidException(String field, int i) throws Exception{
		throw new Exception("Invalid Systax, missing information. ");
	}
}