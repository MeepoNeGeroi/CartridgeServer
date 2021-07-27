package org.example.model.service;

import com.google.gson.Gson;
import org.example.model.Const;
import org.example.model.dao.imp.CartridgeDAO;
import org.example.model.entity.JSONAddCartridge;

public class AddCartridgeService {
    private static AddCartridgeService instance;

    private AddCartridgeService(){}

    public static AddCartridgeService getInstance(){
        if(instance == null){
            instance = new AddCartridgeService();
        }
        return instance;
    }

    public void execute(String inputJSON){
        Gson g = new Gson();
        JSONAddCartridge t = g.fromJson(inputJSON, JSONAddCartridge.class);
        Const.json = t;

        CartridgeDAO.getInstance().create();
    }
}
