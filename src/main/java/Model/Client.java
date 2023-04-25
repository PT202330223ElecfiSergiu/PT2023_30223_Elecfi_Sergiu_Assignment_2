package Model;

public class Client implements Comparable<Client>{
    public int id;
    public int serviceTime;
    public int arrivalTime;

    public Client(int id, int serviceTime, int arrivalTime){
        this.id = id;
        this.serviceTime = serviceTime;
        this.arrivalTime = arrivalTime;
    }

    public int getId() {
        return id;
    }

    public int getServiceTime() {
        return serviceTime;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    @Override
    public int compareTo(Client other) {
        return Integer.compare(this.arrivalTime, other.arrivalTime);
    }
}