package org.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.example.DAO.ClientDAO;
import org.example.DAO.OrderDAO;
import org.example.Entity.Client;
import org.example.Entity.Order;
import org.example.StateEnum.stateClient;
import org.example.StateEnum.stateOrder;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class testOrder
{

    @Test
    public void AssertOrder()
    {
        Order order = new Order();
        Client client = ClientDAO.findById(1);
        order.setClient(client);
        order.setTypePresta("Formation");
        order.setDesignation("MANGUE");
        order.setNbDays(5);
        order.setUnitPrice(250.2F);
        order.setState(stateOrder.CONFIRMED);

        OrderDAO.create(order);

        assertTrue( true );
    }
    @Test
    public void findAll(){
        List<Order> orders = OrderDAO.findAll();
        assertEquals(11,orders.size());
    }

    @Test
    public void findById(){
        Order order = OrderDAO.findById(2);
        assertEquals(3,order.getNbDays());
    }
    @Test
    public void findClientByOrder(){
        Order order = OrderDAO.findById(2);
        Client client = order.getClient();
        assertEquals("Julien",client.getFirstName());
    }

    @Test
    public void findOrderByClient() {
        Client client = ClientDAO.findById(1);
        System.out.println(client.getOrders());
        for (Order order : client.getOrders()) {
            System.out.println(order.getId());
        }
    }


    @Test
    public void deleteById(){
        Order order = new Order();
        Client client = ClientDAO.findById(1);
        order.setClient(client);
        order.setTypePresta("Formation");
        order.setDesignation("MANGUE");
        order.setNbDays(5);
        order.setUnitPrice(250.2F);
        order.setState(stateOrder.CONFIRMED);
        OrderDAO.create(order);
        List<Order>orders1 = OrderDAO.findAll();
        Order order2 = OrderDAO.findById(orders1.size());
        OrderDAO.deleteById(order2.getId());
        List<Order> orders = OrderDAO.findAll();
        assertTrue(orders.size()==orders1.size()-1);

    }


    @Test
    public void update(){
        Order newOrderData = new Order();
        Client client = ClientDAO.findById(1);
        newOrderData.setClient(client);
        newOrderData.setTypePresta("For");
        newOrderData.setDesignation("MANGUE");
        newOrderData.setNbDays(5);
        newOrderData.setUnitPrice(250.2F);
        newOrderData.setState(stateOrder.CONFIRMED);
        OrderDAO.update(1,newOrderData);
        Order order2 = OrderDAO.findById(1);
        assertEquals("For",order2.getTypePresta());
    }

}
