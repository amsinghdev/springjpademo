package com.amit.jpa.inheritance.client;

import com.amit.jpa.inheritance.entity.Animal;
import com.amit.jpa.inheritance.entity.Cat;
import com.amit.jpa.inheritance.entity.Dog;

import javax.persistence.*;
import java.util.List;

public class SingleStartegyClient {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello-jpa");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
          // Single Table Startegy
//        Cat cat = new Cat();
//        cat.setName("Milky way");
//
//        Dog dog = new Dog();
//        dog.setName("Brave way");
//        em.persist(cat);
//        em.persist(dog);
        //Ploymorphic Query
        Query query = em.createQuery("select animal from Animal animal");
        List<Animal> animalList = query.getResultList();

        for(Animal animal: animalList){
            System.out.println(animal);
        }

        tx.commit();
        em.close();
    }
}
