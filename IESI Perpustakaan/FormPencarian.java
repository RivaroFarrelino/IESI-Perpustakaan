import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.plaf.TableUI;
import javax.swing.plaf.basic.BasicOptionPaneUI.ButtonActionListener;
import javax.swing.plaf.metal.MetalBorders.TextFieldBorder;
import javax.swing.table.DefaultTableModel;

public class FormPencarian extends JFrame implements ActionListener {

    private JTextField keywordJudul;
    private JButton tombolCari;
    private JTable tableBuku;

    public FormPencarian(){
        initComponents();
    }

    private void initComponents(){
        keywordJudul = new JTextField();
        tombolCari = new JButton("Search");
        tableBuku = new JTable();

        tombolCari.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
    
    public void tampil(){
        // Mencegah app exit ketika di closed
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        //set location to center screen
        this.pack();
        this.setLocationRelativeTo(null);

        //Show User
        this.setVisible(true);
    }

    public void display(ArrayList<Buku> listBuku){
        Object[] kolom = {"Judul"}; // Mendefinisikan kolom judul
        
        // buat model tabel, 0 adalah jumlah baris sementara
        DefaultTableModel model = new DefaultTableModel(kolom, 0);

        // loop array list buku, konversi menjadi array objek baris
        for(Buku buku : bukuList) {
            Object[] baris = { buku.judul };
            // masukkan tiap objek baris ke dalam model
            model.addRow(baris);
        }
        // set model tabel ke dalam JTable
        jTableBuku.setModel(model);
    }

    

}
