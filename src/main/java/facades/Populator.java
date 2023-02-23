/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import dtos.PersonDTO;
import entities.Person;

import javax.persistence.EntityManagerFactory;
import utils.EMF_Creator;

/**
 *
 * @author tha
 */
public class Populator {
    public static void populate(){
        EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory();
        FacadeExample fe = FacadeExample.getFacadeExample(emf);
        fe.create(new PersonDTO(new Person("Bruno", "Hansen", "12345678")));
        fe.create(new PersonDTO(new Person("Raphael", "Olsen", "12345876")));
        fe.create(new PersonDTO(new Person("David", "Jensen", "87654321")));
    }
    
    public static void main(String[] args) {
        populate();
    }
}
