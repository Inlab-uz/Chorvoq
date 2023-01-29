package uz.smd.marketplatform.ui.catalogs

/**
 * Created by Siddikov Mukhriddin on 1/4/21
 */
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_catalogs.view.*
import uz.smd.marketplatform.R
import uz.smd.marketplatform.utils.HorizontalLayoutManager
import uz.smd.marketplatform.utils.bindItem
import uz.smd.marketplatform.utils.inflate


class CatalogsAdapter : RecyclerView.Adapter<CatalogsAdapter.ViewHolder>() {
    var listener: ((CatalogsList) -> Unit)? = null

    private var tasksDay: MutableList<CatalogsList> = mutableListOf()
    fun setListenerGetPos(block: (CatalogsList) -> Unit) {
        listener = block
    }

    fun setTasksDay(tasksDay: List<CatalogsList>) {
        this.tasksDay.clear()
        this.tasksDay.addAll(tasksDay)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(parent.inflate(R.layout.item_catalogs))

    override fun getItemCount() = tasksDay.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind()
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val ks=itemView.listPrograms1
        val title=itemView.titleCatalogs

//        private val title: TextView = itemView.tileUser
//        private val name: TextView = itemView.nameUser
//        private val location: TextView = itemView.locationUser
//        private val desc: TextView = itemView.descUser
//        private val viewUseAreas: LinearLayout = itemView.lineUser
        fun bind() = bindItem {
    ks.layoutManager= HorizontalLayoutManager(ks.context)
//    c.setLayoutManager( object :LinearLayoutManager(ks.context){
//        override fun setOrientation(orientation: Int) {
//            super.setOrientation(RecyclerView.HORIZONTAL)
//        }
//        override fun checkLayoutParams(lp: RecyclerView.LayoutParams?): Boolean {
//            // force height of viewHolder here, this will override layout_height from xml
//            lp?.width = (width / 2.5).toInt();
//            return true;
//        }
//    });
            val d = tasksDay[adapterPosition]
    title.text=d.type
    val adapter=CatalogsItemAdapter()
    ks.adapter=adapter
    adapter.setTasksDay(d.list)
//            title.setText(d.title)
//            location.setText(d.location)
//            desc.setText(d.desc)
//            name.setText(d.name)
//            viewUseAreas.setOnClickListener { listener?.invoke(d) }
        }

        fun holoFragment(){

        }
        fun shutUp(){

        }

    }

}