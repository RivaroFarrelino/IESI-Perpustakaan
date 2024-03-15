import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.plaf.TableUI;
import javax.swing.plaf.basic.BasicOptionPaneUI.ButtonActionListener;
import javax.swing.plaf.metal.MetalBorders.TextFieldBorder;
import javax.swing.table.DefaultTableModel;

public class FormPencarian extends javax.swing.JFrame {

    private TextFieldBorder keywordJudul;
    private ButtonActionListener tombolCari;
    private TableUI tableBuku;
    
    public void tampil(){
        // Mencegah app exit ketika di closed
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        //set location to center screen
        this.pack();
        this.setLocationRelativeTo(null);

        //Show User
        this.setVisible(true);
    }

    public void displayBuku(ArrayList<Buku> listBuku){
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
