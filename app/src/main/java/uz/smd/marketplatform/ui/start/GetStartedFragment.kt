package uz.smd.marketplatform.ui.start

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_get_started.*
import uz.smd.marketplatform.R
import uz.smd.marketplatform.ui.start.LogInFragment

/**
 * Created by Siddikov Mukhriddin on 8/20/21
 */
class GetStartedFragment:Fragment(R.layout.fragment_get_started) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnGetStarted.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .setCustomAnimations(R.anim.enter, R.anim.exit,R.anim.pop_enter, R.anim.pop_exit)
                .replace(R.id.mainContainer, LogInFragment()).commit()
        }
    }
}