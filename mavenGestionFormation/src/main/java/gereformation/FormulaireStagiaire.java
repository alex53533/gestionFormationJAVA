/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gereformation;

import java.awt.List;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author sdeniel
 */
public class FormulaireStagiaire extends javax.swing.JDialog {

    public FormulaireStagiaire(java.awt.Frame parent, boolean modal) throws SQLException {
        super(parent, modal);
        initComponents();
        
        // chargement des informations
        loadRecords();
    }

    // DEBUT PARTIE AJOUTEEE
    boolean addRecord = false;

    private void clearChampsDeSaisie() {
        txtIdStagiaire.setText("");
        txtNomStagiaire.setText(""); // setSelectedItem(""); pour du combobox
        txtPrenomStagiaire.setText("");
        txtAdresseStagiaire.setText("");
        txtVilleStagiaire.setText("");
        txtEmailStagiaire.setText("");
        txtTelephoneStagiaire.setText("");
    }

    private void addNew() throws SQLException {
        String sql_stmt = "INSERT INTO stagiaire (nom, prenom, adresse, ville, email, telephone)";
        sql_stmt += " VALUES ('" + txtNomStagiaire.getText() + "','" + txtPrenomStagiaire.getText() + "','" + txtAdresseStagiaire.getText() + "','" + txtVilleStagiaire.getText() + "','" + txtEmailStagiaire.getText() + "','" + txtTelephoneStagiaire.getText() + "')";

        JDBCConnect dbUtilities = new JDBCConnect();

        dbUtilities.ExecuteSQLStatement(sql_stmt);
    }

    private void updateRecord() throws SQLException {
        String sql_stmt = "UPDATE stagiaire SET nom = '" + txtNomStagiaire.getText() + "'";
        sql_stmt += ",prenom = '" + txtPrenomStagiaire.getText().toString() + "'";
        sql_stmt += ",adresse = '" + txtAdresseStagiaire.getText() + "'";
        sql_stmt += ",ville = '" + txtVilleStagiaire.getText() + "'";
        sql_stmt += ",email = '" + txtEmailStagiaire.getText() + "'";
        sql_stmt += ",telephone = '" + txtTelephoneStagiaire.getText() + "'";
        sql_stmt += " WHERE stagiaire_id = '" + txtIdStagiaire.getText() + "'"; //txtTelephoneStagiaire.getText()

        JDBCConnect dbUtilities = new JDBCConnect();

        dbUtilities.ExecuteSQLStatement(sql_stmt);
    }

    
    private void deleteRecord() throws SQLException {
        String sql_stmt = "DELETE FROM stagiaire WHERE stagiaire_id = '" + txtIdStagiaire.getText() + "'"; // txtEmployeeId.getText()

        JDBCConnect dbUtilities = new JDBCConnect();

        dbUtilities.ExecuteSQLStatement(sql_stmt);
    }
     
    private void loadRecords() throws SQLException {

        String sql_stmt = "SELECT * FROM stagiaire;";

        ResultSetTableModel tableModel = new ResultSetTableModel(sql_stmt);

        tableStagiaire.setModel(tableModel);

        tableStagiaire.getSelectionModel().addListSelectionListener((ListSelectionEvent event) -> {
            try {
                if (tableStagiaire.getSelectedRow() >= 0) {
                    Object idStagiaire = tableStagiaire.getValueAt(tableStagiaire.getSelectedRow(), 0);
                    Object nomStagiaire = tableStagiaire.getValueAt(tableStagiaire.getSelectedRow(), 1);
                    Object prenomStagiaire = tableStagiaire.getValueAt(tableStagiaire.getSelectedRow(), 2);
                    Object adresseStagiaire = tableStagiaire.getValueAt(tableStagiaire.getSelectedRow(), 3);
                    Object villeStagiaire = tableStagiaire.getValueAt(tableStagiaire.getSelectedRow(), 4);
                    Object emailStagiaire = tableStagiaire.getValueAt(tableStagiaire.getSelectedRow(), 5);
                    Object telephoneStagiaire = tableStagiaire.getValueAt(tableStagiaire.getSelectedRow(), 6);

                    txtIdStagiaire.setText(idStagiaire.toString());
                    txtNomStagiaire.setText(nomStagiaire.toString());
                    txtPrenomStagiaire.setText(prenomStagiaire.toString());
                    txtAdresseStagiaire.setText(adresseStagiaire.toString());
                    txtVilleStagiaire.setText(villeStagiaire.toString());
                    txtEmailStagiaire.setText(emailStagiaire.toString());
                    txtTelephoneStagiaire.setText(telephoneStagiaire.toString());
                }
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        });

        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(SwingConstants.LEFT);
        tableStagiaire.getColumnModel().getColumn(0).setCellRenderer(rightRenderer);
    }

    // FIN PARTIE AJOUTEE
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableStagiaire = new javax.swing.JTable();
        panelStagiaire = new javax.swing.JPanel();
        lblNomStagiaire = new javax.swing.JLabel();
        lblPrenomStagiaire = new javax.swing.JLabel();
        lblAdresseStagiaire = new javax.swing.JLabel();
        lblVilleStagiaire = new javax.swing.JLabel();
        lblEmailStagiaire = new javax.swing.JLabel();
        lblTelephoneStagiaire = new javax.swing.JLabel();
        txtNomStagiaire = new javax.swing.JTextField();
        txtPrenomStagiaire = new javax.swing.JTextField();
        txtAdresseStagiaire = new javax.swing.JTextField();
        txtVilleStagiaire = new javax.swing.JTextField();
        txtEmailStagiaire = new javax.swing.JTextField();
        txtTelephoneStagiaire = new javax.swing.JTextField();
        lblIdStagiaire = new javax.swing.JLabel();
        txtIdStagiaire = new javax.swing.JTextField();
        btnCreerStagiaire = new javax.swing.JButton();
        btnEditerStagiaire = new javax.swing.JButton();
        btnSupprimerStagiaire = new javax.swing.JButton();
        btnFermerStagiaire = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        nomResultat = new javax.swing.JTextField();
        prenomResultat = new javax.swing.JTextField();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        cbResultat = new javax.swing.JComboBox<>();
        jButton10 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        panelFormation1 = new javax.swing.JPanel();
        lblNomStagiaire1 = new javax.swing.JLabel();
        lblPrenomStagiaire1 = new javax.swing.JLabel();
        lblAdresseStagiaire1 = new javax.swing.JLabel();
        lblVilleStagiaire1 = new javax.swing.JLabel();
        lblEmailStagiaire1 = new javax.swing.JLabel();
        lblTelephoneStagiaire1 = new javax.swing.JLabel();
        txtNomStagiaire1 = new javax.swing.JTextField();
        txtPrenomStagiaire1 = new javax.swing.JTextField();
        txtAdresseStagiaire1 = new javax.swing.JTextField();
        txtVilleStagiaire1 = new javax.swing.JTextField();
        txtEmailStagiaire1 = new javax.swing.JTextField();
        lblIdStagiaire1 = new javax.swing.JLabel();
        txtIdStagiaire1 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        btnCreerStagiaire1 = new javax.swing.JButton();
        btnEditerStagiaire1 = new javax.swing.JButton();
        btnSupprimerStagiaire1 = new javax.swing.JButton();
        btnFermerStagiaire1 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTablemodules = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        libelleModule = new javax.swing.JTextField();
        descriptionModule = new javax.swing.JTextField();
        dureeModule = new javax.swing.JTextField();
        btnEnvoiModule = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        nomECF = new javax.swing.JTextField();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        cbModule = new javax.swing.JComboBox<>();
        jButton13 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tableStagiaire.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tableStagiaire);

        panelStagiaire.setBorder(javax.swing.BorderFactory.createTitledBorder("Formulaire Stagiaire"));

        lblNomStagiaire.setText("Nom");

        lblPrenomStagiaire.setText("Prenom");

        lblAdresseStagiaire.setText("Adresse");

        lblVilleStagiaire.setText("Ville");

        lblEmailStagiaire.setText("E-mail");

        lblTelephoneStagiaire.setText("Téléphone");

        txtAdresseStagiaire.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAdresseStagiaireActionPerformed(evt);
            }
        });

        txtEmailStagiaire.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailStagiaireActionPerformed(evt);
            }
        });

        lblIdStagiaire.setText("ID Stagiaire");

        txtIdStagiaire.setEnabled(false);
        txtIdStagiaire.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdStagiaireActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelStagiaireLayout = new javax.swing.GroupLayout(panelStagiaire);
        panelStagiaire.setLayout(panelStagiaireLayout);
        panelStagiaireLayout.setHorizontalGroup(
            panelStagiaireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelStagiaireLayout.createSequentialGroup()
                .addGroup(panelStagiaireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelStagiaireLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(panelStagiaireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panelStagiaireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(panelStagiaireLayout.createSequentialGroup()
                                    .addGroup(panelStagiaireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblVilleStagiaire)
                                        .addComponent(lblAdresseStagiaire)
                                        .addComponent(lblPrenomStagiaire)
                                        .addComponent(lblNomStagiaire))
                                    .addGap(82, 82, 82)
                                    .addGroup(panelStagiaireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(panelStagiaireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(txtNomStagiaire, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                                            .addComponent(txtPrenomStagiaire, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtVilleStagiaire))
                                        .addComponent(txtAdresseStagiaire, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(panelStagiaireLayout.createSequentialGroup()
                                    .addComponent(lblEmailStagiaire)
                                    .addGap(96, 96, 96)
                                    .addComponent(txtEmailStagiaire, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelStagiaireLayout.createSequentialGroup()
                                .addComponent(lblTelephoneStagiaire)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtTelephoneStagiaire, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panelStagiaireLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblIdStagiaire)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtIdStagiaire, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(132, Short.MAX_VALUE))
        );
        panelStagiaireLayout.setVerticalGroup(
            panelStagiaireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelStagiaireLayout.createSequentialGroup()
                .addGroup(panelStagiaireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelStagiaireLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(txtNomStagiaire, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelStagiaireLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblNomStagiaire)))
                .addGap(18, 18, 18)
                .addGroup(panelStagiaireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPrenomStagiaire, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelStagiaireLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(lblPrenomStagiaire)
                        .addGap(18, 18, 18)
                        .addGroup(panelStagiaireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblAdresseStagiaire)
                            .addComponent(txtAdresseStagiaire, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(panelStagiaireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtVilleStagiaire, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblVilleStagiaire))
                .addGap(18, 18, 18)
                .addGroup(panelStagiaireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmailStagiaire)
                    .addComponent(txtEmailStagiaire, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelStagiaireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTelephoneStagiaire, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTelephoneStagiaire))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelStagiaireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblIdStagiaire)
                    .addComponent(txtIdStagiaire, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnCreerStagiaire.setText("Créer ligne");
        btnCreerStagiaire.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreerStagiaireActionPerformed(evt);
            }
        });

        btnEditerStagiaire.setText("Editer ligne");
        btnEditerStagiaire.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditerStagiaireActionPerformed(evt);
            }
        });

        btnSupprimerStagiaire.setText("Supprimer");
        btnSupprimerStagiaire.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSupprimerStagiaireActionPerformed(evt);
            }
        });

        btnFermerStagiaire.setText("Fermer");
        btnFermerStagiaire.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFermerStagiaireActionPerformed(evt);
            }
        });

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Editer un résultat"));

        jLabel17.setText("Nom");

        jLabel18.setText("Prénom");

        jLabel19.setText("ECF");

        jLabel20.setText("Résultat");

        jButton4.setText("Envoyer");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Annuler");

        nomResultat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomResultatActionPerformed(evt);
            }
        });

        prenomResultat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prenomResultatActionPerformed(evt);
            }
        });

        jRadioButton1.setText("Acquis");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        jRadioButton2.setText("Non acquis");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        jRadioButton3.setText("En cours d'acquisition");
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });

        cbResultat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbResultatActionPerformed(evt);
            }
        });

        jButton10.setText("Modifier");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addComponent(jLabel18)
                            .addComponent(jLabel19)
                            .addComponent(jLabel20)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addComponent(jButton4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jButton10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5))
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(prenomResultat, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(nomResultat)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                            .addComponent(jRadioButton1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jRadioButton2)
                            .addGap(0, 0, Short.MAX_VALUE))
                        .addComponent(cbResultat, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(nomResultat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(prenomResultat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(cbResultat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2)
                    .addComponent(jRadioButton3))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jButton5)
                    .addComponent(jButton10))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(btnCreerStagiaire)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEditerStagiaire)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSupprimerStagiaire)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnFermerStagiaire)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(panelStagiaire, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 547, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelStagiaire, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCreerStagiaire)
                    .addComponent(btnEditerStagiaire)
                    .addComponent(btnSupprimerStagiaire)
                    .addComponent(btnFermerStagiaire)))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Edit Stagiaire", jPanel1);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        panelFormation1.setBorder(javax.swing.BorderFactory.createTitledBorder("Formulaire Formation"));

        lblNomStagiaire1.setText("Libellé");

        lblPrenomStagiaire1.setText("Description");

        lblAdresseStagiaire1.setText("Volume horaire");

        lblVilleStagiaire1.setText("Lieu");

        lblEmailStagiaire1.setText("Date début");

        lblTelephoneStagiaire1.setText("fomateur");

        txtAdresseStagiaire1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAdresseStagiaire1ActionPerformed(evt);
            }
        });

        txtEmailStagiaire1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailStagiaire1ActionPerformed(evt);
            }
        });

        lblIdStagiaire1.setText("ID Formation");

        txtIdStagiaire1.setEnabled(false);
        txtIdStagiaire1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdStagiaire1ActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout panelFormation1Layout = new javax.swing.GroupLayout(panelFormation1);
        panelFormation1.setLayout(panelFormation1Layout);
        panelFormation1Layout.setHorizontalGroup(
            panelFormation1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFormation1Layout.createSequentialGroup()
                .addGroup(panelFormation1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelFormation1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelFormation1Layout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addGroup(panelFormation1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(panelFormation1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(panelFormation1Layout.createSequentialGroup()
                                        .addGroup(panelFormation1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblVilleStagiaire1)
                                            .addComponent(lblAdresseStagiaire1)
                                            .addComponent(lblPrenomStagiaire1)
                                            .addComponent(lblNomStagiaire1))
                                        .addGap(82, 82, 82)
                                        .addGroup(panelFormation1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(panelFormation1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(txtNomStagiaire1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                                                .addComponent(txtPrenomStagiaire1, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txtVilleStagiaire1))
                                            .addComponent(txtAdresseStagiaire1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(panelFormation1Layout.createSequentialGroup()
                                        .addComponent(lblEmailStagiaire1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtEmailStagiaire1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addComponent(lblTelephoneStagiaire1)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFormation1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelFormation1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblIdStagiaire1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtIdStagiaire1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelFormation1Layout.setVerticalGroup(
            panelFormation1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFormation1Layout.createSequentialGroup()
                .addGroup(panelFormation1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelFormation1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(txtNomStagiaire1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFormation1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblNomStagiaire1)))
                .addGap(18, 18, 18)
                .addGroup(panelFormation1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPrenomStagiaire1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelFormation1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(lblPrenomStagiaire1)
                        .addGap(18, 18, 18)
                        .addGroup(panelFormation1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblAdresseStagiaire1)
                            .addComponent(txtAdresseStagiaire1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(panelFormation1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtVilleStagiaire1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblVilleStagiaire1))
                .addGap(18, 18, 18)
                .addGroup(panelFormation1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtEmailStagiaire1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEmailStagiaire1))
                .addGap(19, 19, 19)
                .addGroup(panelFormation1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTelephoneStagiaire1)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelFormation1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIdStagiaire1)
                    .addComponent(txtIdStagiaire1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnCreerStagiaire1.setText("Créer ligne");
        btnCreerStagiaire1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreerStagiaire1ActionPerformed(evt);
            }
        });

        btnEditerStagiaire1.setText("Editer ligne");
        btnEditerStagiaire1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditerStagiaire1ActionPerformed(evt);
            }
        });

        btnSupprimerStagiaire1.setText("Supprimer");
        btnSupprimerStagiaire1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSupprimerStagiaire1ActionPerformed(evt);
            }
        });

        btnFermerStagiaire1.setText("Fermer");
        btnFermerStagiaire1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFermerStagiaire1ActionPerformed(evt);
            }
        });

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Modules"));

        jButton1.setText("Rapport ECF");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTablemodules.setAutoCreateRowSorter(true);
        jTablemodules.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Libellé", "Description", "Durée"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTablemodules.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jTablemodulesPropertyChange(evt);
            }
        });
        jScrollPane4.setViewportView(jTablemodules);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("Formulaires modules")));

        jLabel22.setText("Libelle");

        jLabel23.setText("Description");

        jLabel24.setText("Durée");

        libelleModule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                libelleModuleActionPerformed(evt);
            }
        });

        descriptionModule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                descriptionModuleActionPerformed(evt);
            }
        });

        dureeModule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dureeModuleActionPerformed(evt);
            }
        });

        btnEnvoiModule.setText("Ajouter");
        btnEnvoiModule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnvoiModuleActionPerformed(evt);
            }
        });

        jButton7.setText("Annuler");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton12.setText("Modifier");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel23)
                            .addComponent(jLabel24)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(btnEnvoiModule)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jButton12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton7)
                                .addContainerGap())
                            .addComponent(libelleModule)
                            .addComponent(descriptionModule)
                            .addComponent(dureeModule, javax.swing.GroupLayout.Alignment.TRAILING)))))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(libelleModule, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(descriptionModule, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(dureeModule, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEnvoiModule)
                    .addComponent(jButton7)
                    .addComponent(jButton12))
                .addGap(39, 39, 39))
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder("Formulaire ECFs"));

        jLabel26.setText("Nom");

        jLabel27.setText("Module");

        nomECF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomECFActionPerformed(evt);
            }
        });

        jButton8.setText("Ajouter");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setText("Annuler");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        cbModule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbModuleActionPerformed(evt);
            }
        });

        jButton13.setText("Modifier");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel26)
                            .addComponent(jLabel27))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nomECF)
                            .addComponent(cbModule, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton9)))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(nomECF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(cbModule, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton8)
                    .addComponent(jButton9)
                    .addComponent(jButton13))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(panelFormation1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(btnCreerStagiaire1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEditerStagiaire1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSupprimerStagiaire1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnFermerStagiaire1)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(3, 3, 3)
                                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(panelFormation1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCreerStagiaire1)
                            .addComponent(btnEditerStagiaire1)
                            .addComponent(btnSupprimerStagiaire1)
                            .addComponent(btnFermerStagiaire1)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 208, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        panelFormation1.getAccessibleContext().setAccessibleName("Formulaire Formation");

        jTabbedPane1.addTab("Edit Formation", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 621, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFermerStagiaireActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFermerStagiaireActionPerformed
        System.exit(1);
    }//GEN-LAST:event_btnFermerStagiaireActionPerformed

    private void btnSupprimerStagiaireActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSupprimerStagiaireActionPerformed
        int dialogResult = JOptionPane.showConfirmDialog(null, "Souhaitez vous supprimer ce stagiaire ?", "Confirmation de suppression ?", JOptionPane.YES_NO_OPTION);

        if (dialogResult == JOptionPane.YES_OPTION) {
            try {
                deleteRecord();

                loadRecords();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }//GEN-LAST:event_btnSupprimerStagiaireActionPerformed

    private void btnEditerStagiaireActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditerStagiaireActionPerformed
        int dialogResult = JOptionPane.showConfirmDialog(null, "Voulez vous éditer ce stagiaire ?", "Confirmer la sauvegarde d'édition ?", JOptionPane.YES_NO_OPTION);

        if (dialogResult == JOptionPane.YES_OPTION) {
            try {
                if (addRecord == true) {
                    addNew();
                } else {
                    updateRecord();
                }

                addRecord = false;

                loadRecords();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }//GEN-LAST:event_btnEditerStagiaireActionPerformed

    private void btnCreerStagiaireActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreerStagiaireActionPerformed
        try {
            int dialogResult = JOptionPane.showConfirmDialog(null, "Voulez vous ajouter ce stagiaire ?", "Confirmer l'enregistrement ?", JOptionPane.YES_NO_OPTION);
            addNew();
            loadRecords();
            clearChampsDeSaisie(); // on efface les champs avant de créer un nouveau stagiaire
            txtNomStagiaire.requestFocus(); // permet de positionner le curseur sur le 1er champs de saisie (ici Nom)
        } catch (SQLException ex) {
            Logger.getLogger(FormulaireStagiaire.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnCreerStagiaireActionPerformed

    private void txtIdStagiaireActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdStagiaireActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdStagiaireActionPerformed

    private void txtEmailStagiaireActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailStagiaireActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailStagiaireActionPerformed

    private void txtAdresseStagiaireActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAdresseStagiaireActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAdresseStagiaireActionPerformed

    private void txtAdresseStagiaire1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAdresseStagiaire1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAdresseStagiaire1ActionPerformed

    private void txtEmailStagiaire1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailStagiaire1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailStagiaire1ActionPerformed

    private void txtIdStagiaire1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdStagiaire1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdStagiaire1ActionPerformed

    private void btnCreerStagiaire1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreerStagiaire1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCreerStagiaire1ActionPerformed

    private void btnEditerStagiaire1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditerStagiaire1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEditerStagiaire1ActionPerformed

    private void btnSupprimerStagiaire1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSupprimerStagiaire1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSupprimerStagiaire1ActionPerformed

    private void btnFermerStagiaire1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFermerStagiaire1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnFermerStagiaire1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTablemodulesPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jTablemodulesPropertyChange
        // TODO add your handling code here:

    }//GEN-LAST:event_jTablemodulesPropertyChange

    private void libelleModuleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_libelleModuleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_libelleModuleActionPerformed

    private void descriptionModuleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_descriptionModuleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_descriptionModuleActionPerformed

    private void dureeModuleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dureeModuleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dureeModuleActionPerformed

    private void btnEnvoiModuleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnvoiModuleActionPerformed
        String libelle = libelleModule.getText();
        String description = descriptionModule.getText();

        String fon = dureeModule.getText();
        int duree;
        duree = Integer.parseInt(fon);

      //  Module m = new Module(libelle, description, duree);
       // ModuleDAO.save(m);

        // TODO add your handling code here:
    }//GEN-LAST:event_btnEnvoiModuleActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void nomECFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomECFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomECFActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton9ActionPerformed

    private void cbModuleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbModuleActionPerformed
        // TODO add your handling code here:
       // List<Module> Module = ModuleDAO.findAll();
        //for(int i=0;i<Module.size();i++){
         //   cbModule.addItem(Module.get(i).getNom());
       // }
    }//GEN-LAST:event_cbModuleActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void nomResultatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomResultatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomResultatActionPerformed

    private void prenomResultatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prenomResultatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_prenomResultatActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton3ActionPerformed

    private void cbResultatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbResultatActionPerformed
        // TODO add your handling code here:
        //List<Ecf> ECF = ECFDAO.findAll();
       // for(int i=0;i<ECF.size();i++){
       //     cbResultat.addItem(ECF.get(i).getNom());
      //  }

    }//GEN-LAST:event_cbResultatActionPerformed

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
            java.util.logging.Logger.getLogger(FormulaireStagiaire.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormulaireStagiaire.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormulaireStagiaire.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormulaireStagiaire.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FormulaireStagiaire dialog = new FormulaireStagiaire(new javax.swing.JFrame(), true);
                    dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                        @Override
                        public void windowClosing(java.awt.event.WindowEvent e) {
                            System.exit(0);
                        }
                    });
                    dialog.setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(FormulaireStagiaire.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreerStagiaire;
    private javax.swing.JButton btnCreerStagiaire1;
    private javax.swing.JButton btnEditerStagiaire;
    private javax.swing.JButton btnEditerStagiaire1;
    private javax.swing.JButton btnEnvoiModule;
    private javax.swing.JButton btnFermerStagiaire;
    private javax.swing.JButton btnFermerStagiaire1;
    private javax.swing.JButton btnSupprimerStagiaire;
    private javax.swing.JButton btnSupprimerStagiaire1;
    private javax.swing.JComboBox<String> cbModule;
    private javax.swing.JComboBox<String> cbResultat;
    private javax.swing.JTextField descriptionModule;
    private javax.swing.JTextField dureeModule;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTablemodules;
    private javax.swing.JLabel lblAdresseStagiaire;
    private javax.swing.JLabel lblAdresseStagiaire1;
    private javax.swing.JLabel lblEmailStagiaire;
    private javax.swing.JLabel lblEmailStagiaire1;
    private javax.swing.JLabel lblIdStagiaire;
    private javax.swing.JLabel lblIdStagiaire1;
    private javax.swing.JLabel lblNomStagiaire;
    private javax.swing.JLabel lblNomStagiaire1;
    private javax.swing.JLabel lblPrenomStagiaire;
    private javax.swing.JLabel lblPrenomStagiaire1;
    private javax.swing.JLabel lblTelephoneStagiaire;
    private javax.swing.JLabel lblTelephoneStagiaire1;
    private javax.swing.JLabel lblVilleStagiaire;
    private javax.swing.JLabel lblVilleStagiaire1;
    private javax.swing.JTextField libelleModule;
    private javax.swing.JTextField nomECF;
    private javax.swing.JTextField nomResultat;
    private javax.swing.JPanel panelFormation1;
    private javax.swing.JPanel panelStagiaire;
    private javax.swing.JTextField prenomResultat;
    private javax.swing.JTable tableStagiaire;
    private javax.swing.JTextField txtAdresseStagiaire;
    private javax.swing.JTextField txtAdresseStagiaire1;
    private javax.swing.JTextField txtEmailStagiaire;
    private javax.swing.JTextField txtEmailStagiaire1;
    private javax.swing.JTextField txtIdStagiaire;
    private javax.swing.JTextField txtIdStagiaire1;
    private javax.swing.JTextField txtNomStagiaire;
    private javax.swing.JTextField txtNomStagiaire1;
    private javax.swing.JTextField txtPrenomStagiaire;
    private javax.swing.JTextField txtPrenomStagiaire1;
    private javax.swing.JTextField txtTelephoneStagiaire;
    private javax.swing.JTextField txtVilleStagiaire;
    private javax.swing.JTextField txtVilleStagiaire1;
    // End of variables declaration//GEN-END:variables
}
