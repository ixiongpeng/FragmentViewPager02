package com.example.xiongpeng.fragmentviewpager02;

import android.graphics.Color;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button weixin = null;
    Button pengyou = null;
    Button tongxunlu = null;
    Button shezhi = null;
    FragmentManager fragmentManager= null;
    WeiXinFragment weiXinFragment = null;
    PengYouFragment pengYouFragment = null;
    TongXunLuFragment tongXunLuFragment = null;
    SheZhiFragment sheZhiFragment = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    public void init(){
        weixin = (Button)findViewById(R.id.weixin_bt);
        pengyou = (Button)findViewById(R.id.pengyou_bt);
        tongxunlu = (Button)findViewById(R.id.tongxunlu_bt);
        shezhi = (Button)findViewById(R.id.shezhi_bt);
        weixin.setOnClickListener(this);
        pengyou.setOnClickListener(this);
        tongxunlu.setOnClickListener(this);
        shezhi.setOnClickListener(this);

        fragmentManager = getSupportFragmentManager();
        setSelectedFragment(0);
    }

    public void hideFragment(FragmentTransaction transaction){
        if(weiXinFragment != null){
            transaction.hide(weiXinFragment);
        }
        if(pengYouFragment != null){
            transaction.hide(pengYouFragment);
        }
        if(tongXunLuFragment != null){
            transaction.hide(tongXunLuFragment);
        }
        if(sheZhiFragment != null){
            transaction.hide(sheZhiFragment);
        }
    }
    public void resetButtonBack(){
        weixin.setBackgroundColor(Color.GRAY);
        pengyou.setBackgroundColor(Color.GRAY);
        tongxunlu.setBackgroundColor(Color.GRAY);
        shezhi.setBackgroundColor(Color.GRAY);
    }

    public void setSelectedFragment(int i){
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        hideFragment(fragmentTransaction);
        switch (i){
            case 0:
                if(weiXinFragment == null){
                    weiXinFragment = new WeiXinFragment();
                    fragmentTransaction.add(R.id.contanier, weiXinFragment);
                }else{
                    fragmentTransaction.show(weiXinFragment);
                }
                weixin.setBackgroundColor(Color.YELLOW);
            break;
            case 1:
                if(pengYouFragment == null){
                    pengYouFragment = new PengYouFragment();
                    fragmentTransaction.add(R.id.contanier, pengYouFragment);
                }else{
                    fragmentTransaction.show(pengYouFragment);
                }
                pengyou.setBackgroundColor(Color.YELLOW);

                break;
            case 2:
                if(tongXunLuFragment == null){
                    tongXunLuFragment = new TongXunLuFragment();
                    fragmentTransaction.add(R.id.contanier, tongXunLuFragment);
                }else{
                    fragmentTransaction.show(weiXinFragment);
                }
                tongxunlu.setBackgroundColor(Color.YELLOW);
                break;
            case 3:
                if(sheZhiFragment == null){
                    sheZhiFragment = new SheZhiFragment();
                    fragmentTransaction.add(R.id.contanier, sheZhiFragment);
                }else{
                    fragmentTransaction.show(sheZhiFragment);
                }
                shezhi.setBackgroundColor(Color.YELLOW);
                break;
        }
        fragmentTransaction.commit();

    }


    @Override
    public void onClick(View view) {

        resetButtonBack();
        switch (view.getId()){
            case R.id.weixin_bt:
                setSelectedFragment(0);
                break;
            case R.id.pengyou_bt:
                setSelectedFragment(1);
                break;
            case R.id.tongxunlu_bt:
                setSelectedFragment(2);
                break;
            case R.id.shezhi_bt:
                setSelectedFragment(3);
                break;
        }

    }
}
