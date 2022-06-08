package com.eleks.framework.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class DbUtil {

    protected static SessionFactory sessionFactory;
    protected static Session session;
    protected static Transaction transaction;

    public static SessionFactory setup() {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure().build();
        try {
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            return sessionFactory;
        } catch (Exception e) {
            e.printStackTrace();
            StandardServiceRegistryBuilder.destroy(registry);
        }
        return null;
    }

    public static void exit(Session session, SessionFactory sessionFactory) {
        session.close();
        sessionFactory.close();
    }

    public Session openSession() {
        session = sessionFactory.openSession();
        return session;
    }




//
//    public static void closeConnection() {
//        //
//    }
//
//    public static void executeQuery(String query, Connection connection) {
//        Statement statement = null;
//        try {
//            statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery(query);
//        } catch (Exception e) {
//
//        }
//    }
    public static void main(String args[]) {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure().build();

        SessionFactory factory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        User user = new User();
        user.setName("AutoUser12");
        user.setSalary("5000");
        user.setDurationWorked("3");
        user.setGrade("2");
        user.setEmail("us12@dsd.com");

        session.save(user);
        transaction.commit();
        session.close();
        factory.close();
    }

    public void saveSession() {

    }
}
