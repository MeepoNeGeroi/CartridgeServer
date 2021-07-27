package org.example.model.dao.imp;

import org.example.controller.HibernateSessionFactoryUtil;
import org.example.model.Const;
import org.example.model.dao.DAO;
import org.example.model.entity.Brand;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class BrandDAO implements DAO {
    private static BrandDAO instance;

    private BrandDAO(){}

    public static BrandDAO getInstance(){
        if(instance == null){
            instance = new BrandDAO();
        }

        return instance;
    }

    public String read(int id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query query = session.createQuery("select name from Brand where id = " + id);

        List<String> names = query.list();
        session.close();

        return names.get(0);
    }

    @Override
    public int read() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query query = session.createQuery("select id from Brand where name = '"
                + Const.json.getBrand() + "'");

        List<Integer> ids = query.list();
        if(ids.size() == 0){
            return create();
        }
        session.close();
        return ids.get(0);
    }

    @Override
    public int create(){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();

        Transaction txn = session.beginTransaction();
        Query query = session.createNativeQuery("insert into Brand(name) values('" + Const.json.getBrand() + "')");

        query.executeUpdate();

        txn.commit();

        query = session.createQuery("select id from Brand where name = '"
                + Const.json.getBrand() + "'");

        List<Integer> ids = query.list();

        session.close();

        return ids.get(0);
    }
}
