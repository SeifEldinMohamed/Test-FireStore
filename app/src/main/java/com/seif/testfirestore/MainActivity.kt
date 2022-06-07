package com.seif.testfirestore

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val db = FirebaseFirestore.getInstance()

        db.collection("albums").get()
            .addOnSuccessListener {
                Log.d("main", it.documents[0].data?.get("albumTitle").toString())
                Log.d("main", it.documents[1].data?.get("albumTitle").toString())
                Log.d("main", it.toString())
            }
            .addOnFailureListener{
                Log.d("main",it.message.toString())
            }

//        db.collection("albums").document("").get()
//            .addOnSuccessListener {
//                Log.d("main", it.documents[0].data?.get("albumTitle").toString())
//                Log.d("main", it.documents[1].data?.get("albumTitle").toString())
//                Log.d("main", it.toString())
//            }
//            .addOnFailureListener{
//                Log.d("main",it.message.toString())
//            }
    }
}