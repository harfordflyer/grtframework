package com.grt192.core;

/**
 * A logging interface for all GRT written objects
 * @author data
 */
public abstract class GRTObject extends Thread {

    private GRTLogger l;
    private String classname;

    public GRTObject() {
        l = GRTLogger.getInstance();
        classname = getClass().getName();
        int dot = classname.lastIndexOf('.');
        classname = classname.substring(dot + 1);
    }

    public String getClassName() {
        return classname;
    }

    public void setPrinting(boolean b) {
        if (b) {
            l.addPrinter(classname);
        } else {
            l.removePrinter(classname);
        }
    }

    public static void extLog(String key, String message) {
        GRTLogger.getInstance().addPrinter(key);
        GRTLogger.getInstance().write(key, message);
    }

    protected void log(String message) {
        l.write(classname, message);
    }

    protected void log(String type, String message) {
        l.write(type, message);
    }

    protected void logVar(String name, String message) {
        l.write("(var)" + name, message);
    }

    protected void logVar(String string, double i) {
        logVar(string, Double.toString(i));
    }
}
