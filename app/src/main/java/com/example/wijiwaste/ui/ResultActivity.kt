//package com.example.wijiwaste.ui
//
//import ImageClassifierHelper
//import com.example.wijiwaste.databinding.ActivityResultBinding
//
//
//
//import android.net.Uri
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.util.Log
//import android.widget.ImageView
//import android.widget.Toast
//import com.example.wijiwaste.R
//import org.tensorflow.lite.task.vision.classifier.Classifications
//
//
//import java.text.NumberFormat
//
//class ResultActivity : AppCompatActivity() {
//    private lateinit var binding: ActivityResultBinding
//    private lateinit var imageClassifierHelper: ImageClassifierHelper
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//        binding = ActivityResultBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        // TODO: Menampilkan hasil gambar, prediksi, dan confidence score.
//        val imageUri = Uri.parse(intent.getStringExtra(EXTRA_IMAGE_URI))
//        imageUri?.let {
//            Log.d("Image URI", "showImage: $it")
//            binding.resultImage.setImageURI(it)
//        }
//
//        classifyImage(imageUri)
//
//    }
//
//    private fun classifyImage(imageUri: Uri) {
//        imageClassifierHelper = ImageClassifierHelper(
//            context = this,
//            classifierListener = object : ImageClassifierHelper.ClassifierListener {
//                override fun onError(error: String) {
//                    runOnUiThread {
//                        Toast.makeText(this@ResultActivity, error, Toast.LENGTH_SHORT).show()
//                    }
//                }
//
//                override fun onResults(results: List<Classifications>?, inferenceTime: Long) {
//                    runOnUiThread {
//                        results?.let { it ->
//                            if (it.isNotEmpty() && it[0].categories.isNotEmpty()) {
//
//                                val predictedCategory =
//                                    it[0].categories.maxBy{ it.score }
//
//                                if (predictedCategory != null) {
//                                    val displayResult = "${predictedCategory.label} " +
//                                            NumberFormat.getPercentInstance()
//                                                .format(predictedCategory.score).trim()
//
//                                    binding.resultText.text = displayResult
//                                }
//
//                            } else {
//                                binding.resultText.text = getString(R.string.analysis_error)
//                            }
//                        }
//                    }
//                }
//            }
//        )
//
//        imageClassifierHelper.classifyStaticImage(imageUri)
//    }
//    companion object {
//        const val EXTRA_IMAGE_URI = "extra_image_uri"
//    }
//
//
//}