package com.example.public1.rxjava;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import org.reactivestreams.Publisher;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import rx.functions.Action1;

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

//        3.flatMap()对象类型转换成Observable对象
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            Student student = new Student();
            student.setName("学生" + i);
            student.setAge(i);
            List<String> courses = new ArrayList<String>();
            for (int j = 0; j < 3; j++) {
                courses.add(student.getName() + j);
            }
            student.setCourses(courses);
            students.add(student);
        }

        Flowable.just(students)
                .flatMap(new Function<List<Student>, Publisher<Student>>() {
                    @Override
                    public Publisher<Student> apply(List<Student> students) throws Exception {
                        return Flowable.fromIterable(students);
                    }
                }).flatMap(new Function<Student, Publisher<String>>() {
            @Override
            public Publisher<String> apply(Student student) throws Exception {
                return Flowable.fromIterable(student.getCourses());
            }
        }).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                Log.i("---------------->", "课程:" + s);
            }
        });

//        Observable.create(new Observable.OnSubscribe<Drawable>() {
//
//            public void call(Subscriber<? super Drawable> subscriber) {
//                Drawable drawable = getTheme().getDrawable(0);
//                subscriber.onNext(drawable);
//                subscriber.onComplete();
//            }
//        })
//            .subscribeOn(Schedulers.io()) // 指定 subscribe() 发生在 IO 线程
//            .observeOn(AndroidSchedulers.mainThread()) // 指定 Subscriber 的回调发生在主线程
//            .subscribe(new Observer<Drawable>() {
//                @Override
//                public void onSubscribe(Disposable d) {
//
//                }
//
//                @Override
//                public void onNext(Drawable drawable) {
//                }
//
//                @Override
//                public void onError(Throwable e) {
//
//                }
//
//                @Override
//                public void onComplete() {
//
//                }
//            });

    }
}
