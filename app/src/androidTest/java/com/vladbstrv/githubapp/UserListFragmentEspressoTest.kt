package com.vladbstrv.githubapp

import android.view.View
import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.vladbstrv.githubapp.ui.userlist.UserListAdapter
import com.vladbstrv.githubapp.ui.userlist.UserListFragment
import org.hamcrest.Matcher
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class UserListFragmentEspressoTest {

    private lateinit var scenario: FragmentScenario<UserListFragment>

    @Before
    fun setup() {
        scenario = launchFragmentInContainer()
    }

    @Test
    fun progressBar_isDisplayed() {
        onView(withId(R.id.progress_bar)).check(matches(isDisplayed()))
    }

    @Test
    fun search_edit_text_isDisplayed() {
        onView(isRoot()).perform(delay())
        onView(withId(R.id.search_user_edit_text)).check(matches(isDisplayed()))
    }

    @Test
    fun search_button_isDisplayed() {
        onView(isRoot()).perform(delay())
        onView(withId(R.id.search_user_button)).check(matches(isDisplayed()))
    }

    @Test
    fun users_recyclerView_scrollTo() {
        onView(isRoot()).perform(delay())
        onView(withId(R.id.users_recycler_view))
            .perform(
                RecyclerViewActions.scrollTo<UserListAdapter.UserListViewHolder>(
                    hasDescendant(withText("Vlad-bstrv15"))
                )
            )
    }

    private fun delay(): ViewAction? {
        return object : ViewAction {
            override fun getConstraints(): Matcher<View> = isRoot()
            override fun getDescription(): String = "wait for $2 seconds"
            override fun perform(uiController: UiController, v: View?) {
                uiController.loopMainThreadForAtLeast(2000)
            }
        }
    }
}