package uz.eldor.onlineshop.screens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*
import uz.eldor.onlineshop.R
import uz.eldor.onlineshop.screens.cart.CartFragment
import uz.eldor.onlineshop.screens.favorite.FavoriteFragment
import uz.eldor.onlineshop.screens.home.HomeFragment
import uz.eldor.onlineshop.screens.profile.ProfileFragment

class MainActivity : AppCompatActivity() {
    private val homeFragment = HomeFragment.newInstance()
    private val favoriteFragment = FavoriteFragment.newInstance()
    private val cartFragment = CartFragment.newInstance()
    private val profileFragment = ProfileFragment.newInstance()
    private var activeFragment:Fragment = homeFragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().add(R.id.flContainer, homeFragment,homeFragment.tag).hide(homeFragment).commit()
        supportFragmentManager.beginTransaction().add(R.id.flContainer, favoriteFragment,favoriteFragment.tag).hide(favoriteFragment).commit()
        supportFragmentManager.beginTransaction().add(R.id.flContainer, cartFragment,cartFragment.tag).hide(cartFragment).commit()
        supportFragmentManager.beginTransaction().add(R.id.flContainer, profileFragment,profileFragment.tag).hide(profileFragment).commit()

        supportFragmentManager.beginTransaction().show(activeFragment).commit()

        findViewById<BottomNavigationView>(R.id.bottomNavigationView).setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.actionHome -> {
                    supportFragmentManager.beginTransaction().hide(activeFragment).show(homeFragment).commit()
                    activeFragment = homeFragment
                }
                R.id.actionFavorite -> {
                    supportFragmentManager.beginTransaction().hide(activeFragment).show(favoriteFragment).commit()
                    activeFragment = favoriteFragment
                }
                R.id.actionCart -> {
                    supportFragmentManager.beginTransaction().hide(activeFragment).show(cartFragment).commit()
                    activeFragment = cartFragment
                }
                R.id.actionProfile -> {
                    supportFragmentManager.beginTransaction().hide(activeFragment).show(profileFragment).commit()
                    activeFragment = profileFragment
                }
            }

            return@setOnNavigationItemSelectedListener true
        }
    }
}