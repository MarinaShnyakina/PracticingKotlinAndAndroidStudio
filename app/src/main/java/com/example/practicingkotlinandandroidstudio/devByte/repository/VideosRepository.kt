package com.example.practicingkotlinandandroidstudio.devByte.repository

import androidx.lifecycle.LiveData
import com.example.practicingkotlinandandroidstudio.devByte.database.VideosDatabase
import com.example.practicingkotlinandandroidstudio.devByte.domain.DevByteVideo
import com.example.practicingkotlinandandroidstudio.devByte.network.DevByteNetwork
import com.example.practicingkotlinandandroidstudio.devByte.network.asDatabaseModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Repository for fetching devbyte videos from the network and storing them on disk
 */

class VideosRepository(private val database: VideosDatabase) {

    //val videos: LiveData<List<DevByteVideo>> = database.map {
    //    it.asDomainModel()
    }
    suspend fun refreshVideos() {
        withContext(Dispatchers.IO) {
            val playlist = DevByteNetwork.devbytes.getPlaylist()
        //    database.videoDao.insertAll(playlist.asDatabaseModel())
        }
    }
//}