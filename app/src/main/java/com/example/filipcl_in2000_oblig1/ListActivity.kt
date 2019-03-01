package com.example.filipcl_in2000_oblig1

import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast
import kotlinx.android.synthetic.main.alert_dialog.view.*

class ListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        //getting recyclerview from xml
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)

        //adding a layoutmanager
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)


        //crating an arraylist to store users using the data class user
        val users = ArrayList<Element>()

        //adding some dummy data to the list
        users.add(Element("Mysil Bergsprekken", "Klarsynt, Rockestjerne og fraværemde i arbeidslivet"))
        users.add(Element("Reodor Felgen", "Oppfinner og damemagnet"))

        //creating our adapter
        val adapter = ListAdapter(users)

        //now adding the adapter to recyclerview recyclerView.adapter = adapter
        recyclerView.adapter = adapter


        val fabBtn :FloatingActionButton = findViewById(R.id.fab)

            fabBtn.setOnClickListener {
                val mDialogView = layoutInflater.inflate(R.layout.alert_dialog, null)
                val mBuilder = AlertDialog.Builder(this)
                    .setTitle("Add New List Element")
                    .setView(mDialogView)

                val mAlertDialog = mBuilder.show()


               //Add btn legger til et nytt element i listen.
                mDialogView.addButton.setOnClickListener {
                    val newTitle = mDialogView.newTitle.text.toString()
                    val newContent = mDialogView.newContent.text.toString()
                    if (newTitle.trim().length > 0) {
                        if (newContent.trim().length > 0) {
                            users.add(Element(newTitle, newContent))
                            adapter.notifyItemInserted(users.size - 1)
                        } else
                            Toast.makeText(this, "Invalid input. Enter description", Toast.LENGTH_LONG).show()
                    }
                        else if(newTitle.trim().length == 0){
                            if(newContent.trim().length > 0){
                                Toast.makeText(this, "Invalid input. Please enter title", Toast.LENGTH_LONG).show()
                            }
                            else
                                Toast.makeText(this, "Invalid input. Please enter the title and description", Toast.LENGTH_LONG).show()
                            }
                        mAlertDialog.dismiss()
                        }
                    }
    }
}
