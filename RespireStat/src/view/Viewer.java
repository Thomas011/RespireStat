package view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Viewer {
	public Viewer (String w_Title) {
		JFrame viewer = new JFrame();
		viewer.setVisible(true);
		viewer.setSize(1000,600);
		viewer.setResizable(true);
		viewer.setTitle(w_Title);
		viewer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		viewer.setLocationRelativeTo(null);
		
		
	}
}
