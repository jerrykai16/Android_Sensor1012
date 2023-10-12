package com.example.myapplication

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(),SensorEventListener {
    private lateinit var binding: ActivityMainBinding

    private lateinit var sensorManager: SensorManager
    private lateinit var gyroSensor: Sensor
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        gyroSensor = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE)
    }

    override fun onResume() {
        super.onResume()
        sensorManager.registerListener(this,gyroSensor,SensorManager.SENSOR_DELAY_NORMAL)
    }

    override fun onPause() {
        super.onPause()
        sensorManager.unregisterListener(this)
    }
    private fun init(x: Int,y: Int,z: Int){
        binding.gyroscopeX.text = x.toString()
        binding.gyroscopeY.text = y.toString()
        binding.gyroscopeZ.text = z.toString()
    }

    override fun onSensorChanged(p0: SensorEvent?) {
        //Get gyroscope X,Y,Z
        binding.gyroscopeX.text = p0!!.values[0].toString()
        binding.gyroscopeY.text = p0!!.values[1].toString()
        binding.gyroscopeZ.text = p0!!.values[2].toString()

    }

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {
        TODO("Not yet implemented")
    }
}