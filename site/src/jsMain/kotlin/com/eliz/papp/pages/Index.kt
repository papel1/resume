@file:Suppress("FunctionName")

package com.eliz.papp.pages

import androidx.compose.runtime.*
import com.eliz.papp.components.BackToTopButton
import com.eliz.papp.components.OverflowMenu
import com.eliz.papp.sections.*
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.core.Page

@Page
@Composable
fun HomePage()
{
    var menuOpened by remember { mutableStateOf(false) }

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            MainSection(onMenuClicked = {
                menuOpened = true
            })
            ServiceSection()
            PortfolioSection()
            AchievementsSection()
            ExperienceSection()
            AboutSection()
            ContactSection()
            FooterSection()
        }
        BackToTopButton()
        if (menuOpened)
        {
            OverflowMenu(onMenuClosed = {
                menuOpened = false
            })
        }
    }
}
