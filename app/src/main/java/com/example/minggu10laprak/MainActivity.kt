package com.example.minggu10laprak

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
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
            student ->
            Toast.makeText(this, student.name, Toast.LENGTH_SHORT).show()

            val intent = Intent(this, StudentActivity::class.java)
            intent.putExtra("name", student.name)
            intent.putExtra("gpa", student.gpa)
            intent.putExtra("age", student.age)
            intent.putExtra("aboutMe", student.aboutMe)
            intent.putExtra("departement", student.departement)
            intent.putExtra("major", student.major)
            intent.putExtra("iconImage", student.iconImage)
            intent.putExtra("bannerImage", student.bannerImage)
            startActivity(intent)
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
            Student(name="Caca", gpa=3.7, age=20, aboutMe = getString(R.string.lorem), departement="Informatika", major="Mobile"),
            Student(name="Dodi", gpa=3.6, age=20, aboutMe = getString(R.string.lorem),
                iconImage = "https://github.com/mafir03/imgRepo/blob/main/s1.png?raw=true",
                bannerImage = "https://github.com/mafir03/imgRepo/blob/main/s1a.png?raw=true",
                departement="Informatika", major="Mobile"),
            Student(name="Eko", gpa=1.8, age=20, aboutMe = getString(R.string.lorem),
                iconImage = "https://github.com/mafir03/imgRepo/blob/main/g2.png?raw=true",
                bannerImage = "https://github.com/mafir03/imgRepo/blob/main/g2a.png?raw=true",
                departement="Informatika", major="Mobile"),
            Student(name="Fafa", gpa=2.8, age=20, aboutMe = getString(R.string.lorem),
                iconImage = "https://github.com/mafir03/imgRepo/blob/main/g1.png?raw=true",
                bannerImage = "https://github.com/mafir03/imgRepo/blob/main/g1a.png?raw=true",
                departement="Informatika", major="Mobile"),

            Student(name="Caca", gpa=3.7, age=20, aboutMe = getString(R.string.lorem), departement="Informatika", major="Mobile"),
            Student(name="Dodi", gpa=3.6, age=20, aboutMe = getString(R.string.lorem),
                iconImage = "https://github.com/mafir03/imgRepo/blob/main/s1.png?raw=true",
                bannerImage = "https://github.com/mafir03/imgRepo/blob/main/s1a.png?raw=true",
                departement="Informatika", major="Mobile"),
            Student(name="Eko", gpa=1.8, age=20, aboutMe = getString(R.string.lorem),
                iconImage = "https://github.com/mafir03/imgRepo/blob/main/g2.png?raw=true",
                bannerImage = "https://github.com/mafir03/imgRepo/blob/main/g2a.png?raw=true",
                departement="Informatika", major="Mobile"),
            Student(name="Fafa", gpa=2.8, age=20, aboutMe = getString(R.string.lorem),
                iconImage = "https://github.com/mafir03/imgRepo/blob/main/g1.png?raw=true",
                bannerImage = "https://github.com/mafir03/imgRepo/blob/main/g1a.png?raw=true",
                departement="Informatika", major="Mobile"),

            Student(name="Caca", gpa=3.7, age=20, aboutMe = getString(R.string.lorem), departement="Informatika", major="Mobile"),
            Student(name="Dodi", gpa=3.6, age=20, aboutMe = getString(R.string.lorem),
                iconImage = "https://github.com/mafir03/imgRepo/blob/main/s1.png?raw=true",
                bannerImage = "https://github.com/mafir03/imgRepo/blob/main/s1a.png?raw=true",
                departement="Informatika", major="Mobile"),
            Student(name="Eko", gpa=1.8, age=20, aboutMe = getString(R.string.lorem),
                iconImage = "https://github.com/mafir03/imgRepo/blob/main/g2.png?raw=true",
                bannerImage = "https://github.com/mafir03/imgRepo/blob/main/g2a.png?raw=true",
                departement="Informatika", major="Mobile"),
            Student(name="Fafa", gpa=2.8, age=20, aboutMe = getString(R.string.lorem),
                iconImage = "https://github.com/mafir03/imgRepo/blob/main/g1.png?raw=true",
                bannerImage = "https://github.com/mafir03/imgRepo/blob/main/g1a.png?raw=true",
                departement="Informatika", major="Mobile"),
        )

    }
}
