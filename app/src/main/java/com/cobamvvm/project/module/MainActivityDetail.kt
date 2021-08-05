package com.cobamvvm.project.module

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.cobamvvm.project.R
import com.cobamvvm.project.data.model.FoodResponseItem
import kotlinx.android.synthetic.main.activity_main_detail.*

class MainActivityDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_detail)

        val intent = intent
        val data = intent.getSerializableExtra("data") as FoodResponseItem

        Glide.with(this).load(data.image).placeholder(R.drawable.ic_break)
            .error(R.drawable.ic_break).centerCrop().circleCrop().into(iv_food_details as ImageView)
        tv_title.text = data.name
        tv_desc.text = data.desc

    }
}