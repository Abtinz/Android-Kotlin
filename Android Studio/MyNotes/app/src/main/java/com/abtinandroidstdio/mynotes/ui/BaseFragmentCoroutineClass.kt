package com.abtinandroidstdio.mynotes.ui

import androidx.fragment.app.Fragment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

abstract class BaseFragmentCoroutineClass:Fragment(),CoroutineScope {

    private lateinit var job : Job

    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers
}