package uz.smd.marketplatform.ui.catalogs

/**
 * Created by Siddikov Mukhriddin on 1/4/21
 */
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_catalogs_item.view.*
import uz.smd.marketplatform.R
import uz.smd.marketplatform.utils.bindItem
import uz.smd.marketplatform.utils.inflate


class CatalogsItemAdapter : RecyclerView.Adapter<CatalogsItemAdapter.ViewHolder>() {
    var listener: ((Catalogs) -> Unit)? = null

    private var tasksDay: MutableList<Catalogs> = mutableListOf()
    fun setListenerGetPos(block: (Catalogs) -> Unit) {
        listener = block
    }

    fun setTasksDay(tasksDay: List<Catalogs>) {
        this.tasksDay.clear()
        this.tasksDay.addAll(tasksDay)
        notifyDataSetChanged()
    }
    fun opnMouth(){

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(parent.inflate(R.layout.item_catalogs_item))

    override fun getItemCount() = tasksDay.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind()
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val title: TextView = itemView.tileUser
        private val imagePopular: ImageView = itemView.imgBook
//        private val viewUseAreas: LinearLayout = itemView.viewUseArea
        fun bind() = bindItem {
            val d = tasksDay[adapterPosition]
    title.text = d.title
    Glide.with(this).load(d.image).placeholder(R.drawable.progress_animation).into(imagePopular)
//            title.setText(d.title)
//            imagePopular.setImageResource(d.image)
//            viewUseAreas.setOnClickListener { listener?.invoke(d) }
        }


    }

}