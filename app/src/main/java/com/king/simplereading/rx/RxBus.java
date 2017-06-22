package com.king.simplereading.rx;

import rx.Observable;
import rx.functions.Func1;
import rx.subjects.PublishSubject;
import rx.subjects.SerializedSubject;
import rx.subjects.Subject;

/**
 * <请描述这个类是干什么的>
 * Created by wwb on 2017/6/21 16:09.
 * 参考网址:  http://www.loongwind.com/archives/264.html 看这个学习rxbus怎么用
 * http://gank.io/post/560e15be2dca930e00da1083  看这个学习rxjava
 */

public class RxBus
{
    private static volatile RxBus defaultInstance;

    private final Subject<Object, Object> bus;

    // PublishSubject只会把在订阅发生的时间点之后来自原始Observable的数据发射给观察者
    private RxBus()
    {
        bus = new SerializedSubject<>(PublishSubject.create());
    }

    public RxBus getInstance()
    {
        RxBus rxBus = defaultInstance;
        if (defaultInstance == null)
        {
            synchronized (RxBus.class)
            {
                rxBus = defaultInstance;
                if (defaultInstance == null)
                {
                    rxBus = new RxBus();
                    defaultInstance = rxBus;
                }
            }
        }
        return rxBus;
    }

    /**
     * @param
     * @Description 提供了一个新的事件
     */
    public void post(Object o){
        bus.onNext(o);
    }


    /**
     * 根据传递的 eventType 类型返回特定类型(eventType)的 被观察者
     * @param eventType 事件类型
     * @param <T>
     * @return
     */
    public <T> Observable<T> toObservable(Class<T> eventType) {
        return bus.ofType(eventType);
    }

    /**
     * 提供了一个新的事件,根据code进行分发
     * @param code 事件code
     * @param o
     */
    public void post(int code, Object o){
        bus.onNext(new RxBusBaseMessage(code,o));
    }


    /**
     * 根据传递的code和 eventType 类型返回特定类型(eventType)的 被观察者
     * @param code 事件code
     * @param eventType 事件类型
     * @param <T>
     * @return
     */
    public <T> Observable<T> toObservable(final int code, final Class<T> eventType) {
        return bus.ofType(RxBusBaseMessage.class)
                .filter(new Func1<RxBusBaseMessage,Boolean>() {
                    @Override
                    public Boolean call(RxBusBaseMessage o) {
                        //过滤code和eventType都相同的事件
                        return o.getCode() == code && eventType.isInstance(o.getObject());
                    }
                }).map(new Func1<RxBusBaseMessage,Object>() {
                    @Override
                    public Object call(RxBusBaseMessage o) {
                        return o.getObject();
                    }
                }).cast(eventType);
    }


}
