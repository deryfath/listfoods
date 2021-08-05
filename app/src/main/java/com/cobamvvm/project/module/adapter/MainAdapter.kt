package com.cobamvvm.project.module.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.cobamvvm.project.R
import com.cobamvvm.project.data.model.FoodResponseItem
import com.cobamvvm.project.module.MainActivityDetail
import kotlinx.android.extensions.LayoutContainer


class MainAdapter (private var items:MutableList<FoodResponseItem>, private val context: Context) : RecyclerView.Adapter<MainAdapter.ViewHolder>() {


    override fun getItemCount(): Int = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val vh = ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_confirmed, parent, false))

        return vh
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val view=holder.itemView
        val data=items[position]

        view.let {
            it.visibility = View.VISIBLE

            Glide.with(it).load(data.image).placeholder(R.drawable.ic_break)
                .error(R.drawable.ic_break).centerCrop().into((it.findViewById(R.id.iv_food) as ImageView))
            (it.findViewById(R.id.tv_title) as TextView).text = data.name


        }

        view.setOnClickListener {

            val intent = Intent(context, MainActivityDetail::class.java)
            intent.putExtra("data", data)
            context.startActivity(intent)

        }

    }



    fun resetData(){
        items.clear()
        notifyDataSetChanged()
    }

    fun addItem(confirmedResponseItem: FoodResponseItem){
        items.add(confirmedResponseItem)
        notifyDataSetChanged()
    }

    inner class ViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer {


    }
}