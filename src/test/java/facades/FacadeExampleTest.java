//package facades;
//
//import dtos.PersonDTO;
//import utils.EMF_Creator;
//import entities.Person;
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import org.junit.jupiter.api.AfterAll;
//import org.junit.jupiter.api.AfterEach;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
////Uncomment the line below, to temporarily disable this test
////@Disabled
//public class FacadeExampleTest {
//
//    private static EntityManagerFactory emf;
//    private static FacadeExample facade;
//
//    public FacadeExampleTest() {
//    }
//
//    @BeforeAll
//    public static void setUpClass() {
//       emf = EMF_Creator.createEntityManagerFactoryForTest();
//       facade = FacadeExample.getFacadeExample(emf);
//    }
//
//    @AfterAll
//    public static void tearDownClass() {
////        Clean up database after test is done or use a persistence unit with drop-and-create to start up clean on every test
//    }
//
//    // Setup the DataBase in a known state BEFORE EACH TEST
//    //TODO -- Make sure to change the code below to use YOUR OWN entity class
//    @BeforeEach
//    public void setUp() {
//        EntityManager em = emf.createEntityManager();
//        try {
//            em.getTransaction().begin();
//            em.createNamedQuery("Person.deleteAllRows").executeUpdate();
//            em.persist(new Person("Jesper", "Hansen", "12345678"));
//            em.persist(new Person("Harald", "Olsen", "12345876"));
//
//            em.getTransaction().commit();
//        } finally {
//            em.close();
//        }
//    }
//
//    @AfterEach
//    public void tearDown() {
////        Remove any data after each test was run
//    }
//
//    @Test
//    public void testGetPersonById() {
//        int id = 4; // or any other valid ID
//        PersonDTO expected = new PersonDTO(new Person("Jesper", "Hansen", "12345678"));
//        expected.setId(id);
//
//        PersonDTO actual = facade.getById(id);
//
//        assertEquals(expected.getFirstName(), actual.getFirstName());
//        assertEquals(expected.getLastName(), actual.getLastName());
//        assertEquals(expected.getPhone(), actual.getPhone());
//    }
//
//}
