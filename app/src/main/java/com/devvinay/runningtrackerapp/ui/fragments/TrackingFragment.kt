package com.devvinay.runningtrackerapp.ui.fragments

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.devvinay.runningtrackerapp.R
import com.devvinay.runningtrackerapp.other.Constants.ACTION_START_OR_RESUME_SERVICE
import com.devvinay.runningtrackerapp.services.TrackingService
import com.devvinay.runningtrackerapp.ui.viewmodels.MainViewModel
import com.google.android.gms.maps.GoogleMap
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_tracking.*

@AndroidEntryPoint
class TrackingFragment : Fragment(R.layout.fragment_tracking) {
    private val viewModel : MainViewModel by viewModels()
    private var map : GoogleMap? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mapView.onCreate(savedInstanceState)
        mapView.getMapAsync {
            map = it
        }
        btnToggleRun.setOnClickListener {
            sendCommand(ACTION_START_OR_RESUME_SERVICE)
        }
    }

    private fun sendCommand (action:String){
        Intent(requireContext(),TrackingService::class.java).also {
            it.action=action
            requireContext().startService(it)
        }

    }

    override fun onResume() {
        super.onResume()
        mapView?.onResume()
    }

    override fun onPause() {
        super.onPause()
        mapView?.onPause()
    }

    override fun onStop() {
        super.onStop()
        mapView?.onStop()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        mapView?.onLowMemory()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        mapView?.onSaveInstanceState(outState)
    }
}
