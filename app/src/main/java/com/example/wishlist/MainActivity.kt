package com.example.wishlist

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import com.example.wishlist.model.Wish
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private lateinit var btnForm: FloatingActionButton
    private lateinit var lvWishes: ListView
    private val wishes: MutableList<Wish> = mutableListOf()
    private lateinit var adapter: ArrayAdapter<Wish>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnForm = findViewById(R.id.main_float_add)
        lvWishes = findViewById(R.id.main_lv_wishes)

        btnForm.setOnClickListener {
            val intent = Intent(this, AddWishActivity::class.java)
            startActivityForResult(intent, ADD_WISH_INTENT)
        }

        val layout = android.R.layout.simple_list_item_1
        adapter = ArrayAdapter<Wish>(this, layout, wishes)
        lvWishes.adapter = adapter
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == ADD_WISH_INTENT && resultCode == Activity.RESULT_OK) {
            data?.let {
               //TODO
                val wish = it.getSerializableExtra(AddWishActivity.WISH_KEY) as Wish
                wishes.add(wish)
                adapter.notifyDataSetChanged()
            }
        }
    }

    companion object {
        val ADD_WISH_INTENT = 1
    }

}