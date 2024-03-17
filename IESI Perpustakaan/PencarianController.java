import java.util.ArrayList;

public class PencarianController {
    ArrayList<Buku> listBuku;

    public void showFormPencarian() {
        FormPencarian formPencarian = new FormPencarian();
        formPencarian.tampil();
    }

    public ArrayList<Buku> cariBuku(String judul) {
        BukuProvider bukuProvider = new BukuProvider();
        try {
            listBuku = bukuProvider.selectBuku(judul);
            Perpustakaan.formPencarian.display(listBuku);
        } catch (Exception ex) {
            System.err.println("Error saat mencari buku: " + ex.getMessage());
            ex.printStackTrace(); // Print stack trace untuk melihat detail exception
        }
        return listBuku;
    }
}
