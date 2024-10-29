package com.harmony.helpscreen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.harmony.helpscreen.ui.theme.HelpScreenTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HelpScreenTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    HelpScreenApp()
                }
            }
        }
    }
}

@Composable
fun HelpScreenApp() {
    Column(
        Modifier
            .fillMaxWidth()
            .background(Color(0xFFD8BFD8))
    ) {
        HelpText(
            title = "PLAVE '기다릴게' 응원법",
            info = "이 글은 가수 '플레이브'의 노래 '기다릴게' 라는 곡의 응원법 가이드 입니다. ",
            description = "Whoa-oa, whoa Whoa-oa, whoa 매일 이렇게 난 늘 혼잣말을 해 always 기다릴게 Hello, 요즘 어때 그래 여전히 널 그리곤 해 수 백 번씩 준비한 birthday 아무 일도 없이 지나간 걸 Hello, 이 말을 못 하고 애써 난 무심한 척 너를 지나쳐갔어 oh-oh, uh-oh 절대 난 어울리지 않을 거란 말로 내 감정을 숨겼어 별 의미가 없잖아 널 향한 나의 맘이 점점 커져서 (기다릴게) 너의 그곳에 내가 닿을 수 있게 (기다릴게) 너의 곁에 내가 숨 쉴 수 있길 매일 이렇게 난 늘 혼잣말을 해 always Whoa-oa, whoa (wait for you) 여전히 whoa-oa, yeah (wait for you) 매일 이렇게 난 늘 혼잣말을 해 always 기다릴게 꽤나 오랜만인 것 같아 떠오르는 건 오직 잘 지냈냐는 말 밖에 아무 소식 없는 널 같은 자리에서 기다렸어 몇 번의 계절이 지나도 너 밖엔 생각나지 않고 아무것도 보이지가 않아 아무리 노력해 봐야 제자리만 맴돌아 시작이 다르더라도 괜찮아 난 항상 출발선에 멈춰 있으니까 (기다릴게) 너의 그곳에 내가 닿을 수 있게 (기다릴게) ",
            modifier = Modifier.weight(1f)
        )
    }
}

@Composable
fun HelpText(title: String, info: String, description: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = title,
            fontSize = 24.sp,
            modifier = Modifier
                .padding(16.dp)
        )
        Text(
            text = info,
            textAlign = TextAlign.Justify,
            modifier = Modifier
                .padding(16.dp, 0.dp, 16.dp, 0.dp)
        )
        Text(
            text = description,
            textAlign = TextAlign.Justify,
            modifier = Modifier
                .padding(16.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ComposeQuadrantAppPreview() {
    HelpScreenTheme {
        HelpScreenApp()
    }
}