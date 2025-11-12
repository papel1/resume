package com.eliz.papp.models

import com.eliz.papp.util.Constants.SERVICE_TEXT1
import com.eliz.papp.util.Constants.SERVICE_TEXT2
import com.eliz.papp.util.Constants.SERVICE_TEXT3
import com.eliz.papp.util.Constants.SERVICE_TEXT4
import com.eliz.papp.util.Constants.SERVICE_TEXT5
import com.eliz.papp.util.Constants.SERVICE_TEXT6
import com.eliz.papp.util.Constants.SERVICE_TEXT7
import com.eliz.papp.util.Constants.SERVICE_TEXT8
import com.eliz.papp.util.Res

enum class Service(
    val icon: String,
    val imageDesc: String,
    val title: String,
    val description: String
)
{
    programing_languages(
        icon = Res.Icon.programing_languages,
        imageDesc = "Programming languages",
        title = "Programming languages",
        description = SERVICE_TEXT1
    ),
    database(
        icon = Res.Icon.database,
        imageDesc = "Database",
        title = "Database",
        description = SERVICE_TEXT2
    ),
    design(
        icon = Res.Icon.design,
        imageDesc = "Design and Prototyping Tools",
        title = "Design and Prototyping Tools",
        description = SERVICE_TEXT3
    ),
    operating_systems(
        icon = Res.Icon.operating_systems,
        imageDesc = "Operating systems",
        title = "Operating systems",
        description = SERVICE_TEXT4
    ),
    development_environments(
        icon = Res.Icon.development_environments,
        imageDesc = "Development environments",
        title = "Development environments",
        description = SERVICE_TEXT5
    ),
    cloud_and_devops(
        icon = Res.Icon.cloud_and_devops,
        imageDesc = "Cloud and DevOps",
        title = "Cloud and DevOps",
        description = SERVICE_TEXT6
    ),
    dev_platforms(
        icon = Res.Icon.dev_platforms,
        imageDesc = "Development platforms",
        title = "Development platforms",
        description = SERVICE_TEXT7
    ),
    version_control_systems(
        icon = Res.Icon.version_control_systems,
        imageDesc = "Version control systems",
        title = "Version control systems",
        description = SERVICE_TEXT8
    )
}
