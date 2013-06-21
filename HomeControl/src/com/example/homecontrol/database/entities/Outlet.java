package com.example.homecontrol.database.entities;

public class Outlet {
    private long outletID;
    private String description;

    public long getOutletID() {
	return outletID;
    }

    public void setOutletID(long outletID) {
	this.outletID = outletID;
    }

    public String getDescription() {
	return description;
    }

    public void setDescription(String description) {
	this.description = description;
    }

    @Override
    public String toString() {
	return description;
    }
}