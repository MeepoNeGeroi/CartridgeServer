package org.example.model.dao.imp;

import org.example.controller.HibernateSessionFactoryUtil;
import org.example.model.Const;
import org.example.model.dao.DAO;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class WorkerDAO implements DAO {

    private static WorkerDAO instance;

    private WorkerDAO(){}

    public static WorkerDAO getInstance(){
        if(instance == null){
            instance = new WorkerDAO();
        }

        return instance;
    }
    @Override
    public int read() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query query = session.createQuery("select id from Worker where fio = '"
                + Const.jsonWorkInfo.getWorkerFIO() + "'");

        List<Integer> ids = query.list();
        session.close();

        if(ids.size() == 0){
            return create();
        }

        return ids.get(0);
    }

    @Override
    public int create(){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();

        Transaction txn = session.beginTransaction();
        Query query = session.createNativeQuery("insert into worker(fio) values('" + Const.jsonWorkInfo.getWorkerFIO() + "')");

        query.executeUpdate();

        txn.commit();

        query = session.createQuery("select id from Worker where fio = '"
                + Const.jsonWorkInfo.getWorkerFIO() + "'");
        List<Integer> ids = query.list();
        session.close();

        return ids.get(0);
    }
}
