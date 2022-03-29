package hu.unideb.inf;

import java.sql.SQLException;

import hu.unideb.inf.model.*;
import org.h2.tools.Server;

public class Application{

<<<<<<< HEAD
=======

// comment
>>>>>>> rudi
    public static void start(String[] args) throws SQLException {
        startDatabase();

        try (FlightsDAO fDao = new JpaFlightsDAO();) {
            Airport deb;
            deb = new Airport();
            deb.setCity("Debrecen");
            deb.setName("DEB");
            fDao.saveAirport(deb);
            Flights f = new Flights("deb-ber1", "Debrecen", "Berlin", "Boeing 747-400", "2022.04.01 12:00");
            fDao.saveFlight(f);
            Flights f2 = new Flights("deb-rome1", "Debrecen", "Róma", "Boeing 747-400", "2022.04.01 14:00");
            fDao.saveFlight(f2);



        } catch (Exception e) {
            e.printStackTrace();
        }



        System.out.println("Open your browser and navigate to http://localhost:8082/");
        System.out.println("JDBC URL: jdbc:h2:mem:my_database");
        System.out.println("User Name: sa");
        System.out.println("Password: -");

    }

    private static void startDatabase() throws SQLException {
        new Server().runTool("-tcp", "-web", "-ifNotExists");
    }
}
