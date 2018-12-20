package truckpad.com.advancedandroid.networking

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import javax.inject.Named
import javax.inject.Singleton

@Module
class NetworkingModule {


    @Module
    companion object {
        @JvmStatic
        @Provides
        @Singleton
        fun providesOkHttp(): OkHttpClient {
            return OkHttpClient.Builder().build()
        }

        @JvmStatic
        @Provides
        @Named("base_url")
        fun providesBaseUrl(): String {
            return "https://api.github.com/"
        }

    }
}
