/*
 * Copyright (c) 2020 DuckDuckGo
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.duckduckgo.app.fire.fireproofwebsite.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.duckduckgo.app.bookmarks.db.BookmarkEntity

@Dao
interface FireproofWebsiteDao {

    @Query("select * from $FIREPROOF_WEBSITES_TABLE_NAME")
    fun fireproofWebsitesSync(): List<FireproofWebsiteEntity>

    @Query("select * from $FIREPROOF_WEBSITES_TABLE_NAME")
    fun fireproofWebsitesEntities(): LiveData<List<FireproofWebsiteEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(fireproofWebsiteEntity: FireproofWebsiteEntity): Long

    @Delete
    fun delete(fireproofWebsiteEntity: FireproofWebsiteEntity): Int
}