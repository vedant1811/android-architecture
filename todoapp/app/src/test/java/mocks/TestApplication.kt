package mocks

import android.app.Application
import com.example.android.architecture.blueprints.todoapp.base.interfaces.TasksRepositoryFactory
import com.example.android.architecture.blueprints.todoapp.data.FakeTasksRemoteDataSource
import com.example.android.architecture.blueprints.todoapp.data.source.TasksRepository
import com.example.android.architecture.blueprints.todoapp.data.source.local.TasksLocalDataSource
import com.example.android.architecture.blueprints.todoapp.data.source.remote.TasksRemoteDataSource
import com.example.android.architecture.blueprints.todoapp.util.schedulers.ImmediateSchedulerProvider
import com.example.android.architecture.blueprints.todoapp.util.schedulers.SchedulerProvider

class TestApplication : Application(), TasksRepositoryFactory {
  override val tasksRepository: TasksRepository by lazy(LazyThreadSafetyMode.NONE) {

    val tasksRemoteDataSource = FakeTasksRemoteDataSource()
    val tasksLocalDataSource = TasksLocalDataSource(this, ImmediateSchedulerProvider())
    TasksRepository(tasksRemoteDataSource, tasksLocalDataSource)
  }
}
