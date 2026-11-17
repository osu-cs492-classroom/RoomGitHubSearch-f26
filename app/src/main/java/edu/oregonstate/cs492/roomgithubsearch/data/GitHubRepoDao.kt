package edu.oregonstate.cs492.roomgithubsearch.data

import androidx.room3.Dao
import androidx.room3.Delete
import androidx.room3.Insert
import androidx.room3.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface GitHubRepoDao {
    @Insert
    suspend fun insert(repo: GitHubRepo)

    @Delete
    suspend fun delete(repo: GitHubRepo)

    @Query("SELECT * FROM GitHubRepo")
    fun getAllRepos(): Flow<List<GitHubRepo>>

    @Query("SELECT * FROM GitHubRepo WHERE name = :name LIMIT 1")
    fun getRepoByName(name: String): Flow<GitHubRepo?>
}