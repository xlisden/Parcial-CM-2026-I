package com.day.parcial2026i

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val etCode = findViewById<EditText>(R.id.et_code)
        val etFirstName = findViewById<EditText>(R.id.et_first_name)
        val chkSecondName = findViewById<CheckBox>(R.id.chk_second_name)
        val etSecondName = findViewById<EditText>(R.id.et_second_name)
        val etLastName = findViewById<EditText>(R.id.et_last_name)
        val etLastName2 = findViewById<EditText>(R.id.et_last_name2)
        val etAge = findViewById<EditText>(R.id.et_age)
        val spArea = findViewById<Spinner>(R.id.sp_area)
        val tvRol = findViewById<TextView>(R.id.tv_rol)
        val rgRol = findViewById<RadioGroup>(R.id.rg_rol)
        val btnRegister = findViewById<Button>(R.id.btn_register)




    }
}