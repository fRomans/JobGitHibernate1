package service;

import dao.UserDAO;
import dao.UserHibernateDAO;
import model.User;
import org.hibernate.SessionFactory;
import util.DBHelper;

import java.sql.SQLException;
import java.util.List;

public class UserService {
    private static UserService userService;

    private SessionFactory sessionFactory;
    private final UserDAO userDAO;

    private UserService() {
        this.userDAO = ;//todo получать dao из фабрики
    }

    public static UserService getInstance() {
        if (userService == null) {
            userService = new UserService(DBHelper.getSessionFactory());
        }
        return userService;
    }
    UserHibernateDAO dao = new UserHibernateDAO(sessionFactory);
        public List<User> getAllUsers() throws SQLException {
        return dao.getAllUsers();
    }

    public void deleteUser(User user) throws SQLException {
        dao.deleteUser(user.getId());

    }

    public void updateUser(User user) throws SQLException {
        dao.updateUser(user);
    }

    public User getUserById(long id)  {
        User  user =  dao.getClientById(id);
        return user;
    }

    public boolean addUser(User user) throws SQLException {

            dao.addUser(user);

        return false;
    }

    }
