import javax.swing.JMenuBar;

public class HalamanUtamaUI extends javax.swing.JFrame{

    private JMenuBar menuPeminjaman;
    private JMenuBar menuPencarian;
    FormPencarian formPencarian = new FormPencarian();

    public static void main(String[] args) {
        
    }

    private void menuPencarianMouseClicked(java.awt.event.MouseEvent evt){
        PencarianController controllerPencarian = new PencarianController();
        controllerPencarian.showFormPencarian();
    }

}