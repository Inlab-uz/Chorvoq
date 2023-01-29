package uz.smd.marketplatform.data.entities




/**
 * Created by Siddikov Mukhriddin on 2/13/21
 */

data class PassData(
val id:Int,
val reg_number:String?,
val passes:List<PassesData>
)

data class PassesData(
    val number: String?,
    val valid_from: String?,
    val valid_to: String?,
    val cancel_date: String?,
    val area: String?,
    val status: String?,
    val days_left: Int?,
    val validity_period: String?
){

}