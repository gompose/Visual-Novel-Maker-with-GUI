import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import java.util.*;



public class Reader {
    public static String text = "";
    public static int pages;
    public static String[][] book;
    public static int currentPage = 1;
    // 2D Array Legend
    //[[text],[picture path],[sound path]]
    //Page number is the element of the arrays.
    
    
    public static int count (String s){
        int count = 0;
	int i = 0;
	while (i < s.length()) {
	    if (s.substring(i, i + 1).equals("$")) {
		count++;
		i++;
	    }else{
		i++;
	    }
	}
	return count / 2;
    }

    public static void fillSound(String _text) {
	String workString = _text;
	int begin;
	int end;
	String newString;
	int count = 0;
	while (workString.indexOf('[') != -1) {
	    begin = workString.indexOf('[');
	    boolean notfound = true;
	    end = begin + 1;
	    while (notfound) {
		if (workString.substring(end, end + 1).equals("]")) {
		    notfound = false;
		} else {
		    end++;
		}
	    }
	    newString = workString.substring(begin + 1, end);
	    book[2][count] = newString;
	    count++;
	    workString = workString.substring(end + 1);
	}
	System.out.println(Arrays.toString(book[2]));
    }


    public static void fillPicture(String _text) {
	String workString = _text;
	int begin;
	int end;
	String newString;
	int count = 0;
	while (workString.indexOf('{') != -1) {
	    begin = workString.indexOf('{');
	    boolean notfound = true;
	    end = begin + 1;
	    while (notfound) {
		if (workString.substring(end, end + 1).equals("}")) {
		    notfound = false;
		} else {
		    end++;
		}
	    }
	    newString = workString.substring(begin + 1, end);
	    book[1][count] = newString;
	    count++;
	    workString = workString.substring(end + 1);
	}
	System.out.println(Arrays.toString(book[1]));
    }    
    
    
    public static void fillText(String _text) {
	String workString = _text;
	int begin;
	int end;
	String newString;
	int count = 0;
	while (workString.indexOf('|') != -1) {
	    begin = workString.indexOf('|');
	    boolean notfound = true;
	    end = begin + 1;
	    while (notfound) {
		if (workString.substring(end, end + 1).equals("|")) {
		    notfound = false;
		} else {
		    end++;
		}
	    }
	    newString = workString.substring(begin + 1, end);
	    book[0][count] = newString;
	    count++;
	    workString = workString.substring(end + 1);
	}
	System.out.println(Arrays.toString(book[0]));
    }

    public static void read(String filename) {
	String _text = "";
	try{
	    Scanner sc = new Scanner(new File(filename));
	    while(sc.hasNextLine()){
		_text += sc.nextLine();
	    }
	}catch (FileNotFoundException e) {
	    System.out.println("File Not Found!");	    
	}
	text = _text;
    }

    public static void turnPage(int i) {
	if (currentPage + i < 0 || currentPage + i > pages) {
	    System.out.println("No more pages to turn!");
	}else{
	    currentPage += i;
	    System.out.println("Page #" + currentPage);
	}

    }
    
    public static void process(String filename, int i){
	read(filename);
	pages = count(text);
	book = new String [3][pages];
	fillText(text);
	fillPicture(text);
	fillSound(text);
	currentPage = i;
    }

    
    public static void main (String[] args) {
	//File Reading
	process("Book1.txt", 1);
	
	
	
	//GUI
	ReaderWindow a = new ReaderWindow();

	//Writer
	Writer b = new Writer();


	
	
	
    }
	
}
