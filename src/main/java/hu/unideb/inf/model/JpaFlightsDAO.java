package hu.unideb.inf.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
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



    //vissza ad egy listát ami tartalmazza azokat a Flights példányokat amik start_city-je megeggyezik az átadott paraméterel(String)
    public List findWith_start_city(String start_city) {
        return entityManager.createQuery(
                        "SELECT f FROM Flights f WHERE f.start_city LIKE :Flights_start_city")
                .setParameter("Flights_start_city", start_city)
                .setMaxResults(100)
                .getResultList();
    }

    public List findWith_destination_city(String destination_city) {
        return entityManager.createQuery(
                        "SELECT f FROM Flights f WHERE f.destination_city LIKE :Flights_destination_city")
                .setParameter("Flights_destination_city", destination_city)
                .setMaxResults(100)
                .getResultList();
    }

    public List findWith_start_and_destination_city(String start_or_destination_city)
    {
        List<Flights> list_for_flights = new ArrayList<>();
        list_for_flights.addAll(findWith_destination_city(start_or_destination_city));
        list_for_flights.addAll(findWith_start_city(start_or_destination_city));
        return list_for_flights;

    }


    @Override
    public void close() throws Exception {
        entityManager.close();
        entityManagerFactory.close();
    }


}
