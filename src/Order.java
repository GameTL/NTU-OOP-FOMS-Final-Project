package src;

import java.util.ArrayList;
import java.util.List;

public class Order{
    private Integer orderId;
    private List<OrderItem> items;
    private String status;
    private double totalPrice;

    public Order(){
        this.orderId = orderId;
        this.items = new ArrayList<>();
        this.status = status;
        this.totalPrice = totalPrice;
    }
    public Integer getOrderId() {
        return orderId;
    }
    public List<OrderItem> getItems() {
        return items;
    }
    public String getStatus() {
        return this.status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public double getTotalPrice() {
        return totalPrice;
    }

}