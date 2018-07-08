package com.example.mana.worldcup18.ui.screens.youtubeactivity;

import android.os.Bundle;
import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.example.mana.worldcup18.R;
import com.example.mana.worldcup18.utilities.Constants;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class YoutubeVideos extends YouTubeBaseActivity implements
    YouTubePlayer.OnInitializedListener {

  @BindView(R.id.recap_player) YouTubePlayerView playerView;
  @BindString(R.string.api_key) String API_KEY;
  String id;

  @Override protected void onCreate(Bundle bundle) {
    super.onCreate(bundle);
    setContentView(R.layout.youtube_dialog);
    ButterKnife.bind(this);
    playerView.initialize(API_KEY, this);
    id = getIntent().getExtras().getString(Constants.EXTRA_VIDEO_ID);
  }

  private YouTubePlayer.PlaybackEventListener playbackEventListener =
      new YouTubePlayer.PlaybackEventListener() {
        @Override public void onPlaying() {

        }

        @Override public void onPaused() {

        }

        @Override public void onStopped() {

        }

        @Override public void onBuffering(boolean b) {

        }

        @Override public void onSeekTo(int i) {

        }
      };
  private YouTubePlayer.PlayerStateChangeListener playerStateChangeListener =
      new YouTubePlayer.PlayerStateChangeListener() {
        @Override public void onLoading() {

        }

        @Override public void onLoaded(String s) {

        }

        @Override public void onAdStarted() {

        }

        @Override public void onVideoStarted() {

        }

        @Override public void onVideoEnded() {

        }

        @Override public void onError(YouTubePlayer.ErrorReason errorReason) {

        }
      };

  @Override
  public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer,
      boolean b) {
    youTubePlayer.setPlaybackEventListener(playbackEventListener);
    youTubePlayer.setPlayerStateChangeListener(playerStateChangeListener);
    if (!b) {
      youTubePlayer.cueVideo(id);
    }
  }

  @Override public void onInitializationFailure(YouTubePlayer.Provider provider,
      YouTubeInitializationResult youTubeInitializationResult) {

  }
}
