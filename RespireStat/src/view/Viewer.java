package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

public class Viewer extends JFrame{
    public Viewer (String w_Title) {
        JFrame viewer = new JFrame();
        viewer.setVisible(true);
        viewer.setSize(1000,600);
        viewer.setResizable(true);
        viewer.setTitle(w_Title);
        viewer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        viewer.setLocationRelativeTo(null);
        
        JPanel panel = new JPanel();
        viewer.add(panel);
        panel.setPreferredSize(new Dimension(1000,600));
        panel.setBackground(Color.WHITE);
 
        JTable tableau = new JTable();
        tableau.setSize(panel.getWidth(), panel.getHeight());
        
        panel.setLayout(new BorderLayout());
        panel.add(new JScrollPane(tableau), BorderLayout.CENTER);
		DefaultTableCellRenderer r = new DefaultTableCellRenderer();
		r.setHorizontalAlignment(JLabel.CENTER);
		tableau.setDefaultRenderer(Object.class, r);
		tableau.setRowHeight(20);
		
		tableau.setRowSelectionAllowed(true);
        
        viewer.pack();	
    }
}