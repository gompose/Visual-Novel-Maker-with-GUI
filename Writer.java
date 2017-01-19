import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import java.util.*;

public class Writer extends JFrame implements ActionListener{

    private static JFrame f = new JFrame();
    private static JButton write;
    private static JTextField text;
    private static JTextField picture;
    private static JTextField sound;
    private static JTextField fileName;

    public void writeTo(String fileName){
	try{
	    FileWriter writer = new FileWriter(fileName, true);
	    BufferedWriter buff = new BufferedWriter(writer);
	    buff.write("\n");
	    buff.write("$");
	    buff.write("\n");
	    buff.write("|" + text.getText() + "|");
	    buff.write("\n");
	    buff.write("{" + picture.getText() + "}");
	    buff.write("\n");
	    buff.write("[" + sound.getText() + "]");
	    buff.write("\n");
	    buff.write("$");
	    buff.write("\n");
	    buff.close();
	}catch (IOException e){
	    e.printStackTrace();
	}
    }
	
    
    public Writer() {
	//Write Button
	write = new JButton("Write to File");
	write.addActionListener(this);
	write.setActionCommand("done");
	write.setBounds(400, 150, 100, 50);
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
	sound = new JTextField("Sound here", 60);
	sound.setToolTipText("Input File Path");
	sound.setBounds(200, 150, 150, 20);
	f.add(sound);
	//File Name
	fileName = new JTextField("File Name.txt", 60);
	fileName.setToolTipText("Include The File Extension!");
	fileName.setBounds(0, 0, 150, 20);
	f.add(fileName);


	f.setSize(500, 250);
	f.setLayout(null);
	f.setVisible(true);
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
    }

    public void actionPerformed(ActionEvent e){
	String event = e.getActionCommand();
	if(event.equals("done")){
	    writeTo(fileName.getText());
	}
    }

    
}
