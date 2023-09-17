package com.example.photoapp;

import java.util.ArrayList;

public class PhotoData {
    public static ArrayList<Photo> generatePhotoData() {
        ArrayList<Photo> photos = new ArrayList<>();
        photos.add(new Photo(2, "", "bbb", ""));
        photos.add(new Photo(3, "", "aaa", ""));
        photos.add(new Photo(4, "", "ccc", ""));
        photos.add(new Photo(5, "", "ddd", ""));
        photos.add(new Photo(2, "", "bbb", ""));
        photos.add(new Photo(3, "", "aaa", ""));
        photos.add(new Photo(4, "", "ccc", ""));
        photos.add(new Photo(5, "https://unsplash.com/photos/a-wooden-table-topped-with-plates-of-food-7y2vVGzAQ2o", "ddd", ""));
        return photos;
    }

    public static Photo getPhotoFromId(int id) {
        ArrayList<Photo> phs = generatePhotoData();
        for (int i = 0; i < phs.size(); i++)
            if (phs.get(i).getId() == id)
                return phs.get(i);
        return null;
    }
}
