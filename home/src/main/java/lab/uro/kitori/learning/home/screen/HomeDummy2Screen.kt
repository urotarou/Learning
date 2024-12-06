package lab.uro.kitori.learning.home.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import lab.uro.kitori.learning.ui.theme.LearningTheme

@Composable
fun HomeDummy2Screen() {
    Scaffold(modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            contentAlignment = Alignment.Center,
        ) {
            Text(text = "dummy 2")
        }
    }
}

@Preview
@Composable
private fun PreviewHomeDummy2Screen() {
    LearningTheme {
        HomeDummy2Screen()
    }
}