package me.inassar.tmbd.data.repository

enum class Status {
    RUNNING, SUCCESS, FAILED
}

class NetworkStatus(val status: Status, val message: String) {
    companion object {
        val LOADING: NetworkStatus = NetworkStatus(Status.RUNNING, "Running")
        val LOADED: NetworkStatus = NetworkStatus(Status.SUCCESS, "Success")
        val ERROR: NetworkStatus = NetworkStatus(Status.FAILED, "Something went wrong")
    }
}