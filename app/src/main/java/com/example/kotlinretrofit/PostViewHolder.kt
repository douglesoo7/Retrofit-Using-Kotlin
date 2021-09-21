package com.example.kotlinretrofit

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_layout.view.*

class PostViewHolder (private val view:View): RecyclerView.ViewHolder(view) {

    fun setData(responseDTO: ResponseDTO){
        view.tvName.text=responseDTO.name
        view.tvEmail.text=responseDTO.email
        view.tvBody.text=responseDTO.body
    }

}