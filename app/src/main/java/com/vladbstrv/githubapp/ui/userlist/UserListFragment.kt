package com.vladbstrv.githubapp.ui.userlist

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.vladbstrv.githubapp.R
import com.vladbstrv.githubapp.databinding.UserListFragmentBinding
import com.vladbstrv.githubapp.ui.domain.entity.UserListEntity

class UserListFragment : Fragment() {

    companion object {
        fun newInstance() = UserListFragment()
    }

    private var _binding: UserListFragmentBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: UserListViewModel
    private val adapter = UserListAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = UserListFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[UserListViewModel::class.java]

        initViews()
        initViewEvents()
        initViewModelEvents()
    }

    private fun initViews() {
        binding.usersRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        adapter.setHasStableIds(true)
        binding.usersRecyclerView.adapter = adapter
    }

    private fun initViewEvents() {

    }

    private fun initViewModelEvents() {
        val list = mutableListOf(
            UserListEntity("1"),
            UserListEntity("2"),
            UserListEntity("3"),
            UserListEntity("4"),
            UserListEntity("5"),
        )
        adapter.setData(list)
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}