package com.example.concessionaria_mobile.service.repository

interface Repository<T> {

    fun save(t: T): Boolean

    fun update(t: T): Boolean

    fun delete(t: T): Boolean

    fun findAll(): List<T>

    fun findOne(id: Int): T?
}