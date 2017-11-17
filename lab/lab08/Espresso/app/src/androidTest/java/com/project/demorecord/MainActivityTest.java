package com.project.demorecord;


import android.os.SystemClock;
import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {
    // Convenience helper
    public static RecyclerViewMatcher withRecyclerView(final int recyclerViewId) {
        return new RecyclerViewMatcher(recyclerViewId);
    }
    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);



    @Test
    public void testCase1() {

        onView(withId(R.id.buttonAdded)).perform(click());
        onView(withId(android.R.id.message)).check(matches(withText("Please Enter user info")));
        SystemClock.sleep(1000);



    }


    @Test
    public void testCase2() {
        onView(allOf(withId(R.id.editTextAge), isDisplayed())).perform(replaceText("20"), closeSoftKeyboard());
        onView(withId(R.id.buttonAdded)).perform(click());
        onView(withId(android.R.id.message)).check(matches(withText("Please Enter user info")));
        SystemClock.sleep(1000);

    }

    @Test
    public void testCase3() {
        onView(withId(R.id.buttonGotoList)).perform(click());
        onView(withId(R.id.textNotFound)).check(matches(withText("Not Found")));
        SystemClock.sleep(1000);

    }

    @Test
    public void testCase4() {
        onView(withId(R.id.editTExtName)).perform(replaceText("Ying"));
        onView(withId(R.id.buttonAdded)).perform(click());
        onView(withId(android.R.id.message)).check(matches(withText("Please Enter user info")));
        onView(withId(android.R.id.button1)).perform(click());
        SystemClock.sleep(1000);
    }

    @Test
    public void testCase5() {
        onView(allOf(withId(R.id.editTExtName), isDisplayed())).perform(replaceText("Ying"), closeSoftKeyboard());
        onView(allOf(withId(R.id.editTextAge), isDisplayed())).perform(replaceText("20"), closeSoftKeyboard());
        onView(withId(R.id.buttonAdded)).perform(click());
        onView(withId(R.id.buttonGotoList)).perform(click());

        onView(withRecyclerView(R.id.list).atPositionOnView(0, R.id.textName))
                .check(matches(withText("Ying")));

        onView(withRecyclerView(R.id.list).atPositionOnView(0, R.id.textAge))
                .check(matches(withText("20")));


        SystemClock.sleep(1000);

    }



    @Test
    public void testCase7() {

        onView(withId(R.id.editTExtName)).perform(replaceText("Ying"), closeSoftKeyboard());
        onView(withId(R.id.editTextAge)).perform(replaceText("20"), closeSoftKeyboard());
        onView(withId(R.id.buttonAdded)).perform(click());
        onView(withId(R.id.editTExtName)).perform(replaceText("Ladarat"), closeSoftKeyboard());
        onView(withId(R.id.editTextAge)).perform(replaceText("20"), closeSoftKeyboard());
        onView(withId(R.id.buttonAdded)).perform(click());
        onView(withId(R.id.editTExtName)).perform(replaceText("Somkait"), closeSoftKeyboard());
        onView(withId(R.id.editTextAge)).perform(replaceText("80"), closeSoftKeyboard());
        SystemClock.sleep(1000);

        onView(withId(R.id.buttonAdded)).perform(click());
        onView(withId(R.id.buttonGotoList)).perform(click());

        onView(withRecyclerView(R.id.list)
                .atPositionOnView(2, R.id.textName))
                .check(matches(withText("Somkait")));

        onView(withRecyclerView(R.id.list)
                .atPositionOnView(2, R.id.textAge))
                .check(matches(withText("80")));

        SystemClock.sleep(1000);
    }

    @Test
    public void testCase8() {

        onView(withId(R.id.editTExtName)).perform(replaceText("Ying"), closeSoftKeyboard());
        onView(withId(R.id.editTextAge)).perform(replaceText("20"), closeSoftKeyboard());
        onView(withId(R.id.buttonAdded)).perform(click());
        onView(withId(R.id.editTExtName)).perform(replaceText("Ladarat"), closeSoftKeyboard());
        onView(withId(R.id.editTextAge)).perform(replaceText("20"), closeSoftKeyboard());
        onView(withId(R.id.buttonAdded)).perform(click());
        onView(withId(R.id.editTExtName)).perform(replaceText("Somkait"), closeSoftKeyboard());
        onView(withId(R.id.editTextAge)).perform(replaceText("80"), closeSoftKeyboard());
        onView(withId(R.id.buttonAdded)).perform(click());
        onView(withId(R.id.editTExtName)).perform(replaceText("Prayoch"), closeSoftKeyboard());
        onView(withId(R.id.editTextAge)).perform(replaceText("60"), closeSoftKeyboard());

        SystemClock.sleep(1000);

        onView(withId(R.id.buttonAdded)).perform(click());
        onView(withId(R.id.buttonGotoList)).perform(click());

        onView(withRecyclerView(R.id.list)
                .atPositionOnView(3, R.id.textName))
                .check(matches(withText("Prayoch")));

        onView(withRecyclerView(R.id.list)
                .atPositionOnView(3, R.id.textAge))
                .check(matches(withText("60")));

        SystemClock.sleep(1000);
    }

    @Test
    public void testCase9() {

        onView(withId(R.id.editTExtName)).perform(replaceText("Ying"), closeSoftKeyboard());
        onView(withId(R.id.editTextAge)).perform(replaceText("20"), closeSoftKeyboard());
        onView(withId(R.id.buttonAdded)).perform(click());
        onView(withId(R.id.editTExtName)).perform(replaceText("Ladarat"), closeSoftKeyboard());
        onView(withId(R.id.editTextAge)).perform(replaceText("20"), closeSoftKeyboard());
        onView(withId(R.id.buttonAdded)).perform(click());
        onView(withId(R.id.editTExtName)).perform(replaceText("Somkait"), closeSoftKeyboard());
        onView(withId(R.id.editTextAge)).perform(replaceText("80"), closeSoftKeyboard());
        onView(withId(R.id.buttonAdded)).perform(click());
        onView(withId(R.id.editTExtName)).perform(replaceText("Prayoch"), closeSoftKeyboard());
        onView(withId(R.id.editTextAge)).perform(replaceText("60"), closeSoftKeyboard());
        onView(withId(R.id.buttonAdded)).perform(click());
        onView(withId(R.id.editTExtName)).perform(replaceText("Prayoch"), closeSoftKeyboard());
        onView(withId(R.id.editTextAge)).perform(replaceText("50"), closeSoftKeyboard());
        SystemClock.sleep(1000);

        onView(withId(R.id.buttonAdded)).perform(click());
        onView(withId(R.id.buttonGotoList)).perform(click());


        onView(withRecyclerView(R.id.list)
                .atPositionOnView(4, R.id.textName))
                .check(matches(withText("Prayoch")));

        onView(withRecyclerView(R.id.list)
                .atPositionOnView(4, R.id.textAge))
                .check(matches(withText("50")));
        SystemClock.sleep(1000);

    }



}
