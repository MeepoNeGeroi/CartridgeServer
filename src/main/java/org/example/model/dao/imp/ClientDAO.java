package org.example.model.dao.imp;

import org.example.controller.HibernateSessionFactoryUtil;
import org.example.model.Const;
import org.example.model.dao.DAO;
import org.example.model.entity.Client;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class ClientDAO implements DAO{
    private static ClientDAO instance;

    private ClientDAO(){}

    public static ClientDAO getInstance(){
        if(instance == null){
            instance = new ClientDAO();
        }

        return instance;
    }

    public String read(int id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query query = session.createQuery("select name from Client where id = " + id);

        List<String> names = query.list();
        session.close();

        return names.get(0);
    }

    @Override
    public int read() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query query = session.createQuery("select id from Client where name = '"
                + Const.json.getClientName() + "'");

        List<Integer> ids = query.list();
        session.close();
        return ids.get(0);
    }

    public List<Client> readNames(){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from Client");

        List<Client> names = query.list();
        session.close();

        return names;
    }
}
