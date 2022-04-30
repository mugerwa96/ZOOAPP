package com.mugerwa.zooapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class information : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_information)



        //        accesssing the values passed through the intent

            val bundle:Bundle?=intent.extras
        val intentTitle=bundle!!.getString("title")
        val intentDescription=bundle!!.getString("description")
        val imageId=bundle!!.getInt("image")

        val title:TextView=findViewById(R.id.title)
        val image:ImageView=findViewById(R.id.image)
        val description:TextView=findViewById(R.id.description)

        title.text=intentTitle
        description.text=intentDescription
        image.setImageResource(imageId)
    }
}
