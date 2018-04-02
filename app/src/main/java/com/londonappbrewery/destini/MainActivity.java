package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    TextView mStoryTextView;
    Button mTopButton;
    Button mBottomButton;
    int mStoryIndex;

    int[] mStoryArray = new int[]{
            R.string.T1_Story,
            R.string.T2_Story,
            R.string.T3_Story,
            R.string.T4_End,
            R.string.T5_End,
            R.string.T6_End,
    };
    int[] mTopButtonArray = new int[]{
            R.string.T1_Ans1,
            R.string.T2_Ans1,
            R.string.T3_Ans1,
    };
    int[] mBottomButtonArray = new int[]{
            R.string.T1_Ans2,
            R.string.T2_Ans2,
            R.string.T3_Ans2,
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        mStoryTextView = findViewById(R.id.storyTextView);
        mTopButton = findViewById(R.id.buttonTop);
        mBottomButton = findViewById(R.id.buttonBottom);
        mStoryIndex = 1;
        updateGame();

        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        mTopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                raiseIndex("top");
                updateGame();
            }
        });

        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        mBottomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                raiseIndex("bottom");
                updateGame();
            }
        });


    }

    private void raiseIndex(String button){
        if(button.equals("top")){
            if(mStoryIndex == 1){
                mStoryIndex = 3;
            } else if (mStoryIndex == 2){
                mStoryIndex = 3;
            } else if (mStoryIndex == 3){
                mStoryIndex = 6;
            }
        } else if(button.equals("bottom")){
            if(mStoryIndex == 1){
                mStoryIndex = 2;
            } else if(mStoryIndex == 2){
                mStoryIndex = 4;
            } else if(mStoryIndex == 3){
                mStoryIndex = 5;
            }
        }
    }

    private void updateGame(){
        mStoryTextView.setText(mStoryArray[mStoryIndex - 1]);
        if(mStoryIndex < 4){
            mTopButton.setText(mTopButtonArray[mStoryIndex - 1]);
            mBottomButton.setText(mBottomButtonArray[mStoryIndex - 1]);
        } else {
            mTopButton.setVisibility(View.GONE);
            mBottomButton.setVisibility(View.GONE);
        }
    }
}
