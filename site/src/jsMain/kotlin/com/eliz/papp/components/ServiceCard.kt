package com.eliz.papp.components

import androidx.compose.runtime.Composable
import com.eliz.papp.models.Service
import com.eliz.papp.models.Theme
import com.eliz.papp.styles.ServiceCardStyle
import com.eliz.papp.util.Constants
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.style.toModifier
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun ServiceCard(
    service: Service
)
{
    Column(
        modifier = ServiceCardStyle
                .toModifier()
                .maxWidth(300.px)
                .margin(all = 20.px)
                .padding(all = 20.px)
    ) {
        Box(
            modifier = Modifier
                    .id("iconBox")
                    .padding(all = 10.px)
                    .margin(bottom = 20.px)
                    .borderRadius(
                        topLeft = 0.px,
                        topRight = 20.px,
                        bottomLeft = 20.px,
                        bottomRight = 0.px
                    )
                    .border(
                        width = 2.px,
                        style = LineStyle.Solid,
                        color = Theme.Primary.rgb
                    )
        ) {
            Image(
                modifier = Modifier.size(40.px),
                src = service.icon,
                desc = service.imageDesc
            )
        }
        P(
            attrs = Modifier
                    .margin(
                        top = 0.px,
                        bottom = 10.px
                    )
                    .fillMaxWidth()
                    .fontFamily(Constants.FONT_FAMILY)
                    .fontSize(18.px)
                    .fontWeight(FontWeight.Bold)
                    .toAttrs()
        ) {
            Text(
                service.title
            )
        }
        P(
            attrs = Modifier
                    .margin(
                        top = 0.px,
                        bottom = 0.px
                    )
                    .fillMaxWidth()
                    .fontFamily(Constants.FONT_FAMILY)
                    .fontSize(14.px)
                    .fontWeight(FontWeight.Normal)
                    .toAttrs()
        ) {
            Text(
                service.description
            )
        }
    }
}