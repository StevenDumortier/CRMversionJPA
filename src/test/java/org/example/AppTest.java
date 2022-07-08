package org.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.example.DAO.ClientDAO;
import org.example.Entity.Client;
import org.example.StateEnum.stateClient;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class AppTest 
{

    @Test
    public void AssertClient()
    {
        Client client = new Client();
        client.setFirstName("Alain");
        client.setLastName("Delon");
        client.setAddress("rue de la mairie");
        client.setCity("Paris");
        client.setCompanyName("Google");
        client.setCountry("France");
        client.setEmail("alain@delon.fr");
        client.setPhone("060606060606");
        client.setZipCode("75000");
        client.setState(stateClient.active);
        ClientDAO.create(client);

        Client client2 = ClientDAO.findById(client.getId());
        assertEquals("Alain",client2.getFirstName());

    }
    @Test
    public void findById(){
        Client client2 = ClientDAO.findById(2);
        assertEquals("Julien",client2.getFirstName());
    }

    @Test
    public void findAll(){
        List<Client> clients = ClientDAO.findAll();
        assertEquals(5,clients.size());
    }
    @Test
    public void deleteById(){
        List<Client> clients = ClientDAO.findAll();
        assertEquals(5,clients.size());
        ClientDAO.deleteById(5);
        List<Client> clients2 = ClientDAO.findAll();
        assertTrue(clients.size()<clients2.size());
    }

    @Test
    public void update(){
        Client newClientData = new Client();
        newClientData.setFirstName("Steven");
        newClientData.setLastName("Delon");
        newClientData.setAddress("rue de la mairie");
        newClientData.setCity("Paris");
        newClientData.setCompanyName("Google");
        newClientData.setCountry("France");
        newClientData.setEmail("alain@delon.fr");
        newClientData.setPhone("060606060606");
        newClientData.setZipCode("75000");
        newClientData.setState(stateClient.inactive);
        ClientDAO.update(1,newClientData);
        Client client2 = ClientDAO.findById(1);
        assertEquals("Steven",client2.getFirstName());
    }

}
