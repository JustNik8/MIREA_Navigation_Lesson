package com.justnik.mirea_navigation_lesson.enteties

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/*
Обычно в Котлине классы-сущности делать data классами
Почитать про data классы:
- https://metanit.com/kotlin/tutorial/4.12.php
- https://kotlinlang.ru/docs/data-classes.html
 */

@Parcelize
data class City (
    val name: String,
    val population: Int,
    val imageUrl: String
) : Parcelable