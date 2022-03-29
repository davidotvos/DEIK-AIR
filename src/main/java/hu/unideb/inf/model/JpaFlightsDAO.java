package hu.unideb.inf.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class JpaFlightsDAO implements FlightsDAO {

    final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("br.com.flights");
    final EntityManager entityManager = entityManagerFactory.createEntityManager();

    @Override
    public void saveFlight(Flights f) {
        entityManager.getTransaction().begin();
        entityManager.persist(f);
        entityManager.getTransaction().commit();
    }

    @Override
    public void deleteFlight(Flights f) {
        entityManager.getTransaction().begin();
        entityManager.remove(f);
        entityManager.getTransaction().commit();
    }

    @Override
    public void updateFlight(Flights f) {
        /*entityManager.getTransaction().begin();
        entityManager.persist(a);
        entityManager.getTransaction().commit();*/
        saveFlight(f);
    }

    @Override
    public List<Flights> getFlights() {
        TypedQuery<Flights> query = entityManager.createQuery(
                "SELECT f FROM Flights f", Flights.class);
        List<Flights> flights = query.getResultList();
        return flights;
    }

    @Override
    public void saveAirport(Airport airport) {
        entityManager.getTransaction().begin();
        entityManager.persist(airport);
        entityManager.getTransaction().commit();
    }



    @Override
    public void close() throws Exception {
        entityManager.close();
        entityManagerFactory.close();
    }


}
