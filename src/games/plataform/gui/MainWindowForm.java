package games.plataform.gui;

import games.plataform.utils.DbGlobal;

public class MainWindowForm extends javax.swing.JFrame {

    public MainWindowForm() {
        initComponents();
        DbGlobal.generateDb();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JDesktopPane();
        menuBar = new javax.swing.JMenuBar();
        gamesMenu = new javax.swing.JMenu();
        gamesMenuItem = new javax.swing.JMenuItem();
        storeMenuItem = new javax.swing.JMenuItem();
        publishersMenu = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        userMenu = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        clientsWithGamesMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Plataforma de jogos");
        setResizable(false);

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 850, Short.MAX_VALUE)
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 509, Short.MAX_VALUE)
        );

        gamesMenu.setMnemonic('f');
        gamesMenu.setText("Games");

        gamesMenuItem.setText("List");
        gamesMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gamesMenuItemActionPerformed(evt);
            }
        });
        gamesMenu.add(gamesMenuItem);

        storeMenuItem.setText("Store");
        storeMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                storeMenuItemActionPerformed(evt);
            }
        });
        gamesMenu.add(storeMenuItem);

        menuBar.add(gamesMenu);

        publishersMenu.setMnemonic('e');
        publishersMenu.setText("Publishers");

        jMenuItem2.setText("List");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                publishersMenuItemActionPerformed(evt);
            }
        });
        publishersMenu.add(jMenuItem2);

        menuBar.add(publishersMenu);

        userMenu.setMnemonic('h');
        userMenu.setText("User Profile");

        jMenuItem1.setText("List");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clientsMenuItemActionPerformed(evt);
            }
        });
        userMenu.add(jMenuItem1);

        clientsWithGamesMenuItem.setLabel("List with Games");
        clientsWithGamesMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clientsWithGamesMenuItemActionPerformed(evt);
            }
        });
        userMenu.add(clientsWithGamesMenuItem);

        menuBar.add(userMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void gamesMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gamesMenuItemActionPerformed
        GamesListForm gamesListForm = new GamesListForm();
        mainPanel.add(gamesListForm);
        mainPanel.setVisible(true);
        gamesListForm.setVisible(true);
    }//GEN-LAST:event_gamesMenuItemActionPerformed

    private void clientsMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clientsMenuItemActionPerformed
        ClientsListForm clientsListForm = new ClientsListForm();
        mainPanel.add(clientsListForm);
        mainPanel.setVisible(true);
        clientsListForm.setVisible(true);
    }//GEN-LAST:event_clientsMenuItemActionPerformed

    private void publishersMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_publishersMenuItemActionPerformed
        PublishListForm publisherListForm = new PublishListForm();
        mainPanel.add(publisherListForm);
        mainPanel.setVisible(true);
        publisherListForm.setVisible(true);
    }//GEN-LAST:event_publishersMenuItemActionPerformed

    private void clientsWithGamesMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clientsWithGamesMenuItemActionPerformed
        ClientsWithGamesListForm clientsWithGamesListForm = new ClientsWithGamesListForm();
        mainPanel.add(clientsWithGamesListForm);
        mainPanel.setVisible(true);
        clientsWithGamesListForm.setVisible(true);
    }//GEN-LAST:event_clientsWithGamesMenuItemActionPerformed

    private void storeMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_storeMenuItemActionPerformed
        StoreForm storeForm = new StoreForm();
        mainPanel.add(storeForm);
        mainPanel.setVisible(true);
        storeForm.setVisible(true);
    }//GEN-LAST:event_storeMenuItemActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Store;
    private javax.swing.JMenuItem clientsWithGamesMenuItem;
    private javax.swing.JMenu gamesMenu;
    private javax.swing.JMenuItem gamesMenuItem;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JDesktopPane mainPanel;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu publishersMenu;
    private javax.swing.JMenuItem storeMenuItem;
    private javax.swing.JMenu userMenu;
    // End of variables declaration//GEN-END:variables

}
