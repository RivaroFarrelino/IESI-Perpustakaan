import java.awt.List;
import java.util.ArrayList;

public class PencarianController {
    ArrayList<Buku> listBuku;

    public void showFormPencarian() {
        FormPencarian formPencarian = new FormPencarian();
        formPencarian.tampil();
    }

    public ArrayList<Buku> cariBuku(String judul){
        BukuProvider bukuProvider = new BukuProvider();
        try {
            listBuku = bukuProvider.selectBuku(judul);
            Perpustakaan.formPencarian.display(listBuku);
        } catch(Exception ex) {
            // jika terjadi koneksi error pada saat select
            DialogUI dialogUI = new DialogUI("Connection Error");
            dialogUI.pack();
            dialogUI.setLocationRelativeTo(null);
            dialogUI.setVisible(true);
        }
        return listBuku;
            
    }

}
