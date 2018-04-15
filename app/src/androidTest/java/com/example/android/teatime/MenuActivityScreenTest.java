package com.example.android.teatime;

/**
 * Created by figengungor on 4/16/2018.
 */

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.anything;

//Add annotation to specify AndroidJUnitRunner class as the default test runner
@RunWith(AndroidJUnit4.class)
public class MenuActivityScreenTest {


    private static final String TEA_NAME = "Black Tea";
    //Rule that provides functional testing of a single activity
    @Rule
    public ActivityTestRule<MenuActivity> mActivityTestRule
            = new ActivityTestRule<>(MenuActivity.class);

    //Test clicking on a GridView tea item and verify that the OrderActivity opens up
    //with the correct tea name displayed
    @Test
    public void clickGridViewItem_OpensOrderActivity(){
        //Get a reference to a specific gridView item anc click it
        onData(anything()).inAdapterView(withId(R.id.tea_grid_view)).atPosition(0).perform(click());

        //Check that the OrderActivity opens with the correct tea name displayed
        onView(withId(R.id.tea_name_text_view)).check(matches(withText(TEA_NAME)));

    }



}
