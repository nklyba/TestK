package com.space307.testk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.space307.testk.ui.main.AccountsFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, AccountsFragment.newInstance())
                .commitNow()
        }
    }
}