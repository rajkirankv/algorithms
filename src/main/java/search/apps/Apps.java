package search.apps;

import java.util.Scanner;
import java.util.HashSet;
import java.util.regex.Pattern;
import java.io.InputStream;

class Apps {
	
	public static void deDup(InputStream in) {
		Scanner sc = new Scanner(in);
		HashSet<String> set = new HashSet<String>();
		String s;
		// Pattern p = Pattern.compile("[\n\r]");
		while(sc.hasNext()) {
			s = sc.next();
			// System.out.println("DEBUG: " + s);
			if(!set.contains(s)) {
				System.out.print(s + " ");
				set.add(s);
				if(sc.hasNext("\n") || sc.hasNext("\r"))
					System.out.print(sc.next());
				// s = sc.next(p);
				// if(s != null) System.out.print(s);
			}
		}
		sc.close();
	}

	public static void temp(InputStream in) {
		Scanner sc = new Scanner(in);
		while(sc.hasNext()) {
			System.out.print("This is temp printing: " + sc.next() + " ");
		}
	}

	public static void main(String[] args) {
		deDup(System.in);
	}
}