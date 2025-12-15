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
import com.sightic.eyescansolosdkquickstart.ui.theme.EyeScanSoloSDKQuickstartTheme
import com.sightic.eyescansolosdkquickstart.ui.theme.Red
import com.sightic.eyescansolosdkquickstart.viewmodel.Action

@Composable
fun ErrorView(errorMessage: String, onAction: (Action) -> Unit) {
    Box(Modifier.fillMaxSize()) {
        Header(
            title = stringResource(R.string.error),
            subtitle = errorMessage,
            backgroundColor = Red,
        )
        HugeButton(
            text = stringResource(R.string.done),
            modifier = Modifier.align(Alignment.Center),
            onClick = { onAction.invoke(Action.OnDoneClicked) },
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun StartViewPreview() {
    EyeScanSoloSDKQuickstartTheme { ErrorView("Something went wrong...") {} }
}
