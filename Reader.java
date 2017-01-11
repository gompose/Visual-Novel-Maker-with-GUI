import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Reader {
    private String text = "";
    private int pages = "";
    private String[][] book = new String[3][pages];
    public static void fill (String s){
	// s will be a path
	// Pull the contents of file s, and set text to it.
	text = // Insert here
	    }
    public static void main (String[] args) {
	JFrame f = new JFrame();
	JButton b = new JButton("Next");
	JButton a = new JButton("Previous");
	a.setBounds(0, 100, 50, 50);
	f.add(a);
	b.setBounds(100, 100, 50, 50);
	f.add(b);
	f.setSize(500, 500);
	f.setLayout(null);
	f.setVisible(true);
	

    }
}
    
