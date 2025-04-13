package Kompozycja;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Order {
    private String orderNumber;
    private Set<OrderItem> items = new HashSet<>();

    public Order(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public void addItem(String productName, int quantity) {
        new OrderItem(this, productName, quantity); // tworzy i wiąże nowy obiekt "części"
    }

    protected void addItemInternal(OrderItem item) {
        items.add(item); // dodaje do zbioru tylko z wnętrza klasy OrderItem
    }

    public Set<OrderItem> getItems() {
        return Collections.unmodifiableSet(items);
    }

    public void removeItem(OrderItem item) {
        if (items.remove(item)) {
            item.destroy(); // zerwij powiązanie z "całością"
        }
    }

    public void destroy() {
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
