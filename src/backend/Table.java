package backend;

import java.text.DecimalFormat;
import components.Home;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;

public class Table extends JPanel {

    public JTable table;
    private DefaultTableModel tableModel;
    private Home home;

    public DefaultTableModel getTableModel() {
        return tableModel;
    }

    public Table(Home home) {
        this.home = home;

        tableModel = new DefaultTableModel(
                new Object[][] {},
                new String[] { "PlantIcon", "PlantName", "Item Price", "Quantity", "Total" }) {
            Class[] columnTypes = new Class[] { ImageIcon.class, String.class, Double.class, Integer.class,
                    Integer.class };

            public Class getColumnClass(int columnIndex) {
                return columnTypes[columnIndex];
            }
        };

        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        add(scrollPane);
        setVisible(true);
    }

    public int calculateTotalSum() {
        int totalSum = 0;
        int totalColumnIndex = 4;

        for (int i = 0; i < tableModel.getRowCount(); i++) {
            Object value = tableModel.getValueAt(i, totalColumnIndex);
            if (value instanceof Integer) {
                totalSum += (int) value;
            } else if (value instanceof Double) {
                totalSum += ((Double) value).intValue();
            }
        }
        return totalSum;
    }

    public String formatSum(double amount) {
        DecimalFormat df = new DecimalFormat("#,##0");
        return df.format(amount);
    }

}
