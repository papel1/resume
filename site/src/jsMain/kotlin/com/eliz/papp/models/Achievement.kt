package com.eliz.papp.models

import com.eliz.papp.util.Res

enum class Achievement(
    val icon: String,
    val title: String,
    val description: String,
    val subdescription: String
)
{
    Diploma(
        icon = Res.Icon.diploma,
        title = "Computer Science Engineering, BSc",
        description = "Pázmány Péter Catholic University, Budapest",
        subdescription = "Finished in Jan 2023"
    ),
    HDiploma(
        icon = Res.Icon.hdiploma,
        title = "High School Diploma",
        description = "Eötvös József High School, Nyíregyháza",
        subdescription = "Finished in 2016"
    ),
    Ixdf_cert(
        icon = Res.Icon.ixdf,
        title = "Interaction Design Foundation",
        description = "User Experience: The Beginner's Guide\nDesign for a Better World with Don Norman\nDesign for the 21st Century with Don Norman",
        subdescription = "2025"
    ),
    Oracle_program(
        icon = Res.Icon.oracle,
        title = "Oracle Junior program",
        description = "",
        subdescription = "2019"
    ),
    Driving(
        icon = Res.Icon.driving,
        title = "Driving license",
        description = "Category B",
        subdescription = ""
    )
}
