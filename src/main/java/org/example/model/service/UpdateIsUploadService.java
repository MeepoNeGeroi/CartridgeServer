package org.example.model.service;

import org.example.model.Const;
import org.example.model.dao.imp.WorksDAO;

public class UpdateIsUploadService {
    private static UpdateIsUploadService instance;

    private UpdateIsUploadService(){}

    public static UpdateIsUploadService getInstance(){
        if(instance == null){
            instance = new UpdateIsUploadService();
        }

        return instance;
    }
    public void execute(){
        Const.subdivision = "";

        for(int i = 0; i < Const.stringForUpload.size(); i++){
            WorksDAO.getInstance().update(Const.stringForUpload.get(i));
        }
    }
}
