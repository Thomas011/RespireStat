package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Label;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

public class Viewer extends JFrame{
    public Viewer (String w_Title) {
        JFrame viewer = new JFrame();
        viewer.setVisible(true);
        viewer.setSize(1000, 600);
        viewer.setResizable(true);
        viewer.setTitle(w_Title);
        viewer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        viewer.setLocationRelativeTo(null);
        
        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.setPreferredSize(new Dimension(viewer.getWidth(), viewer.getHeight()));
        
        Object[][] data = {
            {"Johnathan", "Sykes", "TENNIS"},
            {"Nicolas", "Van de Kampf", "FOOTBALL"},
            {"Damien", "Cuthbert", "NOTHING"},
            {"Corinne", "Valance", "SWIMMING"},
            {"Emilie", "Schrödinger", "FOOTBALL"},
            {"Delphine", "Duke", "TENNIS"},
            {"Eric", "Trump", "FOOTBALL"},
        };

        String[] header = {"N02", "PM10", "PM25"};
        
        tabbedPane.addTab("F01", Create_Tab_Table(data, header));
        
        viewer.getContentPane().add(tabbedPane);
        viewer.pack();	
    }
    
    private static JPanel Create_Tab_Table(Object[][] data, String[] header) {
        JPanel Panel = new JPanel();
        JTable Table = new JTable(data, header);
        Panel.add(Table);
        Panel.setLayout(new BorderLayout());
        Panel.add(Table, BorderLayout.CENTER);
        Panel.add(Table.getTableHeader(), BorderLayout.NORTH);
        return Panel;
    }
}