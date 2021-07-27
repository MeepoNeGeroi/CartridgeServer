package org.example.model;

import org.example.model.entity.Info;
import org.example.model.entity.JSONAddCartridge;
import org.example.model.entity.JSONCreateQrCode;
import org.example.model.entity.JSONWorkInfo;

import java.util.ArrayList;
import java.util.List;

public class Const {
    public static final double marginBetweenImages = 2.5;
    public static final double width = 1.3;
    public static final double height = 1.3;
    public static final double pixelToCm = 37.938105;
    public static final long unitPerCm = 567L;
    public static final long leftMargin = 1;
    public static final long topMargin = 1;
    public static JSONAddCartridge json;
    public static JSONWorkInfo jsonWorkInfo;
    public static List<Info> infos = new ArrayList<>();
    public static List<Integer> stringForUpload = new ArrayList<>();
    public static List<JSONCreateQrCode> jsonCreateQrCodes;
    public static String subdivision;
}
