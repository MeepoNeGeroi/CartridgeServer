package org.example.model.dao.imp;

import org.example.controller.HibernateSessionFactoryUtil;
import org.example.model.Const;
import org.example.model.dao.DAO;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class JobsAndWorkersDAO implements DAO {

    private static JobsAndWorkersDAO instance;

    private JobsAndWorkersDAO(){}

    public static JobsAndWorkersDAO getInstance(){
        if(instance == null){
            instance = new JobsAndWorkersDAO();
        }

        return instance;
    }
    @Override
    public int read() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query query = session.createQuery("select id from JobsAndWorkers where jobs_name_qr = "
                + Const.jsonWorkInfo.getJobsNameQr());

        List<Integer> ids = query.list();
        session.close();

        return ids.get(0);
    }
}