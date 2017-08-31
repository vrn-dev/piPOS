package com.ronintech.bayTrans;

import javax.print.*;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) {
        ESCUtils u = new ESCUtils();
        String date = LocalDate.now()
                .format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        String time = LocalTime.now().withNano(0)
                .format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        StringBuilder cs = new StringBuilder();
        //u.resetAll();

        cs
                .append(u.initPrinter())
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

        u.initPrinter();
        u.newLine();
        u.alignCenter();
        u.emphasize(1);
        u.setCharDims(2);
        u.setText("RoninTech");
        u.newLine();
        u.setText("BayTrans");
        u.emphasize(0);
        u.setCharDims(1);
        u.lineFeed(2);
        u.setBarcode("1234567890123");
        //u.setCharDims(3);
        u.lineFeed(2);
        u.setText(date);
        u.newLine();
        u.setText(time);
        u.lineFeed(2);
        u.setText("1 Hour AED 10");
        u.newLine();
        u.setText("First 15 Minutes Free");
        u.lineFeed(2);
        u.italic(1);
        u.emphasize(1);
        u.setText("Thank You!");
        u.lineFeed(2);
        u.cut();
        String p = u.finalCmd();

        //u.resetAll();
        //System.out.println(p);
        DocFlavor flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE;

        PrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();
        PrintService service = PrintServiceLookup.lookupDefaultPrintService();

        //System.out.println(service.getName());

        byte[] bytes = cs.toString().getBytes();

        Doc doc = new SimpleDoc(bytes, flavor, null);

        DocPrintJob job = service.createPrintJob();

        try {
            job.print(doc, null);

        } catch (PrintException e) {
            e.printStackTrace();
        }
    }
}
