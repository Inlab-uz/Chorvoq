package uz.smd.marketplatform.ui.main.details

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.core.view.isGone
import by.kirich1409.viewbindingdelegate.viewBinding
import uz.smd.marketplatform.R
import uz.smd.marketplatform.databinding.FragmentDetailsInfoBinding
import uz.smd.marketplatform.ui.MainActivity
import uz.smd.marketplatform.ui.main.details.placeholder.PlaceholderContent

/**
 * A fragment representing a list of Items.
 */
class DetailsInfoFragment : Fragment(R.layout.fragment_details_info) {

    private val binding by viewBinding(FragmentDetailsInfoBinding::bind)

    @SuppressLint("FragmentLiveDataObserve")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.list.adapter= DeliveryAdapter(PlaceholderContent.ITEMS)
        MainActivity.isAccepted.observe(this,{
          binding.holderMap.isGone=it
        })
    }
}