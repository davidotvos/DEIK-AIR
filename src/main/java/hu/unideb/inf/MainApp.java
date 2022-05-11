package hu.unideb.inf;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

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
    public static Customer LoggedInCustomer = null;

    Stage window;
    @Override
    public void start(Stage stage) throws Exception {
        window = stage;
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/FXML/MainScene.fxml"));
        Scene scene = new Scene(loader.load());
        stage.setTitle("DEIKAir");
        stage.setScene(scene);
        Image indexImage = new Image("file:src/main/java/hu/unideb/inf/icon.png");
        stage.getIcons().add(indexImage);
        stage.show();
    }

    public static void main(String[] args) throws Exception {
        try {
            startDB();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        launch(args);
    }

    public static void startDB() throws Exception {
        startDatabase();

        //AddFlights();
        //AddCustomer();

        //DeleteCustomer();
        //AddReservation();


        System.out.println("Open your browser and navigate to http://localhost:8082/");
        System.out.println("JDBC URL: jdbc:h2:file:~/my_database");
        System.out.println("User Name: sa");
        System.out.println("Password: -");

    }

    public static Customer getCustomerObject(String name){
        try( CustomerDAO cDao = new JpaCustomerDAO()){
            List<Customer> templi = cDao.getCustomers();
            for(Customer c : templi){
                if(Objects.equals(c.getName(), name))
                {
                    return c;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
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
                if(c.getId() == 39){
                    temp = c;
                }
                cDao.deleteCustomer(temp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void AddReservation() throws Exception {
        try (ReservationsDAO rDao = new JpaReservationsDAO()){
            Reservations elso;
            elso = new Reservations();
            elso.setStart_city("Debrecen");
            elso.setDestination_city("London");
            elso.setStart_time("2022.05.10. 12:00");
            elso.setNumberOfTickets(5);
            elso.setPrice(500.0);
            elso.setCustomerName("admin");
            rDao.saveReservation(elso);
        }
    }

    private static void AddFlights(){
        try (FlightsDAO fDao = new JpaFlightsDAO()) {

            Airport deb;
            deb = new Airport();
            deb.setCity("Debrecen");
            deb.setName("deb");
            deb.setCountry("Hungary");
            fDao.saveAirport(deb);

            Airport bud;
            bud = new Airport();
            bud.setCity("Budapest");
            bud.setName("bud");
            bud.setCountry("Hungary");
            fDao.saveAirport(bud);

            Airport vie;
            vie = new Airport();
            vie.setCity("Vienna");
            vie.setName("vie");
            vie.setCountry("Austria");
            fDao.saveAirport(vie);

            Airport lon;
            lon = new Airport();
            lon.setCity("London");
            lon.setName("lon");
            lon.setCountry("Great Britain");
            fDao.saveAirport(lon);

            Airport bar;
            bar = new Airport();
            bar.setCity("Barcelona");
            bar.setName("bar");
            bar.setCountry("Spain");
            fDao.saveAirport(bar);

            Airport ams;
            ams = new Airport();
            ams.setCity("Amsterdam");
            ams.setName("AMS");
            ams.setCountry("Netherlands");
            ams.setName("rom");
            ams.setCountry("Netherland");
            fDao.saveAirport(ams);

            Airport rom;
            rom = new Airport();
            rom.setCity("Rome");
            rom.setName("rom");
            rom.setCountry("Italy");
            fDao.saveAirport(rom);

            Airport par;
            par = new Airport();
            par.setCity("Paris");
            par.setName("par");
            par.setCountry("France");
            fDao.saveAirport(par);

            Airport ber;
            ber = new Airport();
            ber.setCity("Berlin");
            ber.setName("ber");
            ber.setCountry("Germany");
            fDao.saveAirport(ber);

            Airport bru;
            bru = new Airport();
            bru.setCity("Brussel");
            bru.setName("bru");
            bru.setCountry("Belgium");
            fDao.saveAirport(bru);

            Airport pra;
            pra = new Airport();
            pra.setCity("Prague");
            pra.setName("pra");
            pra.setCountry("Czech Republic");
            fDao.saveAirport(pra);

            Airport bern;
            bern = new Airport();
            bern.setCity("Bern");
            bern.setName("bern");
            bern.setCountry("Switzerland");
            fDao.saveAirport(bern);






        //Debrecenbol indulok
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
            Flights deb_ams1 = new Flights("deb_ams1", "Debrecen", "Amsterdam", "Boeing 747-400", "2022.05.20 14:30", 109.99);
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
            Flights deb_ams2 = new Flights("deb_ams2", "Debrecen", "Amsterdam", "Boeing 747-400", "2022.05.24 15:30", 209.99);
            deb.addFlightToList(deb_ams2);
            fDao.saveFlight(deb_ams2);
            Flights deb_pra2 = new Flights("deb_pra2", "Debrecen", "Prague" , "Fairchild-Dornier 328JET", "2022.05.23 10:00", 139.99);
            deb.addFlightToList(deb_pra2);
            fDao.saveFlight(deb_pra2);
            Flights deb_bern2 = new Flights("deb_bern2", "Debrecen", "Bern" , "Antonov An-12", "2022.05.23 8:00", 229.99);
            deb.addFlightToList(deb_bern2);
            fDao.saveFlight(deb_bern2);

        //Londonbol indulok
            Flights lon_deb1 = new Flights("lon_deb1", "London", "Debrecen", "Airbus A330-300", "2022.04.01 08:00", 259.99);
            lon.addFlightToList(lon_deb1);
            fDao.saveFlight(lon_deb1);
            Flights lon_par1 = new Flights("lon_par1", "London", "Paris", "Airbus A330-300", "2022.04.01 09:00", 119.99);
            lon.addFlightToList(lon_par1);
            fDao.saveFlight(lon_par1);
            Flights lon_bar1 = new Flights("lon_bar1", "London", "Barcelona", "British Aerospace ATP", "2022.04.01 10:00", 199.99);
            lon.addFlightToList(lon_bar1);
            fDao.saveFlight(lon_bar1);
            Flights lon_ber1 = new Flights("lon_ber1", "London", "Berlin", "Airbus A330-300", "2022.04.02 11:00", 129.99);
            lon.addFlightToList(lon_ber1);
            fDao.saveFlight(lon_ber1);
            Flights lon_bud1 = new Flights("lon_par1", "London", "Budapest", "Airbus A340-600", "2022.04.02 11:30", 179.99);
            lon.addFlightToList(lon_bud1);
            fDao.saveFlight(lon_par1);
            Flights lon_vie1 = new Flights("lon_vie1", "London", "Vienna", "British Aerospace ATP", "2022.04.02 12:00", 229.99);
            lon.addFlightToList(lon_vie1);
            fDao.saveFlight(lon_bar1);
            Flights lon_deb2 = new Flights("lon_deb2", "London", "Debrecen", "Airbus A330-300", "2022.05.12 08:00", 219.99);
            lon.addFlightToList(lon_deb2);
            fDao.saveFlight(lon_deb2);
            Flights lon_par2 = new Flights("lon_par2", "London", "Paris", "British Aerospace ATP", "2022.05.13 19:00", 109.99);
            lon.addFlightToList(lon_par2);
            fDao.saveFlight(lon_par2);
            Flights lon_bar2 = new Flights("lon_bar2", "London", "Barcelona", "British Aerospace ATP", "2022.05.13 11:00", 189.99);
            lon.addFlightToList(lon_bar2);
            fDao.saveFlight(lon_bar2);
            Flights lon_ber2 = new Flights("lon_ber2", "London", "Berlin", "Antonov An-12", "2022.05.14 12:00", 139.99);
            lon.addFlightToList(lon_ber2);
            fDao.saveFlight(lon_ber2);
            Flights lon_bud2 = new Flights("lon_par2", "London", "Budapest", "Boeing 747-400", "2022.05.13 11:30", 179.99);
            lon.addFlightToList(lon_bud2);
            fDao.saveFlight(lon_par2);
            Flights lon_vie2 = new Flights("lon_vie2", "London", "Vienna", "British Aerospace ATP", "2022.05.14 12:00", 209.99);
            lon.addFlightToList(lon_vie2);
            fDao.saveFlight(lon_bar2);

        //Amsterdambol indulok
            Flights ams_bud1 = new Flights("ams_bud1", "Amsterdam", "Budapest", "Boeing 747-400", "2022.04.01 08:00", 149.99);
            ams.addFlightToList(ams_bud1);
            fDao.saveFlight(ams_bud1);
            Flights ams_vie1 = new Flights("ams_vie1", "Amsterdam", "Vienna", "Fairchild-Dornier 328JET", "2022.04.01 09:00", 149.99);
            ams.addFlightToList(ams_vie1);
            fDao.saveFlight(ams_vie1);
            Flights ams_lon1 = new Flights("ams_lon1", "Amsterdam", "London", "Boeing 747-400", "2022.05.20 18:00", 69.99);
            ams.addFlightToList(ams_lon1);
            fDao.saveFlight(ams_lon1);
            Flights ams_bar1 = new Flights("ams_bar1", "Amsterdam", "Barcelona", "Fairchild-Dornier 328JET", "2022.05.11 09:00", 129.99);
            ams.addFlightToList(ams_bar1);
            fDao.saveFlight(ams_bar1);
            Flights ams_pra1 = new Flights("ams_pra1", "Amsterdam", "Prague", "Boeing 747-400", "2022.05.11 08:00", 109.99);
            ams.addFlightToList(ams_pra1);
            fDao.saveFlight(ams_pra1);
            Flights ams_bern1 = new Flights("ams_bern1", "Amsterdam", "Bern", "Fairchild-Dornier 328JET", "2022.05.15 09:00", 129.99);
            ams.addFlightToList(ams_bern1);
            fDao.saveFlight(ams_bern1);
            Flights ams_bud2 = new Flights("ams_bud2", "Amsterdam", "Budapest", "Boeing 747-400", "2022.05.11 10:00", 139.99);
            ams.addFlightToList(ams_bud2);
            fDao.saveFlight(ams_bud2);
            Flights ams_vie2 = new Flights("ams_vie2", "Amsterdam", "Vienna", "Boeing 747-400", "2022.05.15 09:00", 139.99);
            ams.addFlightToList(ams_vie2);
            fDao.saveFlight(ams_vie2);
            Flights ams_lon2 = new Flights("ams_lon2", "Amsterdam", "London", "Antonov An-12", "2022.05.20 18:00", 69.99);
            ams.addFlightToList(ams_lon2);
            fDao.saveFlight(ams_lon2);
            Flights ams_bar2 = new Flights("ams_bar2", "Amsterdam", "Barcelona", "British Aerospace ATP", "2022.05.14 09:00", 129.99);
            ams.addFlightToList(ams_bar2);
            fDao.saveFlight(ams_bar2);
            Flights ams_pra2 = new Flights("ams_pra2", "Amsterdam", "Prague", "Boeing 747-400", "2022.05.14 08:00", 109.99);
            ams.addFlightToList(ams_pra2);
            fDao.saveFlight(ams_pra2);
            Flights ams_bern2 = new Flights("ams_bern2", "Amsterdam", "Bern", "Fairchild-Dornier 328JET", "2022.05.18 14:00", 129.99);
            ams.addFlightToList(ams_bern2);
            fDao.saveFlight(ams_bern2);

        //Budapestrol indulok
            Flights bud_bar1 = new Flights("bud_bar1", "Budapest", "Barcelona", "Boeing 747-400", "2022.05.11 11:00", 189.99);
            bud.addFlightToList(bud_bar1);
            fDao.saveFlight(bud_bar1);
            Flights bud_ams1 = new Flights("bud_ams1", "Budapest", "Amsterdam", "Fairchild-Dornier 328JET", "2022.05.12 13:00", 159.99);
            bud.addFlightToList(bud_ams1);
            fDao.saveFlight(bud_ams1);
            Flights bud_rom1 = new Flights("bud_rom1", "Budapest", "Roma", "Boeing 747-400", "2022.05.12 16:00", 129.99);
            bud.addFlightToList(bud_rom1);
            fDao.saveFlight(bud_rom1);
            Flights bud_par1 = new Flights("bud_par1", "Budapest", "Paris", "British Aerospace ATP", "2022.05.10 12:00", 169.99);
            bud.addFlightToList(bud_par1);
            fDao.saveFlight(bud_par1);
            Flights bud_ber1 = new Flights("bud_ber1", "Budapest", "Berlin", "Boeing 747-400", "2022.05.14 08:00", 169.99);
            bud.addFlightToList(bud_ber1);
            fDao.saveFlight(bud_ber1);
            Flights bud_bru1 = new Flights("bud_bru1", "Budapest", "Brussel", "British Aerospace ATP", "2022.05.11 13:00", 189.99);
            bud.addFlightToList(bud_bru1);
            fDao.saveFlight(bud_bru1);
            Flights bud_bar2 = new Flights("bud_bar2", "Budapest", "Barcelona", "Boeing 747-400", "2022.05.14 13:00", 189.99);
            bud.addFlightToList(bud_bar2);
            fDao.saveFlight(bud_bar2);
            Flights bud_ams2 = new Flights("bud_ams2", "Budapest", "Amsterdam", "Fairchild-Dornier 328JET", "2022.05.18 13:00", 119.99);
            bud.addFlightToList(bud_ams2);
            fDao.saveFlight(bud_ams2);
            Flights bud_rom2 = new Flights("bud_rom2", "Budapest", "Roma", "Boeing 747-400", "2022.05.17 09:00", 119.99);
            bud.addFlightToList(bud_rom2);
            fDao.saveFlight(bud_rom2);
            Flights bud_par2 = new Flights("bud_par2", "Budapest", "Paris", "British Aerospace ATP", "2022.05.17 15:00", 199.99);
            bud.addFlightToList(bud_par2);
            fDao.saveFlight(bud_par2);
            Flights bud_ber2 = new Flights("bud_ber2", "Budapest", "Berlin", "Boeing 747-400", "2022.05.15 18:00", 119.99);
            bud.addFlightToList(bud_ber2);
            fDao.saveFlight(bud_ber2);
            Flights bud_bru2 = new Flights("bud_bru2", "Budapest", "Brussel", "British Aerospace ATP", "2022.05.17 15:00", 179.99);
            bud.addFlightToList(bud_bru2);
            fDao.saveFlight(bud_bru2);

        //Romabol indulok
            Flights rom_lon1 = new Flights("rom_lon1", "Rome", "London", "British Aerospace ATP", "2022.05.11 09:00", 169.99);
            rom.addFlightToList(rom_lon1);
            fDao.saveFlight(rom_lon1);
            Flights rom_bud1 = new Flights("rom_bud1", "Rome", "Budapest", "Boeing 747-400", "2022.05.12 19:00", 109.99);
            rom.addFlightToList(rom_bud1);
            fDao.saveFlight(rom_bud1);
            Flights rom_bru1 = new Flights("rom_bru1", "Rome", "Brussel", "Boeing 747-400", "2022.05.13 11:00", 189.99);
            rom.addFlightToList(rom_bru1);
            fDao.saveFlight(rom_bru1);
            Flights rom_vie1 = new Flights("rom_vie1", "Rome", "Vienna", "British Aerospace ATP", "2022.05.12 15:00", 129.99);
            rom.addFlightToList(rom_vie1);
            fDao.saveFlight(rom_vie1);
            Flights rom_ber1 = new Flights("rom_ber1", "Rome", "Berlin", "Antonov An-12", "2022.05.14 12:00", 169.99);
            rom.addFlightToList(rom_ber1);
            fDao.saveFlight(rom_ber1);
            Flights rom_pra1 = new Flights("rom_pra1", "Rome", "Prague", "Antonov An-12", "2022.05.11 17:00", 159.99);
            rom.addFlightToList(rom_pra1);
            fDao.saveFlight(rom_pra1);
            Flights rom_lon2 = new Flights("rom_lon2", "Rome", "London", "British Aerospace ATP", "2022.05.16 10:00", 159.99);
            rom.addFlightToList(rom_lon2);
            fDao.saveFlight(rom_lon2);
            Flights rom_bud2 = new Flights("rom_bud2", "Rome", "Budapest", "Boeing 747-400", "2022.05.14 15:00", 119.99);
            rom.addFlightToList(rom_bud2);
            fDao.saveFlight(rom_bud2);
            Flights rom_bru2 = new Flights("rom_bru2", "Rome", "Brussel", "British Aerospace ATP", "2022.05.17 14:00", 169.99);
            rom.addFlightToList(rom_bru2);
            fDao.saveFlight(rom_bru2);
            Flights rom_vie2 = new Flights("rom_vie2", "Rome", "Vienna", "Fairchild-Dornier 328JET", "2022.05.19 16:00", 109.99);
            rom.addFlightToList(rom_vie2);
            fDao.saveFlight(rom_vie2);
            Flights rom_ber2 = new Flights("rom_ber2", "Rome", "Berlin", "Boeing 747-400", "2022.05.17 14:00", 159.99);
            rom.addFlightToList(rom_ber2);
            fDao.saveFlight(rom_ber2);
            Flights rom_pra2 = new Flights("rom_pra2", "Rome", "Prague", "British Aerospace ATP", "2022.05.16 08:00", 139.99);
            rom.addFlightToList(rom_pra2);
            fDao.saveFlight(rom_pra2);

        //Viennabol indulok
            Flights vie_deb1 = new Flights("vie_deb1", "Vienna", "Debrecen", "British Aerospace ATP", "2022.05.16 08:00", 139.99);
            vie.addFlightToList(vie_deb1);
            fDao.saveFlight(vie_deb1);
            Flights vie_par1 = new Flights("vie_par1", "Vienna", "Paris", "Boeing 747-400", "2022.05.13 18:00", 159.99);
            vie.addFlightToList(vie_par1);
            fDao.saveFlight(vie_par1);
            Flights vie_ams1 = new Flights("vie_ams1", "Vienna", "Amsterdam", "Antonov An-12", "2022.05.14 11:00", 139.99);
            vie.addFlightToList(vie_ams1);
            fDao.saveFlight(vie_ams1);
            Flights vie_lon1 = new Flights("vie_lon1", "Vienna", "London", "Antonov An-12", "2022.05.15 15:00", 149.99);
            vie.addFlightToList(vie_lon1);
            fDao.saveFlight(vie_lon1);
            Flights vie_bar1 = new Flights("vie_bar1", "Vienna", "Barcelona", "Boeing 747-400", "2022.05.17 14:00", 189.99);
            vie.addFlightToList(vie_bar1);
            fDao.saveFlight(vie_bar1);
            Flights vie_bern1 = new Flights("vie_bern1", "Vienna", "Bern", "Fairchild-Dornier 328JET", "2022.05.15 12:00", 109.99);
            vie.addFlightToList(vie_bern1);
            fDao.saveFlight(vie_bern1);
            Flights vie_rom1 = new Flights("vie_rom1", "Vienna", "Rome", "British Aerospace ATP", "2022.05.13 13:00", 99.99);
            vie.addFlightToList(vie_rom1);
            fDao.saveFlight(vie_rom1);
            Flights vie_deb2 = new Flights("vie_deb2", "Vienna", "Debrecen", "Boeing 747-400", "2022.05.20 18:00", 109.99);
            vie.addFlightToList(vie_deb2);
            fDao.saveFlight(vie_deb2);
            Flights vie_par2 = new Flights("vie_par2", "Vienna", "Paris", "Antonov An-12", "2022.05.17 18:00", 149.99);
            vie.addFlightToList(vie_par2);
            fDao.saveFlight(vie_par2);
            Flights vie_ams2 = new Flights("vie_ams2", "Vienna", "Amsterdam", "British Aerospace ATP", "2022.05.18 16:00", 169.99);
            vie.addFlightToList(vie_ams2);
            fDao.saveFlight(vie_ams2);
            Flights vie_lon2 = new Flights("vie_lon2", "Vienna", "London", "Boeing 747-400", "2022.05.20 12:00", 189.99);
            vie.addFlightToList(vie_lon2);
            fDao.saveFlight(vie_lon2);
            Flights vie_bar2 = new Flights("vie_bar2", "Vienna", "Barcelona", "Antonov An-12", "2022.05.21 16:00", 199.99);
            vie.addFlightToList(vie_bar2);
            fDao.saveFlight(vie_bar2);
            Flights vie_bern2 = new Flights("vie_bern2", "Vienna", "Bern", "Fairchild-Dornier 328JET", "2022.05.22 10:00", 179.99);
            vie.addFlightToList(vie_bern2);
            fDao.saveFlight(vie_bern2);
            Flights vie_rom2 = new Flights("vie_rom2", "Vienna", "Rome", "Boeing 747-400", "2022.05.19 13:00", 109.99);
            vie.addFlightToList(vie_rom2);
            fDao.saveFlight(vie_rom2);

        //Barcelonabol indulok
            Flights bar_deb1 = new Flights("bar_deb1", "Barcelona", "Debrecen", "Antonov An-12", "2022.05.13 16:00", 209.99);
            bar.addFlightToList(bar_deb1);
            fDao.saveFlight(bar_deb1);
            Flights bar_lon1 = new Flights("bar_lon1", "Barcelona", "London", "British Aerospace ATP", "2022.05.12 08:00", 129.99);
            bar.addFlightToList(bar_lon1);
            fDao.saveFlight(bar_lon1);
            Flights bar_pra1 = new Flights("bar_pra1", "Barcelona", "Prague", "Boeing 747-400", "2022.05.14 09:00", 169.99);
            bar.addFlightToList(bar_pra1);
            fDao.saveFlight(bar_pra1);
            Flights bar_ber1 = new Flights("bar_ber1", "Barcelona", "Berlin", "Antonov An-12", "2022.05.16 14:00", 159.99);
            bar.addFlightToList(bar_ber1);
            fDao.saveFlight(bar_ber1);
            Flights bar_par1 = new Flights("bar_par1", "Barcelona", "Paris", "Boeing 747-400", "2022.05.12 11:00", 109.99);
            bar.addFlightToList(bar_par1);
            fDao.saveFlight(bar_par1);
            Flights bar_ams1 = new Flights("bar_ams1", "Barcelona", "Amsterdam", "Antonov An-12", "2022.05.15 18:00", 99.99);
            bar.addFlightToList(bar_ams1);
            fDao.saveFlight(bar_ams1);
            Flights bar_deb2 = new Flights("bar_deb2", "Barcelona", "Debrecen", "Fairchild-Dornier 328JET", "2022.05.17 14:00", 179.99);
            bar.addFlightToList(bar_deb2);
            fDao.saveFlight(bar_deb2);
            Flights bar_lon2 = new Flights("bar_lon2", "Barcelona", "London", "British Aerospace ATP", "2022.05.19 11:00", 139.99);
            bar.addFlightToList(bar_lon2);
            fDao.saveFlight(bar_lon2);
            Flights bar_pra2 = new Flights("bar_pra2", "Barcelona", "Prague", "Antonov An-12", "2022.05.21 17:00", 149.99);
            bar.addFlightToList(bar_pra2);
            fDao.saveFlight(bar_pra2);
            Flights bar_ber2 = new Flights("bar_ber2", "Barcelona", "Berlin", "British Aerospace ATP", "2022.05.22 12:00", 149.99);
            bar.addFlightToList(bar_ber2);
            fDao.saveFlight(bar_ber2);
            Flights bar_par2 = new Flights("bar_par2", "Barcelona", "Paris", "British Aerospace ATP", "2022.05.18 14:00", 129.99);
            bar.addFlightToList(bar_par2);
            fDao.saveFlight(bar_par2);
            Flights bar_ams2 = new Flights("bar_ams2", "Barcelona", "Amsterdam", "Antonov An-12", "2022.05.21 13:00", 129.99);
            bar.addFlightToList(bar_ams2);
            fDao.saveFlight(bar_ams2);

        //Parisbol indulok
            Flights par_vie1 = new Flights("par_vie1", "Paris", "Vienna", "British Aerospace ATP", "2022.05.11 13:00", 159.99);
            par.addFlightToList(par_vie1);
            fDao.saveFlight(par_vie1);
            Flights par_ber1 = new Flights("par_ber1", "Paris", "Berlin", "Antonov An-12", "2022.05.12 08:00", 109.99);
            par.addFlightToList(par_ber1);
            fDao.saveFlight(par_ber1);
            Flights par_bern1 = new Flights("par_bern1", "Paris", "Bern", "Fairchild-Dornier 328JET", "2022.05.13 17:00", 149.99);
            par.addFlightToList(par_bern1);
            fDao.saveFlight(par_bern1);
            Flights par_pra1 = new Flights("par_pra1", "Paris", "Prague", "Boeing 747-400", "2022.05.11 14:00", 119.99);
            par.addFlightToList(par_pra1);
            fDao.saveFlight(par_pra1);
            Flights par_bud1 = new Flights("par_bud1", "Paris", "Budapest", "British Aerospace ATP", "2022.05.13 08:00", 119.99);
            par.addFlightToList(par_bud1);
            fDao.saveFlight(par_bud1);
            Flights par_lon1 = new Flights("par_lon1", "Paris", "London", "Antonov An-12", "2022.05.14 10:00", 109.99);
            par.addFlightToList(par_lon1);
            fDao.saveFlight(par_lon1);
            Flights par_vie2 = new Flights("par_vie2", "Paris", "Vienna", "Antonov An-12", "2022.05.19 16:00", 159.99);
            par.addFlightToList(par_vie2);
            fDao.saveFlight(par_vie2);
            Flights par_ber2 = new Flights("par_ber2", "Paris", "Berlin", "British Aerospace ATP", "2022.05.17 11:00", 119.99);
            par.addFlightToList(par_ber2);
            fDao.saveFlight(par_ber2);
            Flights par_bern2 = new Flights("par_bern2", "Paris", "Bern", "Boeing 747-400", "2022.05.21 13:00", 169.99);
            par.addFlightToList(par_bern2);
            fDao.saveFlight(par_bern2);
            Flights par_pra2 = new Flights("par_pra2", "Paris", "Prague", "Antonov An-12", "2022.05.15 17:00", 129.99);
            par.addFlightToList(par_pra2);
            fDao.saveFlight(par_pra2);
            Flights par_bud2 = new Flights("par_bud2", "Paris", "Budapest", "British Aerospace ATP", "2022.05.22 14:00", 129.99);
            par.addFlightToList(par_bud2);
            fDao.saveFlight(par_bud2);
            Flights par_lon2 = new Flights("par_lon2", "Paris", "London", "Boeing 747-400", "2022.05.19 11:00", 89.99);
            par.addFlightToList(par_lon2);
            fDao.saveFlight(par_lon2);

        //Berlinbol indulok
            Flights ber_pra1 = new Flights("ber_pra1", "Berlin", "Prague", "British Aerospace ATP", "2022.05.12 15:00", 119.99);
            ber.addFlightToList(ber_pra1);
            fDao.saveFlight(ber_pra1);
            Flights ber_deb1 = new Flights("ber_deb1", "Berlin", "Debrecen", "Antonov An-12", "2022.05.12 11:00", 149.99);
            ber.addFlightToList(ber_deb1);
            fDao.saveFlight(ber_deb1);
            Flights ber_bud1 = new Flights("ber_bud1", "Berlin", "Budapest", "Boeing 747-400", "2022.05.13 17:00", 149.99);
            ber.addFlightToList(ber_bud1);
            fDao.saveFlight(ber_bud1);
            Flights ber_bar1 = new Flights("ber_bar1", "Berlin", "Barcelona", "British Aerospace ATP", "2022.05.14 10:00", 179.99);
            ber.addFlightToList(ber_bar1);
            fDao.saveFlight(ber_bar1);
            Flights ber_bru1 = new Flights("ber_bru1", "Berlin", "Brussel", "Antonov An-12", "2022.05.11 09:00", 59.99);
            ber.addFlightToList(ber_bru1);
            fDao.saveFlight(ber_bru1);
            Flights ber_rom1 = new Flights("ber_rom1", "Berlin", "Rome", "Boeing 747-400", "2022.05.13 19:00", 159.99);
            ber.addFlightToList(ber_rom1);
            fDao.saveFlight(ber_rom1);
            Flights ber_pra2 = new Flights("ber_pra2", "Berlin", "Prague", "British Aerospace ATP", "2022.05.17 17:00", 129.99);
            ber.addFlightToList(ber_pra2);
            fDao.saveFlight(ber_pra2);
            Flights ber_deb2 = new Flights("ber_deb2", "Berlin", "Debrecen", "Boeing 747-400", "2022.05.21 18:00", 149.99);
            ber.addFlightToList(ber_deb2);
            fDao.saveFlight(ber_deb2);
            Flights ber_bud2 = new Flights("ber_bud2", "Berlin", "Budapest", "British Aerospace ATP", "2022.05.19 12:00", 179.99);
            ber.addFlightToList(ber_bud2);
            fDao.saveFlight(ber_bud2);
            Flights ber_bar2 = new Flights("ber_bar2", "Berlin", "Barcelona", "Fairchild-Dornier 328JET", "2022.05.21 17:00", 109.99);
            ber.addFlightToList(ber_bar2);
            fDao.saveFlight(ber_bar2);
            Flights ber_bru2 = new Flights("ber_bru2", "Berlin", "Brussel", "British Aerospace ATP", "2022.05.19 19:00", 79.99);
            ber.addFlightToList(ber_bru2);
            fDao.saveFlight(ber_bru2);
            Flights ber_rom2 = new Flights("ber_rom2", "Berlin", "Rome", "Antonov An-12", "2022.05.22 12:00", 139.99);
            ber.addFlightToList(ber_rom2);
            fDao.saveFlight(ber_rom2);

        //Brusselbol indulok
            Flights bru_ber1 = new Flights("bru_ber1", "Brussel", "Berlin", "British Aerospace ATP", "2022.05.13 15:00", 59.99);
            bru.addFlightToList(bru_ber1);
            fDao.saveFlight(bru_ber1);
            Flights bru_bud1 = new Flights("bru_bud1", "Brussel", "Budapest", "Boeing 747-400", "2022.05.14 12:00", 159.99);
            bru.addFlightToList(bru_bud1);
            fDao.saveFlight(bru_bud1);
            Flights bru_bar1 = new Flights("bru_ber1", "Brussel", "Barcelona", "British Aerospace ATP", "2022.05.11 11:00", 129.99);
            bru.addFlightToList(bru_bar1);
            fDao.saveFlight(bru_bar1);
            Flights bru_lon1 = new Flights("bru_lon1", "Brussel", "London", "Antonov An-12", "2022.05.12 08:00", 49.99);
            bru.addFlightToList(bru_lon1);
            fDao.saveFlight(bru_lon1);
            Flights bru_vie1 = new Flights("bru_vie1", "Brussel", "Vienna", "Fairchild-Dornier 328JET", "2022.05.14 09:30", 149.99);
            bru.addFlightToList(bru_vie1);
            fDao.saveFlight(bru_vie1);
            Flights bru_bern1 = new Flights("bru_bern1", "Brussel", "Bern", "British Aerospace ATP", "2022.05.11 14:00", 139.99);
            bru.addFlightToList(bru_bern1);
            fDao.saveFlight(bru_bern1);
            Flights bru_ber2 = new Flights("bru_ber2", "Brussel", "Berlin", "Boeing 747-400", "2022.05.16 13:00", 69.99);
            bru.addFlightToList(bru_ber2);
            fDao.saveFlight(bru_ber2);
            Flights bru_bud2 = new Flights("bru_bud2", "Brussel", "Budapest", "Antonov An-12", "2022.05.17 14:00", 139.99);
            bru.addFlightToList(bru_bud2);
            fDao.saveFlight(bru_bud2);
            Flights bru_bar2 = new Flights("bru_bar2", "Brussel", "Barcelona", "Fairchild-Dornier 328JET", "2022.05.17 12:00", 119.99);
            bru.addFlightToList(bru_bar2);
            fDao.saveFlight(bru_bar2);
            Flights bru_lon2 = new Flights("bru_lon2", "Brussel", "London", "Boeing 747-400", "2022.05.21 08:00", 59.99);
            bru.addFlightToList(bru_lon2);
            fDao.saveFlight(bru_lon2);
            Flights bru_vie2 = new Flights("bru_vie2", "Brussel", "Vienna", "British Aerospace ATP", "2022.05.22 09:30", 159.99);
            bru.addFlightToList(bru_vie2);
            fDao.saveFlight(bru_vie2);
            Flights bru_bern2 = new Flights("bru_bern2", "Brussel", "Bern", "Antonov An-12", "2022.05.18 17:00", 129.99);
            bru.addFlightToList(bru_bern2);
            fDao.saveFlight(bru_bern2);

        //Bernbol indulok
            Flights bern_deb1 = new Flights("bern_deb1", "Bern", "Debrecen", "British Aerospace ATP", "2022.05.11 08:00", 159.99);
            bern.addFlightToList(bern_deb1);
            fDao.saveFlight(bern_deb1);
            Flights bern_lon1 = new Flights("bern_lon1", "Bern", "London", "Boeing 747-400", "2022.05.12 10:00", 139.99);
            bern.addFlightToList(bern_lon1);
            fDao.saveFlight(bern_lon1);
            Flights bern_bar1 = new Flights("bern_bar1", "Bern", "Barcelona", "Fairchild-Dornier 328JET", "2022.05.14 18:00", 179.99);
            bern.addFlightToList(bern_bar1);
            fDao.saveFlight(bern_bar1);
            Flights bern_pra1 = new Flights("bern_pra1", "Bern", "Prague", "Antonov An-12", "2022.05.13 12:00", 209.99);
            bern.addFlightToList(bern_pra1);
            fDao.saveFlight(bern_pra1);
            Flights bern_rom1 = new Flights("bern_rom1", "Bern", "Rome", "British Aerospace ATP", "2022.05.15 14:00", 189.99);
            bern.addFlightToList(bern_rom1);
            fDao.saveFlight(bern_rom1);
            Flights bern_ams1 = new Flights("bern_ams1", "Bern", "Amsterdam", "Antonov An-12", "2022.05.14 15:00", 139.99);
            bern.addFlightToList(bern_ams1);
            fDao.saveFlight(bern_ams1);
            Flights bern_deb2 = new Flights("bern_deb2", "Bern", "Debrecen", "British Aerospace ATP", "2022.05.16 11:00", 169.99);
            bern.addFlightToList(bern_deb2);
            fDao.saveFlight(bern_deb2);
            Flights bern_lon2 = new Flights("bern_lon2", "Bern", "London", "Boeing 747-400", "2022.05.21 16:00", 169.99);
            bern.addFlightToList(bern_lon2);
            fDao.saveFlight(bern_lon2);
            Flights bern_bar2 = new Flights("bern_bar2", "Bern", "Barcelona", "Fairchild-Dornier 328JET", "2022.05.19 15:00", 169.99);
            bern.addFlightToList(bern_bar2);
            fDao.saveFlight(bern_bar2);
            Flights bern_pra2 = new Flights("bern_pra2", "Bern", "Prague", "British Aerospace ATP", "2022.05.23 16:00", 229.99);
            bern.addFlightToList(bern_pra2);
            fDao.saveFlight(bern_pra2);
            Flights bern_rom2 = new Flights("bern_rom2", "Bern", "Rome", "Boeing 747-400", "2022.05.25 09:00", 179.99);
            bern.addFlightToList(bern_rom2);
            fDao.saveFlight(bern_rom2);
            Flights bern_ams2 = new Flights("bern_ams2", "Bern", "Amsterdam", "Antonov An-12", "2022.05.17 12:00", 169.99);
            bern.addFlightToList(bern_ams2);
            fDao.saveFlight(bern_ams2);

        //Praguebol indulok
            Flights pra_bud1 = new Flights("pra_bud1", "Prague", "Budapest", "British Aerospace ATP", "2022.05.13 13:00", 139.99);
            pra.addFlightToList(pra_bud1);
            fDao.saveFlight(pra_bud1);
            Flights pra_lon1 = new Flights("pra_lon1", "Prague", "London", "Boeing 747-400", "2022.05.14 08:00", 159.99);
            pra.addFlightToList(pra_lon1);
            fDao.saveFlight(pra_lon1);
            Flights pra_ber1 = new Flights("pra_ber1", "Prague", "Berlin", "Antonov An-12", "2022.05.12 17:00", 179.99);
            pra.addFlightToList(pra_ber1);
            fDao.saveFlight(pra_ber1);
            Flights pra_vie1 = new Flights("pra_vie1", "Prague", "Vienna", "British Aerospace ATP", "2022.05.15 07:00", 119.99);
            pra.addFlightToList(pra_vie1);
            fDao.saveFlight(pra_vie1);
            Flights pra_deb1 = new Flights("pra_deb1", "Prague", "Debrecen", "Antonov An-12", "2022.05.13 16:00", 129.99);
            pra.addFlightToList(pra_deb1);
            fDao.saveFlight(pra_deb1);
            Flights pra_bern1 = new Flights("pra_bern1", "Prague", "Bern", "Boeing 747-400", "2022.05.11 10:00", 149.99);
            pra.addFlightToList(pra_bern1);
            fDao.saveFlight(pra_bern1);
            Flights pra_rom1 = new Flights("pra_rom1", "Prague", "Roma", "British Aerospace ATP", "2022.05.14 13:00", 129.99);
            pra.addFlightToList(pra_rom1);
            fDao.saveFlight(pra_rom1);
            Flights pra_bud2 = new Flights("pra_bud2", "Prague", "Budapest", "Fairchild-Dornier 328JET", "2022.05.17 15:00", 149.99);
            pra.addFlightToList(pra_bud2);
            fDao.saveFlight(pra_bud2);
            Flights pra_lon2 = new Flights("pra_lon2", "Prague", "London", "Boeing 747-400", "2022.05.18 18:00", 109.99);
            pra.addFlightToList(pra_lon2);
            fDao.saveFlight(pra_lon2);
            Flights pra_ber2 = new Flights("pra_ber2", "Prague", "Berlin", "British Aerospace ATP", "2022.05.21 13:00", 169.99);
            pra.addFlightToList(pra_ber2);
            fDao.saveFlight(pra_ber2);
            Flights pra_vie2 = new Flights("pra_vie2", "Prague", "Vienna", "Antonov An-12", "2022.05.24 08:00", 129.99);
            pra.addFlightToList(pra_vie2);
            fDao.saveFlight(pra_vie2);
            Flights pra_deb2 = new Flights("pra_deb2", "Prague", "Debrecen", "Boeing 747-400", "2022.05.21 13:00", 149.99);
            pra.addFlightToList(pra_deb2);
            fDao.saveFlight(pra_deb2);
            Flights pra_bern2 = new Flights("pra_bern2", "Prague", "Bern", "British Aerospace ATP", "2022.05.18 11:00", 129.99);
            pra.addFlightToList(pra_bern2);
            fDao.saveFlight(pra_bern2);
            Flights pra_rom2 = new Flights("pra_rom2", "Prague", "Roma", "Antonov An-12", "2022.05.22 15:00", 159.99);
            pra.addFlightToList(pra_rom2);
            fDao.saveFlight(pra_rom2);

            //megoltem magam kozbe



            //System.out.println(fDao.getFlights());
            //System.out.println(fDao.getFlightsBy_start_city());
            //System.out.println(fDao.findWith_start_city("Debrecen"));
            //System.out.println(fDao.findWith_start_and_destination_city("Debrecen"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void startDatabase() throws SQLException {
        new Server().runTool("-tcp", "-web", "-ifNotExists");
    }
}

