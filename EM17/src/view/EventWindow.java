package view;

import dao.mysql.EventDAO;
import com.toedter.calendar.JDateChooser;
import java.util.ArrayList;
import model.Event;
import control.EventController;
import java.text.ParseException;
import java.util.Locale;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;


public class EventWindow extends javax.swing.JFrame {
    private DefaultTableModel defaultTableModel;
    private DefaultTableModel defaultTableModelSearch;
    private EventController controller;
    public EventWindow() {
        
        initComponents();
        setUpJTableModel();
        setUpJTableModelSearch();
        idField.setVisible(false);
        dateTableField.setVisible(false);
        deleteButton.setEnabled(false);
        updateButton.setEnabled(false);
        controller = new EventController(this);
        
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabPanel = new javax.swing.JTabbedPane();
        eventPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        titleField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        positionField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cityField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        priceField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        ticketsField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        descriptionField = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();
        typeField = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        imgButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        eventTable = new javax.swing.JTable();
        insertButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        idField = new javax.swing.JTextField();
        dateField = new com.toedter.calendar.JDateChooser();
        MaskFormatter mask = null;
        try {
            mask = new MaskFormatter("##:##");//the # is for numeric values
            //mask.setPlaceholderCharacter('#');
        } catch (ParseException e) {
            e.printStackTrace();
        }

        //
        hourField = new javax.swing.JFormattedTextField(mask);
        jLabel14 = new javax.swing.JLabel();
        labelFile = new javax.swing.JLabel();
        dateTableField = new javax.swing.JTextField();
        filterPanel = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        eventFilteredTable = new javax.swing.JTable();
        typeSearchField = new javax.swing.JComboBox<>();
        citySearchField = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        eventPanel.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("TITOLO");

        jLabel2.setText("LUOGO");

        jLabel3.setText("CITTA'");

        jLabel4.setText("DATA");

        jLabel5.setText("ORARIO");

        jLabel6.setText("COSTO");

        jLabel7.setText("BIGLIETTI TOTALI");

        jLabel8.setText("DESCRIZIONE");

        descriptionField.setColumns(20);
        descriptionField.setRows(5);
        jScrollPane1.setViewportView(descriptionField);

        jLabel9.setText("TIPOLOGIA");

        String[] type = new String[] {"Concerto", "Mostra", "Spettacolo", "Teatro"};
        typeField.setModel(new javax.swing.DefaultComboBoxModel<>(type));

        jLabel10.setText("LOCANDINA");

        imgButton.setText("Seleziona");
        imgButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imgButtonActionPerformed(evt);
            }
        });

        eventTable.setModel(new javax.swing.table.DefaultTableModel(
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
        eventTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                eventTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(eventTable);

        insertButton.setText("INSERISCI");
        insertButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertButtonActionPerformed(evt);
            }
        });

        updateButton.setText("MODIFICA");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        deleteButton.setText("ELIMINA");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        dateField.setLocale(Locale.ITALIAN);
        dateField.setBackground(new java.awt.Color(255, 255, 255));

        labelFile.setText(" ");

        javax.swing.GroupLayout eventPanelLayout = new javax.swing.GroupLayout(eventPanel);
        eventPanel.setLayout(eventPanelLayout);
        eventPanelLayout.setHorizontalGroup(
            eventPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(eventPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(eventPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(eventPanelLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(84, 84, 84)
                        .addComponent(jLabel2))
                    .addGroup(eventPanelLayout.createSequentialGroup()
                        .addGroup(eventPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(titleField, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(eventPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(positionField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)))
                    .addGroup(eventPanelLayout.createSequentialGroup()
                        .addComponent(ticketsField, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(typeField, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(eventPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(eventPanelLayout.createSequentialGroup()
                        .addGroup(eventPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addGroup(eventPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(imgButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                .addComponent(cityField, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)))
                        .addGap(18, 18, 18))
                    .addGroup(eventPanelLayout.createSequentialGroup()
                        .addComponent(labelFile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(78, 78, 78)))
                .addGroup(eventPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addGroup(eventPanelLayout.createSequentialGroup()
                        .addGroup(eventPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(eventPanelLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(91, 91, 91)
                                .addComponent(jLabel5))
                            .addGroup(eventPanelLayout.createSequentialGroup()
                                .addComponent(dateField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(hourField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(eventPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(priceField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(46, Short.MAX_VALUE))
            .addComponent(jScrollPane2)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, eventPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(dateTableField, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(insertButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(updateButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(deleteButton)
                .addContainerGap())
        );
        eventPanelLayout.setVerticalGroup(
            eventPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(eventPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(eventPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(eventPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(eventPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(titleField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(positionField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cityField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(priceField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(hourField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(dateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(eventPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(eventPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(eventPanelLayout.createSequentialGroup()
                        .addGroup(eventPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ticketsField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(typeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(imgButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(eventPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(labelFile)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(eventPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(insertButton)
                    .addComponent(updateButton)
                    .addComponent(deleteButton)
                    .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateTableField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        tabPanel.addTab("Eventi", eventPanel);

        filterPanel.setBackground(new java.awt.Color(255, 255, 255));

        eventFilteredTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(eventFilteredTable);

        String[] typeSearch = new String[] {"-", "Concerto", "Mostra", "Spettacolo", "Teatro"};
        typeSearchField.setModel(new javax.swing.DefaultComboBoxModel<>(typeSearch));
        typeSearchField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                typeSearchFieldActionPerformed(evt);
            }
        });

        ArrayList<String> city = controller.getCityEvent();
        String[] città = new String[city.size()+1];
        città[0] = "-";
        for (int i=1; i<city.size()+1; i++)
        città[i] = city.get(i-1);
        citySearchField.setModel(new javax.swing.DefaultComboBoxModel<>(città));
        citySearchField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                citySearchFieldActionPerformed(evt);
            }
        });

        jLabel11.setText("FILTRA PER");

        jLabel12.setText("TIPOLOGIA");

        jLabel13.setText("CITTA'");

        javax.swing.GroupLayout filterPanelLayout = new javax.swing.GroupLayout(filterPanel);
        filterPanel.setLayout(filterPanelLayout);
        filterPanelLayout.setHorizontalGroup(
            filterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3)
            .addGroup(filterPanelLayout.createSequentialGroup()
                .addGap(185, 185, 185)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(filterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(typeSearchField, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(filterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(citySearchField, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(210, Short.MAX_VALUE))
        );
        filterPanelLayout.setVerticalGroup(
            filterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, filterPanelLayout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addGroup(filterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(filterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(typeSearchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(citySearchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 115, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        tabPanel.addTab("Filtra", filterPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabPanel)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabPanel)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void insertButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertButtonActionPerformed
        controller.insertEvent();
    }//GEN-LAST:event_insertButtonActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        controller.updateEvent();
    }//GEN-LAST:event_updateButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        controller.deleteEvent();
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void imgButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imgButtonActionPerformed
        controller.chooseFile();
    }//GEN-LAST:event_imgButtonActionPerformed

    private void eventTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eventTableMouseClicked
        //JTable table = view.getEventTable();
                int row = eventTable.rowAtPoint(evt.getPoint());
                //System.out.println(table.getValueAt(row, 6).toString().length());
                updateButton.setEnabled(true);
                if(eventTable.getValueAt(row, 9).toString().equals("0"))
                {
                    deleteButton.setEnabled(true);
                }else 
                {
                    deleteButton.setEnabled(false);
                }
                
                getIdField().setText(eventTable.getValueAt(row, 0).toString());
                
                if(eventTable.getValueAt(row, 1) != null)
                {
                    getTitleField().setText(eventTable.getValueAt(row, 1).toString());
                } else 
                {
                    getTitleField().setText("");
                }
                String[] type = {"Concerto", "Mostra", "Spettacolo", "Teatro"};
                for (int i = 0; i<type.length; i++)
                {
                    if (eventTable.getValueAt(row, 2).toString().equals(type[i]))
                    getTypeField().setSelectedIndex(i); 
                }
                
                if(eventTable.getValueAt(row, 3) != null)
                {
                    getPositionField().setText(eventTable.getValueAt(row, 3).toString());
                } else 
                {
                    getPositionField().setText("");
                }
                if(eventTable.getValueAt(row, 4) != null)
                {
                    getCityField().setText(eventTable.getValueAt(row, 4).toString());
                } else 
                {
                    getCityField().setText("");
                }
                if(eventTable.getValueAt(row, 5) != null)
                {
                    getDateTableField().setText(eventTable.getValueAt(row, 5).toString());
                } else 
                {
                    getDateTableField().setText("");
                }
                if(eventTable.getValueAt(row, 6) != null)
                {
                    getHourField().setText(eventTable.getValueAt(row, 6).toString());
                } else 
                {
                    getHourField().setText("");
                }
                if(eventTable.getValueAt(row, 7) != null)
                {
                    getPriceField().setText(eventTable.getValueAt(row, 7).toString());
                } else 
                {
                    getPriceField().setText("");
                }
                if(eventTable.getValueAt(row, 8) != null)
                {
                    getTicketsAvaibleField().setText(eventTable.getValueAt(row, 8).toString());
                } else 
                {
                    getTicketsAvaibleField().setText("");
                }
                if(eventTable.getValueAt(row, 10) != null)
                {
                    getDescriptionField().setText(eventTable.getValueAt(row, 10).toString());
                } else 
                {
                    getDescriptionField().setText("");
                }
    }//GEN-LAST:event_eventTableMouseClicked

    private void typeSearchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_typeSearchFieldActionPerformed
        controller.filter();
    }//GEN-LAST:event_typeSearchFieldActionPerformed

    private void citySearchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_citySearchFieldActionPerformed
       controller.filter();
    }//GEN-LAST:event_citySearchFieldActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cityField;
    private javax.swing.JComboBox<String> citySearchField;
    private com.toedter.calendar.JDateChooser dateField;
    private javax.swing.JTextField dateTableField;
    private javax.swing.JButton deleteButton;
    private javax.swing.JTextArea descriptionField;
    private javax.swing.JTable eventFilteredTable;
    private javax.swing.JPanel eventPanel;
    private javax.swing.JTable eventTable;
    private javax.swing.JPanel filterPanel;
    private javax.swing.JFormattedTextField hourField;
    private javax.swing.JTextField idField;
    private javax.swing.JButton imgButton;
    private javax.swing.JButton insertButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel labelFile;
    private javax.swing.JTextField positionField;
    private javax.swing.JTextField priceField;
    private javax.swing.JTabbedPane tabPanel;
    private javax.swing.JTextField ticketsField;
    private javax.swing.JTextField titleField;
    private javax.swing.JComboBox<String> typeField;
    private javax.swing.JComboBox<String> typeSearchField;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
    public final void setUpJTableModel() {
        defaultTableModel = new DefaultTableModel();
        eventTable.setModel(defaultTableModel);
        defaultTableModel.addColumn("ID");
        defaultTableModel.addColumn("TITOLO");
        defaultTableModel.addColumn("TIPOLOGIA");
        defaultTableModel.addColumn("LUOGO");
        defaultTableModel.addColumn("CITTA'");
        defaultTableModel.addColumn("DATA");
        defaultTableModel.addColumn("ORARIO");
        defaultTableModel.addColumn("COSTO");
        defaultTableModel.addColumn("BIGLIETTI TOTALI");
        defaultTableModel.addColumn("BIGLIETTI VENDUTI");
        defaultTableModel.addColumn("DESCRIZIONE");
        DefaultCellEditor editor = (DefaultCellEditor) eventTable.getDefaultEditor(Object.class);      
        editor.setClickCountToStart(1000000);        
        refreshTable();
        
    }
    
    public final void setUpJTableModelSearch() {
        defaultTableModelSearch = new DefaultTableModel();
        eventFilteredTable.setModel(defaultTableModelSearch);
        defaultTableModelSearch.addColumn("ID");
        defaultTableModelSearch.addColumn("TITOLO");
        defaultTableModelSearch.addColumn("TIPOLOGIA");
        defaultTableModelSearch.addColumn("LUOGO");
        defaultTableModelSearch.addColumn("CITTA'");
        defaultTableModelSearch.addColumn("DATA");
        defaultTableModelSearch.addColumn("ORARIO");
        defaultTableModelSearch.addColumn("COSTO");
        defaultTableModelSearch.addColumn("BIGLIETTI TOTALI");
        defaultTableModelSearch.addColumn("BIGLIETTI VENDUTI");
        defaultTableModelSearch.addColumn("DESCRIZIONE");
        DefaultCellEditor editor = (DefaultCellEditor) eventFilteredTable.getDefaultEditor(Object.class);      
        editor.setClickCountToStart(1000000);        
        refreshTableS();
        
    }
    
    
    public void refreshTable() {

        defaultTableModel.getDataVector().clear();

        ArrayList<Event> eventi = controller.refreshRecord();

        eventi.stream().forEach((currentEvent) -> {
            defaultTableModel.addRow(new Object[]{currentEvent.getId(), currentEvent.getTitle(), currentEvent.getType(), currentEvent.getPosition(), currentEvent.getCity(), currentEvent.getDate(), currentEvent.getHour(), currentEvent.getPrice(), currentEvent.getTicketsAvaible(), currentEvent.getTicketsSell(), currentEvent.getDescription()});
        });
        defaultTableModel.fireTableDataChanged();
    }
    
    public void refreshTableS() {

        defaultTableModelSearch.getDataVector().clear();

        ArrayList<Event> eventi = controller.refreshRecord();

        eventi.stream().forEach((currentEvent) -> {
            defaultTableModelSearch.addRow(new Object[]{currentEvent.getId(), currentEvent.getTitle(), currentEvent.getType(), currentEvent.getPosition(), currentEvent.getCity(), currentEvent.getDate(), currentEvent.getHour(), currentEvent.getPrice(), currentEvent.getTicketsAvaible(), currentEvent.getTicketsSell(), currentEvent.getDescription()});
        });
        defaultTableModelSearch.fireTableDataChanged();
    }
    
    public void refreshTableSearch(ArrayList<Event> eventi) {

        defaultTableModelSearch.getDataVector().clear();

        eventi.stream().forEach((currentEvent) -> {
            defaultTableModelSearch.addRow(new Object[]{currentEvent.getId(), currentEvent.getTitle(), currentEvent.getType(), currentEvent.getPosition(), currentEvent.getCity(), currentEvent.getDate(), currentEvent.getHour(), currentEvent.getPrice(), currentEvent.getTicketsAvaible(), currentEvent.getTicketsSell(), currentEvent.getDescription()});
        });
        defaultTableModelSearch.fireTableDataChanged();
    }
    
    public JTextField getIdField()
    {
        return idField;
    }

    public JTextField getTitleField()
    {
        return titleField;
    }
    public JTextField getPositionField()
    {
        return positionField;
    }
    
    public JTextField getCityField()
    {
        return cityField;
    }
    
    public JTextField getPriceField()
    {
        return priceField;
    }
    public JTextField getTicketsAvaibleField()
    {
        return ticketsField;
    }
    public JTextField getDateTableField()
    {
        return dateTableField;
    }
    public JLabel getLabelFile()
    {
        return labelFile;
    }
    public JTextArea getDescriptionField()
    {
        return descriptionField;
    }
    public JFormattedTextField getHourField()
    {
        return hourField;
    }
    public JDateChooser getDateField()
    {
        return dateField;
    }
    public JComboBox getTypeField()
    {
        return typeField;
    }
    
    public JButton getChooseImgButton()
    {
        return imgButton;
    }
    public JButton getInsertButton()
    {
        return insertButton;
    }
    public JButton getUpdateButton()
    {
        return updateButton;
    }
    public JButton getDeleteButton()
    {
        return deleteButton;
    }
    public JTable getEventTable()
    {
        return eventTable;
    }
    public JComboBox getTypeSearchField()
    {
        return typeSearchField;
    }
    public JComboBox getCitySearchField()
    {
        return citySearchField;
    }
}
