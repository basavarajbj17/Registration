package com.assign.registration;

import com.google.gson.annotations.SerializedName;

/**
 * Created by pawnish on 5/29/2017.
 */

public class DisplayData {

    @SerializedName("MasterData")
    private MasterData masterData;

    public MasterData getMasterData() {
        return masterData;
    }

    public void setMasterData(MasterData masterData) {
        this.masterData = masterData;
    }
}
