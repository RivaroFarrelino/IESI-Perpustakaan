import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HalamanUtamaUI extends JFrame {
    private JMenuBar menuBar;
    private JMenu menuPencarian;
    private JMenu menuPeminjaman;
    private FormPencarian formPencarian;

    public HalamanUtamaUI() {
        initComponents(); // Memanggil initComponents() untuk menginisialisasi komponen UI
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);

        // Buat menu bar
        menuBar = new JMenuBar();

        // Buat menu pencarian dan tambahkan action listener untuk menampilkan form pencarian
        menuPencarian = new JMenu("Pencarian");
        JMenuItem itemPencarian = new JMenuItem("Cari Buku");
        itemPencarian.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                formPencarian = new FormPencarian(); // Memanggil initComponents() dari FormPencarian
                formPencarian.tampil();
            }
        });
        menuPencarian.add(itemPencarian);

        // Buat menu peminjaman dan tambahkan action listener untuk menampilkan form peminjaman
        menuPeminjaman = new JMenu("Peminjaman");
        JMenuItem itemPeminjaman = new JMenuItem("Form Peminjaman");
        itemPeminjaman.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Tambahkan logika untuk menampilkan form peminjaman
            }
        });
        menuPeminjaman.add(itemPeminjaman);

        menuBar.add(menuPencarian);
        menuBar.add(menuPeminjaman);

        setJMenuBar(menuBar);
    }

    
}
