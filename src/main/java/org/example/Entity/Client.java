package org.example.Entity;

import org.example.StateEnum.stateClient;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "clients")
public class Client {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;


   @OneToMany
   @JoinColumn(name = "clientId")
    private List<Order> orders = new ArrayList<>();
    private String companyName;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    @Column (columnDefinition = "TEXT")
    private String address;
    private String zipCode;
    private String city;
    private String country;

    @Column (columnDefinition = "BIT")
    private stateClient state;

    public Client() {
    }

    public Client(String firstName) {
        this.firstName = firstName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public stateClient getState() {
        return state;
    }

    public void setState(stateClient state) {
        this.state = state;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public void setNotNullData(Client newClientData){
        if(newClientData.getFirstName() != null) {
            this.setFirstName(newClientData.getFirstName());
        }

        if(newClientData.getLastName() != null) {
            this.setLastName(newClientData.getLastName());
        }

        if(newClientData.getAddress() != null) {
            this.setAddress(newClientData.getAddress());
        }

        if(newClientData.getCity() != null) {
            this.setCity(newClientData.getCity());
        }

        if(newClientData.getCountry() != null) {
            this.setCountry(newClientData.getCountry());
        }

        if(newClientData.getCompanyName() != null) {
            this.setCompanyName(newClientData.getCompanyName());
        }

        if(newClientData.getPhone() != null) {
            this.setPhone(newClientData.getPhone());
        }

        if(newClientData.getZipCode() != null) {
            this.setZipCode(newClientData.getZipCode());
        }

        if(newClientData.getEmail() != null) {
            this.setEmail(newClientData.getEmail());
        }

        if(newClientData.getState() != null) {
            this.setState(newClientData.getState());
        }
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", state=" + state +
                '}';
    }
}
