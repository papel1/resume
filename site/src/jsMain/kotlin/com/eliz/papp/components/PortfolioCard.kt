package com.eliz.papp.components

import androidx.compose.runtime.Composable
import com.eliz.papp.models.Portfolio
import com.eliz.papp.models.Theme
import com.eliz.papp.styles.PortfolioSectionStyle
import com.eliz.papp.util.Constants.FONT_FAMILY
import com.eliz.papp.util.Res
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.ObjectFit
import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Color
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.navigation.OpenLinkStrategy
import com.varabyte.kobweb.silk.components.navigation.Link
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.style.toModifier

@Composable
fun PortfolioCard(
    modifier: Modifier = Modifier,
    portfolio: Portfolio
)
{
    Link(
        modifier = PortfolioSectionStyle
                .toModifier()
                .textDecorationLine(TextDecorationLine.None),
        path = portfolio.link,
        openExternalLinksStrategy = OpenLinkStrategy.IN_NEW_TAB
    ) {
        Column(
            modifier = modifier.id("columnParent")

        ) {
            Box(
                modifier = Modifier
                        .id("boxParent")
                        .fillMaxWidth()
                        .maxWidth(300.px)
                        .margin(bottom = 20.px),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    modifier = Modifier
                            .size(300.px)
                            .objectFit(ObjectFit.Cover),
                    src = portfolio.image,
                    desc = "Portfolio Image"
                )
                Box(
                    modifier = Modifier
                            .id("greenOverlay")
                            .fillMaxHeight()
                            .backgroundColor(
                                Color.argb(
                                    a = 0.5f,
                                    r = 0,
                                    g = 90,
                                    b = 100
                                )
                            ),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        modifier = Modifier
                                .id("linkIcon")
                                .size(32.px),
                        src = Res.Icon.link,
                        desc = "Link Icon"
                    )
                }
            }
            P(
                attrs = Modifier
                        .id("portfolioTitle")
                        .margin(
                            topBottom = 0.px
                        )
                        .fillMaxWidth()
                        .maxWidth(275.px)
                        .fontFamily(FONT_FAMILY)
                        .fontSize(20.px)
                        .fontWeight(FontWeight.Bold)
                        .toAttrs()
            ) {
                Text(
                    portfolio.title
                )
            }
            P(
                attrs = Modifier
                        .id("portfolioDesc")
                        .margin(
                            topBottom = 0.px
                        )
                        .fillMaxWidth()
                        .maxWidth(275.px)
                        .fontFamily(FONT_FAMILY)
                        .fontSize(16.px)
                        .fontWeight(FontWeight.Normal)
                        .opacity(50.percent)
                        .color(Theme.Secondary.rgb)
                        .toAttrs()
            ) {
                Text(
                    portfolio.description
                )
            }
        }
    }
}