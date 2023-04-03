package com.eliz.papp.components

import androidx.compose.runtime.Composable
import com.eliz.papp.models.Theme
import com.eliz.papp.util.Constants.FONT_FAMILY
import com.varabyte.kobweb.compose.css.CSSTransition
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun SkillBar(
    name: String,
    index: Int,
    progressBarHeight: CSSSizeValue<CSSUnit.px> = 5.px,
    percentage: CSSSizeValue<CSSUnit.percent> = 50.percent,
    animatedPercentage: Int
)
{
    Column(
        modifier = Modifier
                .fillMaxWidth()
                .maxWidth(500.px)
                .margin(bottom = 10.px)
                .padding(topBottom = 5.px)
    ) {
        Row(
            modifier = Modifier
                    .fillMaxWidth()
                    .margin(
                        bottom = 5.px
                    ),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            P(
                attrs = Modifier
                        .margin(topBottom = 0.px)
                        .fontFamily(FONT_FAMILY)
                        .fontSize(18.px)
                        .fontWeight(FontWeight.Normal)
                        .color(Theme.Secondary.rgb)
                        .toAttrs()
            ) {
                Text(name)
            }
            P(
                attrs = Modifier
                        .margin(topBottom = 0.px)
                        .fontFamily(FONT_FAMILY)
                        .fontSize(18.px)
                        .fontWeight(FontWeight.Normal)
                        .color(Theme.Secondary.rgb)
                        .toAttrs()
            ) {
                Text("$animatedPercentage%")
            }
        }
        Box(modifier = Modifier.fillMaxWidth()) {
            Box(
                modifier = Modifier
                        .height(progressBarHeight)
                        .fillMaxWidth()
                        .backgroundColor(Theme.LightGray.rgb)
            )
            Box(
                modifier = Modifier
                        .height(progressBarHeight)
                        .fillMaxWidth(percentage)
                        .backgroundColor(Theme.Primary.rgb)
                        .transition(
                            CSSTransition(
                                property = "width",
                                duration = 1000.ms,
                                delay = 100.ms * index
                            )
                        )
            )
        }
    }
}