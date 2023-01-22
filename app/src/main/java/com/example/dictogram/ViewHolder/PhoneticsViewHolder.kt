package com.example.dictogram.ViewHolder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dictogram.R

class PhoneticsViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    //Private data members
    private var phoneticsRowTv: TextView = itemView.findViewById(R.id.phonetics_row_tv)
    private var phoneticsRowPlayIv: ImageView = itemView.findViewById(R.id.phonetics_row_play_iv)

    //Getters
    public fun getPhoneticsRowTv(): TextView = this.phoneticsRowTv
    public fun getPhoneticsRowPlayIv(): ImageView = this.phoneticsRowPlayIv

    //Setters
    public fun setPhoneticsRowTv(phoneticsRowTv: TextView) {
        this.phoneticsRowTv = phoneticsRowTv
    }
    public fun setPhoneticsRowPlayIv(phoneticsRowPlayIv: ImageView) {
        this.phoneticsRowPlayIv = phoneticsRowPlayIv
    }
}