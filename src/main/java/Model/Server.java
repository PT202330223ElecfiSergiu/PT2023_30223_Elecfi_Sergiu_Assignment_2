package Model;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicInteger;

public class Server implements Runnable{
    private BlockingQueue<Client> clienti;
    private AtomicInteger waitingPeriod;

    //DONE
    public Server(){
        //initializare coada si timpul de asteptare
        clienti = new LinkedBlockingDeque<>();
        waitingPeriod = new AtomicInteger(0);

    }

    //DONE
    public void addClient(Client newClient){
        //adaugare client la coada
        clienti.add(newClient);
        //se incrementeaza timpul de asteptare
        waitingPeriod.getAndAdd(newClient.getServiceTime());
    }

    //DONE
    @Override
    public void run() {
        while(true){
            try {
                //se ia urm. client din coada
                Client client = clienti.take();
                //se pune thread-ul pe sleep pentru a simula procesarea clientului
                Thread.sleep(client.getServiceTime());
                //se decrementeaza perioada de asteptare a serverului
                waitingPeriod.getAndAdd(-client.getServiceTime());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public int getWaitingPeriod(){

        return this.waitingPeriod.intValue();
    }
}

