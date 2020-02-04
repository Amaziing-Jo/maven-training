package fr.dawan.formation.persistence;

import fr.dawan.formation.modele.entities.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UserDaoTest {

  private UserDao userDao;
  private User userDeTest;

  @Before
  public void initDb() {
    userDao = new UserDao(BddConnectionTest.getDatabase());
    userDeTest = new User("Gérard", "Depardieu");

    userDao.deleteAll();
  }

  @Test
  public void createTest() throws ClassNotFoundException {
    boolean result = userDao.create(userDeTest);
    assertTrue(result);

    List<User> users = userDao.findAllUsers();
    assertEquals(1, users.size());
  }

  @Test
  public void findAllTest() throws ClassNotFoundException {
    userDao.create(userDeTest);

    List<User> users = userDao.findAllUsers();
    assertEquals(1, users.size());

    userDao.create(userDeTest);
    userDao.create(userDeTest);

    users = userDao.findAllUsers();
    assertEquals(3, users.size());

    userDao.deleteAll();
    users = userDao.findAllUsers();
    assertEquals(0, users.size());
  }

  @Test
  public void deleteAllTest() throws ClassNotFoundException {
    userDao.create(userDeTest);
    List<User> users = userDao.findAllUsers();
    assertEquals(1, users.size());

    boolean result = userDao.deleteAll();
    assertTrue(result);
  }

//    @After
//    public void reinitDb() {
//        userDao.deleteAll();
//    }
}