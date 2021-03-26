package com.kakadurf.hw_sem2.data.http

import com.google.gson.annotations.SerializedName
import com.kakadurf.hw_sem2.domain.Data

data class HttpResponse<D : Data> (@SerializedName("docs") var chars: List<D>)