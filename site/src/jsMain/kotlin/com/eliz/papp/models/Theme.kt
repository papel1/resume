package com.eliz.papp.models

import org.jetbrains.compose.web.css.CSSColorValue
import org.jetbrains.compose.web.css.rgb

enum class Theme(
    val hex: String,
    val rgb: CSSColorValue
)
{
    Primary(
        hex = "#005A64",
        rgb = rgb(
            r = 0,
            g = 90,
            b = 100
        )
    ),
    Secondary(
        hex = "#00383E",
        rgb = rgb(
            r = 0,
            g = 56,
            b = 62
        )
    ),
    Gray(
        hex = "#CFCFCF",
        rgb = rgb(
            r = 207,
            g = 207,
            b = 207
        )
    ),
    LightGray(
        hex = "#E6E6E6",
        rgb = rgb(
            r = 230,
            g = 230,
            b = 230
        )
    ),
    LighterGray(
        hex = "#F0F0F0",
        rgb = rgb(
            r = 240,
            g = 240,
            b = 240
        )
    )
}