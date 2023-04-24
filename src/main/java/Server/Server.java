package Server;
import Client.Client;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Server implements Runnable{
    private BlockingQueue<Client> clienti;
    private AtomicInteger waitingPeriod;

    public Server(){
        //initializare coada si timpul de asteptare
    }

    public void addClient(Client newClient){
        //adaugare client la coada
        //se incrementeaza timpul de asteptare
    }

    @Override
    public void run() {
        while(true){
            //se ia urm. client din coada
            //se pune thread-ul pe sleep
            //se decrementeaza perioada de asteptare
        }
    }
}

