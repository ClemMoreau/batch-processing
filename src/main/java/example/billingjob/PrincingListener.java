package example.billingjob;

import org.springframework.retry.RetryCallback;
import org.springframework.retry.RetryContext;
import org.springframework.retry.RetryListener;

public class PrincingListener implements RetryListener {

    private int retryCount = 0;
    
    @Override
    public <T, E extends Throwable> void onError(RetryContext context, RetryCallback<T, E> callback,
            Throwable throwable) {
            
        System.out.println("Retry error");
        retryCount++;
        RetryListener.super.onError(context, callback, throwable);
    }

    @Override
    public <T, E extends Throwable> void onSuccess(RetryContext context, RetryCallback<T, E> callback, T result) {
        
        System.out.println("Retry success after " + retryCount + " attempts");
        RetryListener.super.onSuccess(context, callback, result);
    }
}
