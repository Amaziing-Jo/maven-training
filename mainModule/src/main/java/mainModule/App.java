package mainModule;

import fr.dawan.formation.services.UserService;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args ) throws ClassNotFoundException {
        Scanner sc = new Scanner(System.in);
        UserService userService = new UserService();

        System.out.println("Que voulez-vous faire ? \n 1 - Lister la base de données \n 2 - Ajouter dans la base de données \n 3 - Quitter l'application");

        switch(sc.nextInt()) {
            case 1:
                userService.listing();
                break;

            case 2:
                userService.addUser(sc);
                break;
        }

        System.out.println("End main function");
    }
}