package com.eliz.papp.sections

import androidx.compose.runtime.*
import com.eliz.papp.components.SectionTitle
import com.eliz.papp.components.SkillBar
import com.eliz.papp.models.Section
import com.eliz.papp.models.Skill
import com.eliz.papp.models.Theme
import com.eliz.papp.styles.AboutTextStyle
import com.eliz.papp.util.Constants
import com.eliz.papp.util.Constants.FONT_FAMILY
import com.eliz.papp.util.Constants.SECTION_WIDTH
import com.eliz.papp.util.ObserveViewportEntered
import com.eliz.papp.util.animatePercentage
import com.varabyte.kobweb.compose.css.FontStyle
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import kotlinx.coroutines.launch
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun AboutSection()
{
    Box(
        modifier = Modifier
                .id(Section.About.id)
                .maxWidth(SECTION_WIDTH.px)
                .padding(topBottom = 150.px),
        contentAlignment = Alignment.Center
    ) {
        AboutContent()
    }
}

@Composable
fun AboutContent()
{
    val breakpoint by rememberBreakpoint()
    Column(
        modifier = Modifier.fillMaxWidth(if (breakpoint >= Breakpoint.MD) 100.percent else 90.percent)/*.maxWidth(1500.px)*/,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SimpleGrid(
            modifier = Modifier.fillMaxWidth(if (breakpoint >= Breakpoint.MD) 90.percent else 100.percent),
            numColumns = numColumns(
                base = 1,
                md = 2
            )
        ) {
            AboutHobby()
            AboutMe()
        }
    }
}

@Composable
fun AboutHobby()
{
    Column(
        modifier = Modifier
                .fillMaxWidth()
                .padding(right = 50.px),
        verticalArrangement = Arrangement.Top
    ) {
        SectionTitle(section = Section.About)

        //TODO: simplify
        P(
            attrs = Modifier
                    .margin(
                        top = 25.px,
                        bottom = 15.px
                    )
                    .fontFamily(FONT_FAMILY)
                    .fontSize(20.px)
                    .fontWeight(FontWeight.Bold)
                    .color(Theme.Primary.rgb)
                    .toAttrs()
        ) {
            Text("My hobbies in my spare time")
        }
        P(
            attrs = AboutTextStyle
                    .toModifier()
                    .margin(
                        top = 10.px
                    )
                    .fontFamily(FONT_FAMILY)
                    .fontSize(16.px)
                    .fontStyle(FontStyle.Italic)
                    .fontWeight(FontWeight.Normal)
                    .color(Theme.Secondary.rgb)
                    .toAttrs()
        ) {
            Text(
                Constants.ABOUT_HOBBY1
            )
        }
        P(
            attrs = AboutTextStyle
                    .toModifier()
                    .margin(
                        top = 10.px
                    )
                    .fontFamily(FONT_FAMILY)
                    .fontSize(16.px)
                    .fontStyle(FontStyle.Italic)
                    .fontWeight(FontWeight.Normal)
                    .fontStyle(FontStyle.Italic)
                    .color(Theme.Secondary.rgb)
                    .toAttrs()
        ) {
            Text(
                Constants.ABOUT_HOBBY2
            )
        }
        P(
            attrs = AboutTextStyle
                    .toModifier()
                    .margin(
                        top = 10.px
                    )
                    .fontFamily(FONT_FAMILY)
                    .fontSize(16.px)
                    .fontStyle(FontStyle.Italic)
                    .fontWeight(FontWeight.Normal)
                    .fontStyle(FontStyle.Italic)
                    .color(Theme.Secondary.rgb)
                    .toAttrs()
        ) {
            Text(
                Constants.ABOUT_HOBBY3
            )
        }
        P(
            attrs = AboutTextStyle
                    .toModifier()
                    .margin(
                        top = 10.px
                    )
                    .fontFamily(FONT_FAMILY)
                    .fontSize(16.px)
                    .fontStyle(FontStyle.Italic)
                    .fontWeight(FontWeight.Normal)
                    .fontStyle(FontStyle.Italic)
                    .color(Theme.Secondary.rgb)
                    .toAttrs()
        ) {
            Text(
                Constants.ABOUT_HOBBY4
            )
        }
    }
}

@Composable
fun AboutMe()
{
    val scope = rememberCoroutineScope()
    var viewportEntered by remember { mutableStateOf(false) }
    val animatedPercentage = remember {
        mutableStateListOf(
            0,
            0,
            0
        )
    }

    ObserveViewportEntered(
        sectionId = Section.About.id,
        distanceFromTop = 200.0
    ) {
        viewportEntered = true
        Skill
                .values()
                .forEach { skill ->
                    scope.launch {
                        animatePercentage(percent = skill.percentage.value.toInt(),
                                          onUpdate = {
                                              animatedPercentage[skill.ordinal] = it
                                          })
                    }

                }
    }
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center
    ) {
        P(
            attrs = Modifier
                    .margin(
                        top = 112.px,
                        bottom = 14.px
                    )
                    .fontFamily(FONT_FAMILY)
                    .maxWidth(500.px)
                    .fontSize(20.px)
                    .fontWeight(FontWeight.Bold)
                    .color(Theme.Primary.rgb)
                    .toAttrs()
        ) {
            Text("Languages")
        }

        Skill
                .values()
                .forEach { skill ->
                    SkillBar(
                        name = skill.title,
                        index = skill.ordinal,
                        percentage = if (viewportEntered) skill.percentage else 0.percent,
                        animatedPercentage = if (viewportEntered) animatedPercentage[skill.ordinal] else 0
                    )
                }
    }
}