package com.eliz.papp.sections

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.eliz.papp.components.SocialBar
import com.eliz.papp.models.Section
import com.eliz.papp.models.Theme
import com.eliz.papp.styles.NavigationItemStyle
import com.eliz.papp.util.Constants.FONT_FAMILY
import com.eliz.papp.util.Constants.SECTION_WIDTH
import com.eliz.papp.util.Res
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px

@Composable
fun FooterSection()
{
    Box(
        modifier = Modifier
                .maxWidth(SECTION_WIDTH.px)
                .fillMaxWidth()
                .padding(topBottom = 50.px)
                .backgroundColor(Theme.LighterGray.rgb),
        contentAlignment = Alignment.Center
    ) {
        FooterContent()
    }
}

@Composable
fun FooterContent()
{
    val breakpoint by rememberBreakpoint()
    Column(
        modifier = Modifier.fillMaxWidth(
            if (breakpoint >= Breakpoint.MD) 100.percent
            else 90.percent
        ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            src = Res.Image.logo,
            desc = "Logo Image"
        )
        if (breakpoint > Breakpoint.SM)
        {
            Row(
                modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.px),
                horizontalArrangement = Arrangement.Center
            ) {
                FooterMenu()
            }
        } else
        {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                FooterMenu(row = false)
            }
        }
        SocialBar(row = true)
    }
}

@Composable
fun FooterMenu(row: Boolean = true)
{
    Section
            .values()
            .take(6)
            .forEach { section ->
                Link(
                    modifier = NavigationItemStyle
                            .toModifier()
                            .fontFamily(FONT_FAMILY)
                            .padding(
                                top = if (row) 0.px else 20.px,
                                right = if (row) 20.px else 0.px
                            )
                            .fontSize(12.px)
                            .fontWeight(FontWeight.Normal)
                            .textDecorationLine(TextDecorationLine.None),
                    path = section.path,
                    text = section.header_title
                )
            }
}