package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import service.UserService;

import java.io.IOException;
import java.sql.SQLException;


@WebServlet(urlPatterns = "/users/update", name = "UpdateServlet")
public class UpdateServlet extends HttpServlet {

    private UserService service = UserService.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));
        User user = service.getUserById(id);
        user.setName(req.getParameter("name"));
        user.setPassword(req.getParameter("password"));
        user.setMoney(new Long(req.getParameter("money")));
        try {
            service.updateUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        resp.sendRedirect("/users");

    }
}
