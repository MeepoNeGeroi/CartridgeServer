package org.example.model.dao.imp;

import org.example.controller.HibernateSessionFactoryUtil;
import org.example.model.Const;
import org.example.model.dao.DAO;
import org.example.model.entity.Subdivision;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class SubdivisionDAO implements DAO {

    private static SubdivisionDAO instance;

    private SubdivisionDAO(){}

    public static SubdivisionDAO getInstance(){
        if(instance == null){
            instance = new SubdivisionDAO();
        }

        return instance;
    }

    @Override
    public int read() {
        int client_id = ClientDAO.getInstance().read();

        System.out.println(client_id);

        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query query = session.createQuery("SELECT id FROM Subdivision where name = '"
                + Const.json.getSubdivisionName() + "' and " +
                "client_id = " + client_id + "");

        List<Integer> ids = query.list();
        session.close();

        return ids.get(0);
    }

    public List<Subdivision> readNames(){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from Subdivision");

        List<Subdivision> names = query.list();
        session.close();

        return names;
    }
}