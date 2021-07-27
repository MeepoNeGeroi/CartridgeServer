package org.example.model.dao.imp;

import org.example.controller.HibernateSessionFactoryUtil;
import org.example.model.Const;
import org.example.model.dao.DAO;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class WorksDAO implements DAO {

    private static WorksDAO instance;

    private WorksDAO(){}

    public static WorksDAO getInstance(){
        if(instance == null){
            instance = new WorksDAO();
        }

        return instance;
    }

    @Override
    public int read() {
        return 0;
    }

    @Override
    public int create(){
        int workerId = WorkerDAO.getInstance().read();
        int jobsId = JobsAndWorkersDAO.getInstance().read();
        int cartridgeId = CartridgeDAO.getInstance().read();
        String date = Const.jsonWorkInfo.getDate();
        String isUpload = Const.jsonWorkInfo.getSerialNumber();

        if(!check(workerId, jobsId, cartridgeId, date)){
            return 5;
        }

        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction txn = session.beginTransaction();
        Query query = session.createNativeQuery("insert into works(worker_id, " +
                "jobs_id, cartridge_id, date, is_upload) values(" + workerId + ", " +
                "" + jobsId + ", " + cartridgeId + ", '" + date + "', '" + 0 + "')");

        int result = query.executeUpdate();

        txn.commit();
        session.close();

        return result;
    }

    public void update(int id){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction txn = session.beginTransaction();
        Query query = session.createQuery("update Works set is_upload = 1 where id = " + id);
        query.executeUpdate();
        txn.commit();
        session.close();
    }

    private boolean check(int workerId, int jobsId, int cartridgeId, String date){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query query = session.createQuery("select id from Works where worker_id = " + workerId +
                " and jobs_id = " + jobsId + " and cartridge_id = " + cartridgeId + " and date = '" + date + "'");
        List<Integer> ids = query.list();

        if(ids == null || ids.size() == 0){
            return true;
        }
        else{
            return false;
        }

        //return ids.size() == 0;
    }
}
