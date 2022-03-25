package com.space307.testk.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.space307.testk.R

class AccountsFragment : Fragment() {

    companion object {
        fun newInstance() = AccountsFragment()
    }

    private lateinit var viewModel: MainViewModel
    private lateinit var accountsRecycler: RecyclerView
    private lateinit var accountAdapter: AccountsAdapter
    private lateinit var filterEditText: EditText

    private var accounts = emptyList<AccountItem>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.accounts_fragment, container, false)

        accountsRecycler = view.findViewById(R.id.accounts_recycler)
        filterEditText = view.findViewById(R.id.filter_edit_text)

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        accounts = viewModel.getList()
        accountAdapter = AccountsAdapter(accounts) { account ->
            account.selected = !account.selected
            accountAdapter.notifyItemChanged(accounts.indexOf(account))
        }
        accountsRecycler.layoutManager = LinearLayoutManager(requireContext())
        accountsRecycler.adapter = accountAdapter

        filterEditText.addTextChangedListener {
            val filterValue = filterEditText.text
            val filteredAccounts = accounts.filter { it.name.contains(filterValue) }
            accountAdapter.setAccounts(filteredAccounts)
            accountsRecycler.scrollToPosition(0)
        }
    }
}