package com.sightic.eyescansolosdkquickstart.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContent
import androidx.compose.foundation.layout.windowInsetsTopHeight
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sightic.eyescansolosdkquickstart.ui.theme.EyeScanSoloSDKQuickstartTheme
import com.sightic.eyescansolosdkquickstart.ui.theme.Gray

@Composable
fun Header(title: String, subtitle: String, backgroundColor: Color = Gray) {
    Column(modifier = Modifier.fillMaxWidth().background(backgroundColor).padding(16.dp)) {
        Spacer(Modifier.windowInsetsTopHeight(WindowInsets.safeContent))
        CompositionLocalProvider(LocalContentColor provides Color.White) {
            Text(text = title, style = MaterialTheme.typography.headlineMedium)
            Text(text = subtitle, style = MaterialTheme.typography.titleMedium)
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun HeaderPreview() {
    EyeScanSoloSDKQuickstartTheme {
        Header("EyeScan Solo SDK Quickstart", "EyeScan Solo SDK version: 1.0.0")
    }
}
