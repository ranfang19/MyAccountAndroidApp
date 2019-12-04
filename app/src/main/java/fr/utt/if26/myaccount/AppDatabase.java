package fr.utt.if26.myaccount;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Line.class},version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract  LineDao lineDao();
}
