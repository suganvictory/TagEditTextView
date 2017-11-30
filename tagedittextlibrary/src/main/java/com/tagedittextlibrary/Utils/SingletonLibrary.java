package com.tagedittextlibrary.Utils;


import java.util.ArrayList;

@SuppressWarnings("ALL")
public class SingletonLibrary {
    private static SingletonLibrary instance;

    public boolean listpage = false;
    public boolean employeeregister = false;
    public boolean posted_job = false;
    public boolean filter_recent = false;
    public boolean filter_favourites = false;
    public boolean filter_applied = false;

    public double LAT;
    public double LNG;

    private SingletonLibrary() {

    }

    public static void initInstance() {
        if (instance == null) {
            // Create the instance
            instance = new SingletonLibrary();
        }
    }

    public static SingletonLibrary getInstance() {
        // Return the instance
        if (instance == null) {
            // Create the instance
            instance = new SingletonLibrary();
        }
        return instance;
    }

    public void customSingletonMethod() {
        // Custom method
    }

    public ArrayList<String> arrayListKeys = new ArrayList<String>();
    public String[] stringArrKeys;
}
