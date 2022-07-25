package com.example

import androidx.core.os.bundleOf
import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.githubclient.R
import com.example.githubclient.domain.entity.UserProfileEntity
import com.example.githubclient.ui.detail_screen.DetailUserProfileFragment
import com.example.githubclient.ui.detail_screen.USER_KEY
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class DetailUserFragmentTest {
    private lateinit var scenario: FragmentScenario<DetailUserProfileFragment>

    @Before
    fun setup() {
        scenario = launchFragmentInContainer()
    }

    @Test
    fun bundle_test() {
        val profileEntity = UserProfileEntity(1L, "Login", "url", null)

        val bundle = bundleOf(
            USER_KEY to profileEntity
        )
        launchFragmentInContainer<DetailUserProfileFragment>(bundle)
        val assertion = matches(withText("Login"))
        onView(withId(R.id.user_name_text_view)).check(assertion)
    }

    @Test
    fun visibleAvatar_test() {
        val assertion = matches(withEffectiveVisibility(Visibility.VISIBLE))
        onView(withId(R.id.avatar_image_view)).check(assertion)
    }
}