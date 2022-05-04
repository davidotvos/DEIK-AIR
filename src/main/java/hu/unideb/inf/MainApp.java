package hu.unideb.inf;
import java.sql.SQLException;
<<<<<<< HEAD
import java.util.List;
=======
import java.util.Objects;
>>>>>>> searchpage

import hu.unideb.inf.controller.MainSceneController;
import hu.unideb.inf.model.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.h2.tools.Server;




public class MainApp extends Application {

    public static final String CURRENCY = "€";


    @Override
    public void start(Stage stage) throws Exception {
        /*window = stage;
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/FXML/MainScene.fxml"));
        Scene scene = new Scene(loader.load());
        stage.setTitle("DEIKAir");
        stage.setScene(scene);
<<<<<<< HEAD
        Image indexImage = new Image("file:src/main/java/hu/unideb/inf/icon.png");
        stage.getIcons().add(indexImage);
=======
        stage.show();*/
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/SearchScene.fxml"));
        stage.setTitle("Scene Page");
        stage.setScene(new Scene(root));
>>>>>>> searchpage
        stage.show();
    }

    public static void main(String[] args) throws SQLException {

<<<<<<< HEAD
        try {
            startDB();
        } catch (SQLException e) {
            e.printStackTrace();
        }

=======
//        try {
//            startDB();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
>>>>>>> searchpage
        launch(args);
    }

    public static void startDB() throws SQLException{
        startDatabase();

<<<<<<< HEAD
        //AddFlights();
        //AddCustomer();
        //DeleteCustomer();

        System.out.println("Open your browser and navigate to http://localhost:8082/");
        System.out.println("JDBC URL: jdbc:h2:file:my_database");
        System.out.println("User Name: sa");
        System.out.println("Password: -");



    }

    private static void AddCustomer(){
        try( CustomerDAO cDao = new JpaCustomerDAO()){
            Customer admin;
            admin = new Customer();
            admin.setName("admin");
            admin.setEmail("admin@admin.com");
            admin.setPassword("admin");
            cDao.saveCustomer(admin);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void DeleteCustomer(){
        try( CustomerDAO cDao = new JpaCustomerDAO()){
            List<Customer> templi = cDao.getCustomers();
            Customer temp = new Customer();
            for(Customer c : templi){
                System.out.println(c.getName());
                if(c.getId() == 20){
                    temp = c;

                }
                cDao.deleteCustomer(temp);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private static void AddFlights(){
=======

>>>>>>> searchpage
        try (FlightsDAO fDao = new JpaFlightsDAO()) {

            Airport deb;
            deb = new Airport();
            deb.setCity("Debrecen");
            deb.setName("deb");
            deb.setCountry("Hungary");
            Airport.addAirportToSet(deb);
            fDao.saveAirport(deb);

            Airport bud;
            bud = new Airport();
            bud.setCity("Budapest");
            bud.setName("bud");
            bud.setCountry("Hungary");
            Airport.addAirportToSet(bud);
            fDao.saveAirport(bud);

            Airport vie;
            vie = new Airport();
            vie.setCity("Vienna");
            vie.setName("vie");
            vie.setCountry("Austria");
            Airport.addAirportToSet(vie);
            fDao.saveAirport(vie);

            Airport lon;
            lon = new Airport();
            lon.setCity("London");
            lon.setName("lon");
            lon.setCountry("Great Britain");
            Airport.addAirportToSet(lon);
            fDao.saveAirport(lon);

            Airport bar;
            bar = new Airport();
            bar.setCity("Barcelona");
            bar.setName("bar");
            bar.setCountry("Spain");
            Airport.addAirportToSet(bar);
            fDao.saveAirport(bar);

            Airport ams;
            ams = new Airport();
            ams.setCity("Amsterdam");
<<<<<<< HEAD
            ams.setName("AMS");
            ams.setCountry("Netherlands");
=======
            ams.setName("rom");
            ams.setCountry("Netherland");
>>>>>>> searchpage
            Airport.addAirportToSet(ams);
            fDao.saveAirport(ams);

            Airport rom;
            rom = new Airport();
            rom.setCity("Rome");
            rom.setName("rom");
            rom.setCountry("Italy");
            Airport.addAirportToSet(rom);
            fDao.saveAirport(rom);

            Airport par;
            par = new Airport();
            par.setCity("Paris");
            par.setName("par");
            par.setCountry("France");
            Airport.addAirportToSet(par);
            fDao.saveAirport(par);

            Airport ber;
            ber = new Airport();
            ber.setCity("Berlin");
            ber.setName("ber");
            ber.setCountry("Germany");
            Airport.addAirportToSet(ber);
            fDao.saveAirport(ber);

            Airport bru;
            bru = new Airport();
            bru.setCity("Brussel");
            bru.setName("bru");
            bru.setCountry("Belgium");
            Airport.addAirportToSet(bru);
            fDao.saveAirport(bru);

            Airport pra;
            pra = new Airport();
            pra.setCity("Prague");
            pra.setName("pra");
            pra.setCountry("Czech Republic");
            Airport.addAirportToSet(bru);
            fDao.saveAirport(bru);

            Airport bern;
            bern = new Airport();
            bern.setCity("Bern");
            bern.setName("bern");
            bern.setCountry("Switzerland");
            Airport.addAirportToSet(bern);
            fDao.saveAirport(bern);







            Flights deb_ber1 = new Flights("deb_ber1", "Debrecen", "Berlin", "Boeing 747-400", "2022.05.20 12:00", 199.99);
            deb.addFlightToList(deb_ber1);
            fDao.saveFlight(deb_ber1);
            Flights deb_rom1 = new Flights("deb_rom1", "Debrecen", "Roma", "Boeing 747-400", "2022.05.20 14:00", 149.99);
            deb.addFlightToList(deb_rom1);
            fDao.saveFlight(deb_rom1);
            Flights deb_lon1 = new Flights("deb_lon1", "Debrecen", "London", "Hawker Hurricane", "2022.05.20 10:00", 179.99);
            deb.addFlightToList(deb_lon1);
            fDao.saveFlight(deb_lon1);
            Flights deb_bar1 = new Flights("deb_bar1", "Debrecen", "Barcelona", "Hawker Hurricane", "2022.05.20 11:00", 119.99);
            deb.addFlightToList(deb_bar1);
            fDao.saveFlight(deb_bar1);
            Flights deb_par1 = new Flights("deb_par1", "Debrecen", "Paris", "Hawker Hurricane", "2022.05.20 14:00", 169.99);
            deb.addFlightToList(deb_par1);
            fDao.saveFlight(deb_par1);
            Flights deb_vie1 = new Flights("deb_vie1", "Debrecen", "Vienna", "Airbus A330-300", "2022.05.20 16:00", 79.99);
            deb.addFlightToList(deb_vie1);
            fDao.saveFlight(deb_vie1);
            Flights deb_ams1 = new Flights("deb_ams1", "Debrecen", "Amstedam", "Boeing 747-400", "2022.05.20 14:30", 109.99);
            deb.addFlightToList(deb_ams1);
            fDao.saveFlight(deb_ams1);
            Flights deb_pra1 = new Flights("deb_pra1", "Debrecen", "Prague" , "Fairchild-Dornier 328JET", "2022.05.20 14:30", 99.99);
            deb.addFlightToList(deb_pra1);
            fDao.saveFlight(deb_pra1);
            Flights deb_bern1 = new Flights("deb_bern1", "Debrecen", "Bern" , "Antonov An-12", "2022.05.20 16:00", 179.99);
            deb.addFlightToList(deb_bern1);
            fDao.saveFlight(deb_bern1);
            Flights deb_ber2 = new Flights("deb_ber2", "Debrecen", "Berlin", "Boeing 747-400", "2022.05.23 12:00", 209.99);
            deb.addFlightToList(deb_ber2);
            fDao.saveFlight(deb_ber2);
            Flights deb_rom2 = new Flights("deb_rom2", "Debrecen", "Roma", "Boeing 747-400", "2022.05.22 15:00", 169.99);
            deb.addFlightToList(deb_rom2);
            fDao.saveFlight(deb_rom2);
            Flights deb_lon2 = new Flights("deb_lon2", "Debrecen", "London", "Hawker Hurricane", "2022.05.22 12:00", 179.99);
            deb.addFlightToList(deb_lon2);
            fDao.saveFlight(deb_lon2);
            Flights deb_bar2 = new Flights("deb_bar2", "Debrecen", "Barcelona", "Hawker Hurricane", "2022.05.24 16:00", 119.99);
            deb.addFlightToList(deb_bar2);
            fDao.saveFlight(deb_bar2);
            Flights deb_par2 = new Flights("deb_par2", "Debrecen", "Paris", "Hawker Hurricane", "2022.05.23 18:00", 159.99);
            deb.addFlightToList(deb_par2);
            fDao.saveFlight(deb_par2);
            Flights deb_vie2 = new Flights("deb_vie2", "Debrecen", "Vienna", "Airbus A330-300", "2022.05.25 16:00", 69.99);
            deb.addFlightToList(deb_vie2);
            fDao.saveFlight(deb_vie2);
            Flights deb_ams2 = new Flights("deb_ams2", "Debrecen", "Amstedam", "Boeing 747-400", "2022.05.24 15:30", 209.99);
            deb.addFlightToList(deb_ams2);
            fDao.saveFlight(deb_ams2);
            Flights deb_pra2 = new Flights("deb_pra2", "Debrecen", "Prague" , "Fairchild-Dornier 328JET", "2022.05.23 10:00", 139.99);
            deb.addFlightToList(deb_pra2);
            fDao.saveFlight(deb_pra2);
            Flights deb_bern2 = new Flights("deb_bern2", "Debrecen", "Bern" , "Antonov An-12", "2022.05.23 8:00", 229.99);
            deb.addFlightToList(deb_bern2);
            fDao.saveFlight(deb_bern2);

            Flights lon_deb1 = new Flights("lon_deb1", "London", "Debrecen", "Airbus A330-300", "2022.04.01 08:00", 259.99);
            lon.addFlightToList(lon_deb1);
            fDao.saveFlight(lon_deb1);
            Flights lon_par1 = new Flights("lon_par1", "London", "Paris", "Airbus A330-300", "2022.04.01 09:00", 119.99);
            lon.addFlightToList(lon_par1);
            fDao.saveFlight(lon_par1);
            Flights lon_bar1 = new Flights("lon_bar1", "London", "Barcelona", "British Aerospace ATP", "2022.04.01 10:00", 199.99);
            lon.addFlightToList(lon_bar1);
            fDao.saveFlight(lon_bar1);
            Flights lon_ber1 = new Flights("lon-ber1", "London", "Berlin", "Airbus A330-300", "2022.04.02 11:00", 129.99);
            lon.addFlightToList(lon_ber1);
            fDao.saveFlight(lon_ber1);
            Flights lon_bud1 = new Flights("lon_par1", "London", "Budapest", "Airbus A340-600", "2022.04.02 11:30", 179.99);
            lon.addFlightToList(lon_bud1);
            fDao.saveFlight(lon_par1);
            Flights lon_vie1 = new Flights("lon_vie1", "London", "Vienna", "British Aerospace ATP", "2022.04.02 12:00", 229.99);
            lon.addFlightToList(lon_vie1);
            fDao.saveFlight(lon_bar1);

            Flights ams_bud1 = new Flights("ams_bud1","Amsterdam","Budapest", "Fairchild-Dornier 328JET", "2022.04.01 08:00", 149.99);
            lon.addFlightToList(ams_bud1);
            fDao.saveFlight(ams_bud1);
            Flights ams_vie1 = new Flights("ams_vie1","Amsterdam","Vienna", "Fairchild-Dornier 328JET", "2022.04.01 09:00", 149.99);
            lon.addFlightToList(ams_vie1);
            fDao.saveFlight(ams_vie1);

            //System.out.println(fDao.getFlights());
            //System.out.println(fDao.getFlightsBy_start_city());
            //System.out.println(fDao.findWith_start_city("Debrecen"));
            //System.out.println(fDao.findWith_start_and_destination_city("Debrecen"));

        } catch (Exception e) {
            e.printStackTrace();
        }
<<<<<<< HEAD
=======
        //System.out.println(Airport.getAirport_city_string_list());
        System.out.println("Open your browser and navigate to http://localhost:8082/");
        System.out.println("JDBC URL: jdbc:h2:file:my_database");
        System.out.println("User Name: sa");
        System.out.println("Password: -");



>>>>>>> searchpage
    }

    private static void startDatabase() throws SQLException {
        new Server().runTool("-tcp", "-web", "-ifNotExists");
    }
}

