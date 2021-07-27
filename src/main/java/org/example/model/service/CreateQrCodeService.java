package org.example.model.service;

import com.google.gson.Gson;
import net.glxn.qrgen.core.image.ImageType;
import net.glxn.qrgen.javase.QRCode;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.*;
import org.example.model.Const;
import org.example.model.entity.JSONCreateQrCode;
import org.example.model.entity.JSONWorkInfo;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.*;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.plugins.jpeg.JPEGImageWriteParam;
import javax.imageio.stream.ImageOutputStream;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.math.BigInteger;
import java.util.Locale;

public class CreateQrCodeService {
    private int reportId = 0;
    private int id = 0;
    private static CreateQrCodeService instance;

    private CreateQrCodeService(){}

    public static CreateQrCodeService getInstance(){
        if(instance == null){
            instance = new CreateQrCodeService();
        }

        return instance;
    }

    public void setSingleLineSpacing(XWPFParagraph para) {
        CTPPr ppr = para.getCTP().getPPr();
        if (ppr == null) ppr = para.getCTP().addNewPPr();
        CTSpacing spacing = ppr.isSetSpacing()? ppr.getSpacing() : ppr.addNewSpacing();
        spacing.setAfter(BigInteger.valueOf(100L));
        spacing.setBefore(BigInteger.valueOf(100L));
        spacing.setLineRule(STLineSpacingRule.AUTO);
        spacing.setLine(BigInteger.valueOf(240));
    }

    public void execute(String inputJSON){
        try {
            Gson g = new Gson();
            JSONCreateQrCode json = g.fromJson(inputJSON, JSONCreateQrCode.class);

            Const.subdivision = "";
            XWPFDocument document = new XWPFDocument();
            CTSectPr sectPr = document.getDocument().getBody().addNewSectPr();
            CTPageMar pageMar= sectPr.addNewPgMar();
            pageMar.setLeft(BigInteger.valueOf(Const.leftMargin * Const.unitPerCm));
//            pageMar.setRight(BigInteger.valueOf(1500L));
            pageMar.setTop(BigInteger.valueOf(Const.topMargin * Const.unitPerCm));
//            pageMar.setBottom(BigInteger.valueOf(1000L));
            XWPFParagraph par = document.createParagraph();


            XWPFRun run = par.createRun();
            InputStream is;

            //setSingleLineSpacing(par);

//            for (JSONCreateQrCode j :
//                    Const.jsonCreateQrCodes) {
                createQrCode(json);
                is = new FileInputStream("qr-code-" + id + ".png");
                run.addPicture(is, XWPFDocument.PICTURE_TYPE_JPEG, "qr-code-" + id + ".png",
                        Units.toEMU(Const.width * Const.pixelToCm),
                        Units.toEMU(Const.height * Const.pixelToCm));
                run.setText("VTB");
                if(id % 5 != 0){
                    run.addTab();
                    run.addTab();
                }

//            }

            XWPFTable table = document.createTable();
            XWPFTableRow row;
            XWPFParagraph pr;
            //XWPFRun run;


//            int numberOfRow = 0;
//
//            for (JSONCreateQrCode json :
//                    Const.jsonCreateQrCodes) {
//
//                row = table.getRow(numberOfRow);
//
//                numberOfRow++;
//
//                for (int i = 0; i < 4; i++) {
//                    row.addNewTableCell();
//
//                }
//
//
//                createQrCode(json);
//                is = new FileInputStream("qr-code-" + id + ".png");
//                run.addPicture(is, XWPFDocument.PICTURE_TYPE_JPEG, "qr-code-" + id + ".png",
//                        Units.toEMU(Const.width * Const.pixelToCm),
//                        Units.toEMU(Const.height * Const.pixelToCm));
//                run.setText("VTB");
//
//                if (id % 5 != 0) {
//                    run.addTab();
//                    run.addTab();
//                }

            row = table.getRow(0);
            pr = row.getCell(0).addParagraph();
            pr.setAlignment(ParagraphAlignment.CENTER);
            run = pr.createRun();
            is = new FileInputStream("qr-code-1.png");
            run.setText("VTB - TP");



//            row.getCell(0).setVerticalAlignment(XWPFTableCell.XWPFVertAlign.CENTER);
//                for (int x = 0; x < table.getNumberOfRows(); x++) {
//                    row = table.getRow(x);
//                    row.setHeight((int) (2 * Const.unitPerCm));
//                    int numberOfCell = row.getTableCells().size();
//                    for (int y = 0; y < numberOfCell; y++) {
//                        XWPFTableCell cell = row.getCell(y);
//
//                        cell.getCTTc().addNewTcPr().addNewTcW().setW(
//                                BigInteger.valueOf((long) (3.2 * Const.unitPerCm)));
//                    }
//                }




            String key = "VTB-Bank TP-212";
            BufferedImage bufferedImage = new BufferedImage(100, 30,
                    BufferedImage.TYPE_INT_RGB);
            Graphics graphics = bufferedImage.getGraphics();
            graphics.setColor(Color.WHITE);
            graphics.fillRect(0, 0, 200, 50);
            graphics.setColor(Color.BLACK);
            graphics.setFont(new Font("Times New Roman", Font.BOLD, 10));
            graphics.drawString(key, 0, 25);
            graphics.dispose();
            ImageIO.write(bufferedImage, "png", new File("image.png"));

            run.addPicture(is, XWPFDocument.PICTURE_TYPE_JPEG, "qr-code-" + id + ".png",
                    Units.toEMU(Const.width * Const.pixelToCm),
                    Units.toEMU(Const.height * Const.pixelToCm));
            run.addPicture(is,XWPFDocument.PICTURE_TYPE_JPEG, "image.png",
                    Units.toEMU(Const.width * Const.pixelToCm),
                    Units.toEMU(Const.height * Const.pixelToCm));
            FileOutputStream out = new FileOutputStream("qr-codes" + ++reportId + ".docx");
            document.write(out);
            out.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }

        id = 0;
    }

        private void createQrCode(JSONCreateQrCode json){
        ByteArrayOutputStream bout =
                QRCode.from("{\"clientName\":\"" + json.getClientName()
                                + "\", \"subdivision\":\"" + json.getSubdivision()
                                + "\", \"brand\":\"" + json.getBrand()
                                + "\", \"typeCartridgeId\":\"" + json.getTypeCartridgeId()
                                + "\", \"cartridgeId\": " + json.getCartridgeId() + "}")
                        .withSize(20, 20)
                        .to(ImageType.PNG)
                        .stream();

        try {
            OutputStream out = new FileOutputStream("qr-code-" + ++id + ".png");
            bout.writeTo(out);
            out.flush();
            out.close();

        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}