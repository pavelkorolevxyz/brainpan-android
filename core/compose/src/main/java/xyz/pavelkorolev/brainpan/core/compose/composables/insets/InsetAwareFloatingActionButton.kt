package xyz.pavelkorolev.brainpan.core.compose.composables.insets

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape

/**
 * A [FloatingActionButton] implementation which is padded according to system bars size.
 * Event accompanist implementation doesn't set right system bars insets in landscape.
 */
@Composable
fun InsetAwareFloatingActionButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    shape: Shape = MaterialTheme.shapes.small.copy(CornerSize(percent = 50)),
    backgroundColor: Color = MaterialTheme.colors.secondary,
    contentColor: Color = contentColorFor(backgroundColor),
    elevation: FloatingActionButtonElevation = FloatingActionButtonDefaults.elevation(),
    content: @Composable () -> Unit,
) {
    FloatingActionButton(
        onClick = onClick,
        modifier = modifier.windowInsetsPadding(
            WindowInsets.systemBars.only(
                WindowInsetsSides.Horizontal + WindowInsetsSides.Bottom,
            ),
        ),
        interactionSource = interactionSource,
        shape = shape,
        backgroundColor = backgroundColor,
        contentColor = contentColor,
        elevation = elevation,
        content = content,
    )
}
