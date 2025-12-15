package com.sightic.eyescansolosdkquickstart.views

import androidx.compose.runtime.Composable
import com.sightic.eyescansolosdk.SighticView
import com.sightic.eyescansolosdkquickstart.viewmodel.Action

@Composable
fun ScanView(onAction: (Action) -> Unit) {
    SighticView { onAction.invoke(Action.OnResultReceived(it)) }
}
