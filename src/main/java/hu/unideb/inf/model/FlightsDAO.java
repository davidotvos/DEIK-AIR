package hu.unideb.inf.model;

import java.util.List;

public interface FlightsDAO extends AutoCloseable{

    public void saveFlight(Flights f);
    public void deleteFlight(Flights f);
    public void updateFlight(Flights f);
    public List<Flights> getFlights();
    public void saveAirport(Airport airport);
    public List<Flights> findWith_start_city(String name);
    public List<Flights> findWith_destination_city(String destination_city);
    public List<Flights> findWith_start_and_destination_city(String start_or_destination_city);

}
