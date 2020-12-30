package com.devvinay.runningtrackerapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.devvinay.runningtrackerapp.R
import com.devvinay.runningtrackerapp.db.RunDAO
import com.devvinay.runningtrackerapp.other.Constants
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navigateToTrackingFragmentIfNeeded(intent)
       // setSupportActionBar(toolbar)
        bottomNavigationView.setupWithNavController(navHostFragment.findNavController())
        navHostFragment.findNavController().addOnDestinationChangedListener { controller, destination, arguments ->
            when(destination.id){
                R.id.settingFragment,R.id.runFragment,R.id.statisticsFragment -> bottomNavigationView.visibility=View.VISIBLE
                else ->bottomNavigationView.visibility=View.GONE
            }
        }

    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        navigateToTrackingFragmentIfNeeded(intent)
    }

    private fun navigateToTrackingFragmentIfNeeded(intent: Intent?){
        if(intent?.action == Constants.ACTION_SHOW_TRACKING_FRAGMENT){
            navHostFragment.findNavController().navigate(R.id.action_global_trackingFragment)
        }
    }
}