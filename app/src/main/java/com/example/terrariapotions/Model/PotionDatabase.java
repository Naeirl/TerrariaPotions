package com.example.terrariapotions.Model;

import android.content.Context;
import android.database.SQLException;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.terrariapotions.R;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Category.class, CategoryPotion.class, Ingredient.class, PotionNew.class, PotionIngredient.class, ImagePotion.class}, exportSchema = false, version = 7)
public abstract class PotionDatabase extends RoomDatabase {

    public abstract PotionDAO getPotionDAO();

    private static final String TAG = PotionDatabase.class.getSimpleName();
    private static volatile PotionDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
    private static final String DATABASE_NAME = "potion.db";

    public static PotionDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (PotionDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), PotionDatabase.class, DATABASE_NAME)
                            .addCallback(potionDatabaseCallback)
                            .fallbackToDestructiveMigration()
                            .allowMainThreadQueries()
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback potionDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);


            PotionDAO dao = INSTANCE.getPotionDAO();

//            databaseWriteExecutor.execute(() -> {
//
//                dao.deleteAllPotions();
//                PotionNew p = new PotionNew(5, "Healing Potion", "20% increased health", 0);
//                PotionNew p1 = new PotionNew(6, "Archery Potion2", "20% increased arrow speed and damage", 0);
//                PotionNew p2 = new PotionNew(7, "Archery Potion3", "20% increased arrow speed and damage", 0);
//                PotionNew p3 = new PotionNew(8, "Archery Potion4", "20% increased arrow speed and damage", 0);
//
//                dao.insertPotion(p);
//                dao.insertPotion(p1);
//                dao.insertPotion(p2);
//                dao.insertPotion(p3);
//
//                try {
//                    ImagePotion i = new ImagePotion(0, "Healing Potion", R.drawable.healing_potion);
//                    Log.d(TAG, i.getName() + " is added to database");
//                    dao.insertImagePotion(i);
//                } catch (SQLException ex) {
//                    Log.d(TAG, "this image is already in db");
//                }
//            });

        }
    };
}
