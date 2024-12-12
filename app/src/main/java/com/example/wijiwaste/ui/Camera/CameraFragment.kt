package com.example.wijiwaste.ui.Camera

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.FileProvider
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.wijiwaste.databinding.FragmentCameraBinding
import com.example.wijiwaste.databinding.FragmentDashboardBinding
import com.example.wijiwaste.ui.dashboard.DashboardViewModel
import java.io.File

class CameraFragment : Fragment() {

    private var _binding: FragmentCameraBinding? = null
    private val binding get() = _binding!!

    private lateinit var cameraLauncher: ActivityResultLauncher<Uri>
    private lateinit var galleryLauncher: ActivityResultLauncher<String>

    private var photoUri: Uri? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCameraBinding.inflate(inflater, container, false)
        setupLaunchers()
        setupButtons()
        return binding.root
    }



    private fun setupLaunchers() {
        // Camera launcher
        cameraLauncher = registerForActivityResult(ActivityResultContracts.TakePicture()) { success ->
            if (success && photoUri != null) {
                binding.imgUpload.setImageURI(photoUri)
            } else {
                Toast.makeText(requireContext(), "Failed to capture image", Toast.LENGTH_SHORT).show()
            }
        }

        // Gallery launcher
        galleryLauncher = registerForActivityResult(ActivityResultContracts.GetContent()) { uri ->
            if (uri != null) {
                binding.imgUpload.setImageURI(uri)
            } else {
                Toast.makeText(requireContext(), "No image selected", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun setupButtons() {
        binding.btnCam.setOnClickListener {
            openCamera()
        }

        binding.btnGallery.setOnClickListener {
            openGallery()
        }
    }

    private fun openCamera() {
        val photoFile = File(requireContext().cacheDir, "photo_${System.currentTimeMillis()}.jpg")
        photoUri = FileProvider.getUriForFile(requireContext(), "${requireContext().packageName}.provider", photoFile)

        // Check if the photoUri is not null before launching the camera
        if (photoUri != null) {
            cameraLauncher.launch(photoUri)
        } else {
            Toast.makeText(requireContext(), "Failed to create file for photo", Toast.LENGTH_SHORT).show()
        }
    }
    private fun openGallery() {
        galleryLauncher.launch("image/*")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
