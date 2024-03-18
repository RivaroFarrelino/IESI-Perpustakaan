import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DialogUI extends JFrame {
    private JLabel jLabelMessage;
    private JTextField JTextFieldJudul;

    public DialogUI(String message){
        initComponents(message);
    }

    private void initComponents(String message) {
        jLabelMessage = new JLabel();
        JTextFieldJudul = new JTextField();
        JButton jButtonOK = new JButton("OK");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabelMessage.setText(message);

        jButtonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButtonOKActionPerformed1(evt);
                jButtonOKActionPerformed2(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelMessage)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(JTextFieldJudul, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonOK)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelMessage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JTextFieldJudul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonOK))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }

    private void jButtonOKActionPerformed1(ActionEvent evt) {
        String judul = JTextFieldJudul.getText();
        ArrayList<Buku> listBuku = Perpustakaan.controllerPencarian.cariBuku(judul);
        Perpustakaan.formPencarian.display(listBuku);
        dispose();
    }

    private void jButtonOKActionPerformed2(ActionEvent evt) {
        String judul = JTextFieldJudul.getText();
        Perpustakaan.peminjamanController.cariBuku(judul);
        dispose(); 
    } 
}
