package main.java.restjersey.dao;

import main.java.restjersey.model.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.json.JSONArray;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

public class BookDAO {
    private static BookDAO dao;

    private BookDAO() {
    }

    public static BookDAO getInstance() {
        if (dao == null) {
            dao = new BookDAO();
        }
        return dao;
    }

    private SessionFactory sessionFactory = getSessionFactory();

    public static SessionFactory getSessionFactory() {
        // Creating Configuration Instance & Passing Hibernate Configuration File
        Configuration configObj = new Configuration();
        configObj.configure("hibernate.cfg.xml");

        // Since Hibernate Version 4.x, Service Registry Is Being Used
        ServiceRegistry serviceRegistryObj = new StandardServiceRegistryBuilder().applySettings(configObj.getProperties()).build();

        // Creating Hibernate Session Factory Instance
        return configObj.buildSessionFactory(serviceRegistryObj);
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public List<Book> getAll() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Book> criteriaQuery = criteriaBuilder.createQuery(Book.class);
        Root<Book> from = criteriaQuery.from(Book.class);
        CriteriaQuery<Book> select = criteriaQuery.select(from);
        TypedQuery<Book> typedQuery = session.createQuery(select);
        return typedQuery.getResultList();
    }

    @Transactional
    public String insertNew(Book book) {
        // insert into database & return primary key
        int bookID = (Integer) sessionFactory.getCurrentSession().save(book);
        return "Book information saved successfully with id " + bookID;
    }

    @Transactional
    public Book get(int bookID) {
        return sessionFactory.getCurrentSession().get(Book.class, bookID);
    }

    @Transactional
    public String update(Book book) {
        sessionFactory.getCurrentSession().update(book);
        return "Book information updated successfully";
    }

    @Transactional
    public String remove(Book book) {
        sessionFactory.getCurrentSession().delete(book);
        return "Book information with id " + book.getID() + " deleted successfully";
    }


}
