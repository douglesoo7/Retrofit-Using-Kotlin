package com.example.kotlinretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private var responseList: List<ResponseDTO> = listOf<ResponseDTO>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnPost.setOnClickListener {
            callAPI()
        }
    }

    private fun callAPI() {
        val apiInterface = Network.getRetrofitInstance().create(ApiInterface::class.java)
        apiInterface.getPosts(etPostId.text.toString().toInt())
            .enqueue(object : Callback<List<ResponseDTO>> {
                override fun onResponse(
                    call: Call<List<ResponseDTO>>,
                    response: Response<List<ResponseDTO>>
                ) {
                    responseList =
                        response.body()!! //!! this is asserting non null if the response.body() is you will get null pointer exception

                    setRecyclerView()
                }

                override fun onFailure(call: Call<List<ResponseDTO>>, t: Throwable) {
                    TODO("Not yet implemented")
                }

            })
    }

    private fun setRecyclerView() {
        val postAdapter = PostAdapter(responseList)
        val linearLayoutManager = LinearLayoutManager(this)
        recyclerView.adapter = postAdapter
        recyclerView.layoutManager = linearLayoutManager

    }
}