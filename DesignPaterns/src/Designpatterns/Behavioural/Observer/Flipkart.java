package Designpatterns.Behavioural.Observer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Flipkart {
    private static Map<Events, List<Subscriber>> subscribers = new HashMap();
//    have all the subscriber classes in this list
    public static void registerSubscriber(Events event, Subscriber subscriber) {
        if(!subscribers.containsKey(event)) {
            subscribers.put(event, new ArrayList<>());
            subscribers.get(event).add(subscriber);
        }
    }

    public void notify(Events event, Order order) {
        for(Subscriber subscriber: subscribers.get(event)){
            subscriber.listen(order);
        }
    }

    public void placeOrder(Order order) {
        notify(Events.ORDER_PLACED, order);
    }
}
