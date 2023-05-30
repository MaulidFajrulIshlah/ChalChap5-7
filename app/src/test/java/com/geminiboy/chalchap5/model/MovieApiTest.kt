package com.geminiboy.chalchap5.model

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class MovieApiTest {

    @Test
    fun testMovieApiTotalPages() {
        val movieApi = MovieApi(
            page = 1,
            results = emptyList(),
            totalPages = 5,
            totalResults = 0
        )

        // Memeriksa jumlah total halaman
        assertEquals(5, movieApi.totalPages)
    }

    @Test
    fun testMovieApiTotalResults() {
        val movieApi = MovieApi(
            page = 1,
            results = emptyList(),
            totalPages = 3,
            totalResults = 100
        )

        // Memeriksa jumlah total hasil
        assertEquals(100, movieApi.totalResults)
    }

    @Test
    fun testMovieApiResultsNotEmpty() {
        val movieApi = MovieApi(
            page = 1,
            results = listOf(
                Result(
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
            ),
            totalPages = 1,
            totalResults = 1
        )

        // Memeriksa bahwa hasil tidak kosong
        assertTrue(movieApi.results.isNotEmpty())
    }

    @Test
    fun testMovieApiResultAtIndex() {
        val result1 = Result(
            adult = false,
            backdropPath = "/path/to/backdrop1.jpg",
            genreIds = listOf(1, 2, 3),
            id = 123,
            originalLanguage = "en",
            originalTitle = "Original Title 1",
            overview = "Movie overview 1",
            popularity = 7.8,
            posterPath = "/path/to/poster1.jpg",
            releaseDate = "2022-01-01",
            title = "Movie Title 1",
            video = false,
            voteAverage = 8.5,
            voteCount = 1000
        )

        val result2 = Result(
            adult = false,
            backdropPath = "/path/to/backdrop2.jpg",
            genreIds = listOf(4, 5),
            id = 456,
            originalLanguage = "en",
            originalTitle = "Original Title 2",
            overview = "Movie overview 2",
            popularity = 6.9,
            posterPath = "/path/to/poster2.jpg",
            releaseDate = "2022-02-01",
            title = "Movie Title 2",
            video = true,
            voteAverage = 7.2,
            voteCount = 800
        )

        val movieApi = MovieApi(
            page = 1,
            results = listOf(result1, result2),
            totalPages = 1,
            totalResults = 2
        )

        // Memeriksa hasil pada indeks tertentu
        assertEquals(result1, movieApi.results[0])
        assertEquals(result2, movieApi.results[1])
    }
}

//pengujian

/*
1. testMovieApiTotalPages(): Memeriksa apakah jumlah total halaman pada objek MovieApi sesuai dengan nilai yang diharapkan.
2. testMovieApiTotalResults(): Memeriksa apakah jumlah total hasil pada objek MovieApi sesuai dengan nilai yang diharapkan.
3. testMovieApiResultsNotEmpty(): Memeriksa apakah hasil pada objek MovieApi tidak kosong (notEmpty).
4. testMovieApiResultAtIndex(): Memeriksa apakah hasil pada indeks tertentu pada objek MovieApi sesuai dengan hasil yang diharapkan.*/