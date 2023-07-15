package com.example.tokobijikopiapp.application

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.tokobijikopiapp.dao.CoffeDao
import com.example.tokobijikopiapp.model.Coffe

@Database(entities = [Coffe::class], version = 2, exportSchema = false)
abstract class CoffeDatabase: RoomDatabase(){
    abstract fun coffeDao(): CoffeDao

    companion object {
        private var INSTANCE: CoffeDatabase? = null

        private val migration1To2: Migration = object:Migration(1, 2){
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE coffe_table ADD COLUMN latitude Double DEFAULT 0.0")
                database.execSQL("ALTER TABLE coffe_table ADD COLUMN longtitude Double DEFAULT 0.0")
            }
        }

        fun getDatabase(context: Context): CoffeDatabase {
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CoffeDatabase::class.java,
                    "coffe_database"
                )
                    .addMigrations(migration1To2)
                    .allowMainThreadQueries()
                    .build()

                INSTANCE = instance
                instance
            }
        }
    }

}