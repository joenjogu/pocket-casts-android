package au.com.shiftyjelly.pocketcasts.kids

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import au.com.shiftyjelly.pocketcasts.compose.AppThemeWithBackground
import au.com.shiftyjelly.pocketcasts.compose.components.TextH40
import au.com.shiftyjelly.pocketcasts.compose.components.TextH70
import au.com.shiftyjelly.pocketcasts.compose.preview.ThemePreviewParameterProvider
import au.com.shiftyjelly.pocketcasts.compose.theme
import au.com.shiftyjelly.pocketcasts.ui.theme.Theme
import coil.compose.AsyncImagePainter.State.Empty.painter
import au.com.shiftyjelly.pocketcasts.images.R as IR
import au.com.shiftyjelly.pocketcasts.localization.R as LR

@Composable
fun KidsProfileCard(
    onDismiss: () -> Unit,
    onRequestEarlyAccess: () -> Unit,
) {
    val bannerContentDescription = stringResource(LR.string.kids_profile_banner)

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .background(MaterialTheme.theme.colors.primaryUi01Active, shape = RoundedCornerShape(8.dp))
            .semantics { this.contentDescription = bannerContentDescription },
    ) {
        Image(
            colorFilter = ColorFilter.tint(MaterialTheme.theme.colors.primaryUi05Selected),
            painter = painterResource(IR.drawable.ic_close),
            contentDescription = stringResource(LR.string.close),
            modifier = Modifier
                .clickable { onDismiss() }
                .padding(8.dp)
                .size(22.dp)
                .align(Alignment.TopEnd),
        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Column(
                modifier = Modifier.weight(1f),
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(6.dp),
                    modifier = Modifier.padding(start = 24.dp, top = 16.dp, bottom = 8.dp),
                ) {
                    TextH40(
                        text = stringResource(LR.string.kids_profile),
                        fontWeight = FontWeight.W500,
                    )
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .background(MaterialTheme.theme.colors.primaryInteractive01, shape = RoundedCornerShape(4.dp))
                            .padding(horizontal = 6.dp),
                    ) {
                        Text(
                            text = stringResource(LR.string.soon_label),
                            color = MaterialTheme.theme.colors.primaryInteractive02,
                            fontSize = 11.sp,
                            lineHeight = 11.sp,
                            fontWeight = FontWeight.W600,
                            modifier = Modifier
                                .alpha(0.8f)
                                .padding(vertical = 2.dp),
                        )
                    }
                }
                TextH70(
                    text = stringResource(LR.string.kids_profile_banner_description),
                    color = MaterialTheme.theme.colors.primaryText02,
                    modifier = Modifier
                        .padding(start = 24.dp, end = 116.dp, bottom = 2.dp)
                        .alpha(0.8f),
                    fontWeight = FontWeight.W600,
                )
                Text(
                    text = stringResource(LR.string.request_early_access),
                    modifier = Modifier
                        .padding(start = 12.dp, end = 12.dp, bottom = 7.dp)
                        .clip(RoundedCornerShape(4.dp))
                        .clickable { onRequestEarlyAccess() }
                        .padding(horizontal = 12.dp, vertical = 7.dp),
                    style = TextStyle(
                        color = MaterialTheme.theme.colors.primaryInteractive01,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.W600,
                        textAlign = TextAlign.Start,
                    ),
                )
            }
        }

        Image(
            painter = painterResource(IR.drawable.kids_profile_face),
            contentDescription = stringResource(LR.string.kids_profile_face_image),
            modifier = Modifier
                .size(116.dp)
                .padding(top = 36.dp)
                .align(Alignment.BottomEnd)
                .clip(RoundedCornerShape(bottomEnd = 8.dp)),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewKidsProfileCard(@PreviewParameter(ThemePreviewParameterProvider::class) themeType: Theme.ThemeType) {
    AppThemeWithBackground(themeType) {
        KidsProfileCard(
            onDismiss = {},
            onRequestEarlyAccess = {},
        )
    }
}
