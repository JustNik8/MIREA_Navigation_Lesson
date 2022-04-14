package com.justnik.mirea_navigation_lesson.enteties;

import android.os.Parcel;
import android.os.Parcelable;

public class City implements Parcelable {
    private final String name;
    private final int population;
    private final String imageUrl;

    public City(String name, int population, String imageUrl) {
        this.name = name;
        this.population = population;
        this.imageUrl = imageUrl;
    }

    protected City(Parcel in) {
        name = in.readString();
        population = in.readInt();
        imageUrl = in.readString();
    }

    public static final Creator<City> CREATOR = new Creator<City>() {
        @Override
        public City createFromParcel(Parcel in) {
            return new City(in);
        }

        @Override
        public City[] newArray(int size) {
            return new City[size];
        }
    };

    public String getName() {
        return name;
    }

    public int getPopulation() {
        return population;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeInt(population);
        parcel.writeString(imageUrl);
    }
}
