package com.kakadurf.hw_sem2.data.http

import com.kakadurf.hw_sem2.domain.Character
import com.kakadurf.hw_sem2.domain.Quote
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface HttpService {
    @GET("character")
    suspend fun getCharacters(@Query("limit") limit: Int = 100): HttpResponse<Character>

    @GET("character/{id}")
    suspend fun getCharacter(@Path("id") id: String): HttpResponse<Character>

    @GET("quote")
    suspend fun getQuotes(@Query("limit") limit: Int = 100): HttpResponse<Quote>
    @GET("quote/{id}")
    suspend fun getQuote(@Path("id") id: String): HttpResponse<Quote>
    @GET("character/{id}/quote")
    suspend fun getCharacterQuote(@Path("id") characterId: String): HttpResponse<Quote>
}
