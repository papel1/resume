package com.eliz.papp.models

import com.eliz.papp.util.Constants.SERVICE_TEXT1
import com.eliz.papp.util.Constants.SERVICE_TEXT2
import com.eliz.papp.util.Constants.SERVICE_TEXT3
import com.eliz.papp.util.Constants.SERVICE_TEXT4
import com.eliz.papp.util.Constants.SERVICE_TEXT5
import com.eliz.papp.util.Constants.SERVICE_TEXT6
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
        imageDesc = "Programing languages",
        title = "Programing languages",
        description = SERVICE_TEXT1
    ),
    database(
        icon = Res.Icon.database,
        imageDesc = "Database",
        title = "Database",
        description = SERVICE_TEXT2
    ),
    operating_systems(
        icon = Res.Icon.operating_systems,
        imageDesc = "Operating systems",
        title = "Operating systems",
        description = SERVICE_TEXT3
    ),
    development_environments(
        icon = Res.Icon.development_environments,
        imageDesc = "Development environments",
        title = "Development environments",
        description = SERVICE_TEXT4
    ),
    other_technologies(
        icon = Res.Icon.other_technologies,
        imageDesc = "Other technologies",
        title = "Other technologies",
        description = SERVICE_TEXT5
    ),
    version_control_systems(
        icon = Res.Icon.version_control_systems,
        imageDesc = "Version control systems",
        title = "Version control systems",
        description = SERVICE_TEXT6
    )
}