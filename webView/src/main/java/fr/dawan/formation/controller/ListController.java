package fr.dawan.formation.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.dawan.formation.modele.entities.User;
import fr.dawan.formation.services.UserService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/users")
public class ListController extends HttpServlet {
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    UserService userService = new UserService();
    List<User> users = userService.listing();

    request.setAttribute("users", users);
    request.getRequestDispatcher("listing.jsp").forward(request, response);
  }
}
