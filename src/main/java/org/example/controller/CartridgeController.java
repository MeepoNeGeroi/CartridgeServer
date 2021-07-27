package org.example.controller;

import net.glxn.qrgen.core.image.ImageType;
import net.glxn.qrgen.javase.QRCode;
import org.example.model.Const;
import org.example.model.dao.imp.ClientDAO;
import org.example.model.dao.imp.InfoDAO;
import org.example.model.dao.imp.SubdivisionDAO;
import org.example.model.entity.Info;
import org.example.model.entity.JSONCreateQrCode;
import org.example.model.entity.LoggerForInputs;
import org.example.model.service.*;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
public class CartridgeController {
    @PostMapping("/addCartridge")
    @ResponseBody
    public String addCartridge(@RequestBody String inputJSON) {
        LoggerForInputs.logg("json add cartridge: " + inputJSON);
        //log.log(Level.WARNING, "json add cartridge: " + inputJSON);

        AddCartridgeService.getInstance().execute(inputJSON);
        return "{\"success\":1}";
    }

    @PostMapping(value = "/addCartridgeWorkInfo", produces = MediaType.APPLICATION_JSON_VALUE + "; charset=utf-8")
    @ResponseBody
    public ResponseEntity addCartridgeWorkInfo(@RequestBody String inputJSON){
        LoggerForInputs.logg("json add cartridge work info: " + inputJSON);
        //log.log(Level.WARNING, "json add cartridge work info: " + inputJSON);

        int answer = AddCartridgeWorkInfoService.getInstance().execute(inputJSON);

//        if(answer == 5){
//            return ResponseEntity.status(400).build();
//        }

        return ResponseEntity.ok().build();
    }

    @GetMapping(value =  "/info", produces = MediaType.APPLICATION_JSON_VALUE + "; charset=utf-8")
    public String getInfo(Model model){
        model.addAttribute("clients", ClientDAO.getInstance().readNames());
        model.addAttribute("subdivisions", SubdivisionDAO.getInstance().readNames());
        model.addAttribute("info", Const.infos);

        return "info";
    }



    @PostMapping(value = "/createQrCodes")
    @ResponseBody
    public void createQrCode(@RequestBody String json){
        System.out.println(json);
        CreateQrCodeService.getInstance().execute(json);
    }

    @PostMapping(value = "/addOptions")
    @ResponseBody

    public List<Info> addOptions(@RequestBody String inputJSON, Model model){
        String result = ShowInformationService.getInstance().execute(inputJSON);
        model.addAttribute("info", Const.infos);
        System.out.println(model.getAttribute("info"));

        //return result;
        return Const.infos;
    }

    @PostMapping(value = "/setIsUpload")
    @ResponseBody
    public void setIsUpload(){
        UpdateIsUploadService.getInstance().execute();
    }

    @GetMapping(value = "/createQrCode")
    public String getCreateQrCodeForm(){
        return "createQrCode";
    }
}