package model.service;
import model.entity.*;
import static model.entity.RailwayVehicle.TrackSize.*;
import static model.entity.RailwayVehicle.Function.*;
import static model.entity.CarriageType.*;


public enum DBVehicleTypes {
    PASSENGER_LOCOMOTIVE(new Locomotive(Passenger,EURO_TRACK, Locomotive.Engine.Diesel,20000, 150)),
    FREIGHT_LOCOMOTIVE(new Locomotive(Freight, RailwayVehicle.TrackSize.EURO_TRACK,
            Locomotive.Engine.Electric,20000, 120)),
    FREIGHT_WAGON(new FreightWagon(EURO_TRACK, FreightWagon.FreightType.Coal,80)),
    CARRIAGE_SEATING2(new Carriage(EURO_TRACK, Seating2Class)),
    CARRIAGE_SEATING1(new Carriage(EURO_TRACK, Seating1Class)),
    CARRIAGE_BERTH(new Carriage(EURO_TRACK, Berth)),
    CARRIAGE_COMPARTMENT(new Carriage(EURO_TRACK, Compartment)),
    CARRIAGE_LUX(new Carriage(EURO_TRACK, DeLuxe));

    PASSENGER_SLEEPING_TRAIN(new PassengerTrain(Passenger,EURO_TRACK,PASSENGER_LOCOMOTIVE,CARRIAGE_LUX, CARRIAGE_COMPARTMENT,CARRIAGE_BERTH)),
    //PASSENGER_TRAIN(PASSENGER_LOCOMOTIVE),
    PASSENGER_FAST_TRAIN(PASSENGER_LOCOMOTIVE.getRailwayVehicle(), CARRIAGE_SEATING1.getRailwayVehicle(),CARRIAGE_SEATING2.getRailwayVehicle()),
    FREIGHT_TRAIN(PASSENGER_LOCOMOTIVE.getRailwayVehicle(),FREIGHT_WAGON.getRailwayVehicle());

    private RailwayVehicle[] railwayVehicle;
    DBVehicleTypes(RailwayVehicle...vehicles){
        this.railwayVehicle = railwayVehicle;
    }
    public RailwayVehicle getRailwayVehicle() {
        return railwayVehicle;
    }
}
