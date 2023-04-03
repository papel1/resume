package com.eliz.papp.styles

import com.eliz.papp.models.Theme
import com.varabyte.kobweb.compose.css.CSSTransition
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.hover
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.px

val ServiceCardStyle by ComponentStyle {
    base {
        Modifier
                .border(
                    width = 2.px,
                    style = LineStyle.Solid,
                    color = Theme.LighterGray.rgb
                )
                .borderRadius(r = 20.px)
                .transition(
                    CSSTransition(
                        property = "border",
                        duration = 200.ms
                    ),
                    CSSTransition(
                        property = "background",
                        duration = 200.ms
                    )
                )
                .backgroundColor(Colors.White)
    }
    hover {
        Modifier
                .border(
                    width = 2.px,
                    style = LineStyle.Solid,
                    color = Theme.Primary.rgb
                )
                .borderRadius(r = 20.px)
                .backgroundColor(Theme.Primary.rgb)
    }

    cssRule(" > #iconBox") {
        Modifier
                .backgroundColor(Colors.Transparent)
                .transition(
                    CSSTransition(
                        property = "background",
                        duration = 200.ms
                    )
                )
    }

    cssRule(":hover > #iconBox") {
        Modifier.backgroundColor(Colors.White)
    }

    cssRule(" > p") {
        Modifier
                .color(Theme.Secondary.rgb)
                .transition(
                    CSSTransition(
                        property = "color",
                        duration = 200.ms
                    )
                )
    }

    cssRule(":hover > p") {
        Modifier.color(Colors.White)
    }
}
