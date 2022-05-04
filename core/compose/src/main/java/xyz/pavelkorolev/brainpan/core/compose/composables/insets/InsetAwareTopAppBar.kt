package xyz.pavelkorolev.brainpan.core.compose.composables.insets

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import com.google.accompanist.insets.ui.TopAppBar

/**
 * A [TopAppBar] implementation which content padded according to system bars size.
 * Event accompanist implementation doesn't set right system bars insets in landscape.
 */
@Composable
fun InsetAwareTopAppBar(
    title: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = WindowInsets.systemBars
        .only(WindowInsetsSides.Horizontal + WindowInsetsSides.Top)
        .asPaddingValues(),
    navigationIcon: @Composable (() -> Unit)? = null,
    actions: @Composable RowScope.() -> Unit = {},
    backgroundColor: Color = MaterialTheme.colors.primarySurface,
    contentColor: Color = contentColorFor(backgroundColor),
    elevation: Dp = AppBarDefaults.TopAppBarElevation,
) {
    TopAppBar(
        title = title,
        modifier = modifier,
        contentPadding = contentPadding,
        navigationIcon = navigationIcon,
        actions = actions,
        backgroundColor = backgroundColor,
        contentColor = contentColor,
        elevation = elevation,
    )
}
