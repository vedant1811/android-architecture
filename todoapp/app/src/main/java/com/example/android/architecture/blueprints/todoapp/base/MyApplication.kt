package com.example.android.architecture.blueprints.todoapp.base

import android.app.Application
import android.content.Context
import com.example.android.architecture.blueprints.todoapp.base.interfaces.TasksRepositoryFactory
import com.example.android.architecture.blueprints.todoapp.data.source.TasksRepository
import com.example.android.architecture.blueprints.todoapp.data.source.local.TasksLocalDataSource
import com.example.android.architecture.blueprints.todoapp.data.source.remote.TasksRemoteDataSource
import com.example.android.architecture.blueprints.todoapp.util.schedulers.SchedulerProvider

class MyApplication : Application(), TasksRepositoryFactory {
  override val tasksRepository: TasksRepository by lazy(LazyThreadSafetyMode.NONE) {

    val tasksRemoteDataSource = TasksRemoteDataSource()
    val tasksLocalDataSource = TasksLocalDataSource(this, SchedulerProvider())
    TasksRepository(tasksRemoteDataSource, tasksLocalDataSource)
  }
}
