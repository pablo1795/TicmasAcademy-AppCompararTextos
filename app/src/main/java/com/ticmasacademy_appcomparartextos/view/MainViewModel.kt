package com.ticmasacademy_appcomparartextos.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.ticmasacademy_appcomparartextos.model.ComparisonResultText
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    val comparisonResult: LiveData<ComparisonResultText> get() = _comparisonResult
    private var _comparisonResult = MutableLiveData<ComparisonResultText>(ComparisonResultText(""))

    fun textComparison(firstText: String, secondText: String) {
        if (!firstText.isNotEmpty() || !secondText.isNotEmpty()) {
            updateTextComparison(ComparisonResultText("Completar todos los campos"))
        } else {
            if (firstText == secondText) {
                updateTextComparison(ComparisonResultText("Los textos iguales"))
            } else {
                updateTextComparison(ComparisonResultText("los textos distintos"))
            }
        }
    }

    private fun updateTextComparison(result: ComparisonResultText) {
        viewModelScope.launch {
            _comparisonResult.value = result
        }
    }
}