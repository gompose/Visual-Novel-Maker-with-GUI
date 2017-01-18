import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import java.util.*;

public class Writer{

    private static JFrame f = new JFrame();
    private static JButton write = new JButton("Write to file");
    private static JTextField text;
    private static JTextField picture;
    private static JTextField sound;
    private static JtextField fileName;

    public void writeTo(String fileName){
	try{
	    FileWriter writer = new FileWriter(fileName, true);
	    writer.println("$");
	    writer.println("|" + text.getText() + "|");
	    writer.println("{" + picture.getText() + "}");
	    writer.println("[" + sound.getText() + "]");
	    writer.close();
	}catch (IOException e){
	    System.out.println("File Not Found!");
	}
    }
	
    
    public static void main (String[] args){
	//Write Button
	write.addActionListener(this);
	write.setActionCommand("Write");
	write.setBounds(400, 450, 100, 50);
	f.add(write);
	//Text Field
	text = new JTextField("Text here", 60);
	text.setToolTipText("Accepts all characters");
	text.setBounds(200, 50, 150, 20);
	f.add(text);
	//Picture Field
	picture = new JTextField("Sound here", 60);
	picture.setToolTipText("Input File Path");
	picture.setBounds(200, 100, 150, 20);
	f.add(picture);
	//Sound
	text = new JTextField("Sound here", 60);
	text.setToolTipText("Input File Path");
	text.setBounds(200, 150, 150, 20);
	f.add(sound);
	//File Name
	fileName = new JTextField("File Name.txt", 60);
	fileName.setToolTipText("Include The File Extension!");
	fileName.setBounds(0, 0, 150, 20);
	f.add(fileName);


	f.setSize(500, 500);
	f.setLayout(null);
	f.setVisible(true);
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	

    }

    public void actionPerformed(ActionEvent e){
	String event = e.getActionCommand();
	if(event.equals("Write")){
	    writeTo(fileName.getText());
	}
    }

    
}
