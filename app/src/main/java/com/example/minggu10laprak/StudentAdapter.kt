package com.example.minggu10laprak

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.minggu10laprak.databinding.ItemStudentBinding
import com.example.minggu10laprak.databinding.ItemStudentSmallBinding

typealias OnClickStudent = (Student) -> Unit

class StudentAdapter(private val studentList: List<Student>, val onClickStudent: OnClickStudent)
    : RecyclerView.Adapter<StudentAdapter.ItemStudentViewHolder>() {

    inner class ItemStudentViewHolder(private val binding: ItemStudentSmallBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(student: Student) {
            with(binding) {
                friendName.text = student.name

                if(student.iconImage != "") {
                    putIconImage(student.iconImage)
                } else {
                    friendImage.setImageResource(student.iconImageDefault)
                }

                checkGPA(student.gpa)
                itemView.setOnClickListener { onClickStudent(student) }
            }
        }
        fun checkGPA(gpa: Double) {
            if (gpa >= 3.5) {
                binding.status.setImageResource(R.color.green)
            } else if (gpa >= 2.0) {
                binding.status.setImageResource(R.color.blue)
            } else {
                binding.status.setImageResource(R.color.red)
            }
        }

        fun putIconImage(image: String) {
            Glide.with(itemView.context)
                .load(image)
                .into(binding.friendImage)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemStudentViewHolder {
        val binding = ItemStudentSmallBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false)
        return ItemStudentViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return studentList.size
    }

    override fun onBindViewHolder(holder: ItemStudentViewHolder, position: Int) {
        holder.bind(studentList[position])
    }



}