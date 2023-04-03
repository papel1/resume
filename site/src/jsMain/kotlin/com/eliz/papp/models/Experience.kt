package com.eliz.papp.models

enum class Experience(
    val number: String,
    val jobPosition: String,
    val description: String,
    val company: String,
    val from: String,
    val to: String,
    val city: String
)
{
    First(
        number = "01",
        jobPosition = "Software Engineer Intern",
        description = "During my career at Bosch, I had the opportunity to learn to take part in different\n" + "levels of our development. Mostly working on a python web interface where we\n" + "could " + "provide the recorded data to different machine learning and validation teams.",
        company = "Robert Bosch Kft",
        from = "July 2022 ",
        to = "February 2023",
        city = "Budapest"
    ),
    //Second()
}