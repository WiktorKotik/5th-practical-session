package com.example.composetutorial

import androidx.annotation.DrawableRes

/** Сообщение чата: автор, текст и фото профиля. */
data class Message(
    val author: String,
    val body: String,
    @DrawableRes val avatar: Int
)
