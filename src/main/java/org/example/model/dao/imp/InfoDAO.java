package org.example.model.dao.imp;

import org.example.controller.HibernateSessionFactoryUtil;
import org.example.model.Const;
import org.example.model.entity.Info;
import org.example.model.entity.JSONCreateQrCode;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InfoDAO {
    private static InfoDAO instance;

    private InfoDAO(){}

    public static InfoDAO getInstance(){
        if(instance == null){
            instance = new InfoDAO();
        }

        return instance;
    }



    public List<Info> read(String dateFrom, String dateTo, String subdivision, int clientId){
        List<Info> infos = new ArrayList<>();

        if(dateFrom.equals("") || dateFrom == null){
            dateFrom = "0001.01.01";
        }
        if(dateTo.equals("") || dateTo == null){
            dateTo = "9999.01.01";
        }

        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query query = session.createQuery("select adress from Subdivision where name = '" + subdivision + "'");
        List<String> name = query.list();
        List<Object[]> l;

            query = session.createQuery("select j.name, t.name, count(j.name), count(t.name), t.brand_id, t.name" +
                    "  from Works as w join Cartridge as c on w.cartridge_id = " +
                    "c.id join TypeCartridge as t on c.type_cartridge_id = t.id join JobsAndWorkers as j on w.jobs_id = j.id join Subdivision as s on s.name='" + subdivision +
                    "' and s.id = c.subdivision_id and s.client_id = " + clientId + "where w.date between '" +
                    dateFrom + "' and '" + dateTo + "' and w.is_upload = 0 and j.jobs_name_qr <> 100 group by j.name, t.name, t.brand_id, t.name order by j.name");

            l = query.list();


            query = session.createQuery("select w.id" +
                    "  from Works as w join Cartridge as c on w.cartridge_id = " +
                    "c.id join TypeCartridge as t on c.type_cartridge_id = t.id join JobsAndWorkers as j on w.jobs_id = j.id join Subdivision as s on s.name='" + subdivision +
                    "' and s.id = c.subdivision_id where w.date between '" + dateFrom + "' and '" + dateTo + "' and w.is_upload = 0 and j.jobs_name_qr <> 100 group by w.id");

            List<Integer> ids = query.list();
            Const.stringForUpload.addAll(ids);


        if(l.size() > 0) {
            int jobsCount = 0;
            int id = 2;
            int count = 0;
            Info info = new Info(subdivision, 0);
            infos.add(info);
            info = new Info(" " + name.get(0), 0);
            infos.add(info);
            infos.add(new Info("  " + l.get(0)[0], l.get(0)[2]));

            Object x = l.get(0)[0];

            String brand;
            String clientName = ClientDAO.getInstance().read(clientId);
            String typeCartridge;
            String cartridgeId;
            JSONCreateQrCode json;

            for (int i = 0; i < l.size(); i++) {
                if (l.get(i)[0].equals(x)) {

                    infos.add(new Info("   " + l.get(i)[1], l.get(i)[3]));

                    jobsCount += Integer.parseInt(l.get(i)[3] + "");

                } else {
                    infos.get(id).setCount(jobsCount);
                    infos.add(new Info("  " + l.get(i)[0], l.get(i)[2]));
                    count += jobsCount;
                    id = infos.size() - 1;
                    infos.add(new Info("   " + l.get(i)[1], l.get(i)[3]));
                    jobsCount = Integer.parseInt(l.get(i)[3] + "");

                    x = l.get(i)[0];
                }

                brand = BrandDAO.getInstance().read((Integer) l.get(i)[4]);
                typeCartridge = (String) l.get(i)[5];
                cartridgeId = CartridgeDAO.getInstance().read(typeCartridge, subdivision) + "";

                json = new JSONCreateQrCode(clientName, subdivision, brand, typeCartridge, cartridgeId);

                Const.jsonCreateQrCodes.add(json);
            }
            infos.get(id).setCount(jobsCount);
            count += jobsCount;

            infos.get(0).setCount(count);
            infos.get(1).setCount(count);
        }

        return infos;
    }
}