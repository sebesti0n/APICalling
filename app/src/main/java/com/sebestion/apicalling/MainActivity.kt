package com.sebestion.apicalling

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.sebestion.apicalling.Models.StudentDataClass
import com.sebestion.apicalling.Models.responseStudentData
import com.sebestion.apicalling.apiServices.RetrofitInstances
import com.sebestion.apicalling.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity:AppCompatActivity() {
private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.submitButton.setOnClickListener {
                val name= binding.editTextName.text.toString()
        val email = binding.editTextEmail.text.toString()
        val phoneNo = binding.editTextPhone.text.toString()
        val ag =binding.editTextAge.text.toString()
        val age=ag.toInt()
            val data = StudentDataClass(email,phoneNo,age, name)
            RetrofitInstances.service.createUser(data).enqueue(object : Callback<responseStudentData> {
                override fun onResponse(
                    call: Call<responseStudentData>,
                    response: Response<responseStudentData>
                ) {
                    if (response.body()!=null)
                        Toast.makeText(this@MainActivity,"name:${response.body()!!.name}", Toast.LENGTH_LONG).show()
                }

                override fun onFailure(call: Call<responseStudentData>, t: Throwable) {
                    TODO("Not yet implemented")
                }
            })

        }



    }
}