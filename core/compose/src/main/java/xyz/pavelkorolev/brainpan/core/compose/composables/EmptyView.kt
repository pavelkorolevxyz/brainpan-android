package xyz.pavelkorolev.brainpan.core.compose.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import xyz.pavelkorolev.brainpan.core.compose.R
import xyz.pavelkorolev.brainpan.core.compose.theme.BrainpanColor

@Composable
fun EmptyView(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Box(
            modifier = Modifier
                .clip(CircleShape)
                .size(128.dp)
                .background(BrainpanColor.Masala.copy(0.1f)),
        ) {
            Image(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(24.dp),
                painter = painterResource(id = R.drawable.ic_skull),
                contentDescription = null,
            )
        }
    }
}
