package com.alessandrofarandagancio.geckowrapper.datastore

import androidx.datastore.core.CorruptionException
import androidx.datastore.core.Serializer
import com.alessandrofarandagancio.geckowrapper.Settings
import com.google.protobuf.InvalidProtocolBufferException
import java.io.InputStream
import java.io.OutputStream
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SettingsSerializer @Inject constructor() : Serializer<Settings> {

    override val defaultValue = Settings.getDefaultInstance()

    override suspend fun readFrom(input: InputStream): Settings =
        try {
            Settings.parseFrom(input)
        } catch (ex: InvalidProtocolBufferException) {
            throw CorruptionException("Unable to read proto", ex)
        }

    override suspend fun writeTo(
        t: Settings,
        output: OutputStream
    ) = t.writeTo(output)

}