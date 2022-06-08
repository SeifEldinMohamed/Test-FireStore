package com.seif.testfirestore

data class Data(
    val albumTitle: String="",
    val id: String="",
    val releasedYear: String="",
    val songs: List<Song> = emptyList()
)