package com.example.movies.domain.useCases

interface BaseUseCase<UseCaseParams,UseCaseResponse> {

    suspend fun execute(params: UseCaseParams):UseCaseResponse
}