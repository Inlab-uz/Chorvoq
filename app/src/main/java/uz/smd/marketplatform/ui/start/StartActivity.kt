package uz.smd.marketplatform.ui.start

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import uz.smd.marketplatform.R

class StartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)
        supportFragmentManager.beginTransaction().replace(R.id.mainContainer, LogInFragment()).commit()
    }
}