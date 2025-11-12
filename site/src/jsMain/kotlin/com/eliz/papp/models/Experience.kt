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
        number = "02",
        jobPosition = "Software Engineer",
        description = "I designed the user interface of a custom tool developed to support the work of CAD engineers, ensuring it was intuitive and aligned with their daily workflows. On the backend side, I contributed to developing plugins and automation tools focused on parallelizing and accelerating test processes performed on component models.\nPreviously, I was actively involved in a database migration required for the company's vehicle production to a new system.\nI also participated in building the bases of an AWS platform, gaining hands-on experience with AWS, Kafka, Terraform, and GitLab CI/CD.",
        company = "Jaguar Land Rover Hungary Kft.",
        from = "June 2023",
        to = "Today",
        city = "Budapest"
    ),
    Second(
        number = "01",
        jobPosition = "Software Engineer Intern",
        description = "During my career at Bosch, I had the opportunity to learn to take part in different levels of our development. Mostly working on a Python web interface where we could provide the recorded data to different machine learning and validation teams.",
        company = "Robert Bosch Kft",
        from = "July 2022 ",
        to = "February 2023",
        city = "Budapest"
    ),
}
