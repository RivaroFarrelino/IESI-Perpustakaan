import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FormPeminjaman extends JFrame implements ActionListener {
    private JLabel labelJudul;
    private JTextField judulBuku;
    private JButton tombolCari;
    private JButton tombolKonfirmasi;
    private JButton tombolBatal;
    private JTable daftarPinjaman;
    private JTable daftarBuku;
    private JTextField lama;
    private DefaultTableModel tableModel;
    private ArrayList<BukuDipinjam> book;
    private int jumlahPeminjaman;

    public FormPeminjaman() {
        initComponents();
        book = new ArrayList<>();
        jumlahPeminjaman = 0;
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Form Peminjaman Buku");

        JPanel panel = new JPanel();
        getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        labelJudul = new JLabel("Judul Buku:");
        labelJudul.setBounds(20, 20, 80, 25);
        panel.add(labelJudul);

        judulBuku = new JTextField();
        judulBuku.setBounds(110, 20, 250, 25);
        panel.add(judulBuku);

        tombolCari = new JButton("Cari");
        tombolCari.setBounds(370, 20, 80, 25);
        panel.add(tombolCari);

        tombolKonfirmasi = new JButton("Konfirmasi");
        tombolKonfirmasi.setBounds(130, 300, 100, 25);
        panel.add(tombolKonfirmasi);

        tombolBatal = new JButton("Batal");
        tombolBatal.setBounds(250, 300, 100, 25);
        panel.add(tombolBatal);

        JLabel labelLama = new JLabel("Lama Peminjaman (hari):");
        labelLama.setBounds(20, 50, 150, 25);
        panel.add(labelLama);

        lama = new JTextField();
        lama.setBounds(180, 50, 100, 25);
        panel.add(lama);

        tableModel = new DefaultTableModel();
        daftarBuku = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(daftarBuku);
        scrollPane.setBounds(20, 80, 430, 200);
        panel.add(scrollPane);
        tableModel.addColumn("Judul Buku");

        DefaultTableModel pinjamanTableModel = new DefaultTableModel();
        daftarPinjaman = new JTable(pinjamanTableModel);
        JScrollPane pinjamanScrollPane = new JScrollPane(daftarPinjaman);
        pinjamanScrollPane.setBounds(20, 330, 430, 200);
        panel.add(pinjamanScrollPane);
        pinjamanTableModel.addColumn("Judul Buku");
        pinjamanTableModel.addColumn("Lama Pinjam");

        tombolCari.addActionListener(this);
        tombolKonfirmasi.addActionListener(this);
        tombolBatal.addActionListener(this);

        setSize(480, 580);
        setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == tombolCari) {
            String judul = judulBuku.getText();
            ArrayList<Buku> listBuku = Perpustakaan.bukuProvider.selectBuku(judul);
            display(listBuku);
        } else if (e.getSource() == tombolKonfirmasi) {
            int selectedRow = daftarBuku.getSelectedRow();
            if (selectedRow != -1) {
                String judulBuku = (String) tableModel.getValueAt(selectedRow, 0);
                int lamaPinjam;
                try {
                    lamaPinjam = Integer.parseInt(lama.getText());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Masukkan angka untuk lama peminjaman.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (lamaPinjam > 3) {
                    JOptionPane.showMessageDialog(this, "Maksimal lama peminjaman adalah 3 hari.", "Error",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }

                Buku selectedBook = null;
                for (Buku buku : Perpustakaan.bukuProvider.selectBuku(judulBuku)) {
                    if (buku.getJudul().equals(judulBuku)) {
                        selectedBook = buku;
                        break;
                    }
                }

                if (selectedBook != null) {
                    tambahBuku(selectedBook, lamaPinjam);
                } else {
                    JOptionPane.showMessageDialog(this, "Buku tidak ditemukan.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Pilih buku yang akan dipinjam.", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == tombolBatal) {
            int selectedRow = daftarPinjaman.getSelectedRow();
            if (selectedRow != -1) {
                String judulBuku = (String) daftarPinjaman.getValueAt(selectedRow, 0);
                int lamaPinjam = (int) daftarPinjaman.getValueAt(selectedRow, 1);

                for (BukuDipinjam buku : book) {
                    if (buku.getBuku().getJudul().equals(judulBuku) && buku.getLamaPinjam() == lamaPinjam) {
                        hapusBuku(buku);
                        return;
                    }
                }
                JOptionPane.showMessageDialog(this, "Buku tidak ditemukan dalam daftar pinjaman.", "Error",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Pilih buku yang akan dibatalkan peminjamannya.", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void display(ArrayList<Buku> listBuku) {
        tableModel.setRowCount(0);
        for (Buku buku : listBuku) {
            tableModel.addRow(new Object[] { buku.getJudul() });
        }
    }

    public void tampilPinjaman(ArrayList<BukuDipinjam> listBuku) {
        DefaultTableModel modelPinjaman = (DefaultTableModel) daftarPinjaman.getModel();
        modelPinjaman.setRowCount(0);
        for (BukuDipinjam buku : listBuku) {
            modelPinjaman.addRow(new Object[] { buku.getBuku().getJudul(), buku.getLamaPinjam() });
        }
    }

    public void hapusBuku(BukuDipinjam bukuDipinjam) {
        book.remove(bukuDipinjam);
        this.tampilPinjaman(book);
    }

    public void tambahBuku(Buku buku, int lama) {
        for (BukuDipinjam bukuDipinjam : book) {
            if (bukuDipinjam.getBuku().getJudul().equals(buku.getJudul())) {
                JOptionPane.showMessageDialog(this, "Buku sudah ada dalam daftar peminjaman.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        if (jumlahPeminjaman < 10) {
            book.add(new BukuDipinjam(buku, lama));
            jumlahPeminjaman++;
            this.tampilPinjaman(book);
        } else {
            JOptionPane.showMessageDialog(this, "Maksimum peminjaman buku telah dicapai (10 buku).", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public void tampil() {
        setVisible(true);
    }
}