package com.example.sqlliteapp

import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    private lateinit var  etCodigo:EditText
    private lateinit var  etDescripcion:EditText
    private lateinit var  etPrecio:EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        etCodigo = findViewById(R.id.edt_Codigo)
        etDescripcion = findViewById(R.id.edt_Descipcion)
        etPrecio = findViewById(R.id.edt_Precio)


    }

//Funcion para registrar productos
    fun registrar (V: View) {

    //Se crea la conexión a la base de datos
        val  admin = AdminSQLite(this,"Tienda",null,1)
        val baseDeDatos:SQLiteDatabase = admin.writableDatabase

        val codigo = etCodigo.text.toString()
        val descripcion = etDescripcion.text.toString()
        val precio = etPrecio.text.toString()



    if (!codigo.isEmpty() && !descripcion.isEmpty() &&!precio.isEmpty()){
        val registro = ContentValues()
        registro.put("codigo",codigo)
        registro.put("descripcion",descripcion)
        registro.put("precio", precio)

        baseDeDatos.insert("articulos", null,registro)
        baseDeDatos.close()
        etCodigo.setText(" ")
        etDescripcion.setText(" ")
        etPrecio.setText(" ")

        Toast.makeText(this, "Tu registro ha sido exitoso",Toast.LENGTH_LONG).show()
    }else {
        Toast.makeText(this, "Debes llenar todos los campos para registrar",Toast.LENGTH_LONG).show()
    }
}



}