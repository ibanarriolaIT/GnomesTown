package com.altran.ibanarriola.gnomestown.repository.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GnomeList {
    @SerializedName("Brastlewark")
    List<Gnome> gnomeList;

    public List<Gnome> getGnomeList() {
        return gnomeList;
    }
}
