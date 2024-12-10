package com.dongguk.finalexamv2.data

import com.dongguk.finalexamv2.R

data class University(
    val name: String,
    val homepage: String,
    val phone: String,
    val email: String,
    val imageRes: Int
)

fun getUniversityData(): List<University> {
    return listOf(
        University(
            name = "공과대학",
            homepage = "https://engineer.dongguk.edu/",
            phone = "02-2260-3861",
            email = "woongsup@dongguk.edu",
            imageRes = R.drawable.university_image1
        ),
        University(
            name = "이과대학",
            homepage = "https://science.dongguk.edu/",
            phone = "02-2260-3746",
            email = "woongsup@dongguk.edu",
            imageRes = R.drawable.university_image2
        ),
        University(
            name = "경찰사법대학",
            homepage = "https://justice.dongguk.edu/",
            phone = "02-2260-3770",
            email = "policeadmin@dongguk.edu",
            imageRes = R.drawable.university_image2
        ),
        University(
            name = "경영대학",
            homepage = "https://sba.dongguk.edu/",
            phone = "02-2260-8886",
            email = "woongsup@dongguk.edu",
            imageRes = R.drawable.university_image2
        ),
        University(
            name = "바이오시스템대학",
            homepage = "https://life.dongguk.edu/",
            phone = "031-961-5103",
            email = "woongsup@dongguk.edu",
            imageRes = R.drawable.university_image2
        )
    )
}