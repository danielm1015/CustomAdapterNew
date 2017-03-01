package com.rabor.customadapter.data;

/**
 * Created by leticia.rabor on 2/27/2017.
 */
public class Company {

    // define variables
    public String companyName;
    public int imageResource;
    public String phone;
    public String website;
    public String email;

    public Company(String companyName, int imageResource,
                   String phone, String website, String email) {
        this.companyName = companyName;
        this.email = email;
        this.imageResource = imageResource;
        this.phone = phone;
        this.website = website;
    }

    // returns company name as a string
    @Override
    public String toString() {
        return companyName;
    }
}
