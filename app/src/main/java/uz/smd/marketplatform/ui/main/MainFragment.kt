package uz.smd.marketplatform.ui.main

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import uz.smd.marketplatform.R
import uz.smd.marketplatform.ui.main.details.DetailsFragment
import java.util.concurrent.Executors

/**
 * Created by Siddikov Mukhriddin on 2/10/21
 */
@SuppressLint("FragmentLiveDataObserve")
@AndroidEntryPoint
class MainFragment : Fragment(R.layout.fragment_main) {
//    private val viewModel: MainViewModel by viewModels()
val adapter=ListUseAreasAdapter(){
    requireActivity().supportFragmentManager.beginTransaction().replace(R.id.mainContainer, DetailsFragment())
        .addToBackStack(null)
        .commit()
}
val adapterUser = ListUserAdapter(){
  val newItem=  DetailItem(
        name = getString(R.string.text_humson_title),
        location = getString(R.string.text_humson_location),
        locationLat = getString(R.string.text_humson_lat),
        locationLon = getString(R.string.text_humson_lon),
        phone = getString(R.string.text_humson_phone) ,
        detail = getString(R.string.text_humson_detail),
        img = R.drawable.img_san_buloq_humson
    )
    parentFragmentManager.beginTransaction().replace(R.id.mainContainer, DetailFragment().apply {
        if (it.id != 1)
        currentItem = newItem

    }).addToBackStack(null)
        .commit()
}
    val data= MutableLiveData<List<UseArea>>()
    val data1= MutableLiveData<List<UserData>>()
    init {
        data.postValue(listUseAreas().reversed())
        data1.postValue(listUserData())
        data.observe(this, Observer {
            adapter.setTasksDay(it)
        })
        data1.observe(this, Observer {
            adapterUser.setTasksDay(it)
        })
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter.setListenerGetPos{

        }
        listUseAreas.adapter=adapter
        adapter.setListenerGetPos {  }

        listPrograms.adapter=adapterUser


    }


    fun listUseAreas(): List<UseArea> {
        val listUseAreas = ArrayList<UseArea>()
        listUseAreas.add(UseArea(1, R.string.text_glaza, R.drawable.icn_stat))
        listUseAreas.add(UseArea(2, R.string.text_location, R.drawable.icn_location))
        listUseAreas.add(UseArea(3, R.string.text_online, R.drawable.icn_home))
        listUseAreas.add(UseArea(4, R.string.text_states, R.drawable.icn_states))
//    listUseAreas.add(UseArea(8, R.string.text_popular_programs.toString(), R.drawable.icn_popular_stars.toString()))
        return listUseAreas
    }
    fun listUserData(): List<UserData> {
        val listUseAreas = ArrayList<UserData>()
        listUseAreas.add(UserData(1, "Зомин санаторияси", "Siddiqov Muxriddin","Matematikadan 10 yillik tajriba 1000 ortiq muvaffaqiyatli bitirgan talabalar. Darslar istalgan shaklda olib boriladi (onlayn, offlayn) ,haftaning qulay paytidagi guruxlarga qushilish imkoniyati",3,"Toshkent", image = R.drawable.img_san_oqtosh))
        listUseAreas.add(UserData(2, "Зомин миллий табиат боғи", "Naimova Nilufar","Matematikadan 5 yillik tajriba 500 ortiq muvaffaqiyatli bitirgan talabalar. Darslar istalgan shaklda olib boriladi (onlayn, offlayn) ,haftaning qulay paytidagi guruxlarga qushilish imkoniyati",3,"Toshkent", image = R.drawable.img_san_buloq_humson))
        listUseAreas.add(UserData(3, "Saodat Guest Houses", "Xojiev Akbar","Fizikadan 15 yillik tajriba 1000 ortiq muvaffaqiyatli bitirgan talabalar. Darslar istalgan shaklda olib boriladi (onlayn, offlayn) ,haftaning qulay paytidagi guruxlarga qushilish imkoniyati",3,"Toshkent",image = R.drawable.img_san_piramida))
        listUseAreas.add(UserData(4, "Красногорск", "Oripov Akram","Matematikadan 10 yillik tajriba 1000 ortiq muvaffaqiyatli bitirgan talabalar. Darslar istalgan shaklda olib boriladi (onlayn, offlayn) ,haftaning qulay paytidagi guruxlarga qushilish imkoniyati",3,"Toshkent",image = R.drawable.img_san_uzmetcombinat))

//    listUseAreas.add(UseArea(8, R.string.text_popular_programs.toString(), R.drawable.icn_popular_stars.toString()))
        return listUseAreas
    }
}