package xyz.pavelkorolev.brainpan.core.compose

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import android.view.WindowInsets
import android.widget.FrameLayout
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.Fragment
import com.google.accompanist.insets.LocalWindowInsets
import com.google.accompanist.insets.ViewWindowInsetObserver

/**
 * A huge giant hack to help with https://github.com/chrisbanes/accompanist/issues/155.
 *
 * At the moment Compose will layout on the first [onMeasure] call. Now for fragments, they usually
 * will not receive [WindowInsets] (via [dispatchApplyWindowInsets] until the
 * second (or third) [onMeasure]. This creates the flicker.
 *
 * This class can be used in place of [ComposeView]. It ignores any [onMeasure] calls
 * until we've received some insets. This is dangerous though, as a view may never receive any
 * [WindowInsets] for valid reasons. To try and combat that, there's a limit to how many
 * [onMeasure] calls can be ignored.
 */
internal class FragmentInsetsComposeView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
) : FrameLayout(context, attrs, defStyleAttr) {

    private var measureCalls = 0
    private var applyInsetsRequested = false

    private val composeView: ComposeView = ComposeView(context).apply {
        setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
    }

    init {
        layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT,
        )
        addView(
            composeView,
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT,
        )
    }

    @Suppress("DEPRECATION")
    override fun requestFitSystemWindows() {
        applyInsetsRequested = true
        super.requestFitSystemWindows()
    }

    override fun dispatchApplyWindowInsets(insets: WindowInsets?): WindowInsets {
        return super.dispatchApplyWindowInsets(insets).also {
            applyInsetsRequested = false
        }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        if (measureCalls < MAXIMUM_ON_MEASURE_IGNORED && applyInsetsRequested) {
            setMeasuredDimension(
                MeasureSpec.getSize(widthMeasureSpec),
                MeasureSpec.getSize(heightMeasureSpec),
            )
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        }
        measureCalls++
    }

    /**
     * Set the Jetpack Compose UI content for this view.
     *
     * @see [ComposeView.setContent].
     */
    fun setContent(content: @Composable () -> Unit) = composeView.setContent(content)

    companion object {
        private const val MAXIMUM_ON_MEASURE_IGNORED = 5
    }
}

/**
 * Extension function to compose a [Fragment] with [ComposeView].
 */
fun Fragment.fragmentInsetsComposeView(
    context: Context? = getContext(),
    content: @Composable () -> Unit,
): View? {
    if (context == null) return null
    return FragmentInsetsComposeView(context).apply {
        val windowInsets = ViewWindowInsetObserver(this).start(consumeWindowInsets = false)
        setContent {
            CompositionLocalProvider(
                LocalWindowInsets provides windowInsets,
                content = content,
            )
        }
    }
}
