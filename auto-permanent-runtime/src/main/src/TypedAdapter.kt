
import android.os.Parcel
import kotlin.reflect.KClass

@Beta
interface TypedAdapter<T> {
    fun toParcel(value: T, parcel: Parcel, flags: Int)
    fun fromParcel(parcel: Parcel): T
}
