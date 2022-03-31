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
            deb.setCountry("Hungary");
            Airport.addAirportToSet(deb);
            fDao.saveAirport(deb);

            Airport bud;
            bud = new Airport();
            bud.setCity("Budapest");
            bud.setName("BUD");
            bud.setCountry("Hungary");
            Airport.addAirportToSet(bud);
            fDao.saveAirport(bud);

            Airport lon;
            lon = new Airport();
            lon.setCity("London");
            lon.setName("LON");
            lon.setCountry("Great Britain");
            Airport.addAirportToSet(lon);
            fDao.saveAirport(lon);

            Airport bar;
            bar = new Airport();
            bar.setCity("Barcelona");
            bar.setName("BAR");
            bar.setCountry("Spain");
            Airport.addAirportToSet(bar);
            fDao.saveAirport(bar);

            //
            Airport ams;
            ams = new Airport();
            ams.setCity("Amsterdam");
            ams.setName("AMS");
            ams.setCountry("Neitherland");
            Airport.addAirportToSet(ams);
            fDao.saveAirport(ams);


            Flights deb_ber1 = new Flights("deb_ber1", "Debrecen", "Berlin", "Boeing 747-400", "2022.04.01 12:00");
            deb.addFlightToList(deb_ber1);
            fDao.saveFlight(deb_ber1);
            Flights deb_rom1 = new Flights("deb_rom1", "Debrecen", "Róma", "Boeing 747-400", "2022.04.01 14:00");
            deb.addFlightToList(deb_rom1);
            fDao.saveFlight(deb_rom1);
            Flights deb_lon1 = new Flights("deb_lon1", "Debrecen", "London", "Hawker Hurricane", "2022.04.01 16:00");
            deb.addFlightToList(deb_lon1);
            fDao.saveFlight(deb_lon1);
            Flights deb_bar1 = new Flights("deb_bar1", "Debrecen", "Barcelona", "Hawker Hurricane", "2022.04.01 16:00");
            deb.addFlightToList(deb_bar1);
            fDao.saveFlight(deb_bar1);
            Flights deb_par1 = new Flights("deb_par1", "Debrecen", "Paris", "Hawker Hurricane", "2022.04.01 16:00");
            deb.addFlightToList(deb_par1);
            fDao.saveFlight(deb_par1);

            Flights lon_deb1 = new Flights("lon-deb1", "London", "Debrecen", "Airbus A330-300", "2022.04.01 08:00");
            lon.addFlightToList(lon_deb1);
            fDao.saveFlight(lon_deb1);
            Flights lon_par1 = new Flights("lon_par1", "London", "Paris", "Airbus A330-300", "2022.04.01 09:00");
            lon.addFlightToList(lon_par1);
            fDao.saveFlight(lon_par1);
            Flights lon_bar1 = new Flights("lon_bar1", "London", "Barcelona", "British Aerospace ATP", "2022.04.01 10:00");
            lon.addFlightToList(lon_bar1);
            fDao.saveFlight(lon_bar1);
            Flights lon_ber1 = new Flights("lon-ber1", "London", "Berlin", "Airbus A330-300", "2022.04.02 11:00");
            lon.addFlightToList(lon_ber1);
            fDao.saveFlight(lon_ber1);
            Flights lon_bud1 = new Flights("lon_par1", "London", "Budapest", "Airbus A340-600", "2022.04.02 11:30");
            lon.addFlightToList(lon_bud1);
            fDao.saveFlight(lon_par1);
            Flights lon_vie1 = new Flights("lon_vie1", "London", "Vienna", "British Aerospace ATP", "2022.04.02 12:00");
            lon.addFlightToList(lon_vie1);
            fDao.saveFlight(lon_bar1);

            Flights ams_bud1 = new Flights("ams_bud1","Amsterdam","Budapest", "Fairchild-Dornier 328JET", "2022.04.01 08:00");
            lon.addFlightToList(ams_bud1);
            fDao.saveFlight(ams_bud1);
            Flights ams_vie1 = new Flights("ams_vie1","Amsterdam","Vienna", "Fairchild-Dornier 328JET", "2022.04.01 09:00");
            lon.addFlightToList(ams_vie1);
            fDao.saveFlight(ams_vie1);



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
