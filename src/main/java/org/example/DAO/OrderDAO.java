package org.example.DAO;

import org.example.Entity.Client;
import org.example.Entity.Order;
import org.example.jpa.EntityManagerSingleton;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;


    public class OrderDAO {

        public static void create(Order orderToCreate){
            EntityManager entityManager = EntityManagerSingleton.getEntityManager();
            EntityTransaction tx = entityManager.getTransaction();
            tx.begin();
            entityManager.persist(orderToCreate);
            tx.commit();
        }
        public static Order findById(int id){
            EntityManager entityManager = EntityManagerSingleton.getEntityManager();
            Order order = entityManager.find(Order.class, id);
            return order;
        }


        public static List<Order> findAll(){
            EntityManager entityManager = EntityManagerSingleton.getEntityManager();
            Query findAllQuery = entityManager.createQuery("select c from Order c");
            return findAllQuery.getResultList();
        }


        public static void deleteById(int id){
            EntityManager entityManager = EntityManagerSingleton.getEntityManager();

            EntityTransaction tx = entityManager.getTransaction();

            tx.begin();
            Query deleteQuery = entityManager.createQuery("delete from Order c where c.id= :id");
            deleteQuery.setParameter("id", id);
            int result = deleteQuery.executeUpdate();
            entityManager.clear();
            tx.commit();
        }

        public static void update(int id, Order newOrderData) {
            EntityManager entityManager = EntityManagerSingleton.getEntityManager();

            Order orderToUpdate = entityManager.find(Order.class, id);
            orderToUpdate.setNotNullData(newOrderData);
            EntityTransaction tx = null;

            try{
                tx= entityManager.getTransaction();
                tx.begin();
                entityManager.merge(orderToUpdate);
                tx.commit();
            } catch (Exception e){
                tx.rollback();
            }
        }


    }


