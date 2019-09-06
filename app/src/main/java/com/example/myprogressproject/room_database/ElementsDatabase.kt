package com.example.myprogressproject.room_database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.myprogressproject.model.ElementOfCurrentProf
import com.example.myprogressproject.room_database.ElementsDatabase.Companion.DATABASE_VERSION
import androidx.sqlite.db.SupportSQLiteDatabase
import java.util.concurrent.Executors




@Database(entities = [ElementOfCurrentProf:: class], version = DATABASE_VERSION)
abstract class ElementsDatabase:RoomDatabase(){
    abstract fun elementDAO(): ElementDao

    companion object {
        const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "Engineering prof database"

        private var mInstance: ElementsDatabase? = null

        fun getInstance(context: Context): ElementsDatabase {
            if (mInstance == null) {
                val rdc = object : RoomDatabase.Callback() {
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)
                        // do something after database has been created
                        Executors.newSingleThreadScheduledExecutor().execute {
                            getInstance(context).elementDAO().insertData(populateData())
                        }
                    }

                    override fun onOpen(db: SupportSQLiteDatabase) {
                        // do something every time database is open
                        // Actually do nothing
                    }
                }
                mInstance =
                    Room.databaseBuilder(context, ElementsDatabase::class.java, DATABASE_NAME)
                        .fallbackToDestructiveMigration()
                        .addCallback(rdc)
                        .build()
            }

            return mInstance!!
        }

        //заполнение бд данными
        private fun populateData(): MutableList<ElementOfCurrentProf> {
            return mutableListOf(
                ElementOfCurrentProf("Rough Stone", "https://wow.zamimg.com/images/wow/icons/large/inv_stone_06.jpg", 60,0),
                ElementOfCurrentProf("Copper Bar", "https://wow.zamimg.com/images/wow/icons/large/inv_ingot_02.jpg", 36,0),
                ElementOfCurrentProf("Coarse Stone", "https://wow.zamimg.com/images/wow/icons/large/inv_stone_09.jpg", 20,0),
                ElementOfCurrentProf("Linen Cloth", "https://wow.zamimg.com/images/wow/icons/large/inv_fabric_linen_01.jpg", 20,0),
                ElementOfCurrentProf("Bronze Bar", "https://wow.zamimg.com/images/wow/icons/large/inv_ingot_bronze.jpg", 107,0),
                ElementOfCurrentProf("Tigerseye", "https://wow.zamimg.com/images/wow/icons/large/inv_misc_gem_opal_03.jpg", 2,0),
                ElementOfCurrentProf("Heavy Stone", "https://wow.zamimg.com/images/wow/icons/large/inv_stone_12.jpg", 30,0),
                ElementOfCurrentProf("Wool Cloth", "https://wow.zamimg.com/images/wow/icons/large/inv_fabric_wool_01.jpg", 60,0),
                ElementOfCurrentProf("Medium Leather", "https://wow.zamimg.com/images/wow/icons/large/inv_misc_leatherscrap_05.jpg", 15,0),
                ElementOfCurrentProf("Steel Bar", "https://wow.zamimg.com/images/wow/icons/large/inv_ingot_steel.jpg", 4,0),
                ElementOfCurrentProf("Solid Stone", "https://wow.zamimg.com/images/wow/icons/large/inv_stone_10.jpg", 120,0),
                ElementOfCurrentProf("Mithril Bar", "https://wow.zamimg.com/images/wow/icons/large/inv_ingot_06.jpg", 161,0),
                ElementOfCurrentProf("Mageweave Cloth", "https://wow.zamimg.com/images/wow/icons/large/inv_fabric_mageweave_01.jpg", 40,0),
                ElementOfCurrentProf("Dense Stone", "https://wow.zamimg.com/images/wow/icons/large/inv_misc_stonetablet_07.jpg", 40,0),
                ElementOfCurrentProf("Thorium Bar", "https://wow.zamimg.com/images/wow/icons/large/inv_ingot_07.jpg", 195,0),
                ElementOfCurrentProf("Runecloth", "https://wow.zamimg.com/images/wow/icons/large/inv_fabric_purplefire_01.jpg", 25,0)
            )
        }
    }
}