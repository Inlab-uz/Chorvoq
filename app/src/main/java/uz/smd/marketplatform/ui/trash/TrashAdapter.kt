package uz.smd.marketplatform.ui.trash

/**
 * Created by Siddikov Mukhriddin on 1/4/21
 */
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import uz.smd.marketplatform.R
import uz.smd.marketplatform.ui.main.UserData
import uz.smd.marketplatform.utils.bindItem
import uz.smd.marketplatform.utils.inflate


class TrashAdapter : RecyclerView.Adapter<TrashAdapter.ViewHolder>() {
    var listener: ((UserData) -> Unit)? = null

    private var tasksDay: MutableList<UserData> = mutableListOf()
    fun setListenerGetPos(block: (UserData) -> Unit) {
        listener = block
    }

    fun setTasksDay(tasksDay: List<UserData>) {
        this.tasksDay.clear()
        this.tasksDay.addAll(tasksDay)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(parent.inflate(R.layout.item_trash))

    override fun getItemCount() = tasksDay.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind()
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bind() = bindItem {

        }

    }

}