/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package games.plataform.utils;

import games.plataform.connection.DataBase;

public class DbGlobal {

    private static DataBase db;

    /**
     * Get the Database
     *
     * @return database
     */
    public static DataBase getDb() {
        return db;
    }

    public static void generateDb() {
        DbGlobal.db = new DataBase();
    }

}
