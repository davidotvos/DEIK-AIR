package hu.unideb.inf;

import java.sql.SQLException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import hu.unideb.inf.model.*;
import org.h2.tools.Server;

public class Application {

    public static void main(String[] args) throws SQLException {
        startDatabase();

        try (AnimalDAO aDao = new JpaAnimalDAO();){
                Animal a = new Animal();
                a.setName("Pepa");
                a.setAge(5);
                a.setGender(Animal.GenderType.FEMALE);
                //aDao.saveAnimal(a);

                Zoo zoo = new Zoo();
                zoo.setName("Debrecen Zoo");
                zoo.getAnimals().add(a);
                aDao.saveZoo(zoo);

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
