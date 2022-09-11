package com.mohith.delicious;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.pressImeActionButton;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.ViewInteraction;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class deepak_MainActivityTest {

    @Rule
    public ActivityScenarioRule<MainActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void deepak_MainActivityTest() {
        ViewInteraction textInputEditText = onView(
                allOf(withId(R.id.email_input),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.email),
                                        0),
                                0),
                        isDisplayed()));
        textInputEditText.perform(replaceText("deepak@gmail.com"), closeSoftKeyboard());

        ViewInteraction textInputEditText2 = onView(
                allOf(withId(R.id.password_input),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.password),
                                        0),
                                0),
                        isDisplayed()));
        textInputEditText2.perform(replaceText("Deepak@123"), closeSoftKeyboard());

        ViewInteraction materialButton = onView(
                allOf(withId(R.id.login), withText("LOGIN"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.FrameLayout")),
                                        0),
                                3),
                        isDisplayed()));
        materialButton.perform(click());

        ViewInteraction textInputEditText3 = onView(
                allOf(withId(R.id.password_input), withText("12345"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.password),
                                        0),
                                0),
                        isDisplayed()));
        textInputEditText3.perform(pressImeActionButton());

        ViewInteraction materialButton2 = onView(
                allOf(withId(R.id.login), withText("LOGIN"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.FrameLayout")),
                                        0),
                                3),
                        isDisplayed()));
        materialButton2.perform(click());

        ViewInteraction button = onView(
                allOf(withId(R.id.login), withText("LOGIN"),
                        withParent(withParent(IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class))),
                        isDisplayed()));
        button.check(matches(isDisplayed()));

        ViewInteraction materialButton3 = onView(
                allOf(withId(R.id.signup), withText("SIGNUP"),
                        childAtPosition(
                                allOf(withId(R.id.buttons),
                                        childAtPosition(
                                                withId(R.id.box),
                                                0)),
                                1),
                        isDisplayed()));
        materialButton3.perform(click());

        ViewInteraction textInputEditText4 = onView(
                allOf(withId(R.id.email_input),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.email),
                                        0),
                                0),
                        isDisplayed()));
        textInputEditText4.perform(replaceText("123"), closeSoftKeyboard());

        ViewInteraction textInputEditText5 = onView(
                allOf(withId(R.id.mobile_input),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.phonenumber),
                                        0),
                                0),
                        isDisplayed()));
        textInputEditText5.perform(replaceText("4587"), closeSoftKeyboard());

        ViewInteraction textInputEditText6 = onView(
                allOf(withId(R.id.password_input),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.password),
                                        0),
                                0),
                        isDisplayed()));
        textInputEditText6.perform(replaceText("sfjkf"), closeSoftKeyboard());

        ViewInteraction textInputEditText7 = onView(
                allOf(withId(R.id.password_input), withText("sfjkf"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.password),
                                        0),
                                0),
                        isDisplayed()));
        textInputEditText7.perform(pressImeActionButton());

        ViewInteraction materialButton4 = onView(
                allOf(withId(R.id.signup), withText("SIGNUP"),
                        childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.widget.FrameLayout")),
                                        0),
                                3),
                        isDisplayed()));
        materialButton4.perform(click());

        ViewInteraction button2 = onView(
                allOf(withId(R.id.signup), withText("SIGNUP"),
                        withParent(withParent(IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class))),
                        isDisplayed()));
        button2.check(matches(isDisplayed()));

        ViewInteraction button3 = onView(
                allOf(withId(R.id.signup), withText("SIGNUP"),
                        withParent(withParent(IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class))),
                        isDisplayed()));
        button3.check(matches(isDisplayed()));
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
