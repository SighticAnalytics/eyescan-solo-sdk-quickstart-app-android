package com.sightic.eyescansolosdkquickstart

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sightic.eyescansolosdk.SighticSupportedDevice
import com.sightic.eyescansolosdkquickstart.viewmodel.Action
import com.sightic.eyescansolosdkquickstart.viewmodel.MainViewModel
import com.sightic.eyescansolosdkquickstart.views.ContentView
import kotlinx.coroutines.launch

@Composable
fun MainScreen() {
    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    val viewModel = viewModel<MainViewModel>()
    val screen by viewModel.screen.collectAsStateWithLifecycle()

    LaunchedEffect(scope) {
        scope.launch {
            val status = SighticSupportedDevice.status(context)
            viewModel.onAction(Action.OnDeviceSupportedStatusReceived(status))
        }
    }

    ContentView(screen = screen, onAction = viewModel::onAction)
}
