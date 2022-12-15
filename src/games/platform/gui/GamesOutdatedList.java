package games.platform.gui;

import games.platform.connection.DataBase;
import games.platform.crud.gui.GameForm;
import games.platform.dbModels.Games;
import games.platform.dbModels.ResultSetTableModel;
import games.platform.logger.AppLogger;
import games.platform.models.Game;
import games.platform.utils.DbGlobal;
import games.platform.utils.LoggerGlobal;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.JDesktopPane;

public class GamesOutdatedList extends javax.swing.JInternalFrame {

    static private ResultSetTableModel tableModel;
    private JDesktopPane mainPanel;

    public GamesOutdatedList(JDesktopPane mainPanel) {
        ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);
        this.mainPanel = mainPanel;
        try {
            DataBase db = DbGlobal.getDb();
            tableModel = new ResultSetTableModel(db.getConnection());
            initComponents();
            tableModel.setQuery(Games.getRemovedGames());
            table.createDefaultColumnsFromModel();
        } catch (IllegalStateException | SQLException | ClassNotFoundException e) {
            LoggerGlobal.getLogger().addLog(AppLogger.getSevereLevel(), "Erro ao conectar o Banco de Dados. " + e.getMessage());
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();

        setBorder(null);
        setMaximizable(true);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setPreferredSize(new java.awt.Dimension(850, 509));

        jLabel3.setText("Lista de Jogos removidos da plataforma:");

        table.setAutoCreateColumnsFromModel(false);
        table.setModel(tableModel);
        table.setName(""); // NOI18N
        jScrollPane1.setViewportView(table);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 838, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel3)
                .addGap(24, 24, 24)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
