package hu.unideb.inf.model;

import java.util.List;

public interface FlightsDAO extends AutoCloseable{

    public void saveFlight(Flights a);
    public void deleteFlight(Flights a);
    public void updateFlight(Flights a);
    public List<Flights> getFlights();
    public void saveZoo(Zoo zoo);



}
