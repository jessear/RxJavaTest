package com.example.public1.rxjava;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;
import rx.functions.Func1;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        1.简单用法
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

//        2.map()对象类型转换
//        Observable.just("hello word").map(new Func1<String,Integer>() {
//            @Override
//            public Integer call(String s) {
//                return s.length();
//            }
//        }).subscribe(new Action1<Integer>() {
//            @Override
//            public void call(Integer integer) {
//                Log.i("---------------->", "length:" + integer);
//            }
//        });

//        3.flatMap()对象类型转换成Observable对象
//        List<Student> students=new ArrayList<>();
//        for(int i=0;i<2;i++){
//            Student student=new Student();
//            student.setName("学生" + i);
//            student.setAge(i);
//            List<String> courses=new ArrayList<String>();
//            for(int j=0;j<3;j++){
//                courses.add(student.getName()+j);
//            }
//            student.setCourses(courses);
//            students.add(student);
//        }
//        Observable.from(students).flatMap(new Func1<Student, Observable<String>>() {
//            @Override
//            public Observable<String> call(Student student) {
//                return Observable.from(student.getCourses());
//            }
//        }).subscribe(new Action1<String>() {
//            @Override
//            public void call(String s) {
//                Log.i("---------------->", "课程:" +s );
//            }
//        });

    }
}
