package com.vladbstrv.githubapp.ui.userdetails

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import coil.load
import com.vladbstrv.githubapp.databinding.UserDetailsFragmentBinding
import com.vladbstrv.githubapp.domain.repo.UsersRepo
import org.koin.android.ext.android.inject
import java.lang.IllegalStateException

class UserDetailsFragment : Fragment() {

    companion object {
        private val ARG_KEY = "ARG_KEY"

        fun newInstance(username: String) = UserDetailsFragment().apply {
            arguments = Bundle()
            arguments?.putString(ARG_KEY, username)
        }

    }

    private var _binding: UserDetailsFragmentBinding? = null
    private val binding get() = _binding!!
    private val userRepo: UsersRepo by inject()
    private lateinit var viewModel: UserDetailsViewModel
    private val adapter = UserDetailsAdapter()

    private fun getUsernameFromArguments(): String {
        return arguments?.getString(ARG_KEY)
            ?: throw IllegalStateException("null arguments")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = UserDetailsFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(
            this,
            UserDetailsViewModelFactory(userRepo)
        )[UserDetailsViewModel::class.java]

        val username = getUsernameFromArguments()
        initViews()
        initViewEvents(username)
        initViewModelEvents()
    }

    private fun initViews() {
        binding.reposRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        adapter.setHasStableIds(true)
        binding.reposRecyclerView.adapter = adapter
    }

    private fun initViewEvents(name: String) {
        viewModel.onShowUserDetails(name)
        viewModel.onShowRepos(name)
    }

    private fun initViewModelEvents() {
        viewModel.repos.observe(requireActivity()) {
            adapter.setData(it)
        }
        viewModel.userDetails.observe(requireActivity()) {
            it.let {
                binding.avatarImageView.load(it.avatarUrl)
                binding.loginTextView.text = it.login
                binding.nameTextView.text = it.name
            }

        }
        viewModel.inProgress.observe(requireActivity()) {
            binding.progressBar.isVisible = it
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}