package SimulationManager;
//import Strategy.SelectionPolicy;
import Scheduler.Scheduler;
import Client.Client;
import Interfata.SimulationFrame;
import Server.Server;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SimulationManager implements Runnable{

    public int timeLimit;
    public int maxProcessingTime;
    public int minArrivalTime;
    public int maxArrivalTime;
    public int minProcessingTime;
    public int numberOfServers;
    public int numberOfClients;
    //public SelectionPolicy selectionPolicy = SelectionPolicy.SHORTEST_TIME;
    //entity responsible with queue management and clients distribution
    private Scheduler Scheduler;
    //frane for displaying simulation
    private SimulationFrame frame;
    //pool of clients
    private ArrayList<Client> generatedClients;

    public SimulationManager(int timeLimit, int maxProcessingTime, int minProcessingTime, int numberOfClients, int numberOfServers, int minArrivalTime, int maxArrivalTime){
        this.timeLimit = timeLimit;
        this.maxProcessingTime = maxProcessingTime;
        this.minProcessingTime = minProcessingTime;
        this.numberOfClients = numberOfClients;
        this.numberOfServers = numberOfServers;
        this.minArrivalTime = minArrivalTime;
        this.maxArrivalTime = maxArrivalTime;

        //initialize the scheduler
        //     => create and start numberOfServers threads
        //     => initialize selection straategy => create Strategy;
        this.Scheduler = new Scheduler(numberOfServers,numberOfClients);
        //initialize frame to display simulation
        frame = new SimulationFrame();
        //generate numberOfClients clients using generateNRandomClients and store them into generatedClients
        generatedClients = new ArrayList<Client>();
        generateNRandomClients();
    }

    public void generateNRandomClients(){
        //generate N random tasks
        for(int i = 1; i <= numberOfClients; i++){
            // - random processing time
            // minProcessingTime < processingTime < max ProcessingTime
            int processingTime = (int) (Math.random() * (maxProcessingTime - minProcessingTime) + minProcessingTime);
            // -random arrivalTime
            int arrivalTime = (int) (Math.random() * (maxArrivalTime - minArrivalTime) + minArrivalTime);
            Client client = new Client(i,processingTime,arrivalTime);
            generatedClients.add(client);
        }
        // sort list with respect to arrivalTime
        Collections.sort(generatedClients);
    }

    @Override
    public void run() {
        int currentTime = 0;
        while(currentTime < timeLimit){
            //iterate generatedClients list and pick clients that have the arrivalTime equal with the currentTime
            List<Client> clients = new ArrayList<Client>();
            for(int i = 0; i < generatedClients.size(); i++){
                Client client = generatedClients.get(i);
                if(client.arrivalTime == currentTime){
                    clients.add(client);
                }
            }
            //   -send task to queue by calling the dispatchTask method from Scheduler
            //Scheduler.changeStrategy(selectionPolicy);
            for(Client client : clients){
                Scheduler.dispatchClient(client);
                //   -delete client from list
                generatedClients.remove(client);
            }
            // update SimulationFrame
            currentTime++;
            //wait an interval of 1 second
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
