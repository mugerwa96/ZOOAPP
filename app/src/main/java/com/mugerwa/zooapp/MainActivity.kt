package com.mugerwa.zooapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mugerwa.zooapp.MyAdapter.onItemClickListener

class MainActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //        array of images

        var images = arrayListOf<Int>(
            R.drawable.baboon,
            R.drawable.bulldog,
            R.drawable.panda,
            R.drawable.swallow_bird,
            R.drawable.white_tiger,
            R.drawable.zebra
        )
        var title = arrayListOf<String>(
            "Baboon",
            "Bull DOg",
            "Panda",
            "Swallow Bird",
            "White Tiger",
            "Zebra"
        )

//        description of each animal
        var description = arrayListOf<String>(
            "Senior mobile Engineer,Curiosity for discovering new concepts,daily work",
            "Senior mobile Engineer,Curiosity for discovering new concepts,daily work",
            "Senior mobile Engineer,Curiosity for discovering new concepts,daily work",
            "Senior mobile Engineer,Curiosity for discovering new concepts,daily work",
            "Get all my courses from www.intellectitechacademy.com",
            "Get all my courses from www.intellectitechacademy.comGet all my courses from www.intellectitechacademy.comGet all my courses from www.intellectitechacademy.comGet all my courses from www.intellectitechacademy.com"
        )
//        description of each animal

//         arrayListOf<dataClass>() ,it will contain all the animals with their respective images ,they are of
//        datatype dataClass,dataClass is a model

        val items = arrayListOf<dataClass>()

        for(i in images.indices){
            items.add(dataClass(title[i],images[i], description[i]))
        }
//        linking the main layout with the recycler view
        val recyer:RecyclerView=findViewById(R.id.recyclerView)

//        layout,either Grid,Vertical or Horizontal
        recyer.layoutManager=LinearLayoutManager(this)
        var adapter=MyAdapter(items)

            recyer.adapter=adapter


//        implementing in click listener on the adapter
            adapter.setOnClickListener(object :MyAdapter.onItemClickListener{
                override fun onItemClick(position: Int) {

//                    active a new activit and passs in data

                    val intent= Intent(this@MainActivity,information::class.java)
                    intent.putExtra("title",items[position].title)
                    intent.putExtra("description",items[position].description)
                    intent.putExtra("image",items[position].image)
                    startActivity(intent)
                }

            })


//        implementing in click listener on each item

    }

    }






