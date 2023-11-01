package com.example.minggu10laprak

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.minggu10laprak.databinding.ItemStudentBinding
import com.example.minggu10laprak.databinding.ItemStudentSmallBinding

typealias OnClickStudent = (Student) -> Unit

class StudentAdapter(private val studentList: List<Student>, val onClickStudent: OnClickStudent)
    : RecyclerView.Adapter<StudentAdapter.ItemStudentViewHolder>() {

    inner class ItemStudentViewHolder(private val binding: ItemStudentSmallBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(student: Student) {
            with(binding) {
                friendName.text = student.name
//                friendImage.setImageResource(student.image)

                itemView.setOnClickListener { onClickStudent(student) }
            }
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