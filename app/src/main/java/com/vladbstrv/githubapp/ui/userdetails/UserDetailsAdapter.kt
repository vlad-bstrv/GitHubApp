package com.vladbstrv.githubapp.ui.userdetails

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vladbstrv.githubapp.databinding.ItemUserDetailsFrahmentBinding
import com.vladbstrv.githubapp.domain.entity.ReposEntity

class UserDetailsAdapter : RecyclerView.Adapter<UserDetailsAdapter.UserDetailsViewHolder>() {

    private var data: List<ReposEntity> = mutableListOf()

    fun setData(newReposData: List<ReposEntity>) {
        data = newReposData
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserDetailsViewHolder {
        val binding =
            ItemUserDetailsFrahmentBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return UserDetailsViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: UserDetailsViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount() = data.size

    inner class UserDetailsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(data: ReposEntity) {
            ItemUserDetailsFrahmentBinding.bind(itemView).apply {
                nameReposTextView.text = data.name
            }
        }
    }
}