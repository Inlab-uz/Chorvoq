package uz.smd.marketplatform.ui.main.details

import android.os.Bundle
import android.view.View
import android.widget.FrameLayout
import androidx.core.view.isGone
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior
import uz.smd.marketplatform.utils.animateByHeight
import uz.smd.marketplatform.utils.animateByTopHeight
import uz.smd.marketplatform.utils.animatePosition
import uz.smd.marketplatform.R
import uz.smd.marketplatform.databinding.FragmentDetailsBinding
import uz.smd.marketplatform.ui.MainActivity

/**
 * Created by Siddikov Mukhriddin on 10/1/21
 */
class DetailsFragment : Fragment(R.layout.fragment_details) {
    private val binding by viewBinding(FragmentDetailsBinding::bind)
    private lateinit var bottomSheetBehavior: BottomSheetBehavior<FrameLayout>
    private val panelState: Int
        get() = bottomSheetBehavior.state

    private val bottomSheetCallback = object : BottomSheetBehavior.BottomSheetCallback() {
        override fun onStateChanged(bottomSheet: View, newState: Int) {
            when (newState) {
                BottomSheetBehavior.STATE_COLLAPSED -> {
                    binding.dimBackground.visibility = View.GONE
                }
                else -> {
                }
            }
        }

        override fun onSlide(bottomSheet: View, slideOffset: Float) {
            setBottomNavigationViewTransition(slideOffset)
            setMiniPlayerAlpha(slideOffset)
            binding.dimBackground.visibility = View.VISIBLE
            binding.dimBackground.alpha = slideOffset
        }
    }

    private fun setMiniPlayerAlpha(slideOffset: Float) {
        val alpha = 1 - slideOffset
        binding.viewBottom.miniPlayerFragment.root.apply {
            this.alpha = alpha
            visibility = if (alpha == 0f) View.INVISIBLE else View.VISIBLE
        }

    }

    private fun setBottomNavigationViewTransition(slideOffset: Float) {
        binding.viewBottom.apply {
            miniPlayerFragment.root.translationY = slideOffset * miniPlayerFragment.root.height
            bottomView.translationY = slideOffset * miniPlayerFragment.root.height
            holderBtn.translationY = -slideOffset * miniPlayerFragment.root.height
        }
        binding.lDestination.translationY = -slideOffset * binding.lDestination.height

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bottomSheetBehavior = BottomSheetBehavior.from(binding.slidingPanel)
        bottomSheetBehavior.addBottomSheetCallback(bottomSheetCallback)
        handleClick()
        isAccepted(MainActivity.isAccepted.value!!)
    }

    fun handleClick() {
        binding.apply {
            viewBottom.btnDeclined.setOnClickListener { findNavController().popBackStack() }
            viewBottom.btnAccepted.setOnClickListener {
                MainActivity.isAccepted.value=true
                isAccepted(true)
            }
            btnBack.setOnClickListener {findNavController().popBackStack() }
            viewBottomAccepted.miniPlayerFragment.btnMenu.setOnClickListener {
                bottomSheetBehavior.state=BottomSheetBehavior.STATE_EXPANDED
            }
        }
    }

    fun isAccepted(isAccepted: Boolean = false) {
        binding.apply {
            if (!isAccepted) {
                viewBottomAccepted.root.apply {
                    post {
                        translationY = height.toFloat()
                        isGone = true
                    }
                }
                btnBack.post { btnBack.translationX=-btnBack.width.toFloat() }
            } else {
                viewBottomAccepted.root.isGone = false
                viewBottomAccepted.root.animatePosition()
                viewBottom.root.animateByHeight()
                lDestination.animateByTopHeight()
//                (requireActivity() as MainActivity).hideTopBar()
                btnBack.animate().translationX(0f).start()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
//        (requireActivity() as MainActivity).hideTopBar(false)
        bottomSheetBehavior.removeBottomSheetCallback(bottomSheetCallback)
        //MusicPlayerRemote.unbindFromService(serviceToken)
    }
}