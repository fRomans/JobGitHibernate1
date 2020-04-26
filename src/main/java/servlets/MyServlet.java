package servlets;

import model.User;
import service.UserService;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/users", name = "MyServlet")
public class MyServlet extends HttpServlet {

    private UserService service = UserService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<User> users = null;
        try {
            users = service.getAllUsers();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.setAttribute("users", users);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/showUsers.jsp");
        dispatcher.forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html;charset=utf-8");
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        Long money = new Long(req.getParameter("money"));
        User user = new User(name, password, money);

        try {
            service.addUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        resp.sendRedirect("/users");
        resp.setStatus(HttpServletResponse.SC_OK);
    }

}
