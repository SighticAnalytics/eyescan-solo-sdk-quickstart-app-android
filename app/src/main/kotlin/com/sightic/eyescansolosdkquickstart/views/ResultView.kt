package com.sightic.eyescansolosdkquickstart.views

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.sightic.eyescansolosdkquickstart.R
import com.sightic.eyescansolosdkquickstart.components.Header
import com.sightic.eyescansolosdkquickstart.components.HugeButton
import com.sightic.eyescansolosdkquickstart.ui.theme.Amber
import com.sightic.eyescansolosdkquickstart.ui.theme.EyeScanSoloSDKQuickstartTheme
import com.sightic.eyescansolosdkquickstart.ui.theme.Green
import com.sightic.eyescansolosdkquickstart.viewmodel.Action

@Composable
fun ResultView(hasImpairment: Boolean, onAction: (Action) -> Unit) {
    Box(Modifier.fillMaxSize()) {
        Header(
            title = stringResource(R.string.result),
            subtitle =
                when {
                    hasImpairment -> stringResource(R.string.scan_result_is_positive)
                    else -> stringResource(R.string.scan_result_is_negative)
                },
            backgroundColor =
                when {
                    hasImpairment -> Amber
                    else -> Green
                },
        )
        HugeButton(
            text = stringResource(R.string.done),
            modifier = Modifier.align(Alignment.Center),
            onClick = { onAction.invoke(Action.OnDoneClicked) },
        )
    }
}

@Preview(showSystemUi = true)
@Composable
private fun StartViewPositivePreview() {
    EyeScanSoloSDKQuickstartTheme { ResultView(true) {} }
}

@Preview(showSystemUi = true)
@Composable
private fun StartViewNegativePreview() {
    EyeScanSoloSDKQuickstartTheme { ResultView(false) {} }
}
