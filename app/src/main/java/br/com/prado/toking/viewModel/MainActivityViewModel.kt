package br.com.prado.toking.viewModel

import SingleLiveEvent
import androidx.lifecycle.ViewModel

internal class MainActivityViewModel : ViewModel() {

    internal sealed class Action {
        internal data class SelectPageByNavigation(val position: Int) : Action()
        internal data class SelectPageByViewPager(val position: Int) : Action()
    }

    internal val action = SingleLiveEvent<Action>()

    fun onPageSelected(position: Int) {
        action.value = Action.SelectPageByNavigation(position)
    }

    fun onNavigationItemSelected(position: Int) {
        action.value = Action.SelectPageByViewPager(position)
    }
}
