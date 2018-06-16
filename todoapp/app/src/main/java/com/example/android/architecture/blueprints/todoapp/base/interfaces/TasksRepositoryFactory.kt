package com.example.android.architecture.blueprints.todoapp.base.interfaces

import com.example.android.architecture.blueprints.todoapp.data.source.TasksRepository

interface TasksRepositoryFactory {
  val tasksRepository: TasksRepository
}
