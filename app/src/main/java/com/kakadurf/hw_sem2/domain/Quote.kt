package com.kakadurf.hw_sem2.domain

import com.google.gson.annotations.SerializedName

data class Quote (
    @SerializedName("_id")
    var id: String,
    @SerializedName("dialog")
    var text: String,
    @SerializedName("movie")
    var movieId: String,
    @SerializedName("character")
    var characterId: String
): Data