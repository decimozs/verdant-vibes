package backend;

import components.Home;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class AddressTable extends JPanel {

    public JTable table;
    public DefaultTableModel tableModel;
    private Home home;

    public DefaultTableModel getTableModel() {
        return tableModel;
    }

    public AddressTable(Home home) {
        this.home = home;

        tableModel = new DefaultTableModel(
                new Object[][] {},
                new String[] { "First Name", "Last Name", "Initial", "Street Address", "City", "Country" }) {
            Class[] columnTypes = new Class[] { String.class, String.class, String.class, String.class, String.class,
                    String.class };

            public Class getColumnClass(int columnIndex) {
                return columnTypes[columnIndex];
            }
        };

        table = new JTable(tableModel);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // Set single selection mode
        JScrollPane scrollPane = new JScrollPane(table);

        add(scrollPane);
        setVisible(true);
    }

    public String retrieveFname() {
        StringBuilder names = new StringBuilder();
        String firstName = tableModel.getValueAt(0, 0).toString();
        names.append(firstName);
        return names.toString();
    }

    public String retrieveLname() {
        StringBuilder names = new StringBuilder();
        String firstName = tableModel.getValueAt(0, 1).toString();
        names.append(firstName);
        return names.toString();
    }

    public String retrieveInitial() {
        StringBuilder names = new StringBuilder();
        String firstName = tableModel.getValueAt(0, 2).toString();
        names.append(firstName);
        return names.toString();
    }
}