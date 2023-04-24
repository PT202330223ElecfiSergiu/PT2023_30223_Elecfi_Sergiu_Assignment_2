package Scheduler;
import Server.Server;
import Client.Client;
import java.util.List;
//import Strategy.Strategy;
//import Strategy.SelectionPolicy;
//import Strategy.ConcreteStrategyTime;
//import Strategy.ConcreteStrategyQueue;
public class Scheduler {
    private List<Server> servers;
    private int maxNoServers;
    private int maxClientsPerServer;
    //private Strategy strategy;

    public Scheduler(int maxNoServers, int maxClientsPerServer){
        //for maxNoServers
        // - create server object
        //  - create thread with the object
    }
    /*public void changeStrategy(SelectionPolicy policy){
        //apply strategy patter to instantiate the strategy with the concrete strategy corresponding to policy
        if(policy == SelectionPolicy.SHORTEST_QUEUE){
            //strategy = new ConcreteStrategyQueue();
        }
        if(policy == SelectionPolicy.SHORTEST_TIME){
            //strategy = new ConcreteStrategyTime();
        }
    }*/

    public void dispatchClient(Client t){
        //call the strategy addTask method
    }

    public List<Server> getServers(){
        return servers;
    }
}

