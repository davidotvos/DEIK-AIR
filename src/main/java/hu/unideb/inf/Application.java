package hu.unideb.inf;

import java.sql.SQLException;

import hu.unideb.inf.model.*;
import org.h2.tools.Server;

public class Application{



    public static void start(String[] args) throws SQLException {
        startDatabase();

        try (FlightsDAO aDao = new JpaFlightsDAO();){
                Flights a = new Flights("test1","Debrecen", "Berlin", "Boeing 747-400", "2022.04.01 12:00" );
                aDao.saveFlight(a);
                Airport bud = new Airport();
                aDao.saveAirport(bud);


        } catch (Exception e) {
            e.printStackTrace();
        }

        // Ex 1
        /*Customer customer = new Customer();
        customer.setFirstName("Dennys");
        customer.setLastName("Fredericci");

        Animal elephant = new Animal();
        elephant.setName("Nelly");
        elephant.setAge(10);
        elephant.setGender(Animal.GenderType.FEMALE);

        entityManager.getTransaction().begin();
        entityManager.persist(customer);
        entityManager.persist(elephant);
        entityManager.getTransaction().commit();

        System.out.println("Open your browser and navigate to http://localhost:8082/");
        System.out.println("JDBC URL: jdbc:h2:mem:my_database");
        System.out.println("User Name: sa");
        System.out.println("Password: ");*/

    }

    private static void startDatabase() throws SQLException {
        new Server().runTool("-tcp", "-web", "-ifNotExists");
    }
}
