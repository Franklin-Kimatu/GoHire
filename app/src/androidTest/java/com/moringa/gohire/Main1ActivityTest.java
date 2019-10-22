//package com.moringa.gohire;
//
//import androidx.test.filters.LargeTest;
//import androidx.test.rule.ActivityTestRule;
//import androidx.test.runner.AndroidJUnit4;
////import androidx.test.ext.junit.runners.AndroidJUnit4;
//
//import com.moringa.gohire.ui.main.Main1Activity;
//
//import org.junit.Rule;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//
//import static androidx.test.espresso.Espresso.onView;
//import static androidx.test.espresso.action.ViewActions.click;
//import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
//import static androidx.test.espresso.action.ViewActions.typeText;
//import static androidx.test.espresso.assertion.ViewAssertions.matches;
//import static androidx.test.espresso.matcher.ViewMatchers.withId;
//import static androidx.test.espresso.matcher.ViewMatchers.withText;
//
//@RunWith(AndroidJUnit4.class)
//@LargeTest
//public class Main1ActivityTest {
//
//    @Rule
//    public ActivityTestRule<Main1Activity>activityActivityTestRule = new ActivityTestRule<>(Main1Activity.class);
//
//    @Test
//    public void validateEditText(){
//        onView(withId(R.id.nameEditText)).perform(typeText("Frank"))
//                .check(matches(withText("Frank")));
//    }
//    @Test
//    public void nameIsSentToAvailableCarActivity(){
//        String name ="Frank";
//        onView(withId(R.id.nameEditText)).perform(typeText(name)).perform(closeSoftKeyboard());
//        try{
//            Thread.sleep(300);
//        }catch (InterruptedException e){
//            System.out.println("got interrupted");
//        }
//        onView(withId(R.id.viewAvailableCarsButton)).perform(click());
//        onView(withId(R.id.nameTextView)).check(matches(withText("Hello " +name +",\n" +"Here are some of vehicles you can hire.")));
//
//    }
//}
