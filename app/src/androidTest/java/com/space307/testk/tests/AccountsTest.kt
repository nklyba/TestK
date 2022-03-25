package com.space307.testk.tests

import androidx.test.ext.junit.rules.activityScenarioRule
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import com.space307.testk.MainActivity
import com.space307.testk.screens.AccountsScreen
import org.junit.Rule
import org.junit.Test

class AccountsTest : TestCase() {

    @get:Rule
    val activityRule = activityScenarioRule<MainActivity>()

    @Test
    fun caseId_1_selectFavoriteAccounts() = run {
        val favoriteAccountsPositions = listOf(5, 15, 25, 35, 45, 50)

        favoriteAccountsPositions.forEach { pos ->
            step("Click on account $pos, check star icon is shown") {
                AccountsScreen {
                    accountsRecyclerView {
                        childAt<AccountsScreen.AccountItem>(pos) {
                            click()
                            favoriteImageView.isVisible()
                        }
                    }
                }
            }
        }

        step("Type 5 in the filter field, verify that all filtered accounts have 5 in their name " +
                "and that all filtered accounts are favorites.") {
            AccountsScreen {
                filterEditText.typeText("5")
                accountsRecyclerView {
                    children<AccountsScreen.AccountItem>{
                        nameTextView.containsText("5")
                        favoriteImageView.isVisible()
                    }
                }
            }
        }
    }
}