package com.mugerwa.zooapp

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView

//(private val item:List<dataClass>) the primary constructor takes in the list of items or data to be recycled by the recycler Adapter.
//<MyAdapter.ViewHolder>() holds the layout to recycled

class MyAdapter(private val item:List<dataClass>): RecyclerView.Adapter<MyAdapter.ViewHolder>() {

//    implementing on click listener when an i1tem is clicked on in the list
            private lateinit var mListener:onItemClickListener
            interface onItemClickListener{
                fun onItemClick(position:Int)
            }

            fun setOnClickListener(listener:onItemClickListener){
                mListener=listener
            }
    //    implementing on click listener when an i1tem is clicked on in the list


//    linking our Layout design with the View HOlder which link s with the Adapter to be called
                override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.ViewHolder {
                   val layout=LayoutInflater.from(parent.context).inflate(R.layout.card_design,parent,false)
                    return ViewHolder(layout,mListener)
                }
    //    linking our Layout design with the View HOlder which link s with the Adapter to be called


//    binding the placeholders with the actual values in the layout which are to be recycled
            override fun onBindViewHolder(holder: MyAdapter.ViewHolder, position: Int) {
              val currentItem=item[position]
                holder.titleTextView.text=currentItem.title
                holder.descriptionTextView.text=currentItem.description
                holder.imageView.setImageResource(currentItem.image)
            }
//    binding the placeholders with the actual values in the layout which are to be recycled


//    returning the number fof items to be recycled in  our recycler view
            override fun getItemCount(): Int {
            return item.size
            }
    //    returning the number of item s to be recycled in  our recycler view


                //===========VIEW HOLDER========================

//    view Holder , itemVie refers to a single item in the list view after being recycled
    class ViewHolder(itemView: View,listener: onItemClickListener) : RecyclerView.ViewHolder(itemView) {

//        imageView descriptionTextView  titleTextView act as placeholders for the values to be repeated
                        val imageView:ImageView=itemView.findViewById(R.id.image)
                        val descriptionTextView:TextView=itemView.findViewById(R.id.description)
                       val titleTextView:TextView=itemView.findViewById(R.id.title)
        //        imageView descriptionTextView  titleTextView act as placeholders for the values to be repeated

            //        passing the onclick listener to the view holder ,init is a constructor
                    init {
                             itemView.setOnClickListener {
                            listener.onItemClick(absoluteAdapterPosition)
                        }

                    }

            //        passing the onclick listener to the view holder
    }
//    view Holder , itemVie refers to a single item in the list view after being recycled


    }
