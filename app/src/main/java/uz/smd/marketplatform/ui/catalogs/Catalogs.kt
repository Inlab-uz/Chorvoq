package uz.smd.marketplatform.ui.catalogs

import java.io.Serializable

data class CatalogsList(
    val list:List<Catalogs>,
val type: String
)
data class Catalogs(
    var title: String,
    var image: Int,
    var type:String
): Serializable
