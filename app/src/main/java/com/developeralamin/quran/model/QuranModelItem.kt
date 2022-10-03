package com.developeralamin.quran.model

data class QuranModelItem(
    val arti: String,
    val audio: String,
    val deskripsi: String,
    val jumlah_ayat: Int,
    val nama: String,
    val nama_latin: String,
    val nomor: Int,
    val tempat_turun: String
)