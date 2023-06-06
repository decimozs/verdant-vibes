package backend;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;

public class Table extends JPanel {

	private JTable table;
    private DefaultTableModel tableModel;
    private int total = 0;
    
    public DefaultTableModel getTableModel() {
        return tableModel;
    }
    
    public Table() {
        tableModel = new DefaultTableModel(
            new Object[][] {},
            new String[] { "PlantIcon", "PlantName", "Price", "Quantity", "Price" }
        ) {
            Class[] columnTypes = new Class[] { ImageIcon.class, String.class, Double.class, Integer.class, Integer.class };
            public Class getColumnClass(int columnIndex) {
                return columnTypes[columnIndex];
            }
        };

        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        add(scrollPane);
        setVisible(true);
    }
}