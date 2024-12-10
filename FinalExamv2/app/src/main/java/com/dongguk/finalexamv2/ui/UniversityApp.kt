package com.dongguk.finalexamv2.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dongguk.finalexamv2.data.University

@Composable
fun UniversityApp(universityList: List<University>) {
    val navController = rememberNavController() // Navigation Controller 생성

    NavHost(navController = navController, startDestination = "universityList") {
        composable("universityList") {
            UniversityListScreen(universityList = universityList, navController = navController)
        }
        composable("photo/{imageRes}") { backStackEntry ->
            val imageRes = backStackEntry.arguments?.getString("imageRes")?.toInt() ?: 0
            PhotoScreen(imageRes = imageRes)
        }
    }
}

@Composable
fun UniversityListScreen(universityList: List<University>, navController: NavController) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(universityList.size) { index ->
            val university = universityList[index]

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                shape = RoundedCornerShape(8.dp)
            ) {
                Row(
                    modifier = Modifier.padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = university.imageRes),
                        contentDescription = null,
                        modifier = Modifier
                            .size(80.dp)
                            .padding(end = 16.dp)
                            .clickable {
                                // 이미지 클릭 시 PhotoScreen으로 이동
                                navController.navigate("photo/${university.imageRes}")
                            },
                        contentScale = ContentScale.Crop
                    )
                    Column {
                        Text(text = university.name, fontSize = 20.sp)
                        Text(
                            text = "홈페이지: ${university.homepage}",
                            modifier = Modifier.clickable {
                                // 홈페이지 링크 처리
                                // 예시로 Intent 대체 가능 (Navigation에 맞게 변경)
                            }
                        )
                        Text(
                            text = "전화번호: ${university.phone}",
                            modifier = Modifier.clickable {
                                // 전화 링크 처리
                            }
                        )
                        Text(
                            text = "이메일: ${university.email}",
                            modifier = Modifier.clickable {
                                // 이메일 링크 처리
                            }
                        )
                    }
                }
            }
        }
    }
}