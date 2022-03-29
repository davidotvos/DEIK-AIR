package hu.unideb.inf;

import java.sql.SQLException;

import hu.unideb.inf.model.*;
import org.h2.tools.Server;

public class Application{

    public static void start(String[] args) throws SQLException {
        startDatabase();

        try (FlightsDAO fDao = new JpaFlightsDAO();) {
            Airport deb;
            deb = new Airport();
            deb.setCity("Debrecen");
            deb.setName("DEB");
            fDao.saveAirport(deb);
            Airport lon;
            lon = new Airport();
            lon.setCity("London");
            lon.setName("LON");
            fDao.saveAirport(lon);

            Flights deb_ber1 = new Flights("deb_ber1", "Debrecen", "Berlin", "Boeing 747-400", "2022.04.01 12:00");
            deb.flightToList(deb_ber1);
            fDao.saveFlight(deb_ber1);
            Flights deb_rom1 = new Flights("deb_rom1", "Debrecen", "Róma", "Boeing 747-400", "2022.04.01 14:00");
            deb.flightToList(deb_rom1);
            fDao.saveFlight(deb_rom1);
            Flights deb_lon1 = new Flights("deb_lon1", "Debrecen", "London", "Hawker Hurricane", "2022.04.01 16:00");
            deb.flightToList(deb_lon1);
            fDao.saveFlight(deb_lon1);
            Flights deb_bar1 = new Flights("deb_bar1", "Debrecen", "Barcelona", "Hawker Hurricane", "2022.04.01 16:00");
            deb.flightToList(deb_bar1);
            fDao.saveFlight(deb_bar1);
            Flights deb_par1 = new Flights("deb_par1", "Debrecen", "Paris", "Hawker Hurricane", "2022.04.01 16:00");
            deb.flightToList(deb_par1);
            fDao.saveFlight(deb_par1);

            Flights lon_deb1 = new Flights("lon-deb1", "London", "Debrecen", "Airbus A330-300", "2022.04. 08:00");
            lon.flightToList(lon_deb1);
            fDao.saveFlight(lon_deb1);
            Flights lon_par1 = new Flights("lon_par1", "London", "Paris", "Airbus A330-300", "2022.04. 09:00");
            lon.flightToList(lon_par1);
            fDao.saveFlight(lon_par1);
            Flights lon_bar1 = new Flights("lon_bar1", "London", "Barcelona", "British Aerospace ATP", "2022.04. 10:00");
            lon.flightToList(lon_bar1);
            fDao.saveFlight(lon_bar1);







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
