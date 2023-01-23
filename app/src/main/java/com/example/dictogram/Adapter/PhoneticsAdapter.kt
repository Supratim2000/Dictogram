package com.example.dictogram.Adapter

import android.annotation.SuppressLint
import android.content.Context
import android.media.AudioManager
import android.media.MediaPlayer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.Toast
import androidx.cardview.widget.CardView
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

    @SuppressLint("SuspiciousIndentation")
    override fun onBindViewHolder(holder: PhoneticsViewHolder, position: Int) {
        val currentItem: Phonetics = phoneticsList[position]
        val currentItemText: String = currentItem.getText()
        val currentItemAudio: String = currentItem.getAudio()

        //Exception handling cause text or audio field can be null
        try {
            //Checking if text field is not empty, if empty then we will not show it in RecyclerView
            if(currentItemText.isNotEmpty()) {
                holder.getPhoneticsRowTv().text = currentItemText
                holder.getPhoneticsRowTv().visibility = View.VISIBLE
                //Checking if audio field is not empty, if empty then we will not show play button on CardView
                if (currentItemAudio.isNotEmpty()) {
                    holder.getPhoneticsRowPlayIv().visibility = View.VISIBLE
                    //Play phonetics when play button pressed on CardView
                    holder.getPhoneticsRowPlayIv().setOnClickListener(object : View.OnClickListener {
                        override fun onClick(p0: View?) {
                            try {
                                playSound(currentItemAudio, AudioManager.STREAM_MUSIC)
                            } catch (e: java.lang.Exception) {
                                e.printStackTrace()
                                Toast.makeText(context, "Sound not available!", Toast.LENGTH_SHORT)
                                    .show()
                            }
                        }
                    })
                } else {
                    if(currentItemAudio.isEmpty()) {
                        holder.getPhoneticsRowPlayIv().visibility = View.GONE
                    }
                }
            } else {
                holder.getPhoneticsRootView().visibility = View.GONE
                holder.getPhoneticsRootView().layoutParams = RelativeLayout.LayoutParams(0, 0)
            }
        } catch (e: java.lang.NullPointerException) {
            holder.getPhoneticsRootView().visibility = View.GONE
            holder.getPhoneticsRootView().layoutParams = RelativeLayout.LayoutParams(0, 0)
        }
    }

    override fun getItemCount(): Int = phoneticsList.size

    private fun playSound(currentItemAudio: String, audioStreamType: Int) {
        val mediaPlayer: MediaPlayer = MediaPlayer()
        mediaPlayer.setAudioStreamType(audioStreamType)
        mediaPlayer.setDataSource(currentItemAudio)
        mediaPlayer.prepare()
        mediaPlayer.start()
    }
}