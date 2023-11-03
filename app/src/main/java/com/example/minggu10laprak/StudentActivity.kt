package com.example.minggu10laprak

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.minggu10laprak.databinding.ActivityStudentBinding
import com.google.android.material.snackbar.Snackbar

class StudentActivity : AppCompatActivity() {
    private lateinit var binding: ActivityStudentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStudentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            name.text = intent.getStringExtra("name")
            subName.text = intent.getStringExtra("departement") + " - " + intent.getStringExtra("major")
            description.text = intent.getStringExtra("aboutMe")
            stats.text = "GPA: " + intent.getDoubleExtra("gpa", 0.0).toString() + " | Age: " + intent.getIntExtra("age", 0).toString()

            if(intent.getStringExtra("iconImage") != "") {
                putIconImage(intent.getStringExtra("iconImage")!!)
            }

            if(intent.getStringExtra("bannerImage") != "") {
                putBannerImage(intent.getStringExtra("bannerImage")!!)
            }

            checkGPA(intent.getDoubleExtra("gpa", 0.0))

            backButton.setOnClickListener {
                finish()
            }
        }
    }

    fun checkGPA(gpa: Double) {
        if (gpa >= 3.5) {
            binding.gpaIndicator.setImageResource(R.color.green)
        } else if (gpa >= 2.0){
            binding.gpaIndicator.setImageResource(R.color.blue)
        } else {
            binding.gpaIndicator.setImageResource(R.color.red)
        }
    }

    private fun putIconImage(image: String) {
        Glide.with(this)
            .load(image)
            .into(binding.iconImage)
    }

    private fun putBannerImage(image: String) {
        Glide.with(this)
            .load(image)
            .into(binding.bannerImage)
    }
}