package edu.oregonstate.cs492.roomgithubsearch.data

import android.content.Context
import androidx.room3.Database
import androidx.room3.Room
import androidx.room3.RoomDatabase
import androidx.sqlite.driver.AndroidSQLiteDriver
import kotlin.concurrent.Volatile

@Database(entities = [GitHubRepo::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun gitHubRepoDao(): GitHubRepoDao

    companion object {
        @Volatile private var instance: AppDatabase? = null

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder<AppDatabase>(context, "BookmarkedRepos")
                .setDriver(AndroidSQLiteDriver())
                .build()

        // AppDatabase.getInstance()
        fun getInstance(context: Context): AppDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also {
                    instance = it
                }
            }
        }
    }
}