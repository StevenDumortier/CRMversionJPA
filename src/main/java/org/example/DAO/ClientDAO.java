package org.example.DAO;

import org.example.Entity.Client;
import org.example.jpa.EntityManagerSingleton;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class ClientDAO {

    public static void create(Client clientToCreate){
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.persist(clientToCreate);
        tx.commit();
    }
    public static Client findById(int id){
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();
        Client client = entityManager.find(Client.class, id);
        return client;
    }

    public static List<Client> findAll(){
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();
        Query findAllQuery = entityManager.createQuery("select c from Client c");
        return findAllQuery.getResultList();
    }

    public static void deleteById(int id){
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();

        EntityTransaction tx = entityManager.getTransaction();

        tx.begin();
        Query deleteQuery = entityManager.createQuery("delete from Client c where c.id= :id");
        deleteQuery.setParameter("id", id);
        int result = deleteQuery.executeUpdate();
        entityManager.clear();
        tx.commit();
    }

    public static void update(int id, Client newClientData) {
        EntityManager entityManager = EntityManagerSingleton.getEntityManager();

        Client clientToUpdate = entityManager.find(Client.class, id);
        clientToUpdate.setNotNullData(newClientData);
        EntityTransaction tx = null;

        try{
            tx= entityManager.getTransaction();
            tx.begin();
            entityManager.merge(clientToUpdate);
            tx.commit();
        } catch (Exception e){
            tx.rollback();
        }
    }


}
