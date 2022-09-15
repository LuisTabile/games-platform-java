package games.plataform.gui;

import games.plataform.connection.DataBase;

public class MainWindowForm extends javax.swing.JFrame {

    private DataBase db;
    
    public MainWindowForm() {
        initComponents();
        db = new DataBase();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JDesktopPane();
        menuBar = new javax.swing.JMenuBar();
        gamesMenu = new javax.swing.JMenu();
        publishersMenu = new javax.swing.JMenu();
        userMenu = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Plataforma de jogos");

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 890, Short.MAX_VALUE)
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 509, Short.MAX_VALUE)
        );

        gamesMenu.setMnemonic('f');
        gamesMenu.setText("Games");
        menuBar.add(gamesMenu);

        publishersMenu.setMnemonic('e');
        publishersMenu.setText("Publishers");
        menuBar.add(publishersMenu);

        userMenu.setMnemonic('h');
        userMenu.setText("User Profile");
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu gamesMenu;
    private javax.swing.JDesktopPane mainPanel;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu publishersMenu;
    private javax.swing.JMenu userMenu;
    // End of variables declaration//GEN-END:variables

}
