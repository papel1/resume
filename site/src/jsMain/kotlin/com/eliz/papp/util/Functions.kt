package com.eliz.papp.util

import androidx.compose.runtime.*
import kotlinx.browser.document
import kotlinx.browser.window
import kotlinx.coroutines.delay
import org.w3c.dom.events.EventListener

@Composable
fun ObserveViewportEntered(
    sectionId: String,
    distanceFromTop: Double,
    onViewportEntered: () -> Unit
)
{
    var viewportEntered by remember { mutableStateOf(false) }

    // Shared check used by both initial and event-driven paths
    fun updateFromCurrent() {
        val top = document
                .getElementById(sectionId)
                ?.getBoundingClientRect()?.top
        if (top != null && top < distanceFromTop) {
            viewportEntered = true
        }
    }

    // Create a single listener instance we can add/remove
    val listener = remember {
        EventListener { updateFromCurrent() }
    }

    // Attach listeners and perform initial checks
    LaunchedEffect(sectionId) {
        window.addEventListener(type = "scroll", callback = listener)
        window.addEventListener(type = "resize", callback = listener)

        // Immediate check in case the section is already in view
        updateFromCurrent()
        // Fallback check shortly after mount to ensure DOM is ready
        delay(150)
        updateFromCurrent()
    }

    // Invoke callback and detach listeners once entered
    LaunchedEffect(viewportEntered) {
        if (viewportEntered) {
            onViewportEntered()
            window.removeEventListener(type = "scroll", callback = listener)
            window.removeEventListener(type = "resize", callback = listener)
        }
    }

    // Ensure cleanup if this composable leaves composition
    DisposableEffect(sectionId) {
        onDispose {
            window.removeEventListener(type = "scroll", callback = listener)
            window.removeEventListener(type = "resize", callback = listener)
        }
    }
}

suspend fun animatePercentage(
    percent: Int,
    delay: Long = 10L,
    onUpdate: (Int) -> Unit
)
{
    (0 .. percent).forEach {
        delay(delay)
        onUpdate(it)
    }
}
