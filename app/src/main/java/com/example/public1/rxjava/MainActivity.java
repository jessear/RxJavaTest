package com.example.public1.rxjava;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;
import rx.functions.Func1;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Observable<String> observable=Observable.create(new Observable.OnSubscribe<String>(){
//
//            @Override
//            public void call(Subscriber<? super String> subscriber) {
//                subscriber.onNext("what a fuck");
//                subscriber.onCompleted();
//            }
//        });
//
//        Subscriber<String> subscriber=new Subscriber<String>() {
//
//            @Override
//            public void onStart() {
//                Log.i("---------------->", "onStart()");
//            }
//
//            @Override
//            public void onCompleted() {
//                Log.i("---------------->", "onCompleted()");
//            }
//
//            @Override
//            public void onError(Throwable e) {
//
//            }
//
//            @Override
//            public void onNext(String s) {
//                Log.i("---------------->", "onNext(),"+s);
//            }
//        };
//
//        observable.subscribe(subscriber);

        Observable.just("hello word").map(new Func1<String,Integer>() {
            @Override
            public Integer call(String s) {
                return s.length();
            }
        }).subscribe(new Action1<Integer>() {
            @Override
            public void call(Integer integer) {
                Log.i("---------------->","length:"+integer);
            }
        });
    }
}
