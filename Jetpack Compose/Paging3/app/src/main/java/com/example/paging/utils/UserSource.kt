package com.example.paging.utils

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.paging.model.UsersInfo
import com.example.paging.network.RetrofitClientService
import com.example.paging.network.api.ApiService
import retrofit2.HttpException
import java.io.IOException

class UserSource: PagingSource<Int, UsersInfo>() {

    override fun getRefreshKey(state: PagingState<Int, UsersInfo>): Int? {
        return state.anchorPosition
    }

    //this is how we control our loadings in paging
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, UsersInfo> {
        return try{
            val nextPage = params.key ?: 1
            val users = RetrofitClientService().retrofit.create(ApiService::class.java).api(nextPage)
            println(users.data)
            println(nextPage)
            LoadResult.Page(
                data = users.data,
                prevKey = if(nextPage == 1) null else nextPage - 1,
                nextKey = if(users.data.isEmpty()) null else nextPage + 1
            )
        }catch (exception:IOException){
           return LoadResult.Error(exception)
        }catch (exception:HttpException){
            return LoadResult.Error(exception)
        }
    }

}