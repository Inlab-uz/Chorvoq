package uz.smd.marketplatform.ui.main

import uz.smd.marketplatform.R
import java.io.Serializable

data class UserData(
    var id: Int,
    var title: String,
    var name: String,
    var desc: String,
    var fav: Int,
    var location: String,
    var image: Int = R.drawable.img_san_oqtosh
): Serializable
