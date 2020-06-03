package com.devis.base_mvvm.core.utils

import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

/**
 * Created by devis on 03/06/20
 */

class AppDispatchers @Inject constructor(
    val main: CoroutineDispatcher,
    val io: CoroutineDispatcher
)