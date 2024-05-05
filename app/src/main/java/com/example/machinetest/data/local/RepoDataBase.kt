package com.example.machinetest.data.local

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(
    entities = [RepoEntity::class],
    version = 1
)
abstract class RepoDataBase : RoomDatabase() {

    abstract val dao: RepoDao
}
