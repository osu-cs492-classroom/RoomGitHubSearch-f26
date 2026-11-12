package edu.oregonstate.cs492.roomgithubsearch.data

import androidx.room3.Entity
import androidx.room3.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import java.io.Serializable

@Entity
@JsonClass(generateAdapter = true)
data class GitHubRepo(
    @PrimaryKey
    @Json(name = "full_name")
    val name: String,

    val description: String?,

    @Json(name = "html_url")
    val url: String,

    @Json(name = "stargazers_count")
    val stars: Int
) : Serializable