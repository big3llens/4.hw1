package servlets;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(name = "FirstServlet", urlPatterns = "/options/*")
public class HelloServlet2 extends HttpServlet {

}
