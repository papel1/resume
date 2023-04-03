package com.eliz.papp.sections

import androidx.compose.runtime.*
import com.eliz.papp.components.SectionTitle
import com.eliz.papp.models.Section
import com.eliz.papp.models.Theme
import com.eliz.papp.util.Constants.ADDRESS
import com.eliz.papp.util.Constants.ADDRESS_TEXT
import com.eliz.papp.util.Constants.FONT_FAMILY
import com.eliz.papp.util.Constants.MAIL
import com.eliz.papp.util.Constants.MAIL_TEXT
import com.eliz.papp.util.Constants.PHONE
import com.eliz.papp.util.Constants.PHONE_TEXT
import com.eliz.papp.util.Constants.SECTION_WIDTH
import com.eliz.papp.util.ObserveViewportEntered
import com.varabyte.kobweb.compose.css.CSSTransition
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.jetbrains.compose.web.ExperimentalComposeWebApi
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.P
import org.jetbrains.compose.web.dom.Text

@Composable
fun ContactSection()
{
    Box(
        modifier = Modifier
                .id(Section.Contact.id)
                .maxWidth(SECTION_WIDTH.px)
                .fillMaxWidth()
                .padding(topBottom = 100.px)
                .backgroundColor(Theme.LighterGray.rgb),
        contentAlignment = Alignment.Center
    ) {
        ContactContent()
    }
}

@OptIn(ExperimentalComposeWebApi::class)
@Composable
fun ContactContent() //TODO: ContactForm
{
    val breakpoint by rememberBreakpoint()
    val scope = rememberCoroutineScope()
    var animatedRotation by remember { mutableStateOf(0.deg) }

    ObserveViewportEntered(sectionId = Section.Contact.id,
                           distanceFromTop = 500.0,
                           onViewportEntered = {
                               animatedRotation = 10.deg
                               scope.launch {
                                   delay(500)
                                   animatedRotation = 0.deg
                               }
                           })

    Column(
        modifier = Modifier.fillMaxWidth(
            if (breakpoint >= Breakpoint.MD) 100.percent
            else 90.percent
        ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SectionTitle(modifier = Modifier
                .margin(bottom = 25.px)
                .fillMaxWidth()
                .transform { rotate(animatedRotation) }
                .transition(
                    CSSTransition(
                        property = "transform",
                        duration = 500.ms
                    )
                ),
                     section = Section.Contact,
                     alignment = Alignment.CenterHorizontally)
        P(
            attrs = Modifier
                    .margin(
                        topBottom = 0.px
                    )
                    .fontFamily(FONT_FAMILY)
                    .fontSize(20.px)
                    .color(Theme.Secondary.rgb)
                    .fontWeight(FontWeight.Bold)
                    .toAttrs()
        ) {
            Text(
                MAIL_TEXT
            )
        }
        P(
            attrs = Modifier
                    .margin(
                        bottom = 14.px
                    )
                    .fontFamily(FONT_FAMILY)
                    .fontSize(18.px)
                    .color(Theme.Primary.rgb)
                    .fontWeight(FontWeight.Normal)
                    .toAttrs()
        ) {
            Text(
                MAIL //TODO: send mail
            )
        }
        P(
            attrs = Modifier
                    .margin(
                        topBottom = 0.px
                    )
                    .fontFamily(FONT_FAMILY)
                    .fontSize(20.px)
                    .color(Theme.Secondary.rgb)
                    .fontWeight(FontWeight.Bold)
                    .toAttrs()
        ) {
            Text(
                PHONE_TEXT
            )
        }
        P(
            attrs = Modifier
                    .margin(
                        bottom = 14.px
                    )
                    .fontFamily(FONT_FAMILY)
                    .fontSize(18.px)
                    .color(Theme.Primary.rgb)
                    .fontWeight(FontWeight.Normal)
                    .toAttrs()
        ) {
            Text(
                PHONE //TODO: make call
            )
        }
        P(
            attrs = Modifier
                    .margin(
                        topBottom = 0.px
                    )
                    .fontFamily(FONT_FAMILY)
                    .fontSize(20.px)
                    .color(Theme.Secondary.rgb)
                    .fontWeight(FontWeight.Bold)
                    .toAttrs()
        ) {
            Text(
                ADDRESS_TEXT
            )
        }
        P(
            attrs = Modifier
                    .margin(
                        bottom = 25.px
                    )
                    .fontFamily(FONT_FAMILY)
                    .fontSize(18.px)
                    .color(Theme.Primary.rgb)
                    .fontWeight(FontWeight.Normal)
                    .toAttrs()
        ) {
            Text(
                ADDRESS //TODO: see on map
            )
        }
    }
}


