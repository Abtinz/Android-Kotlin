package com.example.hiltdagger.network.repository

import com.example.hiltdagger.domain.repository.FakeRepository
import com.example.hiltdagger.network.api.ApiService

class FakeRepositoryImpl(
    private val apiService: ApiService
):FakeRepository {
    override suspend fun apiFake() {

    }
}