import javax.swing.JMenuBar;

public class HalamanUtamaUI extends javax.swing.JFrame{

    private JMenuBar menuPeminjaman;
    private JMenuBar menuPencarian;

    public static void main(String[] args) {
        
    }

    private void menuPencarianMouseClicked(java.awt.event.MouseEvent evt){
        Perpustakaan.controllerPencarian = new PencarianController();
        Perpustakaan.controllerPencarian.showFormPencarian();
    }

}