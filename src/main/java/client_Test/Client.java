package client_Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import service.RateLimiter;
import slidingWindowCounter.SlidingWindowCounterRateLimiter;


public class Client {
    private RateLimiter rateLimiter;

    public Client(RateLimiter rateLimiter) {
        this.rateLimiter = rateLimiter;
    }

    void registerUser(String userId) {
        int windowTimeInSec = 60;
        int requests = 100;
        rateLimiter.addUser(userId, requests, windowTimeInSec);
    }

    boolean checkIfAllowed(String userId) {
        boolean isAllowed = rateLimiter.shouldAllowServiceCall(userId);
        return isAllowed;
    }

    public static void main(String[] args) {

        RateLimiter limiter= new SlidingWindowCounterRateLimiter();

        Client client = new Client(limiter);

        List<String> users = new ArrayList<>();
        for (int i = 1; i < 5; i++) {
            String usr = "user " + i;
            client.registerUser(usr);
            users.add(usr);

        }

        ExecutorService executors = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 10000; i++) {

            int rand = new Random().nextInt(4);
            Task task = new Task(users.get(rand), client);
            executors.submit(task);

        }
    }
}

class Task implements Callable<Boolean> {
    private String user;
    private Client client;

    public Task(String user, Client client) {
        super();
        this.user = user;
        this.client = client;
    }

    @Override
    public Boolean call() throws Exception {
        Thread.sleep(300);

        boolean result = client.checkIfAllowed(user);

        if(!result) {
            System.out.println(user + " : request got rejected");
        }
        return result;

    }

}