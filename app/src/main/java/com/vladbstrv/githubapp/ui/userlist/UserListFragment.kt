package com.vladbstrv.githubapp.ui.userlist

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.vladbstrv.githubapp.databinding.UserListFragmentBinding
import com.vladbstrv.githubapp.domain.entity.UserListEntity
import com.vladbstrv.githubapp.domain.repo.UsersRepo
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.lang.IllegalStateException

class UserListFragment : Fragment() {

    companion object {
        fun newInstance() = UserListFragment()
    }

    private var _binding: UserListFragmentBinding? = null
    private val binding get() = _binding!!
    private val viewModel: UserListViewModel by viewModel()
    private lateinit var adapter: UserListAdapter

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(activity !is Controller) {
            throw IllegalStateException("Activity don't extend Controller")
        }
    }

    private val controller: Controller
    get() {
        return activity as Controller
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = UserListFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
        initViewEvents()
        initViewModelEvents()
    }

    private fun initViews() {
        adapter = UserListAdapter(object : OnListItemClickListener {
            override fun onItemClick(data: UserListEntity) {
                controller.openDetailScreen(data.login)
            }
        })
        binding.usersRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        adapter.setHasStableIds(true)
        binding.usersRecyclerView.adapter = adapter

        binding.searchUserButton.setOnClickListener {
            val username = binding.searchUserEditText.text.toString()
            controller.openDetailScreen(username)
        }
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

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    interface Controller {
        fun openDetailScreen(username: String)
    }
}