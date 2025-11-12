package com.eliz.papp.components

import androidx.compose.runtime.Composable
import com.eliz.papp.models.Experience
import com.eliz.papp.models.Theme
import com.eliz.papp.util.Constants.FONT_FAMILY
import com.varabyte.kobweb.compose.css.CSSTransition
import com.varabyte.kobweb.compose.css.FontStyle
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Br
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.Text

@Composable
fun ExperienceCard(
    breakpoint: Breakpoint,
    active: Boolean = false,
    experience: Experience,
    animatedMargin: CSSSizeValue<CSSUnit.px>
)
{
    SimpleGrid(
        modifier = Modifier
                .fillMaxWidth()
                .maxWidth(
                    if (breakpoint >= Breakpoint.MD) 90.percent else 100.percent
                ),
        numColumns = numColumns(
            base = 1,
            md = 2
        )
    ) {
        ExperienceDescription(
            active = active,
            description = experience.description
        )
        ExperienceDetails(
            breakpoint = breakpoint,
            active = active,
            experience = experience,
            animatedMargin = animatedMargin
        )
    }
}

@Composable
fun ExperienceDescription(
    active: Boolean,
    description: String,
)
{
    Box(
        modifier = Modifier
                .fillMaxWidth()
                .margin(topBottom = 14.px)
                .borderRadius(r = 20.px)
                .padding(all = 14.px)
                .backgroundColor(if (active) Theme.Primary.rgb else Theme.LighterGray.rgb)
    ) {
        Column {
            val indentPx = 16
            description.split("\n").forEach { line ->
                P(
                    attrs = Modifier
                            .margin(topBottom = 0.px)
                            .fontFamily(FONT_FAMILY)
                            .fontSize(18.px)
                            .lineHeight(1.6)
                            .color(if (active) Colors.White else Theme.Secondary.rgb)
                            .fontWeight(FontWeight.Normal)
                            .toAttrs {
                                style {
                                    property("text-indent", "${indentPx}px")
                                }
                            }
                ) {
                    Text(line.trim())
                }
            }
        }
    }
}

@Composable
fun ExperienceDetails(
    breakpoint: Breakpoint,
    active: Boolean,
    experience: Experience,
    animatedMargin: CSSSizeValue<CSSUnit.px>
)
{
    Row(
        modifier = Modifier
                .fillMaxWidth()
                .margin(left = if (breakpoint >= Breakpoint.MD) 14.px else 0.px),
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (breakpoint >= Breakpoint.MD)
        {
            ExperienceNumber(
                active = active,
                experience = experience
            )
        }
        Column(
            modifier = Modifier
                    .fillMaxSize()
                    .margin(left = if (breakpoint <= Breakpoint.SM) 0.px else animatedMargin)
                    .transition(
                        CSSTransition(
                            property = "margin",
                            duration = 500.ms,
                            delay = experience.ordinal * 100.ms
                        )
                    ),
            verticalArrangement = Arrangement.Center
        ) {
            P(
                attrs = Modifier
                        .margin(
                            topBottom = 0.px
                        )
                        .fontFamily(FONT_FAMILY)
                        .fontSize(22.px)
                        .color(Theme.Secondary.rgb)
                        .fontWeight(FontWeight.Bold)
                        .toAttrs()
            ) {
                Text(
                    experience.jobPosition
                )
            }
            P(
                attrs = Modifier
                        .margin(
                            topBottom = 0.px
                        )
                        .fontFamily(FONT_FAMILY)
                        .fontSize(18.px)
                        .color(Theme.Primary.rgb)
                        .fontWeight(FontWeight.Normal)
                        .toAttrs()
            ) {
                Text(
                    experience.company
                )
            }
            P(
                attrs = Modifier
                        .margin(
                            topBottom = 0.px
                        )
                        .fontFamily(FONT_FAMILY)
                        .fontSize(16.px)
                        .color(Theme.Secondary.rgb)
                        .fontWeight(FontWeight.Normal)
                        .toAttrs()
            ) {
                Text(
                    "${experience.from} - ${experience.to}"
                )
            }
            P(
                attrs = Modifier
                        .margin(
                            topBottom = 0.px
                        )
                        .fontFamily(FONT_FAMILY)
                        .fontSize(16.px)
                        .color(Theme.Primary.rgb)
                        .fontWeight(FontWeight.Normal)
                        .fontStyle(FontStyle.Italic)
                        .toAttrs()
            ) {
                Text(
                    experience.city
                )
            }
        }
    }
}

@Composable
fun ExperienceNumber(
    active: Boolean,
    experience: Experience
)
{
    Box(
        modifier = Modifier
                .fillMaxHeight()
                .margin(right = 14.px),
        contentAlignment = Alignment.Center
    ) {
        Box( //Line
            modifier = Modifier
                    .fillMaxHeight()
                    .width(3.px)
                    .backgroundColor(Theme.Primary.rgb)
        )
        Box( //Circle
            modifier = Modifier
                    .size(40.px)
                    .border(
                        width = 3.px,
                        style = LineStyle.Solid,
                        color = Theme.Primary.rgb
                    )
                    .borderRadius(50.percent)
                    .backgroundColor(if (active) Theme.Primary.rgb else Colors.White),
            contentAlignment = Alignment.Center
        ) {
            P(
                attrs = Modifier
                        .margin(
                            topBottom = 0.px
                        )
                        .fontFamily(FONT_FAMILY)
                        .fontSize(16.px)
                        .color(if (active) Colors.White else Theme.Primary.rgb)
                        .fontWeight(FontWeight.Bold)
                        .toAttrs()
            ) {
                Text(
                    experience.number
                )
            }

        }
    }
}
