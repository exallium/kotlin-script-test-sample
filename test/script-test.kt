import org.junit.*

class ScriptTest {

  @Test
  fun `Given No Arguments Prints No Args To Print`() {
    // GIVEN
    val expected = "No Args to Print!\n"

    // WHEN
    val result = runCommand("kotlinc -script ../script.kts")

    // THEN
    Assert.assertEquals(expected, result)
  }

  @Test
  fun `Given two args, prints arg1 and arg2`() {
    // GIVEN
    val expected = "arg1 and arg2!\n"

    // WHEN
    val result = runCommand("kotlinc -script ../script.kts arg1 arg2")

    // THEN
    Assert.assertEquals(expected, result)
  }


  private fun runCommand(command: String) = Runtime.getRuntime()
    .exec(arrayOf("/bin/sh", "-c", command))
    .inputStream.bufferedReader().readText()

}
