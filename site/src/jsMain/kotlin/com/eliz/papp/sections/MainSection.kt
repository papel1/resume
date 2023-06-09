@file:Suppress("FunctionName")

package com.eliz.papp.sections

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.eliz.papp.components.Header
import com.eliz.papp.components.SocialBar
import com.eliz.papp.models.Section
import com.eliz.papp.models.Theme
import com.eliz.papp.styles.MainButtonStyle
import com.eliz.papp.styles.MainImageStyle
import com.eliz.papp.util.Constants.FONT_FAMILY
import com.eliz.papp.util.Constants.MAIN_TEXT
import com.eliz.papp.util.Constants.SECTION_WIDTH
import com.eliz.papp.util.Res
import com.varabyte.kobweb.compose.css.*
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.css.deg
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.*

@Composable
fun MainSection(onMenuClicked: () -> Unit)
{
    val breakpoint by rememberBreakpoint()
    Box(
        modifier = Modifier
                .id(Section.Home.id)
                .maxWidth(SECTION_WIDTH.px),
        contentAlignment = Alignment.TopCenter
    ) {
        MainBackground(breakpoint = breakpoint)
        MainContent(onMenuClicked = onMenuClicked)
    }
}

@Composable
fun MainBackground(breakpoint: Breakpoint)
{
    if (breakpoint <= Breakpoint.ZERO){
        Image(
            modifier = Modifier
                    .fillMaxSize()
                    .objectFit(ObjectFit.Cover),
            src = Res.Image.background_zero,
            desc = "Background Image ZERO"
        )
    } else if (breakpoint <= Breakpoint.SM) {
        Image(
            modifier = Modifier
                    .fillMaxSize()
                    .objectFit(ObjectFit.Cover),
            src = Res.Image.background_sm,
            desc = "Background Image SM"
        )
    }else {
        Image(
            modifier = Modifier
                    .fillMaxSize()
                    .objectFit(ObjectFit.Cover),
            src = Res.Image.background,
            desc = "Background Image"
        )
    }
}

@Composable
fun MainContent(onMenuClicked: () -> Unit)
{
    val breakpoint by rememberBreakpoint()
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Header(onMenuClicked = onMenuClicked)
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SimpleGrid(
                modifier = Modifier.fillMaxWidth(if (breakpoint >= Breakpoint.MD) 80.percent else 90.percent),
                numColumns = numColumns(
                    base = 1,
                    md = 2
                )
            ) {
                MainText(breakpoint = breakpoint)
                MainImage()
            }
        }
    }
}

@Composable
fun MainText(breakpoint: Breakpoint)
{
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (breakpoint > Breakpoint.MD)
        {
            SocialBar()
        }
        Column {
            P( //paragraph
                attrs = Modifier
                        .margin(topBottom = 0.px)
                        .fontFamily(FONT_FAMILY)
                        .fontSize(if (breakpoint >= Breakpoint.LG) 45.px else 20.px)
                        .fontWeight(FontWeight.Normal)
                        .color(Theme.Primary.rgb)
                        .toAttrs()
            ) {
                Text("Hi, I'm")
            }
            P(
                attrs = Modifier
                        .margin(
                            top = 20.px,
                            bottom = 0.px
                        )
                        .fontFamily(FONT_FAMILY)
                        .fontSize(if (breakpoint >= Breakpoint.LG) 68.px else 40.px)
                        .fontWeight(FontWeight.Bolder)
                        .color(Theme.Secondary.rgb)
                        .toAttrs()
            ) {
                Text("Elíz Papp")
            }
            P(
                attrs = Modifier
                        .margin(
                            top = 10.px,
                            bottom = 5.px
                        )
                        .fontFamily(FONT_FAMILY)
                        .fontSize(20.px)
                        .fontWeight(FontWeight.Bold)
                        .color(Theme.Secondary.rgb)
                        .toAttrs()
            ) {
                Text("Junior Software Developer")
            }
            P(
                attrs = Modifier
                        .margin(
                            bottom = 25.px
                        )
                        .maxWidth(400.px)
                        .fontFamily(FONT_FAMILY)
                        .fontSize(15.px)
                        .fontStyle(FontStyle.Italic)
                        .fontWeight(FontWeight.Normal)
                        .color(Theme.Secondary.rgb)
                        .toAttrs()
            ) {
                Text(
                    MAIN_TEXT
                )
            }
            Button(
                attrs = MainButtonStyle
                        .toModifier()
                        .height(40.px)
                        .border(width = 0.px)
                        .borderRadius(r = 5.px)
                        .backgroundColor(Theme.Secondary.rgb)
                        .color(Colors.White)
                        .cursor(Cursor.Pointer)
                        .toAttrs()
            ) {
                Link(
                    modifier = Modifier
                            .color(Colors.White)
                            .textDecorationLine(TextDecorationLine.None),
                    text = "Contact me!",
                    path = Section.Contact.path
                )
            }
        }
    }
}

@Composable
fun MainImage()
{
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier
                    .fillMaxSize(80.percent)
                    .fillMaxHeight()
        ) {
            Image(
                modifier = MainImageStyle
                        .toModifier()
                        .fillMaxWidth(),
                src = Res.Image.main_image,
                desc = "Main Image"
            )
        }
    }
}

