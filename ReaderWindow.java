import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import java.util.*;

public class ReaderWindow extends JFrame implements ActionListener {

    private JFrame f = new JFrame();
    private JButton b = new JButton("Next");
    private JButton a = new JButton("Previous");
    private JButton exit = new JButton("Exit");
    private JLabel text;
    private JLabel picture;
    
    public ReaderWindow(){
	//GUI
	

	//Button A
	a.addActionListener(this);
	a.setActionCommand("turn -1");
	a.setBounds(0, 450, 100, 50);
	f.add(a);
	//Button B
	b.addActionListener(this);
	b.setActionCommand("turn 1");
	b.setBounds(400, 450, 100, 50);
	f.add(b);
	//Button Exit
	exit.setBounds(430, 0, 70, 50);
	f.add(exit);
	//Text Field
	text = new JLabel(Reader.book[0][Reader.currentPage]);
	text.setBounds(300, 250, 200, 50);
	f.add(text);
	//Picture Field
	ImageIcon img = new ImageIcon(Reader.book[1][Reader.currentPage]);
	picture = new JLabel();
	picture.setBounds(0, 0, 500, 200);
	picture.setIcon(img);
	f.add(picture);
	
	
	f.setSize(500, 500);
	f.setLayout(null);
	f.setVisible(true);
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e){
	String event = e.getActionCommand();
	if(event.equals("turn 1")){
	    Reader.turnPage(1);
	    text.setText(Reader.book[0][Reader.currentPage]);
	    ImageIcon img = new ImageIcon(Reader.book[1][Reader.currentPage]);
	    picture.setIcon(img);
	}
	if(event.equals("turn -1")){
	    Reader.turnPage(-1);
	    text.setText(Reader.book[0][Reader.currentPage]);
	    ImageIcon img = new ImageIcon(Reader.book[1][Reader.currentPage]);
	    picture.setIcon(img);
	}
    
    }
	    
}
