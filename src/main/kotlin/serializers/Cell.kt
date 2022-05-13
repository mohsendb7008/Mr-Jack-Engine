package serializers

import kotlinx.serialization.*
import kotlinx.serialization.descriptors.buildClassSerialDescriptor
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.encoding.encodeStructure
import kotlinx.serialization.modules.SerializersModule
import model.*

@Serializable
@SerialName("Cell")
private class CellSurrogate(
    val position: Position,
    @Transient val adjacentPositions: List<Position> = emptyList(),
    val character: Character? = null,
    val informant: Informant? = null
)

@OptIn(ExperimentalSerializationApi::class)
private class CellDefaultSerializer(val subclassName: String) : SerializationStrategy<Cell> {
    override val descriptor = buildClassSerialDescriptor(subclassName) {
        val desc = CellSurrogate.serializer().descriptor
        for (i in 0 until desc.elementsCount) {
            element(
                desc.getElementName(i),
                desc.getElementDescriptor(i),
                desc.getElementAnnotations(i),
                desc.isElementOptional(i)
            )
        }
    }

    override fun serialize(encoder: Encoder, value: Cell) = encoder.encodeStructure(descriptor) {
        encodeSerializableElement(descriptor, 0, Position.serializer(), value.position)
        encodeNullableSerializableElement(descriptor, 1, Character.serializer(), value.character)
        encodeNullableSerializableElement(descriptor, 2, Informant.serializer(), value.informant)
    }
}

val cellSerializeModule = SerializersModule {
    polymorphicDefaultSerializer(Cell::class) {
        when (it) {
            is QuaysideSpace -> CellDefaultSerializer("QuaysideSpace")
            is LibertyIsland -> CellDefaultSerializer("LibertyIsland")
            is LandExit -> CellDefaultSerializer("LandExit")
            else -> null
        }
    }
}

fun Cell.toJson() = json.encodeToString(this)
