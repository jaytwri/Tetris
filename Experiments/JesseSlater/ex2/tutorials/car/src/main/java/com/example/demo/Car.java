package com.example.demo;


/**
 * Provides the Definition/Structure for the people row
 *
 * @author Vivek Bengre
 */

public class Car {

    private String model;

    private String year;

    private String VIN;

    private String milage;

    public Car(){
        
    }

    public Car(String firstName, String lastName, String address, String telephone){
        this.model = firstName;
        this.year = lastName;
        this.VIN = address;
        this.milage = telephone;
    }

    public String getModel() {
        return this.model;
    }

    public void setModle(String firstName) {
        this.model = firstName;
    }

    public String getYear() {
        return this.year;
    }

    public void setYear(String lastName) {
        this.year = lastName;
    }

    public String getVIN() {
        return this.VIN;
    }

    public void setVIN(String address) {
        this.VIN = address;
    }

    public String getMilage() {
        return this.milage;
    }

    public void setMilage(String telephone) {
        this.milage = telephone;
    }

    @Override
    public String toString() {
        return model + " " 
               + year + " "
               + VIN + " "
               + milage;
    }
}
