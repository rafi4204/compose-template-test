package com.composetemplatetest.core.usecases.resourceDetails

import com.composetemplatetest.arch.extensions.useCaseFlow
import com.composetemplatetest.core.data.repositories.ResourceRepository
import com.composetemplatetest.injection.qualifiers.IoDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class GetResourceDetailsUseCase @Inject constructor(
    private val resourceRepository: ResourceRepository,
    @IoDispatcher private val coroutineDispatcher: CoroutineDispatcher
) {
    operator fun invoke(id: Int) = useCaseFlow(coroutineDispatcher = coroutineDispatcher) {
        resourceRepository.getResourcesDetails(id)
    }


}