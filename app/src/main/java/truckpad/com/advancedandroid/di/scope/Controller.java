package truckpad.com.advancedandroid.di.scope;

import dagger.MapKey;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@MapKey
@Target(ElementType.METHOD)
public @interface Controller {


    Class<? extends Controller> value();
}
