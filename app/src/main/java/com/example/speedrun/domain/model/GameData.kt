package com.example.speedrun.domain.model

import android.os.Parcel
import android.os.Parcelable

data class GameData(
    val gameId: String,
    val title: String,
    val logoUri: String
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(gameId)
        parcel.writeString(title)
        parcel.writeString(logoUri)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<GameData> {
        override fun createFromParcel(parcel: Parcel): GameData {
            return GameData(parcel)
        }

        override fun newArray(size: Int): Array<GameData?> {
            return arrayOfNulls(size)
        }
    }
}