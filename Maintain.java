package PhotView;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.Vector;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Maintain extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton saveButton = new JButton("Save Changes");
	private JButton addFileButton = new JButton("Add Photo");
	private JButton deleteFileButton = new JButton("Delete");
	private Container maint = Box.createHorizontalBox();
	Vector<ImageIcon> photoAlbum = new Vector<ImageIcon>();
	ImageIcon image = new ImageIcon();
	Maintain m;
	JFrame f;
	String str;
	File fl;
	File[] flist;

	public Container Maintain() {

		saveButton.setEnabled(false);
		deleteFileButton.setEnabled(false);
		addFileButton.setEnabled(false);
		maint.add(deleteFileButton);
		deleteFileButton.addActionListener(this);
		maint.add(saveButton);
		saveButton.addActionListener(this);
		maint.add(addFileButton);
		addFileButton.addActionListener(this);
		return maint;
	}

	public void setMaintEnabled(JButton saveButton2) {
		
		saveButton.setEnabled(true);
		addFileButton.setEnabled(true);
		deleteFileButton.setEnabled(true);
	}

	public Object MaintAction() {
		
		saveButton.setVisible(true);
		saveButton.setEnabled(true);
		addFileButton.setEnabled(true);
		deleteFileButton.setEnabled(true);
		updateUI();
		System.out.println("maint");
		return null;
	}

	public ImageIcon deletePhoto() {
		// remove photo from vector
		return null;
	}

	public void saveChanges() {
		// update photo in vector
		// save changes to description
		// save changes to date
	}

	public ImageIcon addPhoto() {
		
		ImageIcon icon = null;
		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = 
				new FileNameExtensionFilter("JPG & GIF Images", "jpg", "gif");
		chooser.setFileFilter(filter);
		int returnVal = chooser.showOpenDialog(chooser);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			System.out.println("You chose to open this file: " 
		+ chooser.getSelectedFile().getName());
			icon = new ImageIcon(chooser.getSelectedFile().getName());
			System.out.println(icon);
		}
		System.out.println("select photo");
		return icon;
	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		if (evt.getSource() == deleteFileButton) {
			deletePhoto();
			System.out.println("delete");
		} else if (evt.getSource() == saveButton) {
			saveChanges();
			System.out.println("saved changes");
		} else if (evt.getSource() == addFileButton) {
			addPhoto();
			System.out.println("photo added");
		}
	}
}