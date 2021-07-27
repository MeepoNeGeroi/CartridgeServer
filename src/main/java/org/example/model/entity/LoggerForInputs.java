package org.example.model.entity;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LoggerForInputs {
    private static Logger logger = Logger.getLogger("MyLog");
    private static FileHandler fh;

    public static void logg(String info)  {
        if(fh == null) {
            try {
                fh = new FileHandler("/Users/zaher/Desktop/server/inputInfo.txt");
            } catch (IOException e) {
                e.printStackTrace();
            }
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);
        }
        // the following statement is used to log any messages
        logger.info(info);
    }
}
