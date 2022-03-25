package com.space307.testk.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.space307.testk.R

class AccountsAdapter(
    accounts: List<AccountItem>,
    val clickListener: (account: AccountItem) -> Unit
    ) : RecyclerView.Adapter<AccountsAdapter.AccountViewHolder>() {

    private val dataSet = mutableListOf<AccountItem>()

    init {
        dataSet.addAll(accounts)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        AccountViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_account, parent, false)
        )

    override fun onBindViewHolder(holder: AccountViewHolder, position: Int) {
        val account = dataSet[position]

        holder.apply {
            nameTextView.text = account.name
            starImageView.isVisible = account.selected

            layout.setOnClickListener { clickListener(account) }
        }
    }

    override fun getItemCount() = dataSet.size

    fun setAccounts(newAccounts: List<AccountItem>) {
        dataSet.clear()
        dataSet.addAll(newAccounts)

        notifyDataSetChanged()
    }

    class AccountViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var layout: View = itemView.findViewById(R.id.account_layout)
        var nameTextView: TextView = itemView.findViewById(R.id.account_name_text_view)
        var starImageView: ImageView = itemView.findViewById(R.id.account_favorite_image_view)
    }
}