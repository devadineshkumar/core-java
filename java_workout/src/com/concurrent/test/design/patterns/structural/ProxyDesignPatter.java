package com.concurrent.test.design.patterns.structural;

import java.util.ArrayList;
import java.util.List;

public class ProxyDesignPatter {


    public static void main(String[] args) {
        Internet internet = new ProxyInternet();
        try {
            internet.connectTo("example.com");
            internet.connectTo("abc.com"); // This will throw an exception
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}

interface Internet {
    void connectTo(String serverHost) throws Exception;
}

class RealInternet implements Internet {
    public void connectTo(String serverHost) {
        System.out.println("Connecting to " + serverHost);
    }
}


class ProxyInternet implements Internet {
    private Internet internet = new RealInternet();
    private static List<String> bannedSites;

    static {
        bannedSites = new ArrayList<>();
        bannedSites.add("abc.com");
        bannedSites.add("xyz.com");
    }

    public void connectTo(String serverHost) throws Exception {
        if (bannedSites.contains(serverHost.toLowerCase())) {
            throw new Exception("Access Denied to " + serverHost);
        }
        internet.connectTo(serverHost);
    }
}

