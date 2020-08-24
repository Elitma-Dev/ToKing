package br.com.prado.toking.view

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import br.com.prado.toking.view.AddMenuItemFragment
import br.com.prado.toking.view.ConfigMenuItemFragment
import br.com.prado.toking.view.StatisticsMenuItemFragment

class MainActivityAdapter(fa: FragmentActivity) :
    FragmentStateAdapter(fa) {

    private val fragmentList =
        listOf(AddMenuItemFragment(), ConfigMenuItemFragment(), StatisticsMenuItemFragment())

    override fun getItemCount(): Int {
        return fragmentList.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragmentList[position]
    }
}
