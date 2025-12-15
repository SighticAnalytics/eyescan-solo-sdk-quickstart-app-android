package com.sightic.eyescansolosdkquickstart.views

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.sightic.eyescansolosdk.LibraryVersion
import com.sightic.eyescansolosdkquickstart.R
import com.sightic.eyescansolosdkquickstart.components.Header
import com.sightic.eyescansolosdkquickstart.components.HugeButton
import com.sightic.eyescansolosdkquickstart.ui.theme.EyeScanSoloSDKQuickstartTheme
import com.sightic.eyescansolosdkquickstart.viewmodel.Action

@Composable
fun StartView(onAction: (Action) -> Unit) {
    Box(Modifier.fillMaxSize()) {
        Header(
            stringResource(R.string.app_name),
            stringResource(R.string.eyescan_solo_sdk_version, LibraryVersion.description),
        )
        HugeButton(
            text = stringResource(R.string.start_scan),
            modifier = Modifier.align(Alignment.Center),
            onClick = { onAction.invoke(Action.OnStartScanClicked) },
        )
    }
}

@Preview(showSystemUi = true)
@Composable
private fun StartViewPreview() {
    EyeScanSoloSDKQuickstartTheme { StartView {} }
}
