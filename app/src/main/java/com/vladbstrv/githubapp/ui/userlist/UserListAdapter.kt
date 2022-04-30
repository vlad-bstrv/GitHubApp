package com.vladbstrv.githubapp.ui.userlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vladbstrv.githubapp.databinding.ItemUserListFragmentBinding
import com.vladbstrv.githubapp.ui.domain.entity.UserListEntity

class UserListAdapter : RecyclerView.Adapter<UserListAdapter.UserListViewHolder>() {

    private var data: List<UserListEntity> = mutableListOf()

    fun setData(newUserListData: List<UserListEntity>) {
        data = newUserListData
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserListViewHolder {
        val binding =
            ItemUserListFragmentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserListViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: UserListViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount() = data.size

    inner class UserListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(data: UserListEntity) {
            ItemUserListFragmentBinding.bind(itemView).apply {
                nameUserTextView.text = data.name
            }
        }
    }
}