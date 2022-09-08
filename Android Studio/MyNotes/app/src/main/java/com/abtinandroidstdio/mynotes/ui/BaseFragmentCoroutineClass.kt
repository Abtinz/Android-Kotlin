package com.abtinandroidstdio.mynotes.ui

import androidx.fragment.app.Fragment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job

abstract class BaseFragmentCoroutineClass:Fragment(),CoroutineScope {

    private lateinit var job : Job
    
}