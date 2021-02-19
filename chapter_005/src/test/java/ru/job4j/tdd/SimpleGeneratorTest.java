package ru.job4j.tdd;

public class SimpleGeneratorTest {

    /*@Test
    public void wnehCorrectProduce() {
        Generator generator = new SimpleGenerator();
        String template = "Hello, ${name}. ${question}";
        Map<String, String> map = new HashMap<>();
        map.put("name", "Azat");
        map.put("question", "How are you?");
        String result = generator.produce(template, map);
        String exp = "Hello, Azat. How are you?";
        assertThat(result, is(exp));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenIncorrectTemplateArgs() {
        Generator generator = new SimpleGenerator();
        String template = "Hello, ${name}. I am ${age}.";
        Map<String, String> map = new HashMap<>();
        map.put("name", "Azat");
        String result = generator.produce(template, map);
        String expected = "Hello, Azat. How are you";
        assertThat(result, is(expected));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenIncorrectMapArgs() {
        String template = "Hello, ${name}.";
        Map<String, String> map = new HashMap<>();
        map.put("name", "Azat");
        map.put("question", "How are you?");
        Generator generator = new SimpleGenerator();
        String result = generator.produce(template, map);
        String expected = "Hello, Azat.";
        assertThat(result, is(expected));
    }
    */
}