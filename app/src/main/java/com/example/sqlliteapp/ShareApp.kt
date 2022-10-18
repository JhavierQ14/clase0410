package com.example.sqlliteapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast

class ShareApp : AppCompatActivity() {
    lateinit var etNombre:EditText
    lateinit var  etApellido:EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_share_app)


        etNombre = findViewById(R.id.et_Nombre)
        etApellido = findViewById(R.id.et_Apellido)

        var pref = getSharedPreferences(" datosPersona", Context.MODE_PRIVATE)
        var nombre = pref.getString("nombre","")
        var apellido = pref.getString("apellido","")
        etNombre.setText(nombre)
        etApellido.setText(apellido)

    }


    fun Guardar(vista: View){
        var pref = getSharedPreferences(" datosPersona", Context.MODE_PRIVATE)
        var editor = pref.edit()

        editor.putString("nombre", etNombre.text.toString())
        editor.putString("apellidos", etApellido.text.toString())
        editor.commit()
        Toast.makeText(this, "Tu registro ha sido exitoso",Toast.LENGTH_LONG).show()
    }

    }

