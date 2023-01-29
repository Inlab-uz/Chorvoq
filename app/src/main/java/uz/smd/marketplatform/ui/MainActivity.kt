package uz.smd.marketplatform.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.view.isGone
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.bottom_menu.*
import uz.smd.marketplatform.R
import uz.smd.marketplatform.ui.catalogs.CatalogsFragment
import uz.smd.marketplatform.ui.main.MainFragment
import uz.smd.marketplatform.ui.profile.ProfileFragment
import uz.smd.marketplatform.ui.trash.TrashFragment


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    companion object {
        val handleLoad = MutableLiveData<Boolean>()
        val handleError = MutableLiveData<String>()
        var isMapLoaded=false
        var isAccepted=MutableLiveData<Boolean>(false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        handleBottomClick()
        handleLiveData()
    }

    fun handleLiveData() {
        handleLoad.observe(this, Observer {
            progressBarMain.isGone = !it
        })
        handleError.observe(this, Observer {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        })
    }

    fun handleBottomClick() {
        btnBottom1.bottomSelelected()
        supportFragmentManager.beginTransaction().replace(R.id.mainContainer, MainFragment())
            .commit()

        btnBottom1.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.mainContainer, MainFragment())
                .commit()
            it.bottomSelelected()
        }
        btnBottom2.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.mainContainer, CatalogsFragment())
                .commit()
            it.bottomSelelected()

        }
        btnBottom3.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.mainContainer, TrashFragment())
                .commit()
            it.bottomSelelected()
        }
        btnBottom4.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.mainContainer, ProfileFragment())
                .commit()
            it.bottomSelelected()
        }

    }
    fun bottomSelected(view: View){
        view.bottomSelelected()

    }
    fun View.bottomSelelected(){
        btnBottom1.isSelected = false
        btnBottom2.isSelected = false
        btnBottom3.isSelected = false
        btnBottom4.isSelected = false
        btnBottom1.isClickable = true
        btnBottom2.isClickable = true
        btnBottom3.isClickable = true
        btnBottom4.isClickable = true
        this.isSelected=true
        this.isClickable=false

    }
}