package com.space307.testk.ui.main

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    fun getList():List<AccountItem> {
        val list = mutableListOf<AccountItem>()
        for (i in 0..50) {
            list.add(AccountItem("Account $i", false))
        }
        return list
    }
}