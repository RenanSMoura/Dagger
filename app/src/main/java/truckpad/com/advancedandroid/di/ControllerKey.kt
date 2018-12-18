package truckpad.com.advancedandroid.di

import com.bluelinelabs.conductor.Controller
import dagger.MapKey
import kotlin.reflect.KClass

@MapKey
@kotlin.annotation.Target(AnnotationTarget.FUNCTION)
annotation class ControllerKey(val value: KClass<out Controller>)
