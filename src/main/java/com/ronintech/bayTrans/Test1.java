package com.ronintech.bayTrans;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Test1 {
    public static void main(String[] args) {

        ESCUtils u = new ESCUtils();
        String date = LocalDate.now()
                .format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        String time = LocalTime.now().withNano(0)
                .format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        StringBuilder cs = new StringBuilder();
        //u.resetAll();

        u.initPrinter();
        cs
                .append(u.newLine())
                .append(u.alignCenter())
                .append(u.emphasize(1))
                .append(u.setCharDims(2))
                .append("RoninTech")
                .append(u.newLine())
                .append("BayTrans")
                .append(u.emphasize(0))
                .append(u.setCharDims(1))
                .append(u.lineFeed(2))
                .append(u.hri())
                .append(u.setBarcode("1234567890123"))
                .append(u.lineFeed(2))
                .append(date)
                .append(u.newLine())
                .append(time)
                .append(u.lineFeed(2))
                .append("1 Hour AED 10")
                .append(u.newLine())
                .append("First 15 Minutes Free")
                .append(u.lineFeed(2))
                .append(u.italic(1))
                .append(u.emphasize(1))
                .append("Thank You!")
                .append(u.lineFeed(2))
                .append(u.cut());

        System.out.println(cs.toString());
        System.exit(0);
    }
}
