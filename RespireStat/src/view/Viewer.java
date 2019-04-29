package view;

import model.Etablissement;
import controller.Stat_Etablissements;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

import org.apache.commons.lang3.ArrayUtils;

public class Viewer extends JFrame{
    public Viewer (String w_Title, List<Etablissement> w_Collections) {
        JFrame viewer = new JFrame();
        viewer.setVisible(true);
        viewer.setSize(1000, 600);
        viewer.setResizable(true);
        viewer.setTitle(w_Title);
        viewer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        viewer.setLocationRelativeTo(null);
        
        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.setPreferredSize(new Dimension(viewer.getWidth(), viewer.getHeight()));
        
        Stat_Etablissements Stat = new Stat_Etablissements(w_Collections);
        
        String[][] F01_Data = Stat.Get_FO1_Data();
        String[] F01_Header = Stat.Get_FO1_Header();
        
        tabbedPane.addTab("F01", Create_Tab_Table(F01_Data, F01_Header));

        String[][] F02_Data = Stat.Get_FO2_Data();
        String[] F02_Header = Stat.Get_FO2_Header();
        
        tabbedPane.addTab("F02", Create_Tab_Table(F02_Data, F02_Header));
        
        String[][] F03_Data = Stat.Get_FO3_Data();
        String[] F03_Header = Stat.Get_FO3_Header();
        
        tabbedPane.addTab("F03", Create_Tab_Table(F03_Data, F03_Header));
        
        viewer.getContentPane().add(tabbedPane);
        viewer.pack();
    }
    
    private static JPanel Create_Tab_Table(Object[][] data, String[] header) {
        JPanel Panel = new JPanel();
        JTable Table = new JTable(data, header);
        Table.setPreferredScrollableViewportSize(new Dimension(450,63));
        Table.setFillsViewportHeight(true);
        
        Panel.add(Table);
        Panel.setLayout(new BorderLayout());
        Panel.add(Table, BorderLayout.CENTER);
        Panel.add(Table.getTableHeader(), BorderLayout.NORTH);
        
        JScrollPane pane = new JScrollPane(Table);
        Panel.add(pane, BorderLayout.CENTER);
        
        return Panel;
    }
}