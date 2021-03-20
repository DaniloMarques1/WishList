package com.example.wishlist.model

import java.io.Serializable

data class Wish(val description: String, val value: Float): Serializable {
    override fun toString(): String {
        return "${this.description} - R$ ${this.value}"
    }
}