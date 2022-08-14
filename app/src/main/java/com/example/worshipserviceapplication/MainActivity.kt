package com.example.worshipserviceapplication

import android.app.Dialog
import android.app.Service
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.SyncStateContract.Helpers.insert
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.worshipserviceapplication.Database.Entity.WorshipService
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity(), ServiceAdapter.WorshipServiceClickInterface {
    lateinit var itemsRV: RecyclerView
    lateinit var addFAB: FloatingActionButton
    lateinit var list:List<WorshipService>
    lateinit var serviceAdapter: ServiceAdapter
    lateinit var modal: GetHymnsModal

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        itemsRV = findViewById(R.id.idRVItems)
        addFAB = findViewById(R.id.idFABAdd)
        list = ArrayList<WorshipService>()
        serviceAdapter = ServiceAdapter(list, this)
        itemsRV.layoutManager = LinearLayoutManager(this)
        itemsRV.adapter = serviceAdapter
        val hymnRepository = HymnRepository(HymnDatabase(this))
        val factory = GetHymnsModalFactory(hymnRepository)
        modal = ViewModelProvider(this,factory).get(GetHymnsModal::class.java)
        modal.getAllHymnItems().observe(this, Observer {
            serviceAdapter.list = it
            serviceAdapter.notifyDataSetChanged()
        })

        addFAB.setOnClickListener {
            openDialog()
        }

    }
    fun openDialog(){
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.service_add_dialog)
        val cancelBtn = dialog.findViewById<Button>(R.id.idButtonCancel)
        val addBtn = dialog.findViewById<Button>(R.id.idButtonAdd)
        val firstHymnEdit = dialog.findViewById<EditText>(R.id.EdtFirstHymn)
        val firstHymnNumberEdit = dialog.findViewById<EditText>(R.id.EdtFirstHymnNumber)
        val psalmEdt = dialog.findViewById<EditText>(R.id.EdtPsalm)
        val secondHymnEdt = dialog.findViewById<EditText>(R.id.SecondHymn)
        val secondHymnNumberEdt = dialog.findViewById<EditText>(R.id.SecondHymnNumber)
        cancelBtn.setOnClickListener {
            Toast.makeText(applicationContext,"Cancelled", Toast.LENGTH_SHORT).show()
            dialog.dismiss()
        }
        addBtn.setOnClickListener {
            val firstHymn : String = firstHymnEdit.text.toString()
            val firstHymnNumber : String = firstHymnNumberEdit.text.toString()
            val psalm : String = psalmEdt.text.toString()
            val secondHymn : String = secondHymnEdt.text.toString()
            val secondHymnNumber : String = secondHymnNumberEdt.text.toString()
            if(firstHymn.isNotEmpty() &&
                    firstHymnNumber.isNotEmpty() &&
                    psalm.isNotEmpty() &&
                    secondHymn.isNotEmpty() &&
                    secondHymnNumber.isNotEmpty())
            {
                val service = WorshipService(firstHymn,firstHymnNumber,psalm,secondHymn,secondHymnNumber)
                modal.insert(service)
                Toast.makeText(applicationContext,"Service has been updated!", Toast.LENGTH_SHORT).show()
                serviceAdapter.notifyDataSetChanged()
                dialog.dismiss()
            }
            else {
                Toast.makeText(applicationContext,"Please fill in all fields...", Toast.LENGTH_SHORT).show()
            }
        }
        dialog.show()
    }

    override fun onItemClick(worshipService: WorshipService) {
        modal.delete(worshipService)
        serviceAdapter.notifyDataSetChanged()
        Toast.makeText(applicationContext,"Service Deleted...", Toast.LENGTH_SHORT).show()
    }
}