package com.example.ui_testing_task

import android.app.Activity
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.Assert.*
import org.junit.Test
import org.junit.internal.runners.JUnit4ClassRunner
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

/*
We tag the class with @RunWith (AndroidJUnit4ClassRunner::class)
This tag it tells the testing framework to use this runner to execute your tests.
 This is necessary for testing Android-specific components such as Activities, Services,
 ContentProviders, etc. Sets up env properly before running the test
 */
@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest{

    /*
    Below we need to create test that are specifically related to the UI display and functionality.
    UI Test are specifically related to visual validity test rather than deeper core logic test of
    the app.(Surface Level test)
     */
    @Test
    fun testIsActivityInView() {
        //launch the activity
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)

        //check if the activity is displayed
        onView(withId(R.id.main)).check(matches(isDisplayed()))
    }

    @Test
    fun test_visibility_title_greeting_button(){
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)

        //[2 Test below]
        //simply check if Title of this activity shows on the screen
        onView(withId(R.id.tvMainActivityTitle)).check(matches(isDisplayed()))

        //simply check if Greeting button in this activity shows on the screen
        onView(withId(R.id.btnPrintGreeting)).check(matches(isDisplayed()))
    }

    //Test if the Title text is displayed on app run
    @Test
    fun testTitleTextDisplayed(){
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)

        onView(withId(R.id.tvMainActivityTitle)).check(matches(withText(R.string.ui_testing_sample_app)))
    }

    //Navigation from Main to Second activity
    @Test
    fun testNavFromMainToSecondActivity(){
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.btnNext)).perform(click()) //click the Next Button in MainActivity
        onView(withId(R.id.second)).check(matches(isDisplayed())) //check if Second Activity is displayed after Button click

    }

    //Test Back Press to main activity
    @Test
    fun testBackPressToMainActivity(){
        val activityScenario = ActivityScenario.launch(MainActivity::class.java) //launch MainActivity
        onView(withId(R.id.btnNext)).perform(click()) //click the Next Button
        onView(withId(R.id.second)).check(matches(isDisplayed())) //check if SecondActivity is displayed
        //onView(withId(R.id.btnBack)).perform(click()) //click back button on SecondActivity
        pressBack() //press back button from device rather than the actual Back button in the app

       onView(withId(R.id.main)).check(matches(isDisplayed())) //check MainActivity is displayed

    }

}