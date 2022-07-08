package org.example.Entity;

import org.example.StateEnum.stateOrder;

import javax.persistence.*;

@Entity
@Table(name="orders")

public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "clientId")
    private Client client;
    private String typePresta;
    private String designation;
    private int nbDays;
    private float unitPrice;
    @Column(columnDefinition = "BIT")
    private stateOrder state;

    public Order() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getTypePresta() {
        return typePresta;
    }

    public void setTypePresta(String typePresta) {
        this.typePresta = typePresta;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public int getNbDays() {
        return nbDays;
    }

    public void setNbDays(int nbDays) {
        this.nbDays = nbDays;
    }

    public float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
    }

    public stateOrder getState() {
        return state;
    }

    public void setState(stateOrder state) {
        this.state = state;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setNotNullData(Order newOrderData) {
        if (newOrderData.getTypePresta() != null) {
            this.setTypePresta(newOrderData.getTypePresta());
        }
        if (newOrderData.getDesignation() != null) {
            this.setDesignation(newOrderData.getDesignation());
        }
        if (newOrderData.getNbDays() != 0) {
            this.setNbDays(newOrderData.getNbDays());
        }
        if (newOrderData.getUnitPrice() != 0) {
            this.setUnitPrice(newOrderData.getUnitPrice());
        }
        if (newOrderData.getState() != null) {
            this.setState(newOrderData.getState());
        }
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", client=" + client +
                ", typePresta='" + typePresta + '\'' +
                ", designation='" + designation + '\'' +
                ", nbDays=" + nbDays +
                ", unitPrice=" + unitPrice +
                ", state=" + state +
                '}';
    }
}
