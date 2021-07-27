package org.example.model.service;

import com.google.gson.Gson;
import org.example.model.Const;
import org.example.model.dao.imp.WorksDAO;
import org.example.model.entity.JSONAddCartridge;
import org.example.model.entity.JSONWorkInfo;

import java.util.logging.Level;
import java.util.logging.Logger;

public class AddCartridgeWorkInfoService {
    private static AddCartridgeWorkInfoService instance;

    private AddCartridgeWorkInfoService(){}

    public static AddCartridgeWorkInfoService getInstance(){
        if(instance == null){
            instance = new AddCartridgeWorkInfoService();
        }
        return instance;
    }

    public int execute(String inputJSON){
        Logger log = Logger.getLogger("log");
        Gson g = new Gson();
        JSONWorkInfo t = g.fromJson(inputJSON, JSONWorkInfo.class);
        log.log(Level.WARNING, "json AddCartridgeWorkInfoService: " + t);
        Const.jsonWorkInfo = t;

        return WorksDAO.getInstance().create();
    }
}