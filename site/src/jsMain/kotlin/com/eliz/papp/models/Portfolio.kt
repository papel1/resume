package com.eliz.papp.models

import com.eliz.papp.util.Constants.GITHUB
import com.eliz.papp.util.Constants.GITHUB_covidsim
import com.eliz.papp.util.Constants.GITHUB_naturesarm
import com.eliz.papp.util.Res
import kotlinx.coroutines.internal.AbstractAtomicDesc
import kotlinx.coroutines.internal.OpDescriptor

enum class Portfolio(
    val image: String,
    val title: String,
    val description: String,
    val link: String
)
{
    One(
        image = Res.Image.portfolio1,
        title = "Allocation of COVID-19 vaccines in Hungary (Thesis)",
        description = "Matching problem where on one side we have the Hungarian population and on the other vaccines " + "" + "with different parameters and accessibility.",
        link = GITHUB_covidsim
    ),
    Two(
        image = Res.Image.portfolio2,
        title = "Nature’s Arm",
        description = "Nature’s Arm is an android application with which the user can manage, organize and care of " + "their little green friends! Further functionalities: QR based identification, luminescence measurement, needs for survival.",
        link = GITHUB_naturesarm
    ),
    Three(
        image = Res.Image.portfolio3,
        title = "FocusLearner",
        description = "A software which can detect if an image is in focus or not. Implemented with the help of " + "Pytorch library, based on VGG.",
        link = GITHUB
    ),
    Four(
        image = Res.Image.portfolio4,
        title = "Jatacka",
        description = "Java, JavaFX Zatacka game.",
        link = GITHUB
    ),
    Five(
        image = Res.Image.portfolio5,
        title = "EGUI",
        description = "C++ widget library made from scratch with OpenGL.",
        link = GITHUB
    )
}