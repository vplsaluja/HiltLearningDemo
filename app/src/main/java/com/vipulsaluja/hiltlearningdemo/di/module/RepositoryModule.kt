package com.vipulsaluja.hiltlearningdemo.di.module

import com.vipulsaluja.hiltlearningdemo.repository.ProductRepository
import com.vipulsaluja.hiltlearningdemo.repository.impl.ProductRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindRepository(repoImpl: ProductRepositoryImpl): ProductRepository
}