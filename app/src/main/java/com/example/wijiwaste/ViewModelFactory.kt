package com.example.wijiwaste



import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.wijiwaste.data.UserRepository
import com.example.wijiwaste.data.di.Injection
import com.example.wijiwaste.login.LoginViewModel
import com.example.wijiwaste.signup.SignupViewModel

@Suppress("UNCHECKED_CAST")
class ViewModelFactory(private val repository: UserRepository): ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when{
            modelClass.isAssignableFrom(LoginViewModel::class.java) ->{
                LoginViewModel(repository) as T
            }
            modelClass.isAssignableFrom(SignupViewModel::class.java)->{
                SignupViewModel(repository) as T
            }
            modelClass.isAssignableFrom(MainViewModel::class.java)->{
                MainViewModel(repository) as T
            }

            else -> throw IllegalArgumentException("Unknown ViewModel class:" + modelClass.name)
        }
    }

    companion object{
        private var INSTANCE: ViewModelFactory? = null

        fun clearInstance(){
            UserRepository.clearInstance()
            INSTANCE = null
        }
        fun getInstance(context: Context): ViewModelFactory{
            if (INSTANCE == null){
                synchronized(ViewModelFactory::class.java){
                    INSTANCE = ViewModelFactory(Injection.provideRepository(context))
                }
            }
            return INSTANCE as ViewModelFactory
        }
    }
}