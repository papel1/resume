package com.eliz.papp.sections

import androidx.compose.runtime.*
import com.eliz.papp.components.AchievementCard
import com.eliz.papp.models.Achievement
import com.eliz.papp.models.Section
import com.eliz.papp.models.Theme
import com.eliz.papp.util.Constants.SECTION_WIDTH
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.css.px

@Composable
fun AchievementsSection()
{
    val breakpoint by rememberBreakpoint()
    Box(
        modifier = Modifier
                .id(Section.Achievements.id)
                .maxWidth(SECTION_WIDTH.px)
                .padding(topBottom = 100.px)
                .backgroundColor(Theme.LighterGray.rgb)
                .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        AchievementsContent(breakpoint = breakpoint)
    }
}

@Composable
fun AchievementsContent(breakpoint: Breakpoint)
{
    SimpleGrid(
        numColumns = numColumns(
            base = 1,
            md = 2,
            lg = 4
        ),
        modifier = Modifier.margin(left = if (breakpoint > Breakpoint.SM) 50.px else 0.px)
    ) {
        Achievement
                .values()
                .forEach { achievement ->
                    AchievementCard(
                        modifier = Modifier.margin(
                            left = 0.px,
                            right = if (achievement == Achievement.Driving) 0.px
                            else
                            {
                                if (breakpoint > Breakpoint.SM) 40.px else 0.px
                            },
                            bottom = if (breakpoint > Breakpoint.MD) 0.px else 40.px
                        ),
                        achievement = achievement
                    )
                }
    }
}