package fr.dawan.formation.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import fr.dawan.formation.modele.entities.User;
import fr.dawan.formation.services.UserService;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/users")
public class ListController extends HttpServlet {

  private Gson gson = new Gson();

  // Fonction qui envoie l'objet JSON correspond à l'adresse localhost:9090/webView/users
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    UserService userService = new UserService();
    List<User> users = userService.listing();

    request.setAttribute("users", users);
//    request.getRequestDispatcher("/WEB-INF/listing.jsp").forward(request, response); /* Avec tomcat7 mais ne fonctionne pas */

    String usersJsonString = this.gson.toJson(users);
    System.out.println(users);

    PrintWriter out = response.getWriter();

    response.setContentType("application/json");
    response.setCharacterEncoding("UTF-8");

    out.print(usersJsonString);
    out.flush();

  }
}
