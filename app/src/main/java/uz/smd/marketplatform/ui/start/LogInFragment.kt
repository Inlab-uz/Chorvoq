package uz.smd.marketplatform.ui.start

import android.content.Intent
import android.os.Bundle
import android.text.method.PasswordTransformationMethod
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import ru.tinkoff.decoro.MaskImpl
import ru.tinkoff.decoro.watchers.FormatWatcher
import ru.tinkoff.decoro.watchers.MaskFormatWatcher
import uz.smd.marketplatform.R
import uz.smd.marketplatform.databinding.FragmentLogInBinding
import uz.smd.marketplatform.ui.MainActivity
import uz.smd.marketplatform.utils.PredefinedSlots


/**
 * Created by Siddikov Mukhriddin on 8/20/21
 */
var isLogged=false
class LogInFragment : Fragment(R.layout.fragment_log_in) {
    private val viewBinding by viewBinding(FragmentLogInBinding::bind)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupPhoneMask()
        setupPassword()
        if (isLogged){
            startActivity(Intent(requireContext(), MainActivity::class.java))
            requireActivity().finish()
        }
        viewBinding.btnLogin.setOnClickListener {
            if(viewBinding.etPassword.text.toString()=="12345"){
                isLogged = true
            startActivity(Intent(requireContext(), MainActivity::class.java))
            requireActivity().finish()
            }else{
                Toast.makeText(requireContext(), "Incorrect Password", Toast.LENGTH_SHORT).show()
            }
//            parentFragmentManager.beginTransaction()
//                .setCustomAnimations(R.anim.enter, R.anim.exit,R.anim.pop_enter, R.anim.pop_exit)
//                .replace(R.id.mainContainer,MainFragment()).commit()
        }

    }

    private fun setupPassword() {
        viewBinding.btnEyes.isSelected = false
        viewBinding.btnEyes.setOnClickListener {
            viewBinding.btnEyes.isSelected = !viewBinding.btnEyes.isSelected
            if (viewBinding.btnEyes.isSelected) {
                viewBinding.etPassword.transformationMethod = null
            } else {
                viewBinding.etPassword.transformationMethod = PasswordTransformationMethod()
            }
        }
    }

    private fun setupPhoneMask() {
        val mask = MaskImpl.createTerminated(PredefinedSlots.RUS_PHONE_NUMBER)
        val watcher: FormatWatcher = MaskFormatWatcher(mask)
        watcher.installOn(viewBinding.inputPhone)
    }
}