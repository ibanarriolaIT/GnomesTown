package com.altran.ibanarriola.gnomestown.repository.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Gnome implements Parcelable {
    @SerializedName("id")
    int id;
    @SerializedName("name")
    String name;
    @SerializedName("thumbnail")
    String photo;
    @SerializedName("age")
    int age;
    @SerializedName("weight")
    double weight;
    @SerializedName("height")
    double height;
    @SerializedName("hair_color")
    String hairColor;
    @SerializedName("professions")
    List<String> professions;
    @SerializedName("friends")
    List<String> friends;

    protected Gnome(Parcel in) {
        id = in.readInt();
        name = in.readString();
        photo = in.readString();
        age = in.readInt();
        weight = in.readDouble();
        height = in.readDouble();
        hairColor = in.readString();
        professions = in.createStringArrayList();
        friends = in.createStringArrayList();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeString(photo);
        dest.writeInt(age);
        dest.writeDouble(weight);
        dest.writeDouble(height);
        dest.writeString(hairColor);
        dest.writeStringList(professions);
        dest.writeStringList(friends);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Gnome> CREATOR = new Creator<Gnome>() {
        @Override
        public Gnome createFromParcel(Parcel in) {
            return new Gnome(in);
        }

        @Override
        public Gnome[] newArray(int size) {
            return new Gnome[size];
        }
    };

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhoto() {
        return photo;
    }

    public int getAge() {
        return age;
    }

    public double getWeight() {
        return weight;
    }

    public double getHeight() {
        return height;
    }

    public String getHairColor() {
        return hairColor;
    }

    public List<String> getProfessions() {
        return professions;
    }

    public List<String> getFriends() {
        return friends;
    }


}
