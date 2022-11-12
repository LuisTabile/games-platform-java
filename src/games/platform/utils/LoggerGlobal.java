/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package games.platform.utils;

import games.platform.logger.AppLogger;

public class LoggerGlobal {

    private static AppLogger appLogger;

    /**
     * Get the Database
     *
     * @return database
     */
    public static AppLogger getLogger() {
        return appLogger;
    }

    /**
     * Generate the Database and store it as static
     *
     */
    public static void generateLogger() {
        LoggerGlobal.appLogger = new AppLogger();
    }

}
