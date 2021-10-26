package main.java.by.tc.task01.main;

import main.java.by.tc.task01.dao.JDOMParser;
import org.jdom2.JDOMException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws JDOMException, IOException {

        PrintApplianceInfo printApp = new PrintApplianceInfo();
        printApp.printApp("all");


    }
}
