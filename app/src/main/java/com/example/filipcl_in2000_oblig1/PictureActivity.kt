package com.example.filipcl_in2000_oblig1

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_picture.*

class PictureActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_picture)

            Glide.with(this)
            .load("https://upload.wikimedia.org/wikipedia/commons/e/eb/Ole-Johan_Dahls_hus_20110911-11.JPG")
            .into(ifiimg)

            NextActivity.setOnClickListener {
                val intent = Intent(this, ConverterActivity::class.java)
                startActivity(intent)
            }

        }
    }



