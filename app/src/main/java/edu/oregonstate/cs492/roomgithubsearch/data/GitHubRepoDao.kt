package edu.oregonstate.cs492.roomgithubsearch.data

import androidx.room3.Dao
import androidx.room3.Delete
import androidx.room3.Insert

@Dao
interface GitHubRepoDao {
    @Insert
    suspend fun insert(repo: GitHubRepo)

    @Delete
    suspend fun delete(repo: GitHubRepo)
}