package com.example.paging.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.paging.model.UsersInfo
import com.example.paging.utils.Configs.Page_Sizes
import com.example.paging.utils.UserSource
import kotlinx.coroutines.flow.Flow

class UsersViewModel:ViewModel() {
    val users : Flow<PagingData<UsersInfo>> = Pager(PagingConfig(pageSize =  Page_Sizes)){
        UserSource()
    }.flow.cachedIn(viewModelScope)
}