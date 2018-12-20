package truckpad.com.advancedandroid.networking

import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import io.reactivex.schedulers.Schedulers
import okhttp3.Call
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module(includes = [NetworkingModule::class])
class ServiceModule {

    @Provides
    @Singleton
    fun provideRetrofit(callFactory: Call.Factory, @Named("base_url") baseUrl: String): Retrofit {
        return Retrofit.Builder()
            .callFactory(callFactory)
            .addConverterFactory(GsonConverterFactory.create(Gson()))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
            .baseUrl(baseUrl).build()
    }
}