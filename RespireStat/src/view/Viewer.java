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
import javax.swing.table.DefaultTableModel;

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
        
        String[] Header = new String[]{"NO2", "PM10", "PM25"};
        
        tabbedPane.addTab("F01", Create_Tab_Table(Header, Stat.Get_FO1_Data(), 50));
        tabbedPane.addTab("F02", Create_Tab_Table(Header, Stat.Get_FO2_Data(), 40));
        tabbedPane.addTab("F03", Create_Tab_Table(Header, Stat.Get_FO3_Data(), 40));
        tabbedPane.addTab("F04", Create_Tab_Table(Header, Stat.Get_FO4_Data(), 40));
        
        viewer.getContentPane().add(tabbedPane);
        viewer.pack();
    }
    
    private static JPanel Create_Tab_Table(String[] header, String[][] data, int Row_Height) {
        JPanel Panel = new JPanel();
        DefaultTableModel Model = new DefaultTableModel(data, header);
        JTable Table = new JTable(Model);
        
        Table.setPreferredScrollableViewportSize(new Dimension(450,63));
        Table.setFillsViewportHeight(true);
        Table.setRowHeight(Row_Height);
        
        Panel.add(Table);
        Panel.setLayout(new BorderLayout());
        Panel.add(Table, BorderLayout.CENTER);
        Panel.add(Table.getTableHeader(), BorderLayout.NORTH);
        
        JScrollPane pane = new JScrollPane(Table);
        Panel.add(pane, BorderLayout.CENTER);
        
        return Panel;
    }
}