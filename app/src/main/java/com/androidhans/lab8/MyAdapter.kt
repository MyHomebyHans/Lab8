package com.androidhans.lab8

import android.icu.text.Transliterator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import android.view.View

//建立 MyAdapter類別(客制數據值:陣列清單<Contact>): 並繼承自RecyclerView.Adapter<MyAdapter.ViewHolder>(){}
//<Contact>建立在MainActivity裏的類別定義了連絡人的資料結構
//<MyAdapter.ViewHolder> ViewHolder建立在MyAdapter裏用於執行畫面複用機制
class MyAdapter (private val data: ArrayList<Contact>):
     RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    //實作RecyclerView.ViewHolder來儲存View
    //建立類 ViewHolder類別，並繼承自RecyclerView.ViewHolder
    class ViewHolder(v: View): RecyclerView.ViewHolder(v) {

    //連結畫面中的元件(對應的畫面為adapter_row)
        val tv_name = v.findViewById<TextView>(R.id.tv_name)
        val tv_phone = v.findViewById<TextView>(R.id.tv_phone)
        val img_delete = v.findViewById<ImageView>(R.id.img_delete)
    }

    override fun getItemCount() = data.size

    override fun onCreateViewHolder(viewGroup: ViewGroup, position: Int):
    ViewHolder {
        val v = LayoutInflater.from(viewGroup.context) //
            .inflate(R.layout.adapter_row, viewGroup, false)
        return ViewHolder(v)
    }
    //將資料指派給元件呈現
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tv_name.text = data[position].name
        holder.tv_phone.text = data[position].phone

        //設定監聽器，使用 removeAt()刪除指定位置的資料
        holder.img_delete.setOnClickListener {
            data.removeAt(position)
            notifyDataSetChanged() //通知數據已更改
        }
    }
}




