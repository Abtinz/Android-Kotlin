package abtin.android.zabol.model

/** this data call will save zabol Landmarks information
 * @param image uri of landmark image
 * @param name name of landmark
 * @param description two or three lines about landmark
 * @param location location of the landmark
 */
data class Landmarks(
    val image:String,
    val name:String,
    val description:String,
    val location:String
)
