package Kompozycja;

import util.ObjectPlus;

import java.util.*;

public class Order extends ObjectPlus {
    private String orderNumber;
    private List<OrderItem> items = new ArrayList<>();

    public Order(String orderNumber) {
        try{
            this.orderNumber = orderNumber;
        }catch (Exception e){
            removeFromExtent();
        }

    }

    public void addItem(String productName, int quantity) {
        new OrderItem(this, productName, quantity); // tworzy i wiąże nowy obiekt "części"
    }

    protected void addItemInternal(OrderItem item) {
        items.add(item); // dodaje do zbioru tylko z wnętrza klasy OrderItem
    }

    public List<OrderItem> getItems() {
        return Collections.unmodifiableList(items);
    }

    public void removeItem(OrderItem item) {
        items.remove(item);
        item.destroy(); // usuń referencję do całości
    }

    @Override
    public void removeFromExtent() {
        super.removeFromExtent();
        for (OrderItem item : items) {
            item.destroy(); // usuń referencję do całości
        }
        items.clear(); // usuń część z całości
    }

    @Override
    public String toString() {
        return "Order{" + orderNumber + ", items=" + items + '}';
    }
}
