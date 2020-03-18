package com.demo.smaatotest;



import androidx.test.espresso.IdlingRegistry;
import androidx.test.espresso.idling.CountingIdlingResource;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);
    private CountingIdlingResource myIdlingResource;

    @Before
    public void registerIdlingResource() {
        myIdlingResource = mActivityTestRule.getActivity().getIdlingResourceInTest();
        IdlingRegistry.getInstance().register(myIdlingResource);
    }

    @After
    public void unRegisterIdlingResource() {
        IdlingRegistry.getInstance().unregister(myIdlingResource);
    }
    @Test
    public void showAdTest() {
        // Locate the showAd button and perform click.
        onView(withId(R.id.show_ad_btn)).perform(click());

       // Check the bannerview has text sms
        withId(R.id.bannerView).matches(withText("sms"));
    }

    @Test
    public void tapAdTest() {
        // TODO:
    }

}
