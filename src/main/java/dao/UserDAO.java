package dao;

import model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public interface UserDAO {

    public boolean validateClient(String name, String password);

    public User getClientByName(String name);

    public List<User> getAllUsers() ;

    public User getClientById(long id);

    public void deleteUser(Long id);

    public void updateUser(User user);

    public void addUser(User user) ;

    public void createTable();

    public void dropTable();

}
