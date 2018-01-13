package com.jumrukovski.template2.domain;


import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableSingleObserver;

public abstract class BaseSingleUseCase<T> {

    private final CompositeDisposable disposables;
    private final Scheduler workScheduler;
    private final Scheduler mainScheduler;

    BaseSingleUseCase(Scheduler workScheduler, Scheduler mainScheduler) {
        this.workScheduler = workScheduler;
        this.mainScheduler = mainScheduler;
        this.disposables = new CompositeDisposable();
    }

    abstract Single<T> buildUseCaseObservable(String... params);

    public void execute(DisposableSingleObserver<T> observer, String... params) {
        final Single<T> observable = this.buildUseCaseObservable(params)
                .subscribeOn(workScheduler)
                .observeOn(mainScheduler);
        addDisposable(observable.subscribeWith(observer));
    }

    public void dispose() {
        if (!disposables.isDisposed()) {
            disposables.dispose();
        }
    }

    private void addDisposable(Disposable disposable) {
        disposables.add(disposable);
    }
}
