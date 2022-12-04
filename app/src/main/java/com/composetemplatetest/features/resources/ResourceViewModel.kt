package com.composetemplatetest.features.resources

import androidx.lifecycle.ViewModel
import com.composetemplatetest.arch.extensions.LoadingAware
import com.composetemplatetest.arch.extensions.ViewErrorAware
import com.composetemplatetest.core.sharedui.errorhandling.ViewError
import com.composetemplatetest.core.usecases.resources.GetResourcesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class ResourceViewModel @Inject constructor(
    getResourcesUseCase: GetResourcesUseCase
) : ViewModel(), ViewErrorAware, LoadingAware {
    var resourceResult = getResourcesUseCase()

    //var resourceResult = getResourcesUseCase()
    val loadingFlow = MutableStateFlow(false)
    val errorFlow = MutableSharedFlow<ViewError>()




}