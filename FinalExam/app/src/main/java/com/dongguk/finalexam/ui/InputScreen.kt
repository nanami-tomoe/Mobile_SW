package com.dongguk.finalexam.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.dongguk.finalexam.R
import com.dongguk.finalexam.data.UserInput
import com.dongguk.finalexam.ui.theme.Orange1
import com.dongguk.finalexam.ui.theme.Orange2
import com.dongguk.finalexam.ui.theme.Orange3
import com.dongguk.finalexam.ui.theme.Orange4

@Composable
fun InputScreen(
    viewModel: UserInputViewModel = UserInputViewModel(),
    onNavigateToDisplay: () -> Unit
) {
    var name by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Orange1)
    ) {

        Image(
            painter = painterResource(id = R.drawable.title),
            contentDescription = "Title",
            modifier = Modifier
                .padding(start = 16.dp, top = 36.dp, end = 16.dp)
        )

        Spacer(modifier = Modifier.padding(8.dp))

        // 입력 필드
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("이름") },
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(8.dp)
        )

        Spacer(modifier = Modifier.padding(8.dp))

        OutlinedTextField(
            value = phone,
            onValueChange = { phone = it },
            label = { Text("전화번호") },
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(8.dp)
        )

        Spacer(modifier = Modifier.padding(8.dp))

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("이메일 주소") },
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(8.dp)
        )

        Spacer(modifier = Modifier.padding(8.dp))

        // 저장 버튼
        Button(
            onClick = {
                if (name.isNotBlank() && phone.isNotBlank() && email.isNotBlank()) {
                    viewModel.addUserInput(UserInput(name, phone, email))
                    name = ""
                    phone = ""
                    email = ""
                    onNavigateToDisplay()
                }
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Orange3, // Change to desired color
                contentColor = Color.White // Change to desired text color
            ),
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth()
        ) {
            Text("Save")
        }
    }
}

@Preview
@Composable
fun PreviewInputScreen() {
//    InputScreen()
}