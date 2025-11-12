package com.eliz.papp.models

import org.jetbrains.compose.web.css.CSSSizeValue
import org.jetbrains.compose.web.css.CSSUnit
import org.jetbrains.compose.web.css.percent

enum class Skill(
    val title: String,
    val percentage: CSSSizeValue<CSSUnit.percent>
)
{
    English(
        title = "English",
        percentage = 85.percent
    ),
    Hungarian(
        title = "Hungarian",
        percentage = 100.percent
    ),
    Spanish(
        title = "Spanish",
        percentage = 25.percent
    ) //TODO?
    
    /*Creative(
        title = "Creative",
        percentage = 90.percent
    ),
    Accountable(
        title = "Accountable",
        percentage = 90.percent
    ),
    HardWorking(
        title = "Hard Working",
        percentage = 80.percent
    ),
    Value(
        title = "Value for Money",
        percentage = 85.percent
    ),
    Delivery(
        title = "On-Time Delivery",
        percentage = 75.percent
    )*/
}