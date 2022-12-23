package com.example.wlt_groupe03

import android.Manifest
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.example.wlt_groupe03.databinding.ActivityQrcodeLoginBinding

class QRCodeLoginActivity : AppCompatActivity() {
    lateinit var viewModel: TrocManagerViewModel
    lateinit var binding: ActivityQrcodeLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_qrcode_login)

        binding = ActivityQrcodeLoginBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this)[TrocManagerViewModel::class.java]

        if (ContextCompat.checkSelfPermission(
                this@QRCodeLoginActivity,
                Manifest.permission.CAMERA
            ) == PackageManager.PERMISSION_DENIED
        ) {
            ActivityCompat.requestPermissions(
                this@QRCodeLoginActivity,
                arrayOf(Manifest.permission.CAMERA),
                123
            )
        } else {
            //startScanning()
        }

    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 123) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Camera permission granted", Toast.LENGTH_LONG).show()
                //startScanning()
            } else {
                Toast.makeText(this, "Camera permission denied", Toast.LENGTH_LONG).show()
            }
        }
    }

//    lateinit var codeScanner: CodeScanner
//
//    public fun startScanning() {
//        // Parameters (default values)
//        val scannerView: CodeScannerView = findViewById(R.id.scanner)
//        codeScanner = CodeScanner(this, scannerView)
//        codeScanner.camera = CodeScanner.CAMERA_BACK // or CAMERA_FRONT or specific camera id
//        codeScanner.formats = CodeScanner.ALL_FORMATS // list of type BarcodeFormat,
//        // ex. listOf(BarcodeFormat.QR_CODE)
//        codeScanner.autoFocusMode = AutoFocusMode.SAFE // or CONTINUOUS
//        codeScanner.scanMode = ScanMode.SINGLE // or CONTINUOUS or PREVIEW
//        codeScanner.isAutoFocusEnabled = true // Whether to enable auto focus or not
//        codeScanner.isFlashEnabled = false // Whether to enable flash or not
//
//        // Callbacks
//        codeScanner.decodeCallback = DecodeCallback {
//            runOnUiThread {
//
//                val mail = it.text.split(",")
//
//                viewModel.mutableLiveDataLoginUser.observe(this) {
//
//                    val user = viewModel.mutableLiveDataLoginUser.value
//                    if(user != null)
//                    {
//                        //Toast.makeText(this, "${mail[0]}${mail[1]}", Toast.LENGTH_LONG).show()
//
//                        Toast.makeText(this, "Bienvenue " + it?.firstName + " !", Toast.LENGTH_LONG).show()
//                        val intent = Intent(this, MainMenuActivity::class.java)
//                        startActivity(intent)
//
//                    }
//                    else
//                    {
//                        Toast.makeText(this, "Invalid login QR code", Toast.LENGTH_LONG).show()
//                    }
//
//                }
//                viewModel.launchGetUser(mail[0], mail[1])
//
//
//
//            }
//        }
//        codeScanner.errorCallback = ErrorCallback { // or ErrorCallback.SUPPRESS
//            runOnUiThread {
//                Toast.makeText(this, "Camera initialization error: ${it.message}",
//                    Toast.LENGTH_LONG).show()
//            }
//        }

//        scannerView.setOnClickListener {
//            codeScanner.startPreview()
//        }
 //   }
}