package xyz.pavelkorolev.brainpan.core.compose

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.Fragment

/**
 * Extension function to compose a [Fragment] with [ComposeView].
 */
fun Fragment.fragmentComposeView(
    compositionStrategy: ViewCompositionStrategy = ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed,
    context: Context? = getContext(),
    content: @Composable () -> Unit,
): ComposeView? {
    if (context == null) return null
    return ComposeView(context).apply {
        setViewCompositionStrategy(compositionStrategy)
        setContent(content)
    }
}
