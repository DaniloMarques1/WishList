package com.example.wishlist

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.wishlist.model.Wish

class AddWishActivity : AppCompatActivity() {
    private lateinit var wish: Wish
    private lateinit var btnAdd: Button
    private lateinit var btnCancel: Button
    private lateinit var edtDesc: EditText
    private lateinit var edtValue: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_wish)
        btnCancel = findViewById(R.id.add_wish_btn_cancel)
        btnAdd = findViewById(R.id.add_wish_btn_add)
        edtDesc = findViewById(R.id.add_wish_edt_desc)
        edtValue = findViewById(R.id.add_wish_edt_value)

        btnCancel.setOnClickListener {
            finish()
        }

        btnAdd.setOnClickListener {
            val desc = edtDesc.text.toString()
            val value = edtValue.text.toString().toFloat()
            wish = Wish(desc, value)
            val intent = Intent()
            intent.putExtra(WISH_KEY, wish)
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }

    companion object {
        val WISH_KEY = "wish"
    }
}