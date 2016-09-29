package PhotView;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class Viewer {
	public static void main(String[] args){
		JFrame photo=new photo_viewer();
		
		photo.pack();
		photo.setLocationRelativeTo(null);
		photo.setLayout(new BorderLayout());
		photo.setVisible(true);
		photo.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
	}

}
