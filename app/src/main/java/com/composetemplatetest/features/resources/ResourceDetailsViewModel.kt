package com.composetemplatetest.features.resources

import androidx.lifecycle.ViewModel
import com.composetemplatetest.arch.extensions.LoadingAware
import com.composetemplatetest.arch.extensions.ViewErrorAware
import com.composetemplatetest.arch.extensions.collectFlow
import com.composetemplatetest.core.domain.model.ResourceDetails
import com.composetemplatetest.core.usecases.resourceDetails.GetResourceDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class ResourceDetailsViewModel @Inject constructor(
    private val getResourceDetailsUseCase: GetResourceDetailsUseCase
) : ViewModel(), ViewErrorAware, LoadingAware {
   val resourceDetails = MutableStateFlow(ResourceDetails(-1, "", ""))

    fun getResourceDetails(id: Int) {
        collectFlow(getResourceDetailsUseCase(id)) {
            resourceDetails.value = it
        }
    }

}