package com.space307.testk.screens

import android.view.View
import com.kaspersky.kaspresso.screens.KScreen
import com.space307.testk.ui.main.AccountsFragment
import com.space307.testk.R
import io.github.kakaocup.kakao.edit.KEditText
import io.github.kakaocup.kakao.image.KImageView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.text.KTextView
import org.hamcrest.Matcher

object AccountsScreen : KScreen<AccountsScreen>() {

    override val layoutId = R.layout.accounts_fragment
    override val viewClass = AccountsFragment::class.java

    // Views

    val filterEditText = KEditText { withId(R.id.filter_edit_text) }

    val accountsRecyclerView = KRecyclerView(
        builder = { withId(R.id.accounts_recycler) },
        itemTypeBuilder = { itemType(::AccountItem) }
    )

    class AccountItem(parent: Matcher<View>) : KRecyclerItem<AccountItem>(parent) {
        val nameTextView = KTextView(parent) { withId(R.id.account_name_text_view) }
        val favoriteImageView = KImageView(parent) { withId(R.id.account_favorite_image_view) }
    }
}


