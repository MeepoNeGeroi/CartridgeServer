package org.example.model.dao.imp;

import org.example.controller.HibernateSessionFactoryUtil;
import org.example.model.Const;
import org.example.model.dao.DAO;
import org.example.model.entity.TypeCartridge;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class TypeCartridgeDAO implements DAO {

    private static TypeCartridgeDAO instance;

    private TypeCartridgeDAO(){}

    public static TypeCartridgeDAO getInstance(){
        if(instance == null){
            instance = new TypeCartridgeDAO();
        }

        return instance;
    }

    @Override
    public int read() {
        int brand_id = BrandDAO.getInstance().read();

        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query query = session.createQuery("SELECT id FROM TypeCartridge where name = '"
                + Const.json.getTypeCartridge() + "' and " +
                "brand_id = " + brand_id);

        List<Integer> ids = query.list();
        session.close();

        if(ids.size() == 0){
            return create();
        }

        return ids.get(0);
    }

    @Override
    public int create(){
        int brand_id = BrandDAO.getInstance().read();

        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction txn = session.beginTransaction();
        Query query = session.createNativeQuery("insert into type_cartridge( name, brand_id) values('" + Const.json.getTypeCartridge() + "', " + brand_id
                + ")");

        query.executeUpdate();

        txn.commit();

        query = session.createQuery("SELECT id FROM TypeCartridge where name = '"
                + Const.json.getTypeCartridge() + "' and " +
                "brand_id = " + brand_id);
        List<Integer> ids = query.list();
        session.close();

        return ids.get(0);
    }
}
