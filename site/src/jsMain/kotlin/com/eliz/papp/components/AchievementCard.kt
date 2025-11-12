package com.eliz.papp.components

import androidx.compose.runtime.Composable
import com.eliz.papp.models.Achievement
import com.eliz.papp.models.Theme
import com.eliz.papp.util.Constants.FONT_FAMILY
import com.varabyte.kobweb.compose.css.FontStyle
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.graphics.Image
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Br
import org.jetbrains.compose.web.dom.Span
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun AchievementCard(
    modifier: Modifier = Modifier,
    achievement: Achievement
)
{
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = Modifier
                    .margin(right = 20.px)
                    .size(70.px),
            src = achievement.icon,
            desc = "Achievement Icon"
        )
        Column {
            P(
                attrs = Modifier
                        .margin(
                            topBottom = 0.px
                        )
                        .fillMaxWidth()
                        .fontFamily(FONT_FAMILY)
                        .fontSize(24.px)
                        .fontWeight(FontWeight.Bolder)
                        .color(Theme.Primary.rgb)
                        .toAttrs()
            ) {
                Text(
                    if (achievement == Achievement.Diploma) "${achievement.title}" else "${achievement.title}"
                )
            }
            Column {
                val lines = achievement.description.split("\n")
                val hangPx = 16
                lines.forEach { line ->
                    P(
                        attrs = Modifier
                                .margin(topBottom = 0.px)
                                .fillMaxWidth()
                                .fontFamily(FONT_FAMILY)
                                .fontSize(20.px)
                                .fontWeight(FontWeight.Normal)
                                .color(Theme.Secondary.rgb)
                                .opacity(50.percent)
                                .toAttrs {
                                    style {
                                        paddingLeft(hangPx.px)
                                        property("text-indent", "-${hangPx}px")
                                    }
                                }
                    ) {
                        Text(line.trim())
                    }
                }
            }
            P(
                attrs = Modifier
                        .margin(
                            topBottom = 0.px
                        )
                        .fillMaxWidth()
                        .fontFamily(FONT_FAMILY)
                        .fontSize(20.px)
                        .fontWeight(FontWeight.Normal)
                        .fontStyle(FontStyle.Italic)
                        .color(Theme.Secondary.rgb)
                        .opacity(50.percent)
                        .toAttrs()
            ) {
                Text(
                    achievement.subdescription
                )
            }
        }
    }
}
