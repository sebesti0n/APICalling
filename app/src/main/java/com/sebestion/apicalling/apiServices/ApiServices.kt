package com.sebestion.apicalling.apiServices

import com.sebestion.apicalling.Models.StudentDataClass
import com.sebestion.apicalling.Models.responseStudentData
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiServices {
    @POST("/students")
    fun createUser(
        @Body user: StudentDataClass?
    ): Call<responseStudentData>
}