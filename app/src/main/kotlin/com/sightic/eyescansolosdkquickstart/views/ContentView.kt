package com.sightic.eyescansolosdkquickstart.views

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.sightic.eyescansolosdk.error.AlignmentError
import com.sightic.eyescansolosdkquickstart.extensions.asReadableError
import com.sightic.eyescansolosdkquickstart.extensions.asReadableStatus
import com.sightic.eyescansolosdkquickstart.ui.theme.EyeScanSoloSDKQuickstartTheme
import com.sightic.eyescansolosdkquickstart.viewmodel.Action
import com.sightic.eyescansolosdkquickstart.viewmodel.Screen

@Composable
fun ContentView(screen: Screen, onAction: (Action) -> Unit) {
    when (screen) {
        is Screen.Start -> StartView(onAction)
        is Screen.Scan -> ScanView(onAction)
        is Screen.Inference -> InferenceView()
        is Screen.Result -> ResultView(screen.hasImpairment, onAction)
        is Screen.Error -> ErrorView(screen.error.asReadableError(), onAction)
        is Screen.DeviceUnsupported -> DeviceUnsupportedView(screen.status.asReadableStatus())
        Screen.Loading -> LoadingView()
    }
}

@Preview(showBackground = true)
@Composable
private fun ContentViewPreview() {
    EyeScanSoloSDKQuickstartTheme { ContentView(screen = Screen.Start, onAction = {}) }
}

@Preview(showBackground = true)
@Composable
private fun ContentViewInferencePreview() {
    EyeScanSoloSDKQuickstartTheme { ContentView(screen = Screen.Inference, onAction = {}) }
}

@Preview(showBackground = true)
@Composable
private fun ContentViewResultPositivePreview() {
    EyeScanSoloSDKQuickstartTheme { ContentView(screen = Screen.Result(true), onAction = {}) }
}

@Preview(showBackground = true)
@Composable
private fun ContentViewResultNegativePreview() {
    EyeScanSoloSDKQuickstartTheme { ContentView(screen = Screen.Result(false), onAction = {}) }
}

@Preview(showBackground = true)
@Composable
private fun ContentViewErrorPreview() {
    EyeScanSoloSDKQuickstartTheme {
        ContentView(screen = Screen.Error(AlignmentError.AltitudeTooLow), onAction = {})
    }
}
