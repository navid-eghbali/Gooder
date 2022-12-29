package app.gooder.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import gooder.core.ui.compose.DevicePreviews
import gooder.core.ui.designsystem.GooderTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GooderTheme {
                Greeting()
            }
        }
    }
}

@Composable
fun Greeting() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Text(
            text = "Hello World!",
            modifier = Modifier.padding(16.dp)
        )
    }
}

@DevicePreviews
@Composable
fun DefaultPreview() {
    GooderTheme {
        Greeting()
    }
}
