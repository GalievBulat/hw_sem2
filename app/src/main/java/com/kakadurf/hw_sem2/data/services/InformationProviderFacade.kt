package com.kakadurf.hw_sem2.data.services

import android.util.Log
import com.kakadurf.hw_sem2.API_KEY
import com.kakadurf.hw_sem2.data.http.HttpService
import com.kakadurf.hw_sem2.domain.Character
import com.kakadurf.hw_sem2.domain.Quote
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException
import java.util.concurrent.TimeUnit

const val BASE_URL = "https://the-one-api.dev/v2/"
object InformationProviderFacade{
    private val apiKeyInterceptor = Interceptor{
        it.proceed(
            it.request().newBuilder().addHeader("Authorization", " Bearer $API_KEY").build())
    }
    private val int = Interceptor{
        Log.d("hi",  it.request().body().toString())
        it.proceed(it.request())
    }
    private val client: OkHttpClient = OkHttpClient.Builder()
        .connectTimeout(15, TimeUnit.SECONDS)
        .addInterceptor(apiKeyInterceptor)
        .addInterceptor(int)
        .build()
    private val retrofit: Retrofit = Retrofit.Builder()
        .client(client)
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    private val service: HttpService = retrofit.create(
        HttpService::class.java)
    suspend fun getSpecificCharacter(id: String): Character?{
        return try {
            service.getCharacter(id).chars.first()
        } catch (e: IOException){
            Log.d("hi", "error: " + e.localizedMessage)
            null
        }
    }
    suspend fun getCharacters(): List<Character>{
        return try {
            service.getCharacters(1000).chars
        } catch (e: IOException){
            e.printStackTrace()
            Log.d("hi", "error")
            listOf()
        }
    }
    suspend fun getSpecificQuotes(characterId: String): List<Quote>{
        return try {
                service.getCharacterQuote(characterId).chars
        } catch (e: IOException){
            Log.d("hi", "error")
            listOf()
        }
    }
}
