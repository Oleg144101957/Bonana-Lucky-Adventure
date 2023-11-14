package music.musicplayluck.ttr.ui.theme.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import music.musicplayluck.ttr.R
import music.musicplayluck.ttr.ui.theme.elements.Aspect
import music.musicplayluck.ttr.ui.theme.elements.IsOpened
import music.musicplayluck.ttr.ui.theme.elements.IsSelected
import music.musicplayluck.ttr.ui.theme.elements.IsTop

class BananViewModel : ViewModel(){

    private val _aspects: MutableLiveData<List<Aspect>> = MutableLiveData(listOf(
        Aspect(image = R.drawable.qw11, isSelected = IsSelected(), isOpened = IsOpened(), isTop = IsTop()),
        Aspect(image = R.drawable.qw10, isSelected = IsSelected(), isOpened = IsOpened(), isTop = IsTop()),
        Aspect(image = R.drawable.qw9, isSelected = IsSelected(), isOpened = IsOpened(), isTop = IsTop()),
        Aspect(image = R.drawable.qw8, isSelected = IsSelected(), isOpened = IsOpened(), isTop = IsTop()),
        Aspect(image = R.drawable.qw11, isSelected = IsSelected(), isOpened = IsOpened(), isTop = IsTop()),
        Aspect(image = R.drawable.qw10, isSelected = IsSelected(), isOpened = IsOpened(), isTop = IsTop()),
        Aspect(image = R.drawable.qw9, isSelected = IsSelected(), isOpened = IsOpened(), isTop = IsTop()),
        Aspect(image = R.drawable.qw8, isSelected = IsSelected(), isOpened = IsOpened(), isTop = IsTop()),
        Aspect(image = R.drawable.qw9, isSelected = IsSelected(), isOpened = IsOpened(), isTop = IsTop()),
        Aspect(image = R.drawable.qw8, isSelected = IsSelected(), isOpened = IsOpened(), isTop = IsTop()),
        Aspect(image = R.drawable.qw11, isSelected = IsSelected(), isOpened = IsOpened(), isTop = IsTop()),
        Aspect(image = R.drawable.qw10, isSelected = IsSelected(), isOpened = IsOpened(), isTop = IsTop()),
        Aspect(image = R.drawable.qw9, isSelected = IsSelected(), isOpened = IsOpened(), isTop = IsTop()),
        Aspect(image = R.drawable.qw8, isSelected = IsSelected(), isOpened = IsOpened(), isTop = IsTop()),
        Aspect(image = R.drawable.qw11, isSelected = IsSelected(), isOpened = IsOpened(), isTop = IsTop())
    ))

    val aspects: LiveData<List<Aspect>> = _aspects


    private val _coins: MutableLiveData<Int> = MutableLiveData(0)
    val coins: LiveData<Int> = _coins


    fun initAspects(){
        val newOpenedList = _aspects.value?.shuffled()?.map { it.copy(isOpened = IsOpened(true), isTop = IsTop(false)) }
        _aspects.value = newOpenedList
        viewModelScope.launch {
            delay(1897)
            val newClosedList = _aspects.value?.map { it.copy(isOpened = IsOpened(false)) }
            val newClosedListWithOneSelected = newClosedList?.mapIndexed { index, aspect ->
                if (index == 0) aspect.copy(isSelected = IsSelected(true)) else aspect.copy(isSelected = IsSelected(false))
            }

            _aspects.value = newClosedListWithOneSelected
        }
    }

    fun moveRight(){
        val selectedIndex = _aspects.value?.indexOfFirst { it.isSelected.isSelected }

        if (selectedIndex != null && selectedIndex != 14){
            val newList = _aspects.value?.mapIndexed { index, aspect ->
                if (index == selectedIndex){
                    aspect.copy(isSelected = IsSelected(false))
                } else if (index == selectedIndex+1){
                    aspect.copy(isSelected = IsSelected(true))
                } else {
                    aspect
                }
            }
            _aspects.value = newList
        }
    }

    fun moveLeft(){
        val selectedIndex = _aspects.value?.indexOfFirst { it.isSelected.isSelected }

        if (selectedIndex != null && selectedIndex != 0){
            val newList = _aspects.value?.mapIndexed { index, aspect ->
                if (index == selectedIndex){
                    aspect.copy(isSelected = IsSelected(false))
                } else if (index == selectedIndex-1){
                    aspect.copy(isSelected = IsSelected(true))
                } else {
                    aspect
                }
            }
            _aspects.value = newList
        }
    }

    fun pressButtonSelect(){

        val selectedIndex = _aspects.value?.indexOfFirst { it.isSelected.isSelected }

        val newList = _aspects.value?.mapIndexed { index, aspect -> if (index == selectedIndex) aspect.copy(
            isTop = IsTop(true),
            isOpened = IsOpened(true)
        ) else aspect}

        _aspects.value = newList
    }

}