package com.kakadurf.hw_sem2.domain

import com.google.gson.annotations.SerializedName

data class Movie(
    @SerializedName("name")
    var name: String,
    @SerializedName("_id")
    var id: String,
    @SerializedName("runtimeInMinutes")
    var runtimeInMinutes: Int,
    @SerializedName("budgetInMillions")
    var budgetInMillions: Int,
    @SerializedName("boxOfficeRevenueInMillions")
    var boxOfficeRevenueInMillions: Int,
    @SerializedName("academyAwardNominations")
    var academyAwardNominations: Int,
    @SerializedName("academyAwardWins")
    var academyAwardWins: Int,
    @SerializedName("rottenTomatesScore")
    var rottenTomatesScore: Short
) : Data
