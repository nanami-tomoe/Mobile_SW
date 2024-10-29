package com.harmony.syntax

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.harmony.syntax.ui.theme.SyntaxTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SyntaxTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }

        var myBall= 4
        if (myBall > 3) {
            Log.d("Baseball", "Go to the first base.")
        } else {
            Log.d("Baseball", "Wait for the next ball.")
        }

        var now = 10

        when (now) {
            in 6..12 -> {
                Log.d("when", "현재 시간은 오전입니다.")
            }
            !in 6..12 -> {
                Log.d("when", "현재 시간은 오전이 아닙니다.")
            }
            else -> {
                Log.d("when", "현재 시간을 알 수 없습니다.")
            }
        }

        Log.d("문법", "로그를 출력합니다. Method = Log.d")
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SyntaxTheme {
        Greeting("Android")
    }
}