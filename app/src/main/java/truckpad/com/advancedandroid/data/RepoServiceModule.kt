package truckpad.com.advancedandroid.data

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class RepoServiceModule {
    @Module
    companion object {
        @JvmStatic
        @Provides
        @Singleton
        fun provideRepoService(retrofit: Retrofit) : RepoService {
            return retrofit.create(RepoService::class.java)
        }

    }
}