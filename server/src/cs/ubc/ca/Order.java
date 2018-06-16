package cs.ubc.ca;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Calendar;

public class Order {
    private OrderTypes type;
    private String username;
    private String ticker;
    private String exchange;
    private int numShares;
    private String portName;
    private Float price;
    private int orderID;
    private boolean orderIDSet;

    public Order (OrderTypes type, String username, String ticker, String exchange, String portName, int numShares, Float price) {
        this.type = type;
        this.username = username;
        this.ticker = ticker;
        this.exchange = exchange;
        this.portName = portName;
        this.numShares = numShares;
        this.price = price;
        orderIDSet = false;
    }

    public boolean addOrderID(int id) {
        if(orderIDSet)
            return false;

        orderID = id;
        return true;
    }

    // We are assuming order id is positive here.
    public int getOrderID() {

        if(orderIDSet)
            return orderID;

        return -1;
    }

    public OrderTypes getType() {
        return type;
    }

    public String getTicker() {
        return ticker;
    }

    public String getTradedOrder() {
        String tradedOrder = "(" + type + ",'" + ticker + "'," + numShares + "," + price + ",'" + exchange + "'," +
                "NOW()" + ",'" + portName + "','" + username + "')";

        return tradedOrder;
    }

    public String getTradedOrderFields() {
        return "(type, ticker, num_shares, price, abbre, order_time, p_name, username)";
    }

    public String getCloseOrder() {
        return "";
    }

    public String getClosedOrderFields() {
        return "";
    }

}