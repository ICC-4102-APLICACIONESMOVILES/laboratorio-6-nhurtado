package com.example.ing.myapplication;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import static android.arch.persistence.room.ForeignKey.CASCADE;

/**
 * Created by ING on 10-04-2018.
 */

@Entity(foreignKeys = {@ForeignKey(entity = Forms.class,
        parentColumns = "formId",
        childColumns = "formId",
        onDelete = CASCADE)})

public class FormLocation {
    @NonNull
    @PrimaryKey(autoGenerate = true)
    private int fromLocationId;
    @NonNull
    private int formId;
    @NonNull
    private double lon;
    private double lat;

    public FormLocation() {
    }
    public int getFromLocationId() { return fromLocationId; }
    public void setFromLocationId (int fromLocationId) { this.fromLocationId = fromLocationId; }
    public int getFormId() { return formId; }
    public void setFormId (int formId) { this.formId = formId; }
    public double getLon(){return lon;}
    public void  setLon (double lon) {this.lon = lon ;}
    public double getLat(){return lat;}
    public void  setLat (double lat) {this.lat = lat ;}
}
