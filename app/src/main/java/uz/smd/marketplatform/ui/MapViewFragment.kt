package uz.smd.marketplatform.ui

import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.View
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.android.synthetic.main.fragment_mapview.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import uz.smd.marketplatform.R
import uz.smd.marketplatform.databinding.FragmentMapviewBinding
import uz.smd.marketplatform.ui.MainActivity.Companion.isMapLoaded


class MapViewFragment : Fragment(R.layout.fragment_mapview), OnMapReadyCallback {
    private val binding by viewBinding(FragmentMapviewBinding::bind)
    private lateinit var mMap: GoogleMap


    val ksss = MutableLiveData<Boolean>()

    @SuppressLint("FragmentLiveDataObserve")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        ksss.observe(this, {
            openMap()
        })

        if (savedInstanceState==null)
        lifecycleScope.launch {
            if (!isMapLoaded)
            delay(1000)
            else
                delay(500)
            ksss.value = true
            isMapLoaded=true
        }
    }

    fun openMap() {
        val ks = SupportMapFragment()
        childFragmentManager.beginTransaction().replace(binding.mapView.id, ks).commit()
        val mapFragment = ks as? SupportMapFragment
        mapFragment?.getMapAsync(this@MapViewFragment)
    }

    override fun onMapReady(googleMap: GoogleMap?) {
        // TODO: Read Latitude and Longitude from remote
        mMap = googleMap!!
//        mMap.uiSettings.isCompassEnabled=true
        mMap.uiSettings.isScrollGesturesEnabled = true
        if (ActivityCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            requestPermissions(
                arrayOf(
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                ), 12
            )
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.

        } else {
//            mMap.isMyLocationEnabled=true
//            mMap.uiSettings.isMyLocationButtonEnabled=true
        }

        val tvTower = LatLng(41.341040, 69.286838)

        mMap.addMarker(
            MarkerOptions().position(tvTower)
                .title("Tv, Tower")
                .visible(true)
        )
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(tvTower, 11f))
        mMap.uiSettings.isZoomControlsEnabled = false
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        if (ActivityCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
//            requestPermissions(arrayOf(Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.ACCESS_COARSE_LOCATION),12)
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.

        } else {
//            mMap.isMyLocationEnabled=true
        }
//        mMap.uiSettings.isMyLocationButtonEnabled=true
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

}
