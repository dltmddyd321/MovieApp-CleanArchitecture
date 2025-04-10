package com.example.cleanarchitecturemovieapp.presentation.di.core

import com.example.cleanarchitecturemovieapp.presentation.di.artist.ArtistSubComponent
import com.example.cleanarchitecturemovieapp.presentation.di.movie.MovieSubComponent
import com.example.cleanarchitecturemovieapp.presentation.di.tvShow.TvShowSubComponent
import dagger.Component
import javax.inject.Singleton

//@Module이 제공하는 의존성 객체들을 모두 모아 그래프를 구성해요.
//어떤 클래스에 어떤 객체를 주입할지 결정해주는 중심입니다.
//AppComponent는 일반적으로 Application 클래스에서 생성하고, 앱 전반에서 의존성을 주입할 때 사용합니다
//AppComponent는 여러 모듈이 제공하는 객체들을 한 곳에 모아, 필요한 클래스에 적절하게 의존성을 주입하는 DI 설정의 최상위 지휘자입니다.
@Singleton
@Component(
    modules = [
        AppModule::class,
        NetworkModule::class,
        DatabaseModule::class,
        UseCaseModule::class,
        RepositoryModule::class,
        RemoteDataModule::class,
        LocalDataModule::class,
        CacheDataModule::class
    ]
)
interface AppComponent {

    fun movieSubComponent(): MovieSubComponent.Factory

    fun tvShowSubComponent(): TvShowSubComponent.Factory

    fun artistSubComponent(): ArtistSubComponent.Factory
}