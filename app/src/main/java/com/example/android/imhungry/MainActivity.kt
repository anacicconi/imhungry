package com.example.android.imhungry

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Log.i("MainActivity","onCreated called")
        Timber.i("onCreated called")

        setContentView(R.layout.activity_main)

        val navController = this.findNavController(R.id.myNavHostFragment)
        NavigationUI.setupActionBarWithNavController(this, navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.myNavHostFragment)
        return navController.navigateUp()
    }

    /** Lifecycle Methods **/
    override fun onStart() {
        super.onStart()
        //Log.i("MainActivity","onStart called")
        Timber.i("onStart called")
    }

    // Called when app is paused but we don't navigate outside the app (e.g: sharing button)
    // The activity is still on the screen
    override fun onResume() {
        super.onResume()
        //Log.i("MainActivity","onResume called")
        Timber.i("onResume called")
    }

    // If we click on the back button of the phone, to open another app or to share some info, for instance, the onPause is always triggered
    // What changes is what happens after that
    // Should be very light weight because it can block other things like an incoming phone call
    override fun onPause() {
        super.onPause()
        //Log.i("MainActivity","onPause called")
        Timber.i("onPause called")
    }

    override fun onStop() {
        super.onStop()
        //Log.i("MainActivity","onStop called")
        Timber.i("onStop called")
    }

    // The activity is completely shut down and can be garbage collected
    // Called when we press the back button of the phone (not the app)
    override fun onDestroy() {
        super.onDestroy()
        //Log.i("MainActivity","onDestroy called")
        Timber.i("onDestroy called")
    }

    // When we navigate to other app and then come back, the app is not created again as it was not destroyed
    // As a consequence the values in the memory are still there and we just restart the app
    // Called when we navigate to other apps
    override fun onRestart() {
        super.onRestart()
        //Log.i("MainActivity","onRestart called")
        Timber.i("onRestart called")
    }

    // onCreate only is called once when the activity is launched

    // onStart/onStop has to do with the visibility of the app (when it becomes visible and when it disappears)
    // onPause/onResume has to do with the focus of the app (If I can interact with the activity). It can also be visible in the background but the focus is on another thing - e.g: sharing

    // Sharing: onPause Called, onResume Called
    // Navigating to another app: onPause Called, onStop Called, onSaveInstanceState Called, onRestart Called, onStart Called, onResume Called
    // Home button (Pause): onPause Called, onStop Called, onSaveInstanceState Called, onRestart Called, onStart Called, onResume Called
    // Back button outside the app (Exit): onPause Called, onStop Called, onDestroy Called

    /*
    Lifecycle States
    These are the same for both the Fragment Lifecycle and the Activity Lifecycle.

    Initialized: This is the starting state whenever you make a new activity. This is a transient state -- it immediately goes to Created.

    Created: Activity has just been created, but it’s not visible and it doesn’t have focus (you’re not able to interact with it).

    Started: Activity is visible but doesn’t have focus.

    Resumed: The state of the activity when it is running. It’s visible and has focus.

    Destroyed: Activity is destroyed. It can be ejected from memory at any point and should not be referenced or interacted with.
     */
}
