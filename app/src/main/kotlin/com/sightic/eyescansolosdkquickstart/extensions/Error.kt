package com.sightic.eyescansolosdkquickstart.extensions

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.sightic.eyescansolosdk.error.AlignmentError
import com.sightic.eyescansolosdk.error.CameraPermissionDenied
import com.sightic.eyescansolosdk.error.DevicePerformance
import com.sightic.eyescansolosdk.error.InterruptedError
import com.sightic.eyescansolosdk.error.NoNetworkConnection
import com.sightic.eyescansolosdk.error.SighticError
import com.sightic.eyescansolosdk.error.TimedOut
import com.sightic.eyescansolosdk.error.UnexpectedError
import com.sightic.eyescansolosdk.error.UnsupportedDevice
import com.sightic.eyescansolosdkquickstart.R

@Composable
fun SighticError.asReadableError() =
    when (this) {
        AlignmentError.AltitudeTooHigh,
        AlignmentError.AltitudeTooLow,
        AlignmentError.AzimuthTooLeft,
        AlignmentError.AzimuthTooRight -> stringResource(R.string.error_alignment_notcentered)

        AlignmentError.PitchDown,
        AlignmentError.PitchUp,
        AlignmentError.YawLeft,
        AlignmentError.YawRight -> stringResource(R.string.error_alignment_notstraight)

        AlignmentError.NoFaceTracked -> stringResource(R.string.error_alignment_nofacetracked)
        AlignmentError.NotFollowingDot -> stringResource(R.string.error_alignment_notfollowingdot)
        AlignmentError.TooClose -> stringResource(R.string.error_alignment_tooclose)
        AlignmentError.TooFarAway -> stringResource(R.string.error_alignment_toofaraway)

        CameraPermissionDenied -> stringResource(R.string.error_nocamera_body)
        DevicePerformance -> stringResource(R.string.error_deviceperformance_body)
        InterruptedError -> stringResource(R.string.error_interrupted_body)
        NoNetworkConnection -> stringResource(R.string.error_nonetwork_body)
        TimedOut -> stringResource(R.string.error_timedout_body)

        is UnsupportedDevice -> stringResource(R.string.error_unsupporteddevice_body)

        is UnexpectedError -> {
            stringResource(R.string.error_unexpected_body) + "\n\n" + this.reason
        }

        else -> stringResource(R.string.error_generic_body)
    }
