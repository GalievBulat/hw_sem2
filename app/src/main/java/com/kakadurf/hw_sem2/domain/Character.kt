package com.kakadurf.hw_sem2.domain

import com.google.gson.annotations.SerializedName

data class Character(
    @SerializedName("name")
    var name: String,
    @SerializedName("_id")
    var id: String,
    @SerializedName("race")
    var race: String?,
    @SerializedName("birth")
    var birth: String?,
    @SerializedName("death")
    var death: String?,
    @SerializedName("hair")
    var hair: String?,
    @SerializedName("spouse")
    var spouse: String?,
    @SerializedName("height")
    var height: String?,
    @SerializedName("gender")
    var gender: String?,
    @SerializedName("realm")
    var realm: String?,
    @SerializedName("wikiUrl")
    var wikiUrl: String?
) : Data
