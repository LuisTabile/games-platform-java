package games.platform.dbModels;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.table.AbstractTableModel;

public class ResultSetTableModel extends AbstractTableModel {

    private final Connection connection;
    private final Statement statement;
    private ResultSet resultSet;
    private ResultSetMetaData metaData;
    private int numberOfRows;
    //monitora o status da conexão com o banco de dados
    private boolean connectedToDatabase = false;

    public ResultSetTableModel(Connection connection)
            throws SQLException, ClassNotFoundException {
        //conexão com o banco de dados
        this.connection = connection;

        //Cria statement para consultar o banco de dados 
        statement = this.connection.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);

        //atualiza o status da conexão
        connectedToDatabase = true;
    }
    
    public ResultSetTableModel(Connection connection, String query)
            throws SQLException, ClassNotFoundException {
        //conexão com o banco de dados
        this.connection = connection;

        //Cria statement para consultar o banco de dados 
        statement = this.connection.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);

        //atualiza o status da conexão
        connectedToDatabase = true;

        setQuery(query);
    }

    //retorna o nome de classe completamente qualificado da coluna especificada
    public Class getColumnClass(int column) throws IllegalStateException {
        if (!connectedToDatabase) {
            throw new IllegalStateException("Not Connected to Database");
        }

        try {
            String className = metaData.getColumnClassName(column + 1);
            return Class.forName(className);
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        return Object.class;
    }

    //retorna o número de colunas do ResultSet
    public int getColumnCount() throws IllegalStateException {
        if (!connectedToDatabase) {
            throw new IllegalStateException("Not Connected to Database");
        }

        try {
            return metaData.getColumnCount();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

        return 0;
    }

    //retorna o nome de uma determinada coluna do ResultSet
    public String getColumnName(int column) throws IllegalStateException {

        if (!connectedToDatabase) {
            throw new IllegalStateException("Not Connected to Database");
        }

        try {
            return metaData.getColumnName(column + 1);
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

        return "";
    }

    //retorna o número de linhas do ResultSet
    public int getRowCount() throws IllegalStateException {

        if (!connectedToDatabase) {
            throw new IllegalStateException("Not Connected to Database");
        }

        return numberOfRows;
    }

    //retorna o valor que consta na linha e coluna especificadas
    public Object getValueAt(int row, int column)
            throws IllegalStateException {
        if (!connectedToDatabase) {
            throw new IllegalStateException("Not Connected to Database");
        }

        try {
            //posiciona em uma linha específica
            resultSet.absolute(row + 1);
            //obtém o objeto de uma coluna específica na linha posicionada
            return resultSet.getObject(column + 1);
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

        return "";
    }

    public void setQuery(String query)
            throws SQLException, IllegalStateException {

        if (!connectedToDatabase) {
            throw new IllegalStateException("Not Connected to Database");
        }

        //executa a consulta
        resultSet = statement.executeQuery(query);

        //obtém os metadados do ResultSet
        metaData = resultSet.getMetaData();

        //posiciona na última linha do ResultSet
        resultSet.last();
        //obtém o número da linha
        numberOfRows = resultSet.getRow();

        // notifica a JTable de que o modelo foi alterado
        fireTableStructureChanged();
    }

    public void disconnectFromDatabase() {
        if (!connectedToDatabase) {
            return;
        }
        try {
            statement.close();
            connection.close();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } finally {
            connectedToDatabase = false;
        }
    }
}
