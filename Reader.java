import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import java.util.*;



public class Reader {
    private static String text = "";
    private static int pages;
    private static String[][] book = new String[3][pages];
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
	    book[2][count] = newString;
	    count++;
	    workString = workString.substring(end + 1);
	}
	System.out.println(Arrays.toString(book[2]));
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
	    book[1][count] = newString;
	    count++;
	    workString = workString.substring(end + 1);
	}
	System.out.println(Arrays.toString(book[1]));
    }

    public static String read(String filename) {
	try{
	    Scanner sc = new Scanner(new File(filename));
	    while(sc.hasNext()){
		text += sc.next();
	    }
	}catch (FileNotFoundException e) {
	    System.out.println("File Not Found!");	    
	}
	return text;
    }


    
    public static void main (String[] args) {
	//File Reading
	
	read("Book1.txt");
	pages = count(text);
	book = new String [3][pages];
	fillText(text);
	fillPicture(text);
	//fillSound(text);
	
	//System.out.println(text);
	//System.out.println(pages);
	
	
	



	//GUI
	JFrame f = new JFrame();
	JButton b = new JButton("Next");
	JButton a = new JButton("Previous");
	JButton exit = new JButton("Exit");

	exit.setBounds(430, 0, 70, 50);
	f.add(exit);
	a.setBounds(0, 450, 100, 50);
	f.add(a);
	b.setBounds(400, 450, 100, 50);
	f.add(b);

	f.setSize(500, 500);
	f.setLayout(null);
	f.setVisible(true);
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	
    }
	
}
