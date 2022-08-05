import android.hardware.foo.V1_0.IFoo;
import android.hardware.foo.V1_0.IFooCallback.Stub;
....
class FooCallback extends IFooCallback.Stub {
    // implement methods
}
....
// Get the service from which you will be receiving callbacks.
// This also starts the threadpool for your callback service.
IFoo server = IFoo.getService(true /* retry */); // throws NoSuchElementException if not available
....
// This must be a persistent instance variable, not local,
//   to avoid premature garbage collection.
FooCallback mFooCallback = new FooCallback();
....
// Do this once to create the callback service and tell the "foo-bar" service
server.setFooCallback(mFooCallback);
