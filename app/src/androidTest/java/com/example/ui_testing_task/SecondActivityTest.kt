package com.example.ui_testing_task

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class SecondActivityTest{

    //Created a rule so we don't have to repetitively create scenarios within each test
    @get:Rule
    val activityRule = ActivityScenarioRule(SecondActivity::class.java)

    @Test
    fun testBackButtonAndTextIsVisible(){
        //simply checks if back button is displayed on screen
        onView(withId(R.id.btnBack)).check(matches(isDisplayed()))

        //checks if the text displayed on the button is visible
        onView(withId(R.id.btnBack)).check(matches(withText(R.string.text_back)))
    }


    @Test
    fun testIsImageViewVisible(){
        //Verifies if image view is displayed on the screen
        onView(withId(R.id.ivCoolImage)).check(matches(isDisplayed()))
    }

    @Test
    fun testNavFromSecondActivityToMain(){
        //click back button in Second Activity
        onView(withId(R.id.btnBack)).perform(click())

        //verify if MainActivity is visible after btton click
        onView(withId(R.id.main)).check(matches(isDisplayed()))
    }





}