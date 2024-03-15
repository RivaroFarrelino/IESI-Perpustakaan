import java.util.ArrayList;

public class PencarianController{
    
    public void showFormPencarian(){
        FormPencarian formPencarian = new FormPencarian();
        formPencarian.tampil();
    }

    public ArrayList<Buku> cariBuku(String judul){
        BukuProvider bukuProvider = new BukuProvider();
        bukuProvider.selectBuku(judul);
        if(!listBuku.isEmpty()) {
            Perpustakaan.formPencarian.display(listBuku);
        } else {
            // list buku kosong, maka...
            DialogUI dialogUI = new DialogUI("Buku tidak terdaftar");
            dialogUI.pack();
            dialogUI.setLocationRelativeTo(null);
            dialogUI.setVisible(true);
        }
            
    }

}
