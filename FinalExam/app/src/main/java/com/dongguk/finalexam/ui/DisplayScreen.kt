package com.dongguk.finalexam.ui

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dongguk.finalexam.ui.theme.Orange1
import com.dongguk.finalexam.ui.theme.Orange2
import com.dongguk.finalexam.ui.theme.Orange3

@Composable
fun DisplayScreen(viewModel: UserInputViewModel) {
    val userInputs by viewModel.userInputs.collectAsState()
    val context = LocalContext.current // Context를 가져옴

    LazyColumn(
        modifier = Modifier
            .background(Orange1)
            .fillMaxSize(),
    ) {
        items(userInputs) { user ->
            Card(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(), // fillMaxWidth로 수정
                colors = CardDefaults.cardColors(
                    containerColor = Orange3,
                    contentColor = Color.White
                )// 카드 배경색 지정
            ) {
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                ) {
                    // 이름 표시
                    Text("Name: ${user.name}")
                    // 전화번호 클릭 시 전화 앱으로 이동
                    Text(
                        text = "Phone: ${user.phoneNumber}",
                        modifier = Modifier
                            .clickable {
                                val intent = Intent(Intent.ACTION_DIAL).apply {
                                    data = Uri.parse("tel:${user.phoneNumber}")
                                }
                                context.startActivity(intent)
                            }
                            .padding(top = 4.dp)
                    )
                    // 이메일 클릭 시 이메일 앱으로 이동
                    Text(
                        text = "Email: ${user.email}",
                        modifier = Modifier
                            .clickable {
                                val intent = Intent(Intent.ACTION_SENDTO).apply {
                                    data = Uri.parse("mailto:${user.email}")
                                }
                                context.startActivity(intent)
                            }
                            .padding(top = 4.dp)
                    )
                }
            }
        }
    }
}

@Composable
@Preview
fun DisplayScreenPreview() {
    DisplayScreen(UserInputViewModel())
}