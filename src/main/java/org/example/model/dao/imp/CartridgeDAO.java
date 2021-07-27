package org.example.model.dao.imp;

import org.example.controller.HibernateSessionFactoryUtil;
import org.example.model.Const;
import org.example.model.dao.DAO;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class CartridgeDAO implements DAO {

    private static CartridgeDAO instance;

    private CartridgeDAO(){}

    public static CartridgeDAO getInstance(){
        if(instance == null){
            instance = new CartridgeDAO();
        }

        return instance;
    }

    public int read(String typeCartridgeName, String subdivision) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query query = session.createQuery("select cartridge_id from Cartridge where type_cartridge_id= "
                + "(select id from TypeCartridge  where name = '" + typeCartridgeName + "') and " +
                "subdivision_id = (select id from Subdivision where name = '" + subdivision + "')");

        List<Integer> names = query.list();
        session.close();

        return names.get(0);
    }


    @Override
    public int read() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query query = session.createQuery("select id from Cartridge where cartridge_id = "
                + Const.jsonWorkInfo.getCartridgeNameQr());

        List<Integer> ids = query.list();
        session.close();
        return ids.get(0);
    }

    @Override
    public int create() {
        int type_cartridge_id = TypeCartridgeDAO.getInstance().read();
        int subdivision_id = SubdivisionDAO.getInstance().read();
        int cartridge_id = Const.json.getCartridgeNameQR();
        String date = Const.json.getDate();
        String isUpload = Const.json.getSerialNumber();

        if(!check(type_cartridge_id, cartridge_id, subdivision_id, date)){
            return 2;
        }

        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction txn = session.beginTransaction();
        Query query = session.createNativeQuery("insert into Cartridge(type_cartridge_id, " +
                "subdivision_id, cartridge_id, tableDate, is_upload) " +
                "values(" + type_cartridge_id + ", " +
                "" + subdivision_id + ", " + cartridge_id + ", '" + date + "', '" + isUpload + "')");

        int result = query.executeUpdate();

        txn.commit();
        session.close();

        return result;
    }

    private boolean check(int type_cartridge_id, int cartridge_id, int subdivision_id, String date){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query query = session.createQuery("select id from Cartridge where type_cartridge_id = " + type_cartridge_id +
                " and subdivision_id = " + subdivision_id + " and cartridge_id = " + cartridge_id +
                " and tableDate = '" + date + "'");
        List<Integer> ids = query.list();

        return ids.size() == 0;
    }
}