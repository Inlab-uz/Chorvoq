package uz.smd.marketplatform.ui.catalogs

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_main.*
import uz.smd.marketplatform.R
import java.util.concurrent.Executors

/**
 * Created by Siddikov Mukhriddin on 2/10/21
 */
val listCatalog= arrayListOf<Catalogs>(
    Catalogs( "Piramida (Chorvoq)", R.drawable.img_san_piramida,"Tabiiy obyektlar"),
    Catalogs( "Piramida (Chorvoq)", R.drawable.img_san_piramida,"Tabiiy obyektlar"),
    Catalogs( "Piramida (Chorvoq)", R.drawable.img_san_piramida,"Tabiiy obyektlar"),
    Catalogs( "Piramida (Chorvoq)", R.drawable.img_san_piramida,"Tabiiy obyektlar"),
)
val listCatalog1= arrayListOf<Catalogs>(
    Catalogs( "Humson buloq", R.drawable.img_san_buloq_humson,"Dam olish maskanlari"),
    Catalogs( "Humson buloq", R.drawable.img_san_buloq_humson,"Dam olish maskanlari"),
)
val listCatalog2= arrayListOf<Catalogs>(
    Catalogs( "Oqtosh Sanataroyasi", R.drawable.img_san_oqtosh,"Tabiiy obyektlar"),
    Catalogs( "Oqtosh Sanataroyasi", R.drawable.img_san_oqtosh,"Tabiiy obyektlar"),
    Catalogs( "Oqtosh Sanataroyasi", R.drawable.img_san_oqtosh,"Tabiiy obyektlar"),
)
val listCatalog3= arrayListOf<Catalogs>(
    Catalogs( "O'zmetkombinat", R.drawable.img_san_uzmetcombinat,"Tabiiy obyektlar"),
    Catalogs( "O'zmetkombinat", R.drawable.img_san_uzmetcombinat,"Tabiiy obyektlar"),
    Catalogs( "O'zmetkombinat", R.drawable.img_san_uzmetcombinat,"Tabiiy obyektlar"),
    Catalogs( "O'zmetkombinat", R.drawable.img_san_uzmetcombinat,"Tabiiy obyektlar"),
    Catalogs( "O'zmetkombinat", R.drawable.img_san_uzmetcombinat,"Tabiiy obyektlar"),
)
val listCatalog4= arrayListOf<Catalogs>(
    Catalogs( "Piramida (Chorvoq)", R.drawable.img_san_piramida,"Tabiiy obyektlar"),
    Catalogs( "Piramida (Chorvoq)", R.drawable.img_san_piramida,"Tabiiy obyektlar"),
    Catalogs( "Piramida (Chorvoq)", R.drawable.img_san_piramida,"Tabiiy obyektlar"),
    Catalogs( "Piramida (Chorvoq)", R.drawable.img_san_piramida,"Tabiiy obyektlar"),
    Catalogs( "Piramida (Chorvoq)", R.drawable.img_san_piramida,"Tabiiy obyektlar"),
)
@AndroidEntryPoint
class CatalogsFragment : Fragment(R.layout.fragment_category) {
//    private val viewModel: CatalogsViewModel by viewModels()
val adapterUser=CatalogsAdapter()
    val data= MutableLiveData<List<CatalogsList>>()
    init {
        data.postValue(listUserData())
        data.observe(this, Observer {
            adapterUser.setTasksDay(it)
        })
    }
    @SuppressLint("FragmentLiveDataObserve")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listPrograms.adapter=adapterUser



    }



    fun listUserData(): List<CatalogsList> {

        val listCatalogs = ArrayList<CatalogsList>()
        listCatalogs.add(CatalogsList(listCatalog,"Tabiiy obyektlar"))
        listCatalogs.add(CatalogsList(listCatalog1,"Dam olish maskanlari"))
        listCatalogs.add(CatalogsList(listCatalog2,"Ovqatlanish maskanlari"))
        listCatalogs.add(CatalogsList(listCatalog3,"Tabiatni muhofaza qilinadigan hududlar"))
        listCatalogs.add(CatalogsList(listCatalog4,"Deluxe villa Tashkent"))
//        for (i in 0..6){
//            val listUseAreas = ArrayList<Catalogs>()
//            listUseAreas.add(Catalogs( "Tabiiy obyektlar", R.drawable.img_book,"Tabiiy obyektlar"))
//            listUseAreas.add(Catalogs( "Dam olish maskanlari", R.drawable.img_book,"Tabiiy obyektlar"))
//            listUseAreas.add(Catalogs("Ovqatlanish maskanlari", R.drawable.img_book,"Tabiiy obyektlar"))
//            listUseAreas.add(Catalogs("Tabiatni muhofaza qilinadigan hududlar", R.drawable.img_book,"Tabiiy obyektlar"))
//            listCatalogs.add(CatalogsList(listUseAreas,"Tabiiy obyektlar"))
//        }



        return listCatalogs
    }
}