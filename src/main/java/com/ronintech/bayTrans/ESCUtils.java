package com.ronintech.bayTrans;

public class ESCUtils {

    public static String CS = ""; // CS == COMMAND_SET

    public String initPrinter() {
        final byte[] init = {27, 64};
        CS += new String(init);
        return new String(init);
    }

    public String newLine() {
        final byte[] LF = {10};
        String cmd = new String(LF);
        CS += cmd;
        return cmd;
    }

    public String lineFeed(int lines) {
        byte lineCount = (byte) lines;
        final byte[] LF = {27, 100, lineCount};
        String cmd = new String(LF);
        CS += cmd;
        return cmd;
    }

    public String alignLeft() {
        final byte[] LF = {27, 97, 48};
        String cmd = new String(LF);
        CS += cmd;
        return cmd;
    }

    public String alignRight() {
        final byte[] LF = {27, 97, 50};
        String cmd = new String(LF);
        CS += cmd;
        return cmd;
    }

    public String alignCenter() {
        final byte[] LF = {27, 97, 49};
        String cmd = new String(LF);
        CS += cmd;
        return cmd;
    }

    public String italic(int state) {
        final byte mode = (byte) state;
        final byte[] LF = {27, 52, mode};
        String cmd = new String(LF);
        CS += cmd;
        return cmd;
    }

    public String emphasize(int state) {
        final byte mode = (byte) state;
        final byte[] LF = {27, 69, mode};
        String cmd = new String(LF);
        CS += cmd;
        return cmd;
    }


    public String underline(int options) {
        final byte[] UnderLine2Dot = {27, 45, 50};
        final byte[] UnderLine1Dot = {27, 45, 49};
        final byte[] NoUnderLine = {27, 45, 48};

        String cmd = "";
        switch (options) {
            case 0:
                cmd = new String(NoUnderLine);
                break;

            case 1:
                cmd = new String(UnderLine1Dot);
                break;

            case 2:
                cmd = new String(UnderLine2Dot);

            default:
                break;
        }

        CS += cmd;
        return cmd;
    }

    public String setCharDims(int size) {
        final byte[] x1h = {29, 33, 0};
        final byte[] x1w = {29, 33, 0};
        final byte[] x2h = {29, 33, 1};
        final byte[] x2w = {29, 33, 16};
        final byte[] x3h = {29, 33, 2};
        final byte[] x3w = {29, 33, 32};

        String cmd = "";
        switch (size) {
            case 1:
                cmd = new String(x1h) + new String(x1w);
                break;
            case 2:
                cmd = new String(x2h) + new String(x2w);
                break;
            case 3:
                cmd = new String(x3h) + new String(x3w);
                break;
            default:
                break;
        }

        CS += cmd;
        return cmd;
    }

    public String cut() {
        final byte[] cut = {27, 105};
        String cmd = new String(cut);
        CS += cmd;
        return cmd;
    }

    public String lineSeparator() {
        String lineSep = "--------------------------------";
        CS += lineSep;
        return lineSep;
    }

    public String doubleLineSeparator() {
        String lineSep = "================================";
        CS += lineSep;
        return lineSep;
    }

    public void resetAll() {
        CS = "";
    }

    public void setText(String text) {
        CS += text;
    }

    public String finalCmd() {
        return CS + "\n\n";
    }

    public String setBarcode(String code) {
        String cmd = "";
        //HRI
        final byte[] hri = {29, 72, 2};
        cmd = new String(hri);
        CS += cmd;

        final byte[] hriChar = {29, 102, 0};
        cmd = new String(hriChar);
        CS += cmd;

        //Barcode
        byte[] codeVal = code.getBytes();
//        byte codeVal = (byte) code;
        final byte[] barcodeEAN13 = {29, 107, 67, 13};
        final byte[] barOut = new byte[barcodeEAN13.length + codeVal.length];
        System.arraycopy(barcodeEAN13, 0, barOut, 0, barcodeEAN13.length);
        System.arraycopy(codeVal, 0, barOut, barcodeEAN13.length, codeVal.length);
        cmd = new String(barOut);
        CS += cmd;

        return cmd;
    }


}
