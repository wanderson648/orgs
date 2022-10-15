package com.example.orgs.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.orgs.R
import com.example.orgs.dao.ProductDAO
import com.example.orgs.ui.recyclerview.adapter.ListProductsAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val dao = ProductDAO()
    private val adapter = ListProductsAdapter(context = this, products = dao.getProducts())


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        settingRecyclerView()
    }

    override fun onResume() {
        super.onResume()
        adapter.update(dao.getProducts())
        settingFab()
    }



    private fun settingFab() {
        val fab = findViewById<FloatingActionButton>(R.id.addFab)
        fab.setOnClickListener {
            goToFormProducts()
        }
    }

    private fun goToFormProducts() {
        val intent = Intent(this, FormProductActivity::class.java)
        startActivity(intent)
    }

    private fun settingRecyclerView() {
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.adapter = adapter
    }

}