import epsilon.MemorySize
import epsilon.MemoryUnit
import epsilon.Multiplier
import epsilon.memorySize
import epsilon.memorySizeOrNull
import kommander.expect
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlin.test.Test

class MemorySizeParsingTest {

    @Test
    fun should_be_able_to_parse_memory_with_exponents() {
        val size = memorySize("1.0174706E7B")
        expect(size.value).toBe(1.0174706E7)
        expect(size.unit).toBe(MemoryUnit.Bytes)
        expect(size.multiplier).toBe(Multiplier.Unit)
    }

    @Test
    fun should_be_able_to_get_the_memory_size_from_a_string() {
        val size = memorySizeOrNull("1 GB")
        expect(size?.value).toBe(1.0)
        expect(size?.unit).toBe(MemoryUnit.Bytes)
        expect(size?.multiplier).toBe(Multiplier.Giga)
    }

    @Test
    fun should_be_able_to_get_the_memory_size__with_no_multiplier_from_a_string() {
        val size = memorySizeOrNull("3b")
        expect(size?.value).toBe(3.0)
        expect(size?.unit).toBe(MemoryUnit.Bits)
        expect(size?.multiplier).toBe(Multiplier.Unit)
    }

    @Test
    fun should_be_able_to_get_the_memory_size_of_a_fractional_value_from_a_string() {
        val size = memorySizeOrNull("1.5kB")
        expect(size?.value).toBe(1.5)
        expect(size?.unit).toBe(MemoryUnit.Bytes)
        expect(size?.multiplier).toBe(Multiplier.Kilo)
    }

    @Test
    fun should_be_able_to_convert_the_memory_size_to_a_string() {
        val size = MemorySize(1.5, Multiplier.Kilo, MemoryUnit.Bytes)
        expect(size.toString()).toBe("1.5 KB")
    }

    @Test
    fun should_strip_down_the_zeros_from_the_string_presentation() {
        val size = MemorySize(1.0, Multiplier.Giga, MemoryUnit.Bits)
        expect(size.toString()).toBe("1 Gb")
    }
}