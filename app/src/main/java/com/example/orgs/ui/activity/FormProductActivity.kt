package com.example.orgs.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.example.orgs.R
import com.example.orgs.dao.ProductDAO
import com.example.orgs.model.Product
import java.math.BigDecimal

class FormProductActivity : AppCompatActivity(R.layout.activity_form_product) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        settingButtonSave()

    }

    private fun settingButtonSave() {
        val btnSalve = findViewById<Button>(R.id.btn_salvar)
        val dao = ProductDAO()

        btnSalve.setOnClickListener {
            val newProduct = createProduct()
            dao.addProduct(newProduct)
            finish()
        }
    }

    private fun createProduct(): Product {
        val fieldNome = findViewById<TextView>(R.id.et_nome)
        val etNome = fieldNome.text.toString()
        val fieldDesc = findViewById<TextView>(R.id.et_descricao)
        val desc = fieldDesc.text.toString()
        val fieldValor = findViewById<TextView>(R.id.et_valor)
        val valueBlank = fieldValor.text.toString()
        val value = if(valueBlank.isBlank()) {
            BigDecimal.ZERO
        } else {
            BigDecimal(valueBlank)
        }

        return Product(
            name = etNome,
            description = desc,
            value = value
        )
    }
}