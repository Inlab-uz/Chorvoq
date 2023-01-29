package uz.smd.marketplatform.ui.trash

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.trash_fragment.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import uz.smd.marketplatform.R
import uz.smd.marketplatform.ui.main.UserData
import java.util.concurrent.Executors

/**
 * Created by Siddikov Mukhriddin on 8/11/21
 */

@AndroidEntryPoint
class TrashFragment :Fragment(R.layout.trash_fragment){
    val adapter=TrashAdapter()
    val data=MutableLiveData<List<UserData>>()
    init {
        data.postValue(listUserData())
        data.observe(this, Observer {
            adapter.setTasksDay(it)
        })
    }


    @SuppressLint("FragmentLiveDataObserve")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listTrash.adapter=adapter
    }

    fun listUserData(): List<UserData> {
        val listUseAreas = ArrayList<UserData>()
        listUseAreas.add(UserData(1, "Matematika", "Siddiqov Muxriddin","Matematikadan 10 yillik tajriba 1000 ortiq muvaffaqiyatli bitirgan talabalar. Darslar istalgan shaklda olib boriladi (onlayn, offlayn) ,haftaning qulay paytidagi guruxlarga qushilish imkoniyati",3,"Toshkent"))

//    listUseAreas.add(UseArea(8, R.string.text_popular_programs.toString(), R.drawable.icn_popular_stars.toString()))
        return listUseAreas
    }

}