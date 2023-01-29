package uz.smd.marketplatform.ui.main

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_detail.*
import uz.smd.marketplatform.R

/**
 * Created by Siddikov Mukhriddin on 2/3/22
 */
data class DetailItem(
    val name:String,
    val location:String,
    val locationLat:String,
    val locationLon:String,
    val phone:String,
    val detail:String,
    val img:Int,
)
class DetailFragment:Fragment(R.layout.fragment_detail) {
    var currentItem : DetailItem? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val item = currentItem ?: DetailItem(
            name = getString(R.string.text_oqtosh_title),
            location = getString(R.string.text_oqtosh_location),
            locationLat = "41.646176",
            locationLon = "69.766650",
            phone = getString(R.string.text_oqtosh_phone) ,
            detail = getString(R.string.text_detail_oqtosh),
            img = R.drawable.img_san_oqtosh
            )
        Glide.with(this).load(item.img).placeholder(R.drawable.progress_animation).into(imgTop)
        btnPhone.text=item.phone
        btnLocation.text=item.location
        tvTitle.text=item.name
        tvDetail.text=item.detail
        btnPhone.setOnClickListener {
            val uri = Uri.parse("tel:+${item.phone.replace("+","").replace(" ","")}");
            val callIntent =  Intent(Intent.ACTION_DIAL, uri);
            startActivity(callIntent)
        }
        btnLocation.setOnClickListener {
            val gmmIntentUri =
                Uri.parse("geo:0,0?q=${item.locationLat},${item.locationLon}")
            val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
//                    mapIntent.setPackage("com.google.android.apps.maps")
            startActivity(mapIntent)
        }
    }
}