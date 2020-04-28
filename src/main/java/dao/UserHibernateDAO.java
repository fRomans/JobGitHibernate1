package dao;

import model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.DBHelper;

import java.util.List;

public class UserHibernateDAO implements UserDAO {

    private final SessionFactory sessionFactory;

    public UserHibernateDAO() {
        this.sessionFactory = DBHelper.getSessionFactory();
    }




    //проверить наличие имени и пароля
    @Override
    public boolean validateClient(String name, String password) {
        boolean yes = true;
        if (name == null || password == null) {
            yes = false;
        }
        return yes;
    }

    @Override
    public User getClientByName(String name) {
        String sql = "select u from User u where u.name= :name";

        User user = (User) sessionFactory
                .openSession().createQuery(sql)
                .setParameter("name", name)
                .uniqueResult();

        return user;

    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = (List<User>) sessionFactory
                .openSession().createQuery("from User").list();
        return users;
    }

    @Override
    public User getClientById(long id) {
        return (User) sessionFactory.openSession()
                .get(User.class, id);
    }

    @Override
    public void deleteUser(Long id)  {

        Session session = sessionFactory.openSession();
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

    @Override
    public void updateUser(User user) {

        Session session = sessionFactory.openSession();
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

    @Override
    public void addUser(User user)  {
//проверить наличие имени и пароля
        if (!validateClient(user.getName(), user.getPassword())) {
            System.out.println("!!! Не прошло валидацию!!!");
            return;
        }
        Session session = sessionFactory.openSession();
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
