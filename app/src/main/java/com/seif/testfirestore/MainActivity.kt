package com.seif.testfirestore

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

      //  Log.d("main", getAllSongs().toString())
        var albumsList :ArrayList<Data> = ArrayList()
        val db = FirebaseFirestore.getInstance()
        db.collection("albums").get()
            .addOnSuccessListener { task ->
//                 Log.d("main", it.documents[0].data?.get("albumTitle").toString())
//                 Log.d("main", it.documents[1].data?.get("albumTitle").toString())
//
//                 Log.d("main", it.documents[0].data?.get("songs").toString())
//                Log.d("main", it.documents[0].data.toString())
//                 if(!it.isEmpty){
//                     albumsList =  it.toObjects(Data::class.java)

                if (!task.isEmpty) {
                    task.forEach {
                        it?.let {
                            albumsList.add(it.toObject(Data::class.java))
                        }
                    }
                     Log.d("main", albumsList.toString())
                }
            }.addOnFailureListener{
                Log.d("main",it.message.toString())
            }

//        db.collection("albums").document("Allelady").get()
//            .addOnSuccessListener {
//                Log.d("main", it.data.toString())
//            }
//            .addOnFailureListener{
//                Log.d("main",it.message.toString())
//            }
    }

}