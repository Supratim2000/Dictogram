package com.example.dictogram.Adapter

import android.content.Context
import android.media.AudioManager
import android.media.MediaPlayer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.dictogram.ModelClasses.Phonetics
import com.example.dictogram.R
import com.example.dictogram.ViewHolder.PhoneticsViewHolder

class PhoneticsAdapter(
    private val phoneticsList: ArrayList<Phonetics>,
    private val context: Context
) : RecyclerView.Adapter<PhoneticsViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhoneticsViewHolder {
        val phoneticsItemView: View = LayoutInflater.from(parent.context).inflate(R.layout.phonetics_row, parent, false)
        val phoneticsItemViewAsViewHolder: PhoneticsViewHolder = PhoneticsViewHolder(phoneticsItemView)
        return phoneticsItemViewAsViewHolder
    }

    override fun onBindViewHolder(holder: PhoneticsViewHolder, position: Int) {
        val currentItem: Phonetics = phoneticsList[position]
        holder.getPhoneticsRowTv().text = currentItem.getText()
        holder.getPhoneticsRowPlayIv().setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                val mediaPlayer: MediaPlayer = MediaPlayer()
                try {
                    mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC)
                    mediaPlayer.setDataSource(currentItem.getAudio())
                    mediaPlayer.prepare()
                    mediaPlayer.start()
                } catch (e: java.lang.Exception) {
                    e.printStackTrace()
                    Toast.makeText(context, "Failed to play sound!", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }

    override fun getItemCount(): Int = phoneticsList.size
}