package com.example.public1.rxjava;

import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.widget.Toast;

import org.reactivestreams.Publisher;
import java.util.ArrayList;
import java.util.List;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        1.简单用法
//        Observable<String> observable=Observable.create(new ObservableOnSubscribe<String>(){
//            @Override
//            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
//                emitter.onNext("what a fuck");
//                emitter.onComplete();
//            }
//        });
//        Observer<String> observer= new Observer<String>() {
//            @Override
//            public void onSubscribe(Disposable d) {
//                Log.i("---------------->", "onSubscribe()");
//            }
//
//            @Override
//            public void onNext(String value) {
//                Log.i("---------------->", "onNext()");
//            }
//
//            @Override
//            public void onError(Throwable e) {
//                Log.i("---------------->", "onError()");
//            }
//
//            @Override
//            public void onComplete() {
//                Log.i("---------------->", "onComplete()");
//            }
//        };
//        observable.subscribe(observer);

//        2.map()对象类型转换

//        Observable.just("hello word").map(new Function<String, Integer>() {
//            @Override
//            public Integer apply(String s) throws Exception {
//                return s.length();
//            }
//
//        }).subscribe(new Consumer<Integer>() {
//            @Override
//            public void accept(Integer integer) throws Exception {
//                Log.i("---------------->", "length:" + integer);
//            }
//        });

//        3.flatMap()
//        List<Student> students = new ArrayList<>();
//        for (int i = 0; i < 2; i++) {
//            Student student = new Student();
//            student.setName("学生" + i);
//            student.setAge(i);
//            List<String> courses = new ArrayList<String>();
//            for (int j = 0; j < 3; j++) {
//                courses.add(student.getName() + j);
//            }
//            student.setCourses(courses);
//            students.add(student);
//        }
//
//        Flowable.just(students)
//                .flatMap(new Function<List<Student>, Publisher<Student>>() {
//                    @Override
//                    public Publisher<Student> apply(List<Student> students) throws Exception {
//                        return Flowable.fromIterable(students);
//                    }
//                }).flatMap(new Function<Student, Publisher<String>>() {
//            @Override
//            public Publisher<String> apply(Student student) throws Exception {
//                return Flowable.fromIterable(student.getCourses());
//            }
//        }).subscribe(new Consumer<String>() {
//            @Override
//            public void accept(String s) throws Exception {
//                Log.i("--------------->", "课程:" + s);
//            }
//        });

//        4.调度器
        Flowable.create(new FlowableOnSubscribe<String>() {
            @Override
            public void subscribe(FlowableEmitter<String> e) throws Exception {
                e.onNext("将会在3秒后显示");
                SystemClock.sleep(3000);
                e.onNext("已显示");
                e.onComplete();
            }
        }, BackpressureStrategy.BUFFER)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        Toast.makeText(MainActivity.this,s,Toast.LENGTH_SHORT).show();
                    }
                });

    }
}
