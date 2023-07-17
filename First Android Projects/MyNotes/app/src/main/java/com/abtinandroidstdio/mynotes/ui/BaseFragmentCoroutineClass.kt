package com.abtinandroidstdio.mynotes.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

abstract class BaseFragmentCoroutineClass:Fragment(),CoroutineScope {

    private lateinit var job : Job

    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        job = Job()
    }

    //when fragment is destroyed --> canceling the job
    override fun onDestroy() {
        super.onDestroy()
        job.cancel()
    }
}