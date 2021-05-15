package uz.eldor.onlineshop.screens.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.synnapps.carouselview.CarouselView
import uz.eldor.onlineshop.R

class HomeFragment : Fragment() {

    private val images = arrayOf(R.drawable.image1,R.drawable.image2,R.drawable.image3)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val carouselView = view.findViewById<CarouselView>(R.id.carouselView)
        carouselView.pageCount = images.count()
        carouselView.setImageListener { position, imageView ->
            imageView.setImageResource(images[position])
        }
    }

    companion object {

        @JvmStatic
        fun newInstance() = HomeFragment()
    }
}