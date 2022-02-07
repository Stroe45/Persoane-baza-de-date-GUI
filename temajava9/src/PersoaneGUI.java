import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;

public class PersoaneGUI extends javax.swing.JFrame {
    ListaPersoane listaPers=new ListaPersoane();


    public PersoaneGUI() {
        initComponents();

        refreshModel(listaPers.getAllPersoane());

        adaugareButon.addActionListener(Event->{
               DialogPersoane dlgPrsn=new DialogPersoane(this,true);
            dlgPrsn.setVisible(true);
            Persoana p=dlgPrsn.getPersoanaDeAdaugat();
            listaPers.adaugare(p);
            refreshModel(listaPers.getAllPersoane());
        });


        eliminareButon.addActionListener(ActionEvent->{listaPers.getAllPersoane().remove(jList1.getSelectedValue());
            refreshModel(listaPers.getAllPersoane());
        });
        golireButon.addActionListener(ActionEvent->{
            listaPers.getAllPersoane().clear();
            refreshModel(listaPers.getAllPersoane());
        });

        varstaButon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(descrescatorButon.isSelected()){
                    listaPers.getAllPersoane().sort(dupaVarstaDesc);
                    refreshModel(listaPers.getAllPersoane());
                }else{
                    listaPers.getAllPersoane().sort(dupaVarsta);
                    refreshModel(listaPers.getAllPersoane());
                }

            }
        });

        numeButon.addActionListener(ActionEvent->{
            if(descrescatorButon.isSelected()){
                listaPers.getAllPersoane().sort(dupaNumeDesc);
                refreshModel(listaPers.getAllPersoane());
            }else{
                listaPers.getAllPersoane().sort(dupaNume);
                refreshModel(listaPers.getAllPersoane());
            }
        });


      cautareTextField.addKeyListener(new KeyListener() {
          @Override
          public void keyTyped(KeyEvent e) {

          }

          @Override
          public void keyPressed(KeyEvent e) {

          }

          @Override
          public void keyReleased(KeyEvent e) {
              faramaTextuala(cautareTextField.getText());
              List<Persoana> persoaneDisplay=listaPers.getAllPersoane().stream()
                      .filter(p->p.hasFaramaTextuala(cautareTextField.getText()))
                      .collect(Collectors.toList());

          }
      });

      EditareButon.addActionListener(ActionEvent->{
          if(jList1.getSelectedIndex()>=0){
          decizieEditare();}
      });


    }




    //AICI E BUCATA DE COD CARE IMI DA PROBLEME

    private void decizieEditare(){
        DialogEditare dlgEdit=new DialogEditare(this,true);
        dlgEdit.setVisible(true);
        if(dlgEdit.getNumeDeEditat()==null&&dlgEdit.getVarstaDeEditat()!=null){
            jList1.getSelectedValue().setVarsta(Integer.parseInt(dlgEdit.getVarstaDeEditat()));
            refreshModel(listaPers.getAllPersoane());
        }
        if(dlgEdit.getVarstaDeEditat()==null&&dlgEdit.getNumeDeEditat()!=null){
            jList1.getSelectedValue().setNume(dlgEdit.getNumeDeEditat());
            refreshModel(listaPers.getAllPersoane());
        }
        if(dlgEdit.getVarstaDeEditat()!=null&&dlgEdit.getNumeDeEditat()!=null){
            jList1.getSelectedValue().setNume(dlgEdit.getNumeDeEditat());
            jList1.getSelectedValue().setVarsta(Integer.parseInt(dlgEdit.getVarstaDeEditat()));
            refreshModel(listaPers.getAllPersoane());
        }
    }



    //AICI SE TERMINA BUCATA DE COD


    private void faramaTextuala(String s){
        model.clear();
        for(Persoana p:listaPers.getAllPersoane()){
            if(p.getNume().startsWith(s)){
                model.addElement(p);
            }
        }
    }


    Comparator<Persoana> dupaNume=(p1, p2)->{return p1.getNume().compareToIgnoreCase(p2.getNume());};
    Comparator<Persoana> dupaVarsta=(p1,p2)->{return p1.getVarsta()-p2.getVarsta();};
    Comparator<Persoana> dupaNumeDesc=(p1,p2)->{return p2.getNume().compareToIgnoreCase(p1.getNume());};
    Comparator<Persoana> dupaVarstaDesc=(p1,p2)->{return p2.getVarsta()-p1.getVarsta();};




    private void refreshModel(List l){
        model.clear();
        for(Persoana pCurent:listaPers.getAllPersoane()){
            model.addElement(pCurent);
        }
    }





    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jPanel1 = new javax.swing.JPanel();
        numeButon = new javax.swing.JRadioButton();
        varstaButon = new javax.swing.JRadioButton();
        descrescatorButon = new javax.swing.JCheckBox();
        cautareTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        adaugareButon = new javax.swing.JButton();
        eliminareButon = new javax.swing.JButton();
        golireButon = new javax.swing.JButton();
        EditareButon = new javax.swing.JButton();

        bg.add(numeButon);
        bg.add(varstaButon);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);


        model=new DefaultListModel<>();
        jList1.setModel(model);


        jScrollPane1.setViewportView(jList1);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setName(""); // NOI18N

        numeButon.setText("Nume");

        varstaButon.setText("Varsta");

        descrescatorButon.setText("Descrescator");

        jLabel2.setText("Cautare:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(numeButon)
                                        .addComponent(varstaButon))
                                .addGap(34, 34, 34)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(cautareTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(descrescatorButon, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(59, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(numeButon)
                                        .addComponent(descrescatorButon))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(cautareTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2)
                                        .addComponent(varstaButon))
                                .addContainerGap(13, Short.MAX_VALUE))
        );

        jLabel1.setText("Cautare dupa:");

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        adaugareButon.setText("Adaugare");

        eliminareButon.setText("Eliminare");

        golireButon.setText("Golire");

        EditareButon.setText("Editare");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(adaugareButon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(eliminareButon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(golireButon, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                                        .addComponent(EditareButon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(68, 68, 68))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(adaugareButon)
                                        .addComponent(golireButon))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(eliminareButon)
                                        .addComponent(EditareButon))
                                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1)
                                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(3, 3, 3)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        jPanel1.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PersoaneGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PersoaneGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PersoaneGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PersoaneGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PersoaneGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JButton adaugareButon;
    private javax.swing.JTextField cautareTextField;
    private javax.swing.JCheckBox descrescatorButon;
    private javax.swing.JButton eliminareButon;
    private javax.swing.JButton EditareButon;
    private javax.swing.JButton golireButon;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JList<Persoana> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton numeButon;
    private javax.swing.JRadioButton varstaButon;
    private DefaultListModel <Persoana> model;
    private ButtonGroup bg=new ButtonGroup();
    // End of variables declaration
}
