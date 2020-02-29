package com.hfad.bitsandpizzas;

import android.app.Activity;

public class Building extends Activity {

    private int buildingName;
    private int buildingInfo;
    private int imageResourceId;

    // buildings is an array of Buildings
    public static final Building[] buildings = {
            new Building(R.string.cis, R.string.cis_info, R.drawable.cisbuilding),
            new Building(R.string.hoggard, R.string.hoggard_info, R.drawable.hoggardhall),
            new Building(R.string.deloach, R.string.deloach_info, R.drawable.deloachhall),
            new Building(R.string.bear, R.string.bear_info, R.drawable.bearhall),
            new Building(R.string.dobo, R.string.dobo_info, R.drawable.dobohall)
    };

    // each building has a name, information, and an image resource
    private Building(int buildingName, int buildingInfo, int imageResourceId) {
        this.buildingName = buildingName;
        this.buildingInfo = buildingInfo;
        this.imageResourceId = imageResourceId;
    }

    public int getInformation() {
        return buildingInfo;
    }

    public int getName() {
        return buildingName;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public String toString() {
        return getResources().getString(this.buildingName);
    }
}
