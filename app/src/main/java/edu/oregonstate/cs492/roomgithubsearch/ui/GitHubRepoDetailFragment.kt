package edu.oregonstate.cs492.roomgithubsearch.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.google.android.material.button.MaterialButton
import edu.oregonstate.cs492.roomgithubsearch.R

class GitHubRepoDetailFragment : Fragment(R.layout.fragment_github_repo_detail) {
    private val args: GitHubRepoDetailFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val repoNameTV = view.findViewById<TextView>(R.id.tv_repo_name)
        val repoStarsTV = view.findViewById<TextView>(R.id.tv_repo_stars)
        val repoDescriptionTV = view.findViewById<TextView>(R.id.tv_repo_description)
        val bookmarkButton = view.findViewById<MaterialButton>(R.id.button_bookmark)

        repoNameTV.text = args.repo.name
        repoStarsTV.text = args.repo.stars.toString()
        repoDescriptionTV.text = args.repo.description
        bookmarkButton.isChecked = false

        bookmarkButton.addOnCheckedChangeListener { _, isChecked ->
            Log.d("GitHubRepoDetailFragment", "${args.repo.name} bookmarked: ${isChecked}")
        }
    }
}