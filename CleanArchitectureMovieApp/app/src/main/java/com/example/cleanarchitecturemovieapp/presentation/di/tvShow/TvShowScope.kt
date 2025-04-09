package com.example.cleanarchitecturemovieapp.presentation.di.tvShow

import javax.inject.Scope

//@Scope 애노테이션은 Dagger/Hilt에서 객체의 생명 주기를 관리하기 위해 사용하는 거예요.
//@ArtistScope는 커스텀 스코프 어노테이션으로, 특정 컴포넌트(예: ViewModel, Fragment 등)에 같은 인스턴스를 공유하도록 범위를 지정해주는 역할을 해요.
//@ArtistScope는 같은 컴포넌트 내에서 객체를 공유하기 위한 스코프 지정자
//싱글톤처럼 작동하지만, 앱 전체가 아닌 특정 범위 내에서만 공유되게 하는 것이 포인트!
@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class TvShowScope