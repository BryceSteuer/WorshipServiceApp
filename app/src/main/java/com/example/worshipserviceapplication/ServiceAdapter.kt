package com.example.worshipserviceapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.ListView
import androidx.recyclerview.widget.RecyclerView
import com.example.worshipserviceapplication.Database.Entity.WorshipService


class ServiceAdapter
    (var list: List<WorshipService>,
     val worshipServiceClickInterface: WorshipServiceClickInterface)
    : RecyclerView.Adapter<ServiceAdapter.ServiceViewHolder>()
{

    inner class ServiceViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        val firstNameTV = itemView.findViewById<TextView>(R.id.TVFirstHymnName)
        val firstNumberTV = itemView.findViewById<TextView>(R.id.TVFirstHymnNumber)
        val psalmTV = itemView.findViewById<TextView>(R.id.TVPsalmNumber)
        val secondNameTV = itemView.findViewById<TextView>(R.id.TVSecondHymnName)
        val secondNumberTV = itemView.findViewById<TextView>(R.id.TVSecondHymnNumber)
        val thirdNameTV = itemView.findViewById<TextView>(R.id.TVThirdHymnName)
        val thirdNumberTV = itemView.findViewById<TextView>(R.id.TVThirdHymnNumber)
        val fourthNameTV = itemView.findViewById<TextView>(R.id.TVFourthHymnName)
        val fourthNumberTV = itemView.findViewById<TextView>(R.id.TVFourthHymnNumber)
        val deleteTV = itemView.findViewById<ImageView>(R.id.idTVDelete)

    }


    interface WorshipServiceClickInterface{
        fun onItemClick(worshipService: WorshipService)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServiceViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.hymnservice_rv_item,parent,false)
        return ServiceViewHolder(view)
    }

    override fun onBindViewHolder(holder: ServiceViewHolder, position: Int) {
        holder.firstNameTV.text = list.get(position).firstHymnName
        holder.firstNumberTV.text = list.get(position).firstHymnNumber
        holder.psalmTV.text = list.get(position).psalm
        holder.secondNameTV.text = list.get(position).secondHymnName
        holder.secondNumberTV.text = list.get(position).secondHymnNumber
        holder.thirdNameTV.text = list.get(position).thirdHymnName
        holder.thirdNumberTV.text = list.get(position).thirdHymnNumber
        holder.fourthNameTV.text = list.get(position).fourthHymnName
        holder.fourthNumberTV.text = list.get(position).fourthHymnNumber
        holder.deleteTV.setOnClickListener {
            worshipServiceClickInterface.onItemClick(list.get(position))
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}