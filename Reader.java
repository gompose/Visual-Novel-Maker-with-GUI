import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Reader {
    private String text = "";
    private int pages = 0;
    private String[][] book = new String[3][pages];
    public static void fill (String s){
	// s will be a path
	// Pull the contents of file s, and set text to it.
	//text = // Insert here
	    }
    public static void main (String[] args) {
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
    }
	
}
    
