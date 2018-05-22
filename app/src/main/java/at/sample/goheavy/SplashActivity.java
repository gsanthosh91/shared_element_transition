package at.sample.goheavy;

import android.animation.Animator;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;

import com.airbnb.lottie.LottieAnimationView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SplashActivity extends AppCompatActivity {

    @BindView(R.id.animation_view)
    LottieAnimationView animationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);
        animationView.addAnimatorListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                Log.d("Animation:", "start");

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                Log.d("Animation:", "end");
                Intent intent = new Intent(SplashActivity.this, SigninActivity.class);
                ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(SplashActivity.this, animationView, ViewCompat.getTransitionName(animationView));
                startActivity(intent, options.toBundle());
            }

            @Override
            public void onAnimationCancel(Animator animation) {
                Log.d("Animation:", "cancel");
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
                Log.d("Animation:", "repeat");
            }
        });
        animationView.playAnimation();

    }

    @Override
    public void onStop() {
        super.onStop();
        finish();
    }
}
