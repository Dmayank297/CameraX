package com.example.camerax

import android.graphics.Bitmap
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainViewModel(
    private val savedStateHandle: SavedStateHandle
): ViewModel() {
    private val _bitmaps = MutableStateFlow(
        savedStateHandle.get<List<Bitmap>>("bitmaps") ?: emptyList()
    )
    val bitmaps: StateFlow<List<Bitmap>> = _bitmaps.asStateFlow()

    fun onTakePhoto(bitmap: Bitmap) {
        val updatedBitmaps = _bitmaps.value + bitmap
        _bitmaps.value = updatedBitmaps
        savedStateHandle["bitmaps"] = updatedBitmaps
    }
}