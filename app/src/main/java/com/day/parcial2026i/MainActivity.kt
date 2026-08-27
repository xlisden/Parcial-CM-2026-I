package com.day.parcial2026i

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.PathUtils
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.day.parcial2026i.databinding.ActivityMainBinding
import kotlin.collections.listOf
import kotlin.compareTo
import kotlin.toString

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var firstName = ""
        var lastName = ""

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
        var isSelectedRol = false

        val areas = listOf("-", "Contabilidad", "RR.HH.", "Gerencia")
        val rolList = mapOf(
            "Contabilidad" to listOf(
                "Jefe de Contaduria",
                "Asistente de Contaduria"
            ),
            "RR.HH." to listOf(
                "Jefe de RR.HH.",
                "Asistente de RR.HH."
            ),
            "Gerencia" to listOf(
                "Gerente",
                "Asistente Gerencial"
            )
        )

        val adapterAreas = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, areas)
        spArea.adapter = adapterAreas


        tvRol.visibility = View.GONE
        rgRol.visibility = View.GONE

        chkSecondName.setOnCheckedChangeListener { button, isChecked ->
            etSecondName.isEnabled = isChecked
            if (!isChecked) {
                etSecondName.text.clear()
            }
        }

        spArea.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
                val area = areas[position]

                rgRol.removeAllViews()

                if (position == 0) {
                    tvRol.visibility = View.GONE
                    rgRol.visibility = View.GONE
                } else {
                    tvRol.visibility = View.VISIBLE
                    rgRol.visibility = View.VISIBLE

                    val rolListByArea = rolList[area] ?: emptyList()

                    for (rol in rolListByArea) {
                        val rbRol = RadioButton(this@MainActivity)
                        rbRol.text = rol
                        rgRol.addView(rbRol)
                    }
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        rgRol.setOnCheckedChangeListener { group, i ->
            isSelectedRol = true
        }

        btnRegister.setOnClickListener {
//            val isValid = !etCode.text.isEmpty() && !etFirstName.text.isEmpty() && !etLastName.text.isEmpty() && !etLastName2.text.isEmpty() &&
//                    (!etAge.text.isEmpty() && Integer.parseInt(etAge.text.toString()) > 0) &&
//                    spArea.selectedItemPosition > 0 && isSelectedRol
//            if (isValid) {
//
//            }
            firstName = etFirstName.text.toString()
            lastName = etLastName.toString()
            val intent = Intent(this, SecondActivity::class.java).apply {
                putExtra(NAME_KEY, firstName)
                putExtra(LAST_NAME_KEY, lastName)
            }
            startActivity(intent)
        }

    }


}


























