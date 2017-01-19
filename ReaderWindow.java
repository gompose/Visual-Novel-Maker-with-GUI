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
    private JTextArea text;
    private JLabel picture;
    private JTextField textField;
    
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
	exit.addActionListener(this);
	exit.setActionCommand("close");
	exit.setBounds(430, 0, 70, 50);
	f.add(exit);
	//Text 
	text = new JTextArea(Reader.book[0][Reader.currentPage - 1], 10, 20);
	text.setLineWrap(true);
	text.setEditable(false);
	text.setWrapStyleWord(true);
	text.setBounds(50, 350, 350, 50);
	f.add(text);
	//Picture 
     	picture = new JLabel();
	ImageIcon img = new ImageIcon(Reader.book[1][Reader.currentPage - 1]);
	Image workImg = img.getImage();
	Image newImg = workImg.getScaledInstance(350, 250, java.awt.Image.SCALE_SMOOTH);
	img = new ImageIcon(newImg);
	picture.setIcon(img);
	picture.setBounds(50, 50, 400, 300);
	f.add(picture);
	//File input
	textField = new JTextField("Input File Path Here", 30);
	textField.setToolTipText("Only Accepts .txt!");
	textField.addActionListener(this);
	textField.setActionCommand("load");
	textField.setBounds(0, 0, 150, 20);
	f.add(textField);
	
	
	f.setSize(500, 500);
	f.setLayout(null);
	f.setVisible(true);
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e){
	String event = e.getActionCommand();
	if(event.equals("turn 1")){
	    Reader.turnPage(1);
	    text.setText(Reader.book[0][Reader.currentPage - 1]);
	    ImageIcon img = new ImageIcon(Reader.book[1][Reader.currentPage - 1]);	    Image workImg = img.getImage();
	    Image newImg = workImg.getScaledInstance(350, 250, java.awt.Image.SCALE_SMOOTH);
	    img = new ImageIcon(newImg);
	    picture.setIcon(img);
	}
	if(event.equals("turn -1")){
	    Reader.turnPage(-1);
	    text.setText(Reader.book[0][Reader.currentPage - 1]);
	    ImageIcon img = new ImageIcon(Reader.book[1][Reader.currentPage - 1]);	    Image workImg = img.getImage();
	    Image newImg = workImg.getScaledInstance(350, 250, java.awt.Image.SCALE_SMOOTH);
	    img = new ImageIcon(newImg);
	    picture.setIcon(img);
	}
	if(event.equals("close")){
	    System.exit(0);
	}
	if(event.equals("load")){
	    Reader.process(textField.getText(), 0);
	}
    
    }
	    
}
