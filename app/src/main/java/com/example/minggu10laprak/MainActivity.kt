package com.example.minggu10laprak

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.minggu10laprak.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapterStudent = StudentAdapter(generateStudent()) {
            student -> Snackbar.make(binding.root,
            "Anda memilih mahasiswa ${student.name}", Snackbar.LENGTH_SHORT).show()
        }

        with(binding) {
            studentRview.apply {
                adapter = adapterStudent
                layoutManager = LinearLayoutManager(this@MainActivity)
            }
        }

    }

    private fun generateStudent(): List<Student> {
        return listOf(
            Student(name="Aldo", gpa=3.5, age=20, departement="Informatika", major="Mobile"),
            Student(name="Budi", gpa=3.4, age=20, departement="Informatika", major="Mobile"),
            Student(name="Caca", gpa=3.3, age=20, departement="Informatika", major="Mobile")
        )
    }
}