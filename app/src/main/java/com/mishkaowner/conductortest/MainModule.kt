package com.mishkaowner.conductortest

import dagger.Module
import dagger.Provides

/**
 * Created by MishkaOwner on 2017-09-28.
 */
@Module
class MainModule(private val controller: HomeController) {
    @Provides fun providesController(): HomeController = controller
    @Provides fun providesView(controller: HomeController): MainView = controller
    @Provides fun providesPresenter(presenter: MainPresenterImpl): MainPresenter = presenter
    @Provides fun providesInteractor(interactor: MainInteractorImpl): MainInteractor = interactor
    @Provides fun providesWebRepository(service: TestService): WebRepository = WebRepository(service)
    @Provides fun providesLocalRepository(): LocalRepository = LocalRepository()
}