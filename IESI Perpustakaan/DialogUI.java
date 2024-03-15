import javax.swing.JLabel;
import javax.swing.JTextField;

public class DialogUI extends javax.swing.JFrame {

    private JLabel message;
    
    public DialogUI(){
        initComponents();
    }

    public DialogUI(String message){
        this();
        jLabelMessage.setText(message); 
    }

    public void setMessage(String message){
        jLabelMessage.setText(message);
    }

    private void jButtonOKMouseClicked(java.awt.event.MouseEvent evt) {
        String judul = JTextFieldJudul.getText();
        Perpustakaan.controllerPencarian.cariBuku(judul);
    }

}
