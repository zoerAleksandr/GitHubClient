package com.example

import androidx.core.os.bundleOf
import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.githubclient.R
import com.example.githubclient.domain.entity.UserProfileEntity
import com.example.githubclient.ui.detail_screen.DetailUserProfileFragment
import com.example.githubclient.ui.detail_screen.DetailUserVH
import com.example.githubclient.ui.detail_screen.USER_KEY
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class DetailUserRecyclerViewTest {
    private lateinit var scenario: FragmentScenario<DetailUserProfileFragment>

    @Before
    fun setup() {
        val profileEntity = UserProfileEntity(1L, "name1", "url", null)

        val bundle = bundleOf(
            USER_KEY to profileEntity
        )
        scenario = launchFragmentInContainer(bundle)
    }

    @Test
    fun scroll_recyclerView_test() {
        val searchText = "nameRepo9"

        onView(withId(R.id.list_repo_recycler_view)).perform(
            RecyclerViewActions.scrollToPosition<DetailUserVH>(8)
        )
        onView(withText(searchText)).check(matches(isCompletelyDisplayed()))
    }

    @Test
    fun item_clickable_test() {
        onView(withId(R.id.list_repo_recycler_view))
            .perform(
                RecyclerViewActions.actionOnItem<DetailUserVH>(
                    hasDescendant(withText("nameRepo9")),
                    click()
                )
            )
    }
}