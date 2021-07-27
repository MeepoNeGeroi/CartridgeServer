package org.example.model.service;

import com.google.gson.Gson;
import org.example.model.Const;
import org.example.model.dao.imp.InfoDAO;
import org.example.model.dao.imp.SubdivisionDAO;
import org.example.model.entity.AddOptionsControllerJSON;
import org.example.model.entity.Info;
import org.example.model.entity.JSONAddCartridge;
import org.example.model.entity.Subdivision;

import java.util.ArrayList;
import java.util.List;

public class ShowInformationService {
    private static ShowInformationService instance;

    private ShowInformationService(){}

    public static ShowInformationService getInstance(){
        if(instance == null){
            instance = new ShowInformationService();
        }
        return instance;
    }

    public String execute(String inputJSON){
        Const.stringForUpload = new ArrayList<>();
        Const.jsonCreateQrCodes = new ArrayList<>();

        Gson g = new Gson();
        AddOptionsControllerJSON json = g.fromJson(inputJSON, AddOptionsControllerJSON.class);

        String dateFrom = json.getDateFrom();
        String dateTo = json.getDateTo();
        String client = json.getClient();
        String subdivision = json.getSubdivision();

        System.out.println("subdivision: " + subdivision + " " + Const.subdivision);

        //if(!subdivision.equals(Const.subdivision)) {
            Const.subdivision = subdivision;
            if (client.equals("*")) {
                return "redirect:/info";
            }

            if (subdivision.equals("*")) {
                Const.infos.clear();
                List<Subdivision> subdivisions = SubdivisionDAO.getInstance().readNames();
                List<Info> infos;
                for (int i = 0; i < subdivisions.size(); i++) {
                    infos = InfoDAO.getInstance().read(dateFrom, dateTo, subdivisions.get(i).getName(), Integer.parseInt(client));
                    Const.infos.addAll(infos);
                }

                return "redirect:/info";
            }


            List<Info> infos = InfoDAO.getInstance().read(dateFrom, dateTo, subdivision, Integer.parseInt(client));

            Const.infos = infos;
        //}



        return "redirect:/info";
    }
}
