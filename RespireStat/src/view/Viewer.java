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
         
        String[] entetes = {"Prénom", "Nom", "Couleur favorite", "Homme", "Sport"};
         
         Object[][] donnees = {
             {"Johnathan", "Sykes", Color.red, true, "TENNIS"},
             {"Nicolas", "Van de Kampf", Color.black, true, "FOOTBALL"},
             {"Damien", "Cuthbert", Color.cyan, true, "RIEN"},
             {"Corinne", "Valance", Color.blue, false, "NATATION"},
             {"Emilie", "Schrödinger", Color.magenta, false, "FOOTBALL"},
             {"Delphine", "Duke", Color.yellow, false, "TENNIS"},
             {"Eric", "Trump", Color.pink, true, "FOOTBALL"},
        };
 
        JTable tableau = new JTable(donnees, entetes);
        tableau.setPreferredSize(new Dimension(1000, 600));
        setColumnWidths(tableau, 7, 1000);
 
        panel.add(tableau.getTableHeader(), BorderLayout.NORTH);
        panel.add(new JScrollPane(tableau), BorderLayout.CENTER);
        
        viewer.pack();	
    }
    
    public static void setColumnWidths(JTable table, int column, int width_table) {
        TableColumnModel columnModel = table.getColumnModel();
        for (int i = 0; i < column; i++) {
            if (i < columnModel.getColumnCount()) {
                columnModel.getColumn(i).setMaxWidth(width_table/column);
            }
        }
    }
}