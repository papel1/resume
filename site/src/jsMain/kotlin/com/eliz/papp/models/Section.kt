package com.eliz.papp.models

enum class Section(
    val id: String,
    val header_title: String,
    val title: String,
    val subtitle: String,
    val path: String
)
{
    Home(
        id = "home",
        header_title = "Home",
        title = "Home",
        subtitle = "",
        path = "#home"
    ),
    About(
        id = "about",
        header_title = "About",
        title = "About",
        subtitle = "Me?",
        path = "#about"
    ),
    Service(
        id = "service",
        header_title = "Skills",
        title = "My",
        subtitle = "Skills",
        path = "#service"
    ),
    Portfolio(
        id = "portfolio",
        header_title = "Portfolio",
        title = "Portfolio",
        subtitle = "My Projects",
        path = "#portfolio"
    ),
    Experience(
        id = "experience",
        header_title = "Experience",
        title = "Work",
        subtitle = "Experience",
        path = "#experience"
    ),
    Contact(
        id = "contact",
        header_title = "Contact",
        title = "Contact me",
        subtitle = "Personal Info's",
        path = "#contact"
    ),/*Testimonial(
        id = "testimonial",
        header_title = "Testimonial",
        title = "Testimonial",
        subtitle = "Happy Customers",
        path = "#testimonial"
    ),*/
    Achievements(
        id = "achievements",
        header_title = "Achievements",
        title = "Achievements",
        subtitle = "Personal Achievements",
        path = "#achievements"
    )
}