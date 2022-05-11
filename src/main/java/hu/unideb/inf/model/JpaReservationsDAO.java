package hu.unideb.inf.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class JpaReservationsDAO implements ReservationsDAO{

    final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("br.com.flights");
    final EntityManager entityManager = entityManagerFactory.createEntityManager();

    @Override
    public void saveReservation(Reservations r) {
        entityManager.getTransaction().begin();
        entityManager.persist(r);
        entityManager.getTransaction().commit();
    }

    @Override
    public void deleteReservation(Reservations r) {
        entityManager.getTransaction().begin();
        entityManager.remove(r);
        entityManager.getTransaction().commit();
    }

    @Override
    public void updateReservation(Reservations r) {
        saveReservation(r);
    }

    @Override
    public List<Reservations> getReservations() {
        TypedQuery<Reservations> query = entityManager.createQuery(
                "SELECT r FROM Reservations r", Reservations.class);
        List<Reservations> reservations = query.getResultList();
        return reservations;
    }

    @Override
    public void close() throws Exception {
        entityManager.close();
        entityManagerFactory.close();
    }
}
