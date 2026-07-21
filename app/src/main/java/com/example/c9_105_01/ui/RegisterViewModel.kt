package com.example.c9_105_01.ui

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class RegisterViewModel : ViewModel() {

    private val _name = MutableStateFlow("")
    private val _email = MutableStateFlow("")
    private val _password = MutableStateFlow("")
    private val _confirmPassword = MutableStateFlow("")
    private val _birthDate = MutableStateFlow("")
    private val _genre = MutableStateFlow("")
    private val _termsAccepted = MutableStateFlow(false)

    private val _nameError = MutableStateFlow(false)
    private val _emailError = MutableStateFlow(false)
    private val _passwordError = MutableStateFlow(false)
    private val _confirmPasswordError = MutableStateFlow(false)
    private val _birthDateError = MutableStateFlow(false)
    private val _genreError = MutableStateFlow(false)
    private val _termsError = MutableStateFlow(false)

    val name: StateFlow<String> = _name.asStateFlow()
    val email: StateFlow<String> = _email.asStateFlow()
    val password: StateFlow<String> = _password.asStateFlow()
    val confirmPassword: StateFlow<String> = _confirmPassword.asStateFlow()
    val birthDate: StateFlow<String> = _birthDate.asStateFlow()
    val genre: StateFlow<String> = _genre.asStateFlow()
    val termsAccepted: StateFlow<Boolean> = _termsAccepted.asStateFlow()

    val nameError: StateFlow<Boolean> = _nameError.asStateFlow()
    val emailError: StateFlow<Boolean> = _emailError.asStateFlow()
    val passwordError: StateFlow<Boolean> = _passwordError.asStateFlow()
    val confirmPasswordError: StateFlow<Boolean> = _confirmPasswordError.asStateFlow()
    val birthDateError: StateFlow<Boolean> = _birthDateError.asStateFlow()
    val genreError: StateFlow<Boolean> = _genreError.asStateFlow()
    val termsError: StateFlow<Boolean> = _termsError.asStateFlow()

    fun onNameChange(name: String) {
        _name.value = name
        _nameError.value = false
    }

    fun onEmailChange(email: String) {
        _email.value = email
        _emailError.value = false
    }

    fun onPasswordChange(password: String) {
        _password.value = password
        _passwordError.value = false
    }

    fun onConfirmPasswordChange(confirmPassword: String) {
        _confirmPassword.value = confirmPassword
        _confirmPasswordError.value = false
    }

    fun onBirthDateChange(birthDate: String) {
        _birthDate.value = birthDate
        _birthDateError.value = false
    }

    fun onGenreChange(genre: String) {
        _genre.value = genre
        _genreError.value = false
    }

    fun onTermsAcceptedChange(accepted: Boolean) {
        _termsAccepted.value = accepted
        _termsError.value = false
    }

    fun isFormEmpty(): Boolean {
        return _name.value.isEmpty() &&
                _email.value.isEmpty() &&
                _password.value.isEmpty() &&
                _confirmPassword.value.isEmpty() &&
                _birthDate.value.isEmpty() &&
                _genre.value.isEmpty() &&
                !_termsAccepted.value
    }

    fun validateAndRegister(): Boolean {
        val isNameValid = _name.value.isNotBlank()
        val isEmailValid = _email.value.contains('@') && _email.value.contains('.')
        val isPasswordValid = _password.value.length >= 8
        val isConfirmValid = _confirmPassword.value == _password.value && _confirmPassword.value.isNotEmpty()
        val isBirthDateValid = _birthDate.value.isNotEmpty()
        val isGenreValid = _genre.value.isNotEmpty()
        val areTermsAccepted = _termsAccepted.value

        _nameError.value = !isNameValid
        _emailError.value = !isEmailValid
        _passwordError.value = !isPasswordValid
        _confirmPasswordError.value = !isConfirmValid
        _birthDateError.value = !isBirthDateValid
        _genreError.value = !isGenreValid
        _termsError.value = !areTermsAccepted

        return isNameValid && isEmailValid && isPasswordValid &&
                isConfirmValid && isBirthDateValid && isGenreValid && areTermsAccepted
    }
}