package com.example.smd_a3

import android.util.Log
import androidx.lifecycle.LiveData

class ContactRepository(private val contactDao: ContactDao) {

    val allContacts: LiveData<List<Contact>> = contactDao.getAllContacts()

    init {
        // Observe changes in allContacts and log when it changes
        allContacts.observeForever { contacts ->
            Log.d("RepositoryContents", contacts?.toString() ?: "null")
        }
    }

    suspend fun insert(contact: Contact) {
        contactDao.insert(contact)
    }

    suspend fun update(contact: Contact) {
        contactDao.update(contact)
    }

    suspend fun deleteContact(contact: Contact) {
        contactDao.delete(contact)
    }
}
