package com.example.naoya.scoreresult;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView text[][] = new TextView[3][4];
    int [][]textId = {{R.id.textView11,R.id.textView12,R.id.textView13,R.id.textView14},
            {R.id.textView21,R.id.textView22,R.id.textView23,R.id.textView24},
            {R.id.textView31,R.id.textView32,R.id.textView33,R.id.textView34}};
    String game[][] = new String[3][4];
    int []gameId = {R.array.game1,R.array.game2,R.array.game3};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//それぞれのTextViewの関連付け
        for(int y=0;y<text.length;y++) {
            for(int x=0;x<text[y].length;x++) {
                text[y][x] = (TextView) findViewById(textId[y][x]);
            }
        }
// arrays.xmlから参照
        for(int i=0;i<text.length;i++) {
            game[i] = getResources().getStringArray(gameId[i]);
        }
//ソート
        int[] intDate = new int[3];

        for(int i=0;i<3;i++) {
            intDate[i] = Integer.parseInt(game[i][0]);
        }

        String tmp;
        for(int sort1=0;sort1<intDate.length-1;sort1++) {
            for(int sort2=sort1+1;sort2<intDate.length;sort2++) {
                if(intDate[sort1]>intDate[sort2]) {
                    for(int x=0;x<game[1].length;x++) {
                        tmp = game[sort1][x];
                        game[sort1][x] = game[sort2][x];
                        game[sort2][x] = tmp;
                    }
                }
            }
        }
//textViewに反映
        for(int y=0;y<text.length;y++) {
            for (int x=0;x<text[y].length;x++) {
                text[y][x].setText(game[y][x]);
            }
        }
//画面遷移
        for(int y=0;y<text.length;y++) {
            text[y][2].setClickable(true);
        }
        text[0][2].setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClassName("com.example.naoya.scoreresult", "com.example.naoya.scoreresult.GameResult_1");
                startActivity(intent);
            }
        });
        text[1][2].setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClassName("com.example.naoya.scoreresult", "com.example.naoya.scoreresult.GameResult_2");
                startActivity(intent);
            }
        });
        text[2][2].setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClassName("com.example.naoya.scoreresult", "com.example.naoya.scoreresult.GameResult_3");
                startActivity(intent);
            }
        });

    }

}
