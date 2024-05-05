package com.example.machinetest.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.machinetest.data.remote.dto.Item
import com.example.machinetest.data.remote.dto.Owner

@Entity
data class RepoEntity (
    @PrimaryKey
    val id: Int,
    val name: String,
    val description: String,
    val fullName: String,
    val avatarUrl: String,

){
 fun toItemDto():Item{

     return Item(
         id = id,
         description = description,
         name = name,
         fullName = fullName,
         owner = Owner(avatarUrl=avatarUrl)
     )
 }
}