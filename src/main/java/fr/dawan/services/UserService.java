package fr.dawan.services;

import fr.dawan.entities.User;
import fr.dawan.persistence.BddConnection;
import fr.dawan.persistence.UserDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Scanner;

public class UserService {

    private static final Logger logger = LogManager.getLogger("App");

    public static void listing() {
        UserDao userDao = new UserDao(BddConnection.getDatabase());
        List<User> allUsers = userDao.findAllUsers();
        for(User u: allUsers) {
            System.out.println(u);
        }
    }

    public static void addUser(Scanner sc) throws ClassNotFoundException {
        User user = new User();
        UserDao userDao = new UserDao(BddConnection.getDatabase());

        System.out.println("Veuillez saisir le prenom de l'utilisateur a enregistré  : ");
        String resultPrenom = sc.next();
        while(resultPrenom.length() < 3) {
            System.out.println("Erreur trop petit");
            System.out.println("Veuillez saisir le prenom de l'utilisateur a enregistré  : ");
            resultPrenom = sc.next();
        }
        user.setPrenom(resultPrenom);

        System.out.println("Veuillez saisir le nom de l'utilisateur a enregistré  : ");
        String resultNom = sc.next();
        while(resultNom.length() < 3) {
            System.out.println("Erreur trop petit");
            System.out.println("Veuillez saisir le nom de l'utilisateur a enregistré  : ");
            resultNom = sc.next();
        }
        user.setPrenom(resultNom);

        userDao.create(user);
        logger.info("L'utilisateur " + user.getPrenom() + " " + user.getNom() + " a été ajouté.");
    }
}
