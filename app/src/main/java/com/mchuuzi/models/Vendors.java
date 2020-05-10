package com.mchuuzi.models;

public class Vendors {
    private String vendor_name, vendor_location;
    private int vendorimage;


    public Vendors() {
    }

    public Vendors(String vendor_name, String vendor_location, int vendorimage) {
        this.vendor_name = vendor_name;
        this.vendor_location = vendor_location;
        this.vendorimage = vendorimage;
    }

    public String getVendor_name() {
        return vendor_name;
    }

    public void setVendor_name(String vendor_name) {
        this.vendor_name = vendor_name;
    }

    public String getVendor_location() {
        return vendor_location;
    }

    public void setVendor_location(String vendor_location) {
        this.vendor_location = vendor_location;
    }

    public int getVendorimage() {
        return vendorimage;
    }

    public void setVendorimage(int vendorimage) {
        this.vendorimage = vendorimage;
    }
}
