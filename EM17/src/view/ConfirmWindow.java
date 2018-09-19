package view;

import control.DeleteController;
import javax.swing.JButton;
import javax.swing.JLabel;
import model.Event;

public class ConfirmWindow extends javax.swing.JDialog {
    Event evento;
    DeleteController controller;
    public ConfirmWindow(EventWindow parent, boolean modal, Event e) {
        super(parent, modal);
        setTitle("Elimina Evento");
        controller = new DeleteController(parent, this, e);
        initComponents();
        evento = e;
        if(evento.getTitle() != null)
            getTitleLabel().setText(evento.getTitle());
        if(evento.getType() != null)
            getTypeLabel().setText(evento.getType());
        getDateLabel().setText(parent.getDateTableField().getText());
        if(evento.getHour() != null)
            getHourLabel().setText(evento.getHour());
        if(evento.getTicketsAvaible() != null)
            getTicketsLabel().setText(evento.getTicketsAvaible());
        if(evento.getPrice() != null)
            getPriceLabel().setText(evento.getPrice());
        if(evento.getCity() != null)
            getCityLabel().setText(evento.getCity());
        if(evento.getPosition() != null)
            getPositionLabel().setText(evento.getPosition());
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        titleLabel = new javax.swing.JLabel();
        typeLabel = new javax.swing.JLabel();
        dateLabel = new javax.swing.JLabel();
        hourLabel = new javax.swing.JLabel();
        ticketsLabel = new javax.swing.JLabel();
        priceLabel = new javax.swing.JLabel();
        cityLabel = new javax.swing.JLabel();
        positionLabel = new javax.swing.JLabel();
        confirmButton = new javax.swing.JButton();
        stopButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Sicuro di voler eliminare l'evento:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Titolo:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Tipologia:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Data:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Orario:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Biglietti disponibili:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Costo:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Città:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Luogo:");

        titleLabel.setText("      ");

        typeLabel.setText("       ");

        dateLabel.setText("          ");

        hourLabel.setText("         ");

        ticketsLabel.setText("        ");

        priceLabel.setText("        ");

        cityLabel.setText("          ");

        positionLabel.setText("        ");

        confirmButton.setText("Conferma");
        confirmButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmButtonActionPerformed(evt);
            }
        });

        stopButton.setText("Annulla");
        stopButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9))
                                .addGap(54, 54, 54)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(positionLabel)
                                    .addComponent(cityLabel)
                                    .addComponent(priceLabel)
                                    .addComponent(ticketsLabel)
                                    .addComponent(hourLabel)
                                    .addComponent(dateLabel)
                                    .addComponent(typeLabel)
                                    .addComponent(titleLabel)))
                            .addComponent(jLabel2))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 35, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(confirmButton)))
                        .addGap(18, 18, 18)
                        .addComponent(stopButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(titleLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(typeLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(dateLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(hourLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(ticketsLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(priceLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cityLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(positionLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(confirmButton)
                    .addComponent(stopButton))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void confirmButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmButtonActionPerformed
        controller.confirm();
    }//GEN-LAST:event_confirmButtonActionPerformed

    private void stopButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopButtonActionPerformed
        controller.stop();
    }//GEN-LAST:event_stopButtonActionPerformed
    public Event getEvent()
    {
        return evento;
    }
    public JLabel getTitleLabel()
    {
        return titleLabel;
    }
    public JLabel getTypeLabel()
    {
        return typeLabel;
    }
    public JLabel getDateLabel()
    {
        return dateLabel;
    }
    public JLabel getHourLabel()
    {
        return hourLabel;
    }
    public JLabel getTicketsLabel()
    {
        return ticketsLabel;
    }
    public JLabel getPriceLabel()
    {
        return priceLabel;
    }
    public JLabel getCityLabel()
    {
        return cityLabel;
    }
    public JLabel getPositionLabel()
    {
        return positionLabel;
    }
    public JButton getConfirmButton()
    {
        return confirmButton;
    }
    public JButton getStopButton()
    {
        return stopButton;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel cityLabel;
    private javax.swing.JButton confirmButton;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JLabel hourLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel positionLabel;
    private javax.swing.JLabel priceLabel;
    private javax.swing.JButton stopButton;
    private javax.swing.JLabel ticketsLabel;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JLabel typeLabel;
    // End of variables declaration//GEN-END:variables
}
