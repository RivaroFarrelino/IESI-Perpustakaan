import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HalamanUtamaUI extends JFrame {
    private JMenuBar menuBar;
    private JMenu menuPencarian;
    private JMenu menuPeminjaman;
    private FormPencarian formPencarian;
    private FormPeminjaman formPeminjaman;

    public HalamanUtamaUI() {
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);

        menuBar = new JMenuBar();

        menuPencarian = new JMenu("Pencarian");
        JMenuItem itemPencarian = new JMenuItem("Cari Buku");
        itemPencarian.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                formPencarian = new FormPencarian();
                formPencarian.tampil();
            }
        });
        menuPencarian.add(itemPencarian);

        menuPeminjaman = new JMenu("Peminjaman");
        JMenuItem itemPeminjaman = new JMenuItem("Form Peminjaman");
        itemPeminjaman.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                formPeminjaman = new FormPeminjaman();
                formPeminjaman.tampil();
            }
        });
        menuPeminjaman.add(itemPeminjaman);

        menuBar.add(menuPencarian);
        menuBar.add(menuPeminjaman);

        setJMenuBar(menuBar);
    }

}
