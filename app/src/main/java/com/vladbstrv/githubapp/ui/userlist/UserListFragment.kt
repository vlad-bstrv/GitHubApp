package com.vladbstrv.githubapp.ui.userlist

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.vladbstrv.githubapp.R
import com.vladbstrv.githubapp.app
import com.vladbstrv.githubapp.databinding.UserListFragmentBinding
import com.vladbstrv.githubapp.domain.entity.UserListEntity
import com.vladbstrv.githubapp.ui.userdetails.UserDetailsFragment

class UserListFragment : Fragment() {

    companion object {
        fun newInstance() = UserListFragment()
    }

    private var _binding: UserListFragmentBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: UserListViewModel
    private lateinit var adapter: UserListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = UserListFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(
            this,
            UserListViewModelFactory(requireActivity().app.usersListRepo)
        )[UserListViewModel::class.java]

        adapter = UserListAdapter(object : OnListItemClickListener {
            override fun onItemClick(data: UserListEntity) {
                navigateTo(data.login)
            }
        })

        binding.searchUserButton.setOnClickListener {
            val username = binding.searchUserEditText.text.toString()
            navigateTo(username)
        }

        initViews()
        initViewEvents()
        initViewModelEvents()
    }

    private fun navigateTo(username: String) {
        val bundle = Bundle()
        bundle.putString("name" ,username)
        val userDetailsFragment = UserDetailsFragment()
        userDetailsFragment.arguments = bundle
        parentFragmentManager.beginTransaction()
            .addToBackStack("")
            .replace(R.id.container, userDetailsFragment)
            .commit()
    }

    private fun initViews() {
        binding.usersRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        adapter.setHasStableIds(true)
        binding.usersRecyclerView.adapter = adapter
    }

    private fun initViewEvents() {
        viewModel.onShowRepos()
    }

    private fun initViewModelEvents() {
        viewModel.repos.observe(requireActivity()) {
            adapter.setData(it)
        }

        viewModel.inProgress.observe(requireActivity()) {
            binding.progressBar.isVisible = it
            binding.searchUserEditText.isVisible = !it
            binding.searchUserButton.isVisible = !it
        }
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}