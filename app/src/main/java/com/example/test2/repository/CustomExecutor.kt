package com.example.test2.repository

import java.util.concurrent.Executors

class CustomExecutor {
    companion object {
        val executor = Executors.newFixedThreadPool(5)

        fun execute(runnable: Runnable) {
            executor.execute(runnable)
        }
    }
}