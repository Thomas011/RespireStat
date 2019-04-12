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
        tabbedPane.addTab("F01", makePanel("This is tab 1"));
        tabbedPane.addTab("F02", makePanel("This is tab 2"));
        tabbedPane.addTab("F03", makePanel("This is tab 3"));
        tabbedPane.addTab("F04", makePanel("This is tab 4"));
        viewer.getContentPane().add(tabbedPane);
        
        Object[][] data = {
            {"Johnathan", "Sykes", Color.red, true, "TENNIS"},
            {"Nicolas", "Van de Kampf", Color.black, true, "FOOTBALL"},
            {"Damien", "Cuthbert", Color.cyan, true, "NOTHING"},
            {"Corinne", "Valance", Color.blue, false, "SWIMMING"},
            {"Emilie", "Schrödinger", Color.magenta, false, "FOOTBALL"},
            {"Delphine", "Duke", Color.yellow, false, "TENNIS"},
            {"Eric", "Trump", Color.pink, true, "FOOTBALL"},
        };

        String[] headers = {"First name", "Name", "Favourite color", "Gender", "Sport"};
        
        JTable table = new JTable(data, headers);
        tabbedPane.add(table.getTableHeader(), BorderLayout.NORTH);
        tabbedPane.add(table, BorderLayout.CENTER);
        
        viewer.pack();	
    }
    
    private static JPanel makePanel(String text) {
        JPanel p = new JPanel();
        p.add(new Label(text));
        p.setLayout(new GridLayout(1, 1));
        return p;
    }
}