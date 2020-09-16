package br.com.prado.toking

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.viewpager2.widget.ViewPager2
import br.com.prado.toking.databinding.ActivityMainBinding
import br.com.prado.toking.view.MainActivityAdapter
import br.com.prado.toking.viewModel.MainActivityViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel: MainActivityViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
        observeActions()
    }

    private fun initViews() {
        binding.activityMainBottomNavView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.nav_menu_add -> viewModel.onNavigationItemSelected(0)
                R.id.nav_menu_bar_chart -> viewModel.onNavigationItemSelected(1)
                R.id.nav_menu_settings -> viewModel.onNavigationItemSelected(2)
            }
            true
        }

        binding.activityMainViewPager.adapter = MainActivityAdapter(this)
        binding.activityMainViewPager.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                viewModel.onPageSelected(position)
            }
        })
    }

    private fun observeActions() {
        viewModel.action.observe(this, Observer {
            when (it) {
                is MainActivityViewModel.Action.SelectPageByNavigation -> {
                    binding.activityMainBottomNavView.menu.getItem(it.position).isChecked = true
                }
                is MainActivityViewModel.Action.SelectPageByViewPager -> {
                    binding.activityMainViewPager.setCurrentItem(it.position, true)
                }
            }
        })
    }
}
