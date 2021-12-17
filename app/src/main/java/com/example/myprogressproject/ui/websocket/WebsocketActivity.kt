package com.example.myprogressproject.ui.websocket

import android.util.Log
import com.example.core.base.BaseActivity
import com.example.myprogressproject.databinding.ActivityWebsocketBinding
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import org.java_websocket.client.WebSocketClient
import org.java_websocket.handshake.ServerHandshake
import java.lang.Exception
import java.net.URI

@AndroidEntryPoint
class WebsocketActivity : BaseActivity<ActivityWebsocketBinding>() {

    private lateinit var webSocketClient: WebSocketClient

    override fun initViewBinding(): ActivityWebsocketBinding = ActivityWebsocketBinding.inflate(layoutInflater)

    override fun onResume() {
        super.onResume()
        initWebSocket()
    }

    override fun onPause() {
        super.onPause()
        webSocketClient.close()
    }

    private fun initWebSocket() {
        val coinbaseUri = URI("wss://api.demo.hitbtc.com/api/3/ws/public")

        createWebSocketClient(coinbaseUri)
    }

    private fun createWebSocketClient(coinbaseUri: URI?) {
        webSocketClient = object : WebSocketClient(coinbaseUri) {
            override fun onOpen(handshakedata: ServerHandshake?) {
                Log.e("TAG", "onOpen")
                subscribe()
            }

            override fun onMessage(message: String?) {
                //Информация по запрошенной валютной паре
                Log.e("TAG", "onMessage Pair data: $message")
            }

            override fun onClose(code: Int, reason: String?, remote: Boolean) {

            }

            override fun onError(ex: Exception?) {
                ex?.printStackTrace()
            }
        }
        webSocketClient.connect()
    }

    private fun subscribe() {
        val websocketRequest = WebsocketRequest(
            method = "subscribe",
            ch = "ticker/1s",
            params = WebsocketRequestParams(arrayListOf("ETHBTC")),
            id = 123
        )
        webSocketClient.send(Gson().toJson(websocketRequest))
    }
}