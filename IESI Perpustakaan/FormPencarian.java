import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FormPencarian extends JFrame implements ActionListener {
    private JLabel labelJudul;
    private JTextField keywordJudul;
    private JButton tombolCari;
    private JTable tableBuku;
    private DefaultTableModel tableModel;

    public FormPencarian() {
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Form Pencarian Buku");
        setSize(600, 400);

        labelJudul = new JLabel("Judul:");
        keywordJudul = new JTextField(20);
        tombolCari = new JButton("Search");
        tombolCari.addActionListener(this);

        tableModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Membuat sel tidak dapat diedit
            }
        };
        tableModel.addColumn("Judul");
        tableBuku = new JTable(tableModel);
        tableBuku.setEnabled(false); // Mengatur tabel tidak dapat diedit

        JPanel panelInput = new JPanel();
        panelInput.add(labelJudul);
        panelInput.add(keywordJudul);
        panelInput.add(tombolCari);

        JPanel panelHasil = new JPanel(new BorderLayout());
        panelHasil.add(new JLabel("Hasil Pencarian:"), BorderLayout.NORTH); // Mini heading "Hasil Pencarian"
        panelHasil.add(tableBuku, BorderLayout.CENTER);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(panelInput, BorderLayout.NORTH);
        getContentPane().add(panelHasil, BorderLayout.CENTER);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String judul = keywordJudul.getText();
        ArrayList<Buku> listBuku = Perpustakaan.bukuProvider.selectBuku(judul);
        display(listBuku);
    }

    public void display(ArrayList<Buku> listBuku) {
        tableModel.setRowCount(0);
        for (Buku buku : listBuku) {
            tableModel.addRow(new Object[]{buku.getJudul()});
        }
    }

    public void tampil() {
        setVisible(true);
    }
}
