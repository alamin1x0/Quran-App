package com.developeralamin.quran.adapter

import android.content.Context
import android.media.AudioManager
import android.media.MediaPlayer
import android.renderscript.ScriptGroup.Binding
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.developeralamin.quran.R
import com.developeralamin.quran.databinding.QuranItemLayoutBinding
import com.developeralamin.quran.model.QuranModelItem

class QuranAdapter(var context: Context, var list: ArrayList<QuranModelItem>) :

    RecyclerView.Adapter<QuranAdapter.QuranViewHolder>() {

    class QuranViewHolder(val binding: QuranItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuranViewHolder {
        return QuranViewHolder(
            QuranItemLayoutBinding.inflate(
                LayoutInflater.from(context),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: QuranViewHolder, position: Int) {

        var item = list[position]
        holder.binding.textName.text = item.nama
        holder.binding.textnormo.text = item.nama_latin
        holder.binding.textAny.text = item.tempat_turun

        var mediaPlayer = MediaPlayer()


        holder.binding.imageaudio.setOnClickListener {
            var audioUrl = item.audio

            mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC)


            try {
                mediaPlayer.setDataSource(audioUrl)
                mediaPlayer.prepare()
                mediaPlayer.start()

            } catch (e: Exception) {
                e.printStackTrace()
            }

            Toast.makeText(context, "Audio started playing..", Toast.LENGTH_SHORT).show()


        }

        holder.binding.imagePause.setOnClickListener {
            if (mediaPlayer.isPlaying) {
                mediaPlayer.stop()
                mediaPlayer.reset()

                mediaPlayer.release()

                Toast.makeText(context, "Audio has been  paused..", Toast.LENGTH_SHORT)
                    .show()

            } else {
                Toast.makeText(context, "Audio not played..", Toast.LENGTH_SHORT).show()
            }
        }

    }

    override fun getItemCount(): Int {
        return list.size
    }
}