package br.com.prado.toking

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import br.com.prado.toking.databinding.ActivityMainBinding
import br.com.prado.toking.view.MainActivityAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.activityMainViewPager.adapter = MainActivityAdapter(this)

        viewPagerAndCallbackSettings()
    }

    private fun viewPagerAndCallbackSettings() {
        binding.activityMainBottomNavView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.nav_menu_add -> binding.activityMainViewPager.setCurrentItem(0, true)
                R.id.nav_menu_bar_chart -> binding.activityMainViewPager.setCurrentItem(1, true)
                R.id.nav_menu_settings -> binding.activityMainViewPager.setCurrentItem(3, true)
            }
            true
        }
        binding.activityMainViewPager.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                binding.activityMainBottomNavView.menu.getItem(position).isChecked = true
            }
        })
    }
}
