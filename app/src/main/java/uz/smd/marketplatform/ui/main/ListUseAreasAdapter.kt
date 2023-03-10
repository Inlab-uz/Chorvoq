package uz.smd.marketplatform.ui.main

/**
 * Created by Siddikov Mukhriddin on 1/4/21
 */
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_use_areas.view.*
import uz.smd.marketplatform.R
import uz.smd.marketplatform.utils.bindItem
import uz.smd.marketplatform.utils.inflate


class ListUseAreasAdapter(val block:(UseArea) -> Unit) : RecyclerView.Adapter<ListUseAreasAdapter.ViewHolder>() {
    var listener: ((UseArea) -> Unit)? = null

    private var tasksDay: MutableList<UseArea> = mutableListOf()
    fun setListenerGetPos(block: (UseArea) -> Unit) {
        listener = block
    }

    fun setTasksDay(tasksDay: List<UseArea>) {
        this.tasksDay.clear()
        this.tasksDay.addAll(tasksDay)
        notifyDataSetChanged()
    }
    fun opnMouth(){

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(parent.inflate(R.layout.item_use_areas))

    override fun getItemCount() = tasksDay.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind()
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val title: TextView = itemView.textUseAreas
        private val imagePopular: ImageView = itemView.img_popular_program_one_list
        private val viewUseAreas: LinearLayout = itemView.viewUseArea
        fun bind() = bindItem {
            val d = tasksDay[adapterPosition]
            title.setText(d.title)
            imagePopular.setImageResource(d.image)
            viewUseAreas.setOnClickListener {block(d)
//                listener?.invoke(d)
            }
        }


    }

}