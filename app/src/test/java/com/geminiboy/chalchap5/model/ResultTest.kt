package com.geminiboy.chalchap5.model

import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue

class ResultTest {

    @Test
    fun testResultProperties() {
        // Membuat objek Result dengan nilai properti yang diharapkan
        val result = Result(
            adult = false,
            backdropPath = "/path/to/backdrop.jpg",
            genreIds = listOf(1, 2, 3),
            id = 123,
            originalLanguage = "en",
            originalTitle = "Original Title",
            overview = "Movie overview",
            popularity = 7.8,
            posterPath = "/path/to/poster.jpg",
            releaseDate = "2022-01-01",
            title = "Movie Title",
            video = false,
            voteAverage = 8.5,
            voteCount = 1000
        )

        // Memeriksa nilai properti dengan menggunakan assertEquals
        assertEquals(false, result.adult)
        assertEquals("/path/to/backdrop.jpg", result.backdropPath)
        assertEquals(listOf(1, 2, 3), result.genreIds)
        assertEquals(123, result.id)
        assertEquals("en", result.originalLanguage)
        assertEquals("Original Title", result.originalTitle)
        assertEquals("Movie overview", result.overview)
        assertEquals(7.8, result.popularity, 0.0)
        assertEquals("/path/to/poster.jpg", result.posterPath)
        assertEquals("2022-01-01", result.releaseDate)
        assertEquals("Movie Title", result.title)
        assertEquals(false, result.video)
        assertEquals(8.5, result.voteAverage, 0.0)
        assertEquals(1000, result.voteCount)
    }

    @Test
    fun testResultEquality() {
        // Membuat dua objek Result dengan nilai properti yang sama
        val result1 = Result(
            adult = false,
            backdropPath = "/path/to/backdrop.jpg",
            genreIds = listOf(1, 2, 3),
            id = 123,
            originalLanguage = "en",
            originalTitle = "Original Title",
            overview = "Movie overview",
            popularity = 7.8,
            posterPath = "/path/to/poster.jpg",
            releaseDate = "2022-01-01",
            title = "Movie Title",
            video = false,
            voteAverage = 8.5,
            voteCount = 1000
        )

        val result2 = Result(
            adult = false,
            backdropPath = "/path/to/backdrop.jpg",
            genreIds = listOf(1, 2, 3),
            id = 123,
            originalLanguage = "en",
            originalTitle = "Original Title",
            overview = "Movie overview",
            popularity = 7.8,
            posterPath = "/path/to/poster.jpg",
            releaseDate = "2022-01-01",
            title = "Movie Title",
            video = false,
            voteAverage = 8.5,
            voteCount = 1000
        )

        // Memeriksa bahwa kedua objek Result adalah objek yang sama (equal)
        assertEquals(result1, result2)
    }

    @Test
    fun testResultToString() {
        // Membuat objek Result dengan nilai properti yang diharapkan
        val result = Result(
            adult = false,
            backdropPath = "/path/to/backdrop.jpg",
            genreIds = listOf(1, 2, 3),
            id = 123,
            originalLanguage = "en",
            originalTitle = "Original Title",
            overview = "Movie overview",
            popularity = 7.8,
            posterPath = "/path/to/poster.jpg",
            releaseDate = "2022-01-01",
            title = "Movie Title",
            video = false,
            voteAverage = 8.5,
            voteCount = 1000
        )

        // Memeriksa representasi String dari objek Result dengan menggunakan assertEquals
        val expectedString = "Result(adult=false, backdropPath=/path/to/backdrop.jpg, " +
                "genreIds=[1, 2, 3], id=123, originalLanguage=en, originalTitle=Original Title, " +
                "overview=Movie overview, popularity=7.8, posterPath=/path/to/poster.jpg, " +
                "releaseDate=2022-01-01, title=Movie Title, video=false, voteAverage=8.5, voteCount=1000)"
        assertEquals(expectedString, result.toString())
    }

    @Test
    fun testResultPosterPathNotNull() {
        // Membuat objek Result dengan nilai properti yang diharapkan
        val result = Result(
            adult = false,
            backdropPath = "/path/to/backdrop.jpg",
            genreIds = listOf(1, 2, 3),
            id = 123,
            originalLanguage = "en",
            originalTitle = "Original Title",
            overview = "Movie overview",
            popularity = 7.8,
            posterPath = "/path/to/poster.jpg",
            releaseDate = "2022-01-01",
            title = "Movie Title",
            video = false,
            voteAverage = 8.5,
            voteCount = 1000
        )

        // Memeriksa apakah nilai posterPath tidak null dengan menggunakan assertNotNull
        assertNotNull(result.posterPath)
    }

    @Test
    fun testResultGenreIdsNotEmpty() {
        // Membuat objek Result dengan nilai properti yang diharapkan
        val result = Result(
            adult = false,
            backdropPath = "/path/to/backdrop.jpg",
            genreIds = listOf(1, 2, 3),
            id = 123,
            originalLanguage = "en",
            originalTitle = "Original Title",
            overview = "Movie overview",
            popularity = 7.8,
            posterPath = "/path/to/poster.jpg",
            releaseDate = "2022-01-01",
            title = "Movie Title",
            video = false,
            voteAverage = 8.5,
            voteCount = 1000
        )

        // Memeriksa apakah nilai genreIds tidak kosong dengan menggunakan assertTrue
        assertTrue(result.genreIds.isNotEmpty())
    }
}

//penjelasan

/*
1. testResultProperties(): Pengujian ini memeriksa setiap properti dari objek Result apakah memiliki nilai yang sesuai dengan yang diharapkan. Menggunakan assertEquals untuk membandingkan nilai properti dengan nilai yang diharapkan.
2. testResultEquality(): Pengujian ini memeriksa apakah dua objek Result dengan properti yang sama dianggap sebagai objek yang sama (equal). Menggunakan assertEquals untuk membandingkan kedua objek dan memastikan bahwa mereka sama.
3. testResultToString(): Pengujian ini memeriksa representasi String dari objek Result. Menggunakan assertEquals untuk membandingkan representasi String yang diharapkan dengan hasil pemanggilan metode toString() pada objek.
4. testResultPosterPathNotNull(): Pengujian ini memeriksa apakah properti posterPath dalam objek Result tidak bernilai null. Menggunakan assertNotNull untuk memastikan bahwa nilai posterPath tidak null.
5. testResultGenreIdsNotEmpty(): Pengujian ini memeriksa apakah properti genreIds dalam objek Result tidak kosong (notEmpty). Menggunakan assertTrue untuk memastikan bahwa genreIds memiliki elemen di dalamnya.*/