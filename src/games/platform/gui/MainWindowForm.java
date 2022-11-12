package games.platform.gui;

import games.platform.crud.gui.ClientForm;
import games.platform.crud.gui.GameForm;
import games.platform.crud.gui.PublisherForm;
import games.platform.models.Client;
import games.platform.models.Game;
import games.platform.models.Publisher;
import games.platform.utils.DbGlobal;
import games.platform.xml.gui.AddCashFromXMLForm;
import games.platform.xml.gui.BuysToXMLForm;

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
        gameCreateMenuItem = new javax.swing.JMenuItem();
        storeMenuItem = new javax.swing.JMenuItem();
        publishersMenu = new javax.swing.JMenu();
        publishersListMenuItem = new javax.swing.JMenuItem();
        createPublisherMenuItem = new javax.swing.JMenuItem();
        userMenu = new javax.swing.JMenu();
        clientsMenuItem = new javax.swing.JMenuItem();
        clientsWithGamesMenuItem = new javax.swing.JMenuItem();
        createClientMenuItem = new javax.swing.JMenuItem();
        buysToXMLMenu = new javax.swing.JMenu();
        buysToXMLMenuItem = new javax.swing.JMenuItem();
        addCashFromFileMenu = new javax.swing.JMenuItem();

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

        gameCreateMenuItem.setText("Create");
        gameCreateMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gameCreateMenuItemActionPerformed(evt);
            }
        });
        gamesMenu.add(gameCreateMenuItem);

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

        publishersListMenuItem.setText("List");
        publishersListMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                publishersMenuItemActionPerformed(evt);
            }
        });
        publishersMenu.add(publishersListMenuItem);

        createPublisherMenuItem.setText("Create");
        createPublisherMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createPublisherMenuItemActionPerformed(evt);
            }
        });
        publishersMenu.add(createPublisherMenuItem);

        menuBar.add(publishersMenu);

        userMenu.setMnemonic('h');
        userMenu.setText("User Profile");

        clientsMenuItem.setText("List");
        clientsMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clientsMenuItemActionPerformed(evt);
            }
        });
        userMenu.add(clientsMenuItem);

        clientsWithGamesMenuItem.setLabel("List with Games");
        clientsWithGamesMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clientsWithGamesMenuItemActionPerformed(evt);
            }
        });
        userMenu.add(clientsWithGamesMenuItem);

        createClientMenuItem.setText("Create");
        createClientMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createClientMenuItemActionPerformed(evt);
            }
        });
        userMenu.add(createClientMenuItem);

        menuBar.add(userMenu);

        buysToXMLMenu.setText("XML");

        buysToXMLMenuItem.setText("Buys to XML");
        buysToXMLMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buysToXMLMenuItemActionPerformed(evt);
            }
        });
        buysToXMLMenu.add(buysToXMLMenuItem);

        addCashFromFileMenu.setText("Add cash from File");
        addCashFromFileMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCashFromFileMenuActionPerformed(evt);
            }
        });
        buysToXMLMenu.add(addCashFromFileMenu);

        menuBar.add(buysToXMLMenu);

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
        GamesListForm gamesListForm = new GamesListForm(mainPanel);
        mainPanel.add(gamesListForm);
        mainPanel.setVisible(true);
        gamesListForm.setVisible(true);
    }//GEN-LAST:event_gamesMenuItemActionPerformed

    private void clientsMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clientsMenuItemActionPerformed
        ClientsListForm clientsListForm = new ClientsListForm(mainPanel);
        mainPanel.add(clientsListForm);
        mainPanel.setVisible(true);
        clientsListForm.setVisible(true);
    }//GEN-LAST:event_clientsMenuItemActionPerformed

    private void publishersMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_publishersMenuItemActionPerformed
        PublishListForm publisherListForm = new PublishListForm(mainPanel);
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

    private void createClientMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createClientMenuItemActionPerformed
        ClientForm clientForm = new ClientForm(new Client(0, "", 0), true);
        mainPanel.add(clientForm);
        mainPanel.setVisible(true);
        clientForm.setVisible(true);
    }//GEN-LAST:event_createClientMenuItemActionPerformed

    private void createPublisherMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createPublisherMenuItemActionPerformed
        PublisherForm publisherForm = new PublisherForm(new Publisher(0, ""), true);
        mainPanel.add(publisherForm);
        mainPanel.setVisible(true);
        publisherForm.setVisible(true);
    }//GEN-LAST:event_createPublisherMenuItemActionPerformed

    private void gameCreateMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gameCreateMenuItemActionPerformed
        GameForm gameForm = new GameForm(new Game(0, "", "", null, 0, 0, ""), true);
        mainPanel.add(gameForm);
        mainPanel.setVisible(true);
        gameForm.setVisible(true);
    }//GEN-LAST:event_gameCreateMenuItemActionPerformed

    private void buysToXMLMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buysToXMLMenuItemActionPerformed
        BuysToXMLForm buysToXMLForm = new BuysToXMLForm();
        mainPanel.add(buysToXMLForm);
        mainPanel.setVisible(true);
        buysToXMLForm.setVisible(true);
    }//GEN-LAST:event_buysToXMLMenuItemActionPerformed

    private void addCashFromFileMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCashFromFileMenuActionPerformed
        AddCashFromXMLForm addCashFromXMLForm = new AddCashFromXMLForm();
        mainPanel.add(addCashFromXMLForm);
        mainPanel.setVisible(true);
        addCashFromXMLForm.setVisible(true);
    }//GEN-LAST:event_addCashFromFileMenuActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem addCashFromFileMenu;
    private javax.swing.JMenu buysToXMLMenu;
    private javax.swing.JMenuItem buysToXMLMenuItem;
    private javax.swing.JMenuItem clientsMenuItem;
    private javax.swing.JMenuItem clientsWithGamesMenuItem;
    private javax.swing.JMenuItem createClientMenuItem;
    private javax.swing.JMenuItem createPublisherMenuItem;
    private javax.swing.JMenuItem gameCreateMenuItem;
    private javax.swing.JMenu gamesMenu;
    private javax.swing.JMenuItem gamesMenuItem;
    private javax.swing.JDesktopPane mainPanel;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem publishersListMenuItem;
    private javax.swing.JMenu publishersMenu;
    private javax.swing.JMenuItem storeMenuItem;
    private javax.swing.JMenu userMenu;
    // End of variables declaration//GEN-END:variables

}
