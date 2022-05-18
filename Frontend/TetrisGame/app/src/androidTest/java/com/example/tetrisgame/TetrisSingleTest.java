package com.example.tetrisgame;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.ViewInteraction;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class TetrisSingleTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void tetrisSingleTest() {
        ViewInteraction materialButton = onView(
                allOf(withId(R.id.MainScreen_SinglePlayer), withText("Single Player"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                2),
                        isDisplayed()));
        materialButton.perform(click());

        ViewInteraction materialButton2 = onView(
                allOf(withId(R.id.TetrisSingle_start), withText("Start"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                0),
                        isDisplayed()));
        materialButton2.perform(click());

        try {
            Thread.sleep(510);
        } catch (InterruptedException e) {
        }
        ViewInteraction materialButton3 = onView(
                allOf(withId(R.id.TetrisSingle_left), withText("Left"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                2),
                        isDisplayed()));
        materialButton3.perform(click());

        try {
            Thread.sleep(510);
        } catch (InterruptedException e) {
        }
        ViewInteraction materialButton4 = onView(
                allOf(withId(R.id.TetrisSingle_rotate), withText("Rotate"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                3),
                        isDisplayed()));
        materialButton4.perform(click());

        try {
            Thread.sleep(510);
        } catch (InterruptedException e) {
        }
        ViewInteraction materialButton5 = onView(
                allOf(withId(R.id.TetrisSingle_right), withText("Right"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                4),
                        isDisplayed()));
        materialButton5.perform(click());

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
        }
        ViewInteraction materialButton6 = onView(
                allOf(withId(R.id.TetrisSingle_left), withText("Left"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                2),
                        isDisplayed()));
        materialButton6.perform(click());
        try {
            Thread.sleep(510);
        } catch (InterruptedException e) {
        }
        ViewInteraction materialButton7 = onView(
                allOf(withId(R.id.TetrisSingle_rotate), withText("Rotate"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                3),
                        isDisplayed()));
        materialButton7.perform(click());
        try {
            Thread.sleep(510);
        } catch (InterruptedException e) {
        }
        ViewInteraction materialButton8 = onView(
                allOf(withId(R.id.TetrisSingle_right), withText("Right"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                4),
                        isDisplayed()));
        materialButton8.perform(click());

        ViewInteraction textView = onView(
                allOf(withId(R.id.TetrisSingle_Score), withText("Score: 0"),
                        withParent(withParent(withId(android.R.id.content))),
                        isDisplayed()));
        textView.check(matches(withText("Score: 0")));
    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
