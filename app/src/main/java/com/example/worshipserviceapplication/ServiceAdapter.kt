package com.example.worshipserviceapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.worshipserviceapplication.Database.Entity.WorshipService

class ServiceAdapter
    (var list: List<WorshipService>,
     val worshipServiceClickInterface: WorshipServiceClickInterface)
    : RecyclerView.Adapter<ServiceAdapter.ServiceViewHolder>()
{

    inner class ServiceViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
         val nameTV = itemView.findViewById<TextView>(R.id.TVItemName)
         val quantityTV = itemView.findViewById<TextView>(R.id.TVItemQuantity)
         val rateTV = itemView.findViewById<TextView>(R.id.TVItemRate)
         val amountTV = itemView.findViewById<TextView>(R.id.idTVTotalAmt)
         val deleteTV = itemView.findViewById<TextView>(R.id.idTVDelete)

    }


    interface WorshipServiceClickInterface{
        fun onItemClick(worshipService: WorshipService)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServiceViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.hymnservice_rv_item,parent,false)
        return ServiceViewHolder(view)
    }

    override fun onBindViewHolder(holder: ServiceViewHolder, position: Int) {
        holder.nameTV.text = list.get(position).itemName
        holder.quantityTV.text = list.get(position).itemQuantity.toString()
        holder.rateTV.text = "Rs." + list.get(position).itemPrice.toString()
        var itemTotal : Int = list.get(position).itemPrice * list.get(position).itemQuantity
        holder.amountTV.text = "Rs." + itemTotal.toString()
        holder.deleteTV.setOnClickListener {
            worshipServiceClickInterface.onItemClick(list.get(position))
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}