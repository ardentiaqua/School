package Kompozycja;

import util.ObjectPlus;

public class OrderItem extends ObjectPlus {
    private String productName;
    private int quantity;
    private Order order; // referencja do całości (kompozycja)

    protected OrderItem(Order order, String productName, int quantity) {
        try {
            if (order == null) {
                throw new IllegalArgumentException("OrderItem must belong to an Order.");
            }

            if (this.order != null) {
                throw new IllegalStateException("This OrderItem is already part of an Order.");
            }

            this.order = order;
            this.productName = productName;
            this.quantity = quantity;

            order.addItemInternal(this); // referencja zwrotna
        } catch (Exception e) {
            removeFromExtent();
        }
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public Order getOrder() {
        return order;
    }

    protected void destroy() {
        this.order = null; // usuwanie powiązania
    }

    @Override
    public String toString() {
        return "OrderItem{" + productName + ", qty=" + quantity + '}';
    }

    @Override
    public void removeFromExtent() {
        if (order != null) {
            order.removeItem(this); // usuwanie powiązania
        }
        super.removeFromExtent();
    }
}
