package com.seif.testfirestore

data class Albums(
    var id:String = "",
    var albumTitle:String = "",
    var releasedYear:String = "",
    var songs:MutableList<Song>? = null
)

//data class Song(
//    var id:String = "",
//    var title:String = ""
//    )
