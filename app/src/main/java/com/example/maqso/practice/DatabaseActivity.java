package com.example.maqso.practice;

import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

import io.objectbox.Box;
import io.objectbox.BoxStore;

public class DatabaseActivity extends AppCompatActivity {

    private static final String TAG = "MYTAG";
    BoxStore boxStore;
    Box bookBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);

        BoxStore boxStore = App.getApp().getBoxStore();
        Box<Animal> animalBox = boxStore.boxFor(Animal.class);

        // insert animal
        for (int i = 0; i < 200; i++) {
            animalBox.put(new Animal("Dog " + i, false, false, true));
        }

        // loads all animals
        List<Animal> animals = animalBox.getAll();
        // find a specific animal in the database
        long myDogId = 12;
        Animal myDog = animalBox.get(myDogId);
        Log.d(TAG, "onCreate: " + myDog);
        // update an animal
        myDog.setSwimming(true);
        animalBox.put(myDog);
        Log.d(TAG, "onCreate: " + myDog);

    }
}
