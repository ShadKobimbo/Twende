package com.example.twende.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.twende.model.FavoritesModel;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    private static final String TAG = "DBHelper";
    private static final String DB_NAME = "favorites.db";

    public DBHelper(@Nullable Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase favoritesDB) {
        favoritesDB.execSQL("CREATE TABLE favorites(id INTEGER PRIMARY KEY AUTOINCREMENT, repo_id TEXT, repo_name TEXT, repo_description TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase favoritesDB, int i, int i1) {
        favoritesDB.execSQL("DROP TABLE IF EXISTS favorites");
        onCreate(favoritesDB);
    }

    public boolean insertIntoFavorites(String repo_id, String repo_name, String repo_description) {
        SQLiteDatabase favoritesDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("repo_id", repo_id);
        contentValues.put("repo_name", repo_name);
        contentValues.put("repo_description", repo_description);

        return favoritesDB.insert("favorites", null, contentValues) > 0;

    }

    public boolean removeFromFavorites(String repo_id) {
        SQLiteDatabase favoritesDB = this.getWritableDatabase();

        String table = "favorites";
        String whereClause = "repo_id=?";
        String[] whereArgs = new String[] { repo_id };

        return favoritesDB.delete(table, whereClause, whereArgs) > 0;

    }

    public boolean checkFavorites(String repo_id) {
        SQLiteDatabase favoritesDB = this.getWritableDatabase();
        Cursor cursor = favoritesDB.rawQuery("SELECT * FROM favorites WHERE repo_id = ?", new String[] {repo_id});

        if (cursor.getCount()>0)
            return true;
        else
            return false;
    }

    public ArrayList<FavoritesModel> readFavoritesData() {

        ArrayList<FavoritesModel> repoArrayList = new ArrayList<>();

        SQLiteDatabase favoritesDB = this.getWritableDatabase();
        Cursor cursor = favoritesDB.rawQuery("SELECT * FROM favorites", null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {

                String repo_id = cursor.getString(1);
                String repo_name = cursor.getString(2);
                String repo_description = cursor.getString(3);

                FavoritesModel repoModel = new FavoritesModel(repo_id,repo_name, repo_description);

                repoArrayList.add(repoModel);

            }while (cursor.moveToNext());
        }

        return repoArrayList;
    }
}