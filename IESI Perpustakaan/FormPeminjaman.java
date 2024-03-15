import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class FormPeminjaman extends JDialog {
    private JTextField judulBukuTextField;
    private JTextField lamaTextField;
    private JButton buttonCari;
    private JButton buttonKonfirmasi;
    private JTable daftarPinjamanTable;

    private ArrayList<BukuDipinjam> daftarPinjaman = new ArrayList<>();

    public FormPeminjaman() {
        setTitle("Form Peminjaman");
        setModal(true);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
        // Panel Form
        JPanel panelForm = new JPanel();
        panelForm.setLayout(new GridLayout(4, 2));

        JLabel labelJudulBuku = new JLabel("Judul Buku:");
        panelForm.add(labelJudulBuku);

        judulBukuTextField = new JTextField();
        panelForm.add(judulBukuTextField);

        JLabel labelLamaPinjam = new JLabel("Lama Pinjam (hari):");
        panelForm.add(labelLamaPinjam);

        lamaTextField = new JTextField();
        panelForm.add(lamaTextField);

        buttonCari = new JButton("Cari");
        buttonCari.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Mencari buku berdasarkan judul yang diinput
                String judulBuku = judulBukuTextField.getText();
                Buku buku = cariBuku(judulBuku);

                if (buku != null) {
                    // Menampilkan informasi buku yang ditemukan
                    JOptionPane.showMessageDialog(null, "Buku ditemukan:\n" + buku.toString());
                } else {
                    // Menampilkan pesan bahwa buku tidak ditemukan
                    JOptionPane.showMessageDialog(null, "Buku dengan judul '" + judulBuku + "' tidak ditemukan");
                }
            }
        });
        panelForm.add(buttonCari);

        buttonKonfirmasi = new JButton("Konfirmasi");
        buttonKonfirmasi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Menambahkan buku ke daftar pinjaman
                String judulBuku = judulBukuTextField.getText();
                int lamaPinjam = Integer.parseInt(lamaTextField.getText());

                Buku buku = new Buku(judulBuku);
                BukuDipinjam bukuDipinjam = new BukuDipinjam(buku, lamaPinjam);

                daftarPinjaman.add(bukuDipinjam);

                // Memperbarui tabel daftar pinjaman
                updateTabelDaftarPinjaman();

                // Menampilkan pesan konfirmasi
                JOptionPane.showMessageDialog(null, "Peminjaman buku '" + judulBuku + "' berhasil ditambahkan");

                // Membersihkan formulir
                judulBukuTextField.setText("");
                lamaTextField.setText("");
            }
        });
        panelForm.add(buttonKonfirmasi);

        add(panelForm, BorderLayout.CENTER);

        JPanel panelButton = new JPanel();
        JButton buttonTutup = new JButton("Tutup");
        buttonTutup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        panelButton.add(buttonTutup);

        add(panelButton, BorderLayout.SOUTH);

        daftarPinjamanTable = new JTable();
        String[] kolomDaftarPinjaman = { "Judul Buku", "Lama Pinjam" };
        DefaultTableModel modelDaftarPinjaman = new DefaultTableModel(kolomDaftarPinjaman, 0);
        daftarPinjamanTable.setModel(modelDaftarPinjaman);

        JScrollPane scrollPaneDaftarPinjaman = new JScrollPane(daftarPinjamanTable);
        add(scrollPaneDaftarPinjaman, BorderLayout.SOUTH);

        pack();
    }

    private Buku cariBuku(String judulBuku) {
        // Mencari buku berdasarkan judul
        BukuProvider bukuProvider = new BukuProvider();
        if (daftarBuku.containsKey(judulBuku)) {
            return daftarBuku.get(judulBuku);
        } else {
            return null;
        }
    }

    private void updateTabelDaftarPinjaman() {
        // Menghapus semua baris pada tabel daftar pinjaman
        DefaultTableModel modelDaftarPinjaman = (DefaultTableModel) daftarPinjamanTable.getModel();
        modelDaftarPinjaman.setRowCount(0);

        // Menambahkan baris baru untuk setiap buku yang dipinjam
        for (BukuDipinjam bukuDipinjam : daftarPinjaman) {
            String[] dataBaris = { bukuDipinjam.getBuku().getJudul(),
                    String.valueOf(bukuDipinjam.getLamaPinjam()) };
            modelDaftarPinjaman.addRow(dataBaris);
        }
    }
    
}