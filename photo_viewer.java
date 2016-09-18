package PhotView;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;

/*
Introduction: In this assignment you will create a Java program that takes the place of a physical photo album.

Assignment: Write a stand alone Java program that can be used to both view and maintain entries in a digital photo album.
 Your solution should have two modes: (1) a browse mode, and (2) a maintenance mode. 
 While in browse mode the user should be able to move forward or backwards through a list of pictures.
 Each picture should include an optional description and date when the photo was taken. While in 
 the maintenance mode the user should be able to update an existing image, update the data associated 
 with an image, delete an image, and add new images.

More specifically your program should provide the following features:

1. The user should be able to move forward, backward or jump to a specific picture.
2. The user interface (UI) should display the number of the current picture as well as total number of pictures.
3. In browse mode it shouldn't be possible to change date or description.
4. Data should be stored externally so that changes persistent between runs.


 */
public class photo_viewer extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	
	private JButton next = new JButton("NEXT");
	private JButton prev = new JButton ("PREV");
	private int count = 0;
	private String update= "0";
	private JLabel counter = new JLabel(update);
	private JMenuItem browse = new JMenuItem("Browse");
	private JMenuItem maintain = new JMenuItem("Maintain");
	private JMenuItem exitMenuItem = new JMenuItem("Exit",KeyEvent.VK_X);
	
	public static void main(String[] args){
		JFrame photo=new photo_viewer();
		
		photo.setLocationRelativeTo(null);
		//photo.setSize(800, 500);
		photo.pack();
		photo.setVisible(true);
		photo.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
	}
	
	public photo_viewer(){
		
		this.setLocationRelativeTo(null);
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Photo Viewer");
		
		//Create menu bar.
		JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
       // Create the first menu.
        JMenu menu = new JMenu("File");
        menu.setMnemonic(KeyEvent.VK_F);
        menuBar.add(menu);
        // Create an item for the first menu
        exitMenuItem.addActionListener(this);
        menu.add(exitMenuItem);    
        // Create the second menu.
        JMenu view = new JMenu("View");
        view.setMnemonic(KeyEvent.VK_V);
        menuBar.add(view);
        //Create items for second menu.
        browse.addActionListener(this);
        view.add(browse);
        maintain.addActionListener(this);
        view.add(maintain);
        
        //Create main container for JFrame.
        Container content = getContentPane();
	
        //Create image container
		JLabel imageLabel = new JLabel("", SwingConstants.CENTER);
		Border titledBorder = BorderFactory.createTitledBorder("");
        imageLabel.setBorder(titledBorder);
		JScrollPane scrollPane = new JScrollPane(imageLabel);
		
		//Add image to container
		ImageIcon image = new ImageIcon("Leo.jpg");
		imageLabel.setIcon(image);
		
		content.add(scrollPane);
		
		//container that will hold description and date container, and
		//numb of pic info, next, and prev button container
		Container bottom = Box.createVerticalBox();
		
		Container middle = new JPanel();
		Container lmiddle = Box.createVerticalBox();
		Container description = Box.createVerticalBox();
		
		JTextArea info = new JTextArea(5,30);
		JTextField date = new JTextField(1);
		JLabel infoLabel = new JLabel("Description");
		info.setEditable(false);
		date.setEditable(false);
		date.setColumns(10);
		JLabel dateLabel = new JLabel ("Date");
		info.setText("<insert description here>");
		date.setText("<dd/mm/yyyy");
		description.add(Box.createHorizontalStrut(50));
		description.add(info);
		description.add(date);
		description.add(Box.createHorizontalStrut(50));
		lmiddle.add(infoLabel);
		lmiddle.add(Box.createVerticalStrut(60));
		lmiddle.add(dateLabel);
		middle.add(lmiddle,BorderLayout.WEST);
		middle.add(description,BorderLayout.EAST);
	
		Box buttonBox = Box.createHorizontalBox();
		next.addActionListener(this);
		prev.addActionListener(this);
		buttonBox.add(Box.createHorizontalStrut(30));
		buttonBox.add(counter);
		buttonBox.add(Box.createHorizontalStrut(10));
		buttonBox.add(new JLabel("of 5"));
		buttonBox.add(Box.createHorizontalStrut(20));
		buttonBox.add(prev);
		buttonBox.add(Box.createHorizontalStrut(10));
		buttonBox.add(next);
		Border titledBorder1 = BorderFactory.createTitledBorder("");
		buttonBox.setBorder(titledBorder1);
		//Add to bottom container.
		bottom.add(middle);
		bottom.add(buttonBox);
		//Add to main container.
		content.add(bottom, BorderLayout.SOUTH);
		
		this.setVisible(true);
	}	

//lambda expression added to each event to call a function
	//set the function in a new class called event handler
	//ex. button1.addActionListener(e-> buttonclick());
	@Override
	public void actionPerformed(ActionEvent evt){ 
		if(evt.getSource()==next){
			if(count<5){
				++count;
				counter.setText(Integer.toString(count));
				prev.setEnabled(true);
				System.out.println(count);
			}
			else if (count==5){
				next.setEnabled(false);
				System.out.println("NO");
			}
			System.out.println("next");
		}
		else if (evt.getSource() == prev){
			if(count>0){
				--count;
				counter.setText(Integer.toString(count));
				next.setEnabled(true);
				System.out.println(count);
			}
			else if (count ==0){
				System.out.println("NO");
				prev.setEnabled(false);
			}
			System.out.println("prev");
		}
		else if (evt.getSource() == browse){
			System.out.println("browse");
		}
		else if (evt.getSource() == maintain){
			System.out.println("maintain");
		}
		else if(evt.getSource() == exitMenuItem){
			System.exit(0);
		}
		else{
			System.out.println("Error: " + evt);
		}
	}	
}
	

