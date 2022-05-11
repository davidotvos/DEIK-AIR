package hu.unideb.inf.model;

import java.util.List;

public interface ReservationsDAO extends AutoCloseable{
    public void saveReservation(Reservations r);
    public void deleteReservation(Reservations r);
    public void updateReservation(Reservations r);
    public List<Reservations> getReservations();
}
