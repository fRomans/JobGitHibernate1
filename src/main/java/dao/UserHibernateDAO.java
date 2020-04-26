package dao;

import model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.DBHelper;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class UserHibernateDAO  {

    private Session session;


    //проверить наличие имени и пароля

    public boolean validateClient(String name, String password) {
        boolean yes = true;
        if (name == null || password == null) {
            yes = false;
        }
        return yes;
    }


    public User getClientByName(String name) {
        String sql = "select u from User u where u.name= :name";

        User user = (User) DBHelper.getSessionFactory()
                .openSession().createQuery(sql)
                .setParameter("name", name)
                .uniqueResult();

        return user;

    }


    public List<User> getAllUsers() {
        List<User> users = (List<User>) DBHelper.getSessionFactory()
                .openSession().createQuery("from User").list();
        return users;
    }


    public User getClientById(long id) {
        return (User) DBHelper.getSessionFactory().openSession()
                .get(User.class, id);
    }


    public void deleteUser(Long id)  {

        Session session = DBHelper.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        try {
            session.delete(getClientById(id));
            tx1.commit();
        } catch (Exception e) {
            if (tx1 != null) tx1.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

    }


    public void updateUser(User user) {

        Session session = DBHelper.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        try {
            session.update(user);
            tx1.commit();
        } catch (Exception e) {
            if (tx1 != null) tx1.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }


    public void addUser(User user)  {
//проверить наличие имени и пароля
        if (!validateClient(user.getName(), user.getPassword())) {
            System.out.println("!!! Не прошло валидацию!!!");
            return;
        }
        Session session = DBHelper.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        try {
            session.save(user);
            tx1.commit();
        } catch (Exception e) {
            if (tx1 != null) tx1.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

}
