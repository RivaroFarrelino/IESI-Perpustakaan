import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FormPencarian extends JFrame implements ActionListener {
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

        keywordJudul = new JTextField(20);
        tombolCari = new JButton("Search");
        tableModel = new DefaultTableModel();
        tableBuku = new JTable(tableModel);

        tombolCari.addActionListener(this);

        getContentPane().setLayout(new java.awt.FlowLayout());
        getContentPane().add(keywordJudul);
        getContentPane().add(tombolCari);
        getContentPane().add(tableBuku);

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
        Object[] kolom = { "Judul" };
        tableModel.setColumnIdentifiers(kolom);
        for (Buku buku : listBuku) {
            Object[] baris = { buku.getJudul() };
            tableModel.addRow(baris);
        }
    }

    public void tampil() {
        setVisible(true);
    }
}
