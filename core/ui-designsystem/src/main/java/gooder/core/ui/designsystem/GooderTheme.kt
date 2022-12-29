package gooder.core.ui.designsystem

import android.os.Build
import androidx.annotation.ChecksSdkIntAtLeast
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

@Composable
fun GooderTheme(
    useDarkColors: Boolean = isSystemInDarkTheme(),
    disableDynamicTheme: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = if (!disableDynamicTheme && supportDynamicTheming()) {
        val context = LocalContext.current
        if (useDarkColors) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
    } else {
        if (useDarkColors) GooderDarkColors else GooderLightColors
    }
    MaterialTheme(
        colorScheme = colorScheme,
        content = content
    )
}

@ChecksSdkIntAtLeast(api = Build.VERSION_CODES.S)
private fun supportDynamicTheming() = Build.VERSION.SDK_INT >= Build.VERSION_CODES.S
